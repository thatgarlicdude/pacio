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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class of the PacROMSetFilenames interface.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class TestPacROMSetFilenames implements PacROMSetFilenames {
	
	/**
	 * Tests the getProgramName method in the PacROMSetFilenames interface.
	 */
	@Test
	public final void testGetProgramName() {
		String programName = getProgramName();
		assertSame(programName, PacROMSetFilenames.programName);
		System.out.println(programName);
	}
	
	/**
	 * Tests the getGraphicName method in the PacROMSetFilenames interface.
	 */
	@Test
	public final void testGetGraphicName() {
		String graphicName = getGraphicName();
		assertSame(graphicName, PacROMSetFilenames.graphicName);
		System.out.println(graphicName);
	}
	
	/**
	 * Tests the getColorName method in the PacROMSetFilenames interface.
	 */
	@Test
	public final void testGetColorName() {
		String colorName = getColorName();
		assertSame(colorName, PacROMSetFilenames.colorName);
		System.out.println(colorName);
	}
	
	/**
	 * Tests the getPaletteName method in the PacROMSetFilenames interface.
	 */
	@Test
	public final void testGetPaletteName() {
		String paletteName = getPaletteName();
		assertSame(paletteName, PacROMSetFilenames.paletteName);
		System.out.println(paletteName);
	}
	
	/**
	 * Tests the getSoundName method in the PacROMSetFilenames interface.
	 */
	@Test
	public final void testGetSoundName() {
		String soundName = getSoundName();
		assertSame(soundName, PacROMSetFilenames.soundName);
		System.out.println(soundName);
	}
	
	/**
	 * Tests the getMysteryName method in the PacROMSetFilenames interface.
	 */
	@Test
	public final void testGetMysteryName() {
		String mysteryName = getMysteryName();
		assertSame(mysteryName, PacROMSetFilenames.mysteryName);
		System.out.println(mysteryName);
	}
}
