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
 * An abstract class that represents as a categorized list of ROM file
 * names.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public abstract class PacCatalog {
	
	/**
	 * The list of program ROM filenames in the ROM set.
	 */
	private final String[] programROMNames;
	
	/**
	 * The list of graphic ROM filenames in the ROM set.
	 */
	private final String[] graphicROMNames;
	
	/**
	 * The list of color ROM filenames in the ROM set.
	 */
	private final String[] colorROMNames;
	
	/**
	 * The list of palette ROM filenames in the ROM set.
	 */
	private final String[] paletteROMNames;
	
	/**
	 * The list of sound ROM filenames in the ROM set.
	 */
	private final String[] soundROMNames;
	
	/**
	 * The list of mystery ROM filenames in the ROM set.
	 */
	private final String[] mysteryROMNames;
	
	/**
	 * Gets the list of program ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of program ROM filenames.
	 */
	public final String[] getProgramROMNames() {
		return programROMNames.clone();
	}
	
	/**
	 * Gets the list of graphic ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of graphic ROM filenames.
	 */
	public final String[] getGraphicROMNames() {
		return graphicROMNames.clone();
	}
	
	/**
	 * Gets the list of color ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of color ROM filenames.
	 */
	public final String[] getColorROMNames() {
		return colorROMNames.clone();
	}
	
	/**
	 * Gets the list of palette ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of palette ROM filenames.
	 */
	public final String[] getPaletteROMNames() {
		return paletteROMNames.clone();
	}
	
	/**
	 * Gets the list of sound ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of sound ROM filenames.
	 */
	public final String[] getSoundROMNames() {
		return soundROMNames.clone();
	}
	
	/**
	 * Gets the list of mystery ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of mystery ROM filenames.
	 */
	public final String[] getMysteryROMNames() {
		return mysteryROMNames.clone();
	}
	
	/**
	 * Constructs an instance of the PacCatalog.
	 * 
	 * @param programROMNames The list of program ROM filenames in the
	 * ROM set.
	 * @param graphicROMNames The list of graphic ROM filenames in the
	 * ROM set.
	 * @param colorROMNames The list of color ROM filenames in the ROM
	 * set.
	 * @param paletteROMNames The list of palette ROM filenames in the
	 * ROM set.
	 * @param soundROMNames The list of sound ROM filenames in the ROM
	 * set.
	 * @param mysteryROMNames The list of mystery ROM filenames in the
	 * ROM set.
	 */
	public PacCatalog(
			final String[] programROMNames,
			final String[] graphicROMNames,
			final String[] colorROMNames,
			final String[] paletteROMNames,
			final String[] soundROMNames,
			final String[] mysteryROMNames) {
		this.programROMNames = programROMNames;
		this.graphicROMNames = graphicROMNames;
		this.colorROMNames = colorROMNames;
		this.paletteROMNames = paletteROMNames;
		this.soundROMNames = soundROMNames;
		this.mysteryROMNames = mysteryROMNames;
	}
}
