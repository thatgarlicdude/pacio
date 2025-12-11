/*
 * Copyright 2025 GarlicDude
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.thatgarlicdude.pacio;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**A class that represents a ROM set directory.*/
public final class PacRomSet extends PacFile implements Openable {
	
	/**The ROMs within the ROM set directory.*/
	public ArrayList<PacRom> roms = new ArrayList<PacRom>();
	
	/**Opens the ROM set directory.*/
	@Override
	public final void open() throws IOException {
		DirectoryStream<Path> paths = Files.newDirectoryStream(this.path);
		for (Path path : paths) {
			// TODO: Create a better ROM-checking system than this.
			if (!Files.isRegularFile(path)) continue;
			PacRom rom = new PacRom(path);
			roms.add(rom);
		}
		paths.close();
	}
	
	/**Closes the ROM set directory.*/
	@Override
	public final void close() {
		roms.clear();
	}
	
	/**Finds a specific ROM within the ROM set.*/
	public final PacRom find(final String romName) {
		for (PacRom rom : roms) {
			if (rom.name.matches(romName)) return rom;
		}
		return null;
	}
	
	// TODO: Maybe have only one constructor, which is the main one.
	
	/**The main constructor of the PacRomSet.*/
	public PacRomSet(final Path path, final String name, final ArrayList<PacRom> roms) {
		// This doesn't automatically open the PacRomSet.
		super(path, name);
		this.roms = roms;
	}
	
	/**A constructor using a Path for the file path.*/
	public PacRomSet(final Path path) throws IOException {
		super(path);
		this.open();
	}
	
	/**A constructor using a URI for the file.*/
	public PacRomSet(final URI pathURI) throws IOException {
		this(Paths.get(pathURI));
	}
	
	/**A constructor using a String for the file path.*/
	public PacRomSet(final String pathString) throws IOException {
		this(Paths.get(pathString));
	}
}
