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

package io.github.thatgarlicdude.pacio.model;

import java.util.Objects;

/*
 * TODO: Maybe in the future, add a superclass called ROMSet that will
 * handle proper IO functionality. It'll probably make managing classes
 * easier if done so.
 */

/**
 * A class that represents a unified <i>Pac-Man</i> ROM set.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 */
public final class PacROMSet {
	
	/**
	 * The unified byte data of the <b>program</b> ROMs.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getProgramData()
	 */
	private final byte[] programData;
	
	/**
	 * The unified byte data of the <b>graphic</b> ROMs.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getGraphicData()
	 */
	private final byte[] graphicData;
	
	/**
	 * The unified byte data of the <b>color</b> ROMs.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getColorData()
	 */
	private final byte[] colorData;
	
	/**
	 * The unified byte data of the <b>palette</b> ROMs.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getPaletteData()
	 */
	private final byte[] paletteData;
	
	/**
	 * The unified byte data of the <b>sound</b> ROMs.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getSoundData()
	 */
	private final byte[] soundData;
	
	// TODO: Should there even be an array containing mystery byte data?
	
	/**
	 * The unified byte data of the <b>mystery</b> ROMs.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getMysteryData()
	 */
	private final byte[] mysteryData;
	
	/**
	 * Gets a cloned array of the {@link #programData}, which is a
	 * unified byte array containing <b>program</b> data.
	 * 
	 * @return A cloned array of the {@link #programData} array.
	 * @since 1.0.0-alpha
	 * @see #programData
	 */
	public final byte[] getProgramData() {
		// Return a cloned array of the program data.
		return programData.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #graphicData}, which is a
	 * unified byte array containing <b>graphic</b> data.
	 * 
	 * @return A cloned array of the {@link #graphicData} array.
	 * @since 1.0.0-alpha
	 * @see #graphicData
	 */
	public final byte[] getGraphicData() {
		// Return a cloned array of the graphic data.
		return graphicData.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #colorData}, which is a
	 * unified byte array containing <b>color</b> data.
	 * 
	 * @return A cloned array of the {@link #colorData} array.
	 * @since 1.0.0-alpha
	 * @see #colorData
	 */
	public final byte[] getColorData() {
		// Return a cloned array of the color data.
		return colorData.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #paletteData}, which is a
	 * unified byte array containing <b>palette</b> data.
	 * 
	 * @return A cloned array of the {@link #paletteData} array.
	 * @since 1.0.0-alpha
	 * @see #paletteData
	 */
	public final byte[] getPaletteData() {
		// Return a cloned array of the palette data.
		return paletteData.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #soundData}, which is a
	 * unified byte array containing <b>sound</b> data.
	 * 
	 * @return A cloned array of the {@link #soundData} array.
	 * @since 1.0.0-alpha
	 * @see #soundData
	 */
	public final byte[] getSoundData() {
		// Return a cloned array of the sound data.
		return soundData.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #mysteryData}, which is a
	 * unified byte array containing <b>mystery</b> data.
	 * 
	 * @return A cloned array of the {@link #mysteryData} array.
	 * @since 1.0.0-alpha
	 * @see #mysteryData
	 */
	public final byte[] getMysteryData() {
		// Return a cloned array of the mystery data.
		return mysteryData.clone();
	}
	
	/**
	 * Constructs an instance of the unified <i>Pac-Man</i> ROM set.
	 * 
	 * @param programData The unified array of bytes in the
	 * <b>program</b> ROMs.
	 * @param graphicData The unified array of bytes in the
	 * <b>graphic</b> ROMs.
	 * @param colorData The unified array of bytes in the
	 * <b>color</b> ROM.
	 * @param paletteData The unified array of bytes in the
	 * <b>palette</b> ROM.
	 * @param soundData The unified array of bytes in the
	 * <b>sound</b> ROM.
	 * @param mysteryData The unified array of bytes in the
	 * <b>mystery</b> ROM.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	public PacROMSet(
			final byte[] programData,
			final byte[] graphicData,
			final byte[] colorData,
			final byte[] paletteData,
			final byte[] soundData,
			final byte[] mysteryData) {
		this.programData = Objects.requireNonNull(programData);
		this.graphicData = Objects.requireNonNull(graphicData);
		this.colorData = Objects.requireNonNull(colorData);
		this.paletteData = Objects.requireNonNull(paletteData);
		this.soundData = Objects.requireNonNull(soundData);
		this.mysteryData = Objects.requireNonNull(mysteryData);
	}
}
