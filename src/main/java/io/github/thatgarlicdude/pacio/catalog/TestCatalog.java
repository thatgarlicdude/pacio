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
 * A test class extending from PacCatalog used for the test ROM set.
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class TestCatalog extends PacCatalog {
	
	/**
	 * A static list of program ROM filenames in the test ROM set.
	 */
	private static final String[] PROGRAM_ROMS = {
			"test_prog1", "test_prog2"
	};
	
	/**
	 * A static list of graphic ROM filenames in the test ROM set.
	 */
	private static final String[] GRAPHIC_ROMS = {
			"test_gfx1", "test_gfx2"
	};
	
	/**
	 * A static list of color ROM filenames in the test ROM set.
	 */
	private static final String[] COLOR_ROMS = {
			"test_clr1", "test_clr2"
	};
	
	/**
	 * A static list of palette ROM filenames in the test ROM set.
	 */
	private static final String[] PALETTE_ROMS = {
			"test_pal1", "test_pal2"
	};
	
	/**
	 * A static list of sound ROM filenames in the test ROM set.
	 */
	private static final String[] SOUND_ROMS = {
			"test_sfx1", "test_sfx2"
	};
	
	/**
	 * A static list of mystery ROM filenames in the test ROM set.
	 */
	private static final String[] MYSTERY_ROMS = {
			"test_mys1", "test_mys2"
	};
	
	/**
	 * Constructs an instance of the test catalog.
	 */
	public TestCatalog() {
		super(
				PROGRAM_ROMS,
				GRAPHIC_ROMS,
				COLOR_ROMS,
				PALETTE_ROMS,
				SOUND_ROMS,
				MYSTERY_ROMS);
	}
}
