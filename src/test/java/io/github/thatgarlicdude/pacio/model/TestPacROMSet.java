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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class for the {@link PacROMSet} class.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 * @see PacROMSet
 */
public final class TestPacROMSet {
	
	/**
	 * The {@link PacROMSet} object used for testing purposes.
	 * 
	 * @since 1.1.0-alpha
	 * @author GarlicDude
	 */
	private final PacROMSet pacROMSet = new PacROMSet(
			new byte[0], // Program Data.
			new byte[0], // Graphic Data.
			new byte[0], // Color Data.
			new byte[0], // Palette Data.
			new byte[0], // Sound Data.
			new byte[0] // Mystery Data.
			);
	
	/**
	 * Tests the {@link PacROMSet#getProgramData()} method.
	 * 
	 * @since 1.1.0-alpha
	 * @author GarlicDude
	 * @see PacROMSet#getProgramData()
	 */
	@Test
	public final void testGetProgramData() {
		// Get the program data for the PacROMSet.
		final byte[] programData = pacROMSet.getProgramData();
		/*
		 * Just assert that as not null. There isn't much we could do with
		 * it.
		 */
		assertNotNull(programData);
	}
	
	/**
	 * Tests the {@link PacROMSet#getGraphicData()} method.
	 * 
	 * @since 1.1.0-alpha
	 * @author GarlicDude
	 * @see PacROMSet#getGraphicData()
	 */
	@Test
	public final void testGetGraphicData() {
		// Get the graphic data for the PacROMSet.
		final byte[] graphicData = pacROMSet.getGraphicData();
		/*
		 * Just assert that as not null. There isn't much we could do with
		 * it.
		 */
		assertNotNull(graphicData);
	}
	
	/**
	 * Tests the {@link PacROMSet#getColorData()} method.
	 * 
	 * @since 1.1.0-alpha
	 * @author GarlicDude
	 * @see PacROMSet#getColorData()
	 */
	@Test
	public final void testGetColorData() {
		// Get the color data for the PacROMSet.
		final byte[] colorData = pacROMSet.getColorData();
		/*
		 * Just assert that as not null. There isn't much we could do with
		 * it.
		 */
		assertNotNull(colorData);
	}
	
	/**
	 * Tests the {@link PacROMSet#getPaletteData()} method.
	 * 
	 * @since 1.1.0-alpha
	 * @author GarlicDude
	 * @see PacROMSet#getPaletteData()
	 */
	@Test
	public final void testGetPaletteData() {
		// Get the palette data for the PacROMSet.
		final byte[] paletteData = pacROMSet.getPaletteData();
		/*
		 * Just assert that as not null. There isn't much we could do with
		 * it.
		 */
		assertNotNull(paletteData);
	}
	
	/**
	 * Tests the {@link PacROMSet#getSoundData()} method.
	 * 
	 * @since 1.1.0-alpha
	 * @author GarlicDude
	 * @see PacROMSet#getSoundData()
	 */
	@Test
	public final void testGetSoundData() {
		// Get the sound data for the PacROMSet.
		final byte[] soundData = pacROMSet.getSoundData();
		/*
		 * Just assert that as not null. There isn't much we could do with
		 * it.
		 */
		assertNotNull(soundData);
	}
	
	/**
	 * Tests the {@link PacROMSet#getMysteryData()} method.
	 * 
	 * @since 1.1.0-alpha
	 * @author GarlicDude
	 * @see PacROMSet#getMysteryData()
	 */
	@Test
	public final void testGetMysteryData() {
		// Get the mystery data for the PacROMSet.
		final byte[] mysteryData = pacROMSet.getMysteryData();
		/*
		 * Just assert that as not null. There isn't much we could do with
		 * it.
		 */
		assertNotNull(mysteryData);
	}
}
