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
 * the <i>Puck-Man</i> ROM set.
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class PuckManCatalog extends PacCatalog {
	
	/**
	 * A static list of the program ROM filenames in the <i>Puck-Man</i>
	 * ROM set.
	 */
	private static final String[] PROGRAM_ROMS = {
			"pm1_prg1.6e", "pm1_prg2.6k", "pm1_prg3.6f", "pm1_prg4.6m",
			"pm1_prg5.6h", "pm1_prg6.6n", "pm1_prg7.6j", "pm1_prg8.6p"
	};
	
	/**
	 * A static list of the graphic ROM filenames in the <i>Puck-Man</i>
	 * ROM set.
	 */
	private static final String[] GRAPHIC_ROMS = {
			"pm1_chg1.5e", "pm1_chg2.5h", "pm1_chg3.5f", "pm1_chg4.5j",
	};
	
	/**
	 * A static list of the color ROM filenames in the <i>Puck-Man</i>
	 * ROM set.
	 */
	private static final String[] COLOR_ROMS = {
			"pm1-1.7f"
	};
	
	/**
	 * A static list of the palette ROM filenames in the <i>Puck-Man</i>
	 * ROM set.
	 */
	private static final String[] PALETTE_ROMS = {
			"pm1-4.4a"
	};
	
	/**
	 * A static list of the sound ROM filenames in the <i>Puck-Man</i>
	 * ROM set.
	 */
	private static final String[] SOUND_ROMS = {
			"pm1-3.1m"
	};
	
	/**
	 * A static list of the mystery ROM filenames in the <i>Puck-Man</i>
	 * ROM set.
	 */
	private static final String[] MYSTERY_ROMS = {
			"pm1-2.3m"
	};
	
	/**
	 * Constructs an instance of the <i>Puck-Man</i> catalog.
	 */
	public PuckManCatalog() {
		super(
				PROGRAM_ROMS,
				GRAPHIC_ROMS,
				COLOR_ROMS,
				PALETTE_ROMS,
				SOUND_ROMS,
				MYSTERY_ROMS);
	}
}
