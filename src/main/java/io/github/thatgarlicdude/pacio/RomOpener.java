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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**A class that handles opening the Pac-Man ROM set.*/
public final class RomOpener {
	
	/**Creates a new PacRom in memory and opens it automatically.*/
	public static final PacRom openRom(final Path path) throws IOException {
		String name = path.getFileName().toString();
		byte[] data = Files.readAllBytes(path);
		PacRom rom = new PacRom(path, name, data);
		return rom;
	}
	
	/**Creates a new PacRomSet in memory and opens it automatically.*/
	public static final PacRomSet openRomSet(final Path path) throws IOException {
		String name = path.getFileName().toString();
		ArrayList<PacRom> roms = openRoms(path);
		PacRomSet romSet = new PacRomSet(path, name, roms);
		return romSet;
	}
	
	/**Creates a list of PacRoms in the PacRomSet.*/
	private static final ArrayList<PacRom> openRoms(final Path path) throws IOException {
		ArrayList<PacRom> roms = new ArrayList<PacRom>();
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
		for (Path romPath : directoryStream) {
			// TODO: Create a better ROM-checking system than this.
			if (!Files.isRegularFile(romPath)) continue;
			PacRom rom = openRom(romPath);
			roms.add(rom);
		}
		directoryStream.close();
		return roms;
	}
}
