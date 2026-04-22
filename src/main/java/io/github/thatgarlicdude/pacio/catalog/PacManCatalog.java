/*
 * Copyright 2026 GarlicDude
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

package io.github.thatgarlicdude.pacio.catalog;

/**
 * A class that represents a categorized list of the ROM file names in
 * the Pac-Man ROM set.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacManCatalog extends PacCatalog {
	
	/**
	 * A static list of program ROM filenames in the Pac-Man ROM set.
	 */
	private static final String[] PROGRAM_ROMS = {
			"pacman.6e", "pacman.6f", "pacman.6h", "pacman.6j"
	};
	
	/**
	 * A static list of graphic ROM filenames in the Pac-Man ROM set.
	 */
	private static final String[] GRAPHIC_ROMS = {
			"pacman.5e", "pacman.5f"
	};
	
	/**
	 * A static list of color ROM filenames in the Pac-Man ROM set.
	 */
	private static final String[] COLOR_ROMS = {
			"82s123.7f"
	};
	
	/**
	 * A static list of palette ROM filenames in the Pac-Man ROM set.
	 */
	private static final String[] PALETTE_ROMS = {
			"82s126.4a"
	};
	
	/**
	 * A static list of sound ROM filenames in the Pac-Man ROM set.
	 */
	private static final String[] SOUND_ROMS = {
			"82s126.1m", "82s126.3m"
	};
	
	/**
	 * Constructs an instance of the Pac-Man catalog.
	 */
	public PacManCatalog() {
		super(
				PROGRAM_ROMS,
				GRAPHIC_ROMS,
				COLOR_ROMS,
				PALETTE_ROMS,
				SOUND_ROMS);
	}
}
