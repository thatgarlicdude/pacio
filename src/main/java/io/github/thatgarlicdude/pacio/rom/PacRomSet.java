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

package io.github.thatgarlicdude.pacio.rom;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**A class that represents a ROM set directory.*/
public final class PacRomSet extends PacFile implements Closable, Savable {
	
	/**The ROMs within the ROM set directory.*/
	private ArrayList<PacRom> roms;
	
	/**Returns the ROMs ArrayList in the PacROMSet.*/
	public ArrayList<PacRom> getRoms() {
		return this.roms;
	}
	
	/**Creates a new PacRomSet in memory and opens it automatically.*/
	public static PacRomSet open(final Path path) throws IOException {
		String name = path.getFileName().toString();
		ArrayList<PacRom> roms = openRoms(path);
		PacRomSet romSet = new PacRomSet(path, name, roms);
		return romSet;
	}
	
	/**Creates a new PacRomSet using a URI and opens it automatically.*/
	public static PacRomSet open(final URI pathURI) throws IOException {
		Path path = Paths.get(pathURI);
		PacRomSet romSet = open(path);
		return romSet;
	}
	
	/**Creates a new PacRomSet using a string and opens it automatically.*/
	public static PacRomSet open(final String pathString) throws IOException {
		Path path = Paths.get(pathString);
		PacRomSet romSet = open(path);
		return romSet;
	}
	
	/**Creates a list of PacRoms in the PacRomSet.*/
	private static ArrayList<PacRom> openRoms(final Path path) throws IOException {
		ArrayList<PacRom> roms = new ArrayList<PacRom>();
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
		for (Path romPath : directoryStream) {
			// TODO: Create a better ROM-checking system than this.
			if (!Files.isRegularFile(romPath)) continue;
			PacRom rom = PacRom.open(romPath);
			roms.add(rom);
		}
		directoryStream.close();
		return roms;
	}
	
	/**Closes the ROM set directory.*/
	@Override
	public final void close() {
		// Close each ROM from memory.
		for (PacRom rom : this.roms) {
			rom.close();
		}
		roms.clear();
	}
	
	/**Saves the ROM set directory.*/
	@Override
	public final void save() throws IOException {
		// Save each ROM from memory.
		for (PacRom rom : this.roms) {
			rom.save();
		}
	}
	
	/**Finds a specific ROM within the ROM set.*/
	public final PacRom find(final String romName) {
		for (PacRom rom : roms) {
			if (rom.name.matches(romName)) return rom;
		}
		return null;
	}
	
	/**The main constructor of the PacRomSet.*/
	PacRomSet(final Path path, final String name, final ArrayList<PacRom> roms) {
		super(path, name);
		this.roms = roms;
	}
}
