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

import java.nio.file.Path;
import java.util.ArrayList;

/**A class that represents a ROM set directory.*/
public final class PacRomSet extends PacFile {
	
	/**The ROMs within the ROM set directory.*/
	public ArrayList<PacRom> roms = new ArrayList<PacRom>();
	
	/**Closes the ROM set directory.*/
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
	
	/**The main constructor of the PacRomSet.*/
	PacRomSet(final Path path, final String name, final ArrayList<PacRom> roms) {
		super(path, name);
		this.roms = roms;
	}
}
