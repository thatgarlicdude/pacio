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

package io.github.thatgarlicdude.pacio.io;

/**
 * A class that represents a unified Pac-Man ROM set.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacROMSet {
	
	/**
	 * The unified byte data of the program ROMs.
	 */
	private final byte[] programData;
	
	/**
	 * The unified byte data of the graphic ROMs.
	 */
	private final byte[] graphicData;
	
	/**
	 * The unified byte data of the color ROMs.
	 */
	private final byte[] colorData;
	
	/**
	 * The unified byte data of the palette ROMs.
	 */
	private final byte[] paletteData;
	
	/**
	 * The unified byte data of the sound ROMs.
	 */
	private final byte[] soundData;
	
	/**
	 * The unified byte data of the mystery ROMs.
	 */
	private final byte[] mysteryData;
	
	/**
	 * Gets the unified byte data of the program ROMs.
	 * 
	 * @return A unified byte array of program ROM data.
	 */
	public final byte[] getProgramData() {
		return programData;
	}
	
	/**
	 * Gets the unified byte data of the graphic ROMs.
	 * 
	 * @return A unified byte array of graphic ROM data.
	 */
	public final byte[] getGraphicData() {
		return graphicData;
	}
	
	/**
	 * Gets the unified byte data of the color ROMs.
	 * 
	 * @return A unified byte array of color ROM data.
	 */
	public final byte[] getColorData() {
		return colorData;
	}
	
	/**
	 * Gets the unified byte data of the palette ROMs.
	 * 
	 * @return A unified byte array of palette ROM data.
	 */
	public final byte[] getPaletteData() {
		return paletteData;
	}
	
	/**
	 * Gets the unified byte data of the sound ROMs.
	 * 
	 * @return A unified byte array of sound ROM data.
	 */
	public final byte[] getSoundData() {
		return soundData;
	}
	
	/**
	 * Gets the unified byte data of the mystery ROMs.
	 * 
	 * @return A unified byte array of mystery ROM data.
	 */
	public final byte[] getMysteryData() {
		return mysteryData;
	}
	
	/**
	 * Constructs an instance of the unified Pac-Man ROM set.
	 * 
	 * @param programData The unified array of bytes in the program ROMs.
	 * @param graphicData The unified array of bytes in the graphic ROMs.
	 * @param colorData The unified array of bytes in the color ROMs.
	 * @param paletteData The unified array of bytes in the palette ROMs.
	 * @param soundData The unified array of bytes in the sound ROMs.
	 */
	public PacROMSet(
			final byte[] programData,
			final byte[] graphicData,
			final byte[] colorData,
			final byte[] paletteData,
			final byte[] soundData,
			final byte[] mysteryData) {
		this.programData = programData;
		this.graphicData = graphicData;
		this.colorData = colorData;
		this.paletteData = paletteData;
		this.soundData = soundData;
		this.mysteryData = mysteryData;
	}
}
