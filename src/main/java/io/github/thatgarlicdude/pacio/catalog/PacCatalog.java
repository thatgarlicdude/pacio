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
	private final String[] programROMs;
	
	/**
	 * The list of graphic ROM filenames in the ROM set.
	 */
	private final String[] graphicROMs;
	
	/**
	 * The list of color ROM filenames in the ROM set.
	 */
	private final String[] colorROMs;
	
	/**
	 * The list of palette ROM filenames in the ROM set.
	 */
	private final String[] paletteROMs;
	
	/**
	 * The list of sound ROM filenames in the ROM set.
	 */
	private final String[] soundROMs;
	
	/**
	 * Gets the list of program ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of program ROM filenames.
	 */
	public final String[] getProgramROMs() {
		return programROMs.clone();
	}
	
	/**
	 * Gets the list of graphic ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of graphic ROM filenames.
	 */
	public final String[] getGraphicROMs() {
		return graphicROMs.clone();
	}
	
	/**
	 * Gets the list of color ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of color ROM filenames.
	 */
	public final String[] getColorROMs() {
		return colorROMs.clone();
	}
	
	/**
	 * Gets the list of palette ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of palette ROM filenames.
	 */
	public final String[] getPaletteROMs() {
		return paletteROMs.clone();
	}
	
	/**
	 * Gets the list of sound ROM filenames in the catalog.
	 * 
	 * @return The string array consisting of sound ROM filenames.
	 */
	public final String[] getSoundROMs() {
		return soundROMs.clone();
	}
	
	/**
	 * Constructs an instance of the PacCatalog.
	 * 
	 * @param programROMs The list of program ROM filenames in the ROM set.
	 * @param graphicROMs The list of graphic ROM filenames in the ROM set.
	 * @param colorROMs The list of color ROM filenames in the ROM set.
	 * @param paletteROMs The list of palette ROM filenames in the ROM set.
	 * @param soundROMs The list of sound ROM filenames in the ROM set.
	 */
	public PacCatalog(
			final String[] programROMs,
			final String[] graphicROMs,
			final String[] colorROMs,
			final String[] paletteROMs,
			final String[] soundROMs) {
		this.programROMs = programROMs;
		this.graphicROMs = graphicROMs;
		this.colorROMs = colorROMs;
		this.paletteROMs = paletteROMs;
		this.soundROMs = soundROMs;
	}
}
