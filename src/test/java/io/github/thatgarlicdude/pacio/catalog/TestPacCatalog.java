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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class of the PacCatalog class.
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public abstract class TestPacCatalog {
	
	/**
	 * Placeholder message for the assertList method.
	 */
	private static final String PLACEHOLDER_MESSAGE = "List index %d: %s";
	
	/**
	 * The PacCatalog used for testing purposes.
	 */
	private final PacCatalog pacCatalog;
	
	/**
	 * Asserts a list within the class's PacCatalog to check if it's not
	 * null.
	 * 
	 * @param list The list the method wants to assert.
	 */
	private final void assertList(final String[] list) {
		assertNotNull(list);
		for (int index = 0; index < list.length; index++) {
			String message = String.format(
					PLACEHOLDER_MESSAGE,
					index,
					list[index]);
			assertNotNull(list[index]);
			System.out.println(message);
		}
	}
	
	/**
	 * Tests the getProgramROMNames method in the PacCatalog class.
	 */
	@Test
	public final void testGetProgramROMNames() {
		String[] programROMNames = pacCatalog.getProgramROMNames();
		assertList(programROMNames);
	}
	
	/**
	 * Tests the getGraphicROMNames method in the PacCatalog class.
	 */
	@Test
	public final void testGetGraphicROMNames() {
		String[] graphicROMNames = pacCatalog.getGraphicROMNames();
		assertList(graphicROMNames);
	}
	
	/**
	 * Tests the getColorROMNames method in the PacCatalog class.
	 */
	@Test
	public final void testGetColorROMs() {
		String[] colorROMNames = pacCatalog.getColorROMNames();
		assertList(colorROMNames);
	}
	
	/**
	 * Tests the getPaletteROMNames method in the PacCatalog class.
	 */
	@Test
	public final void testGetPaletteROMNames() {
		String[] paletteROMNames = pacCatalog.getPaletteROMNames();
		assertList(paletteROMNames);
	}
	
	/**
	 * Tests the getSoundROMNames method in the PacCatalog class.
	 */
	@Test
	public final void testGetSoundROMNames() {
		String[] soundROMNames = pacCatalog.getSoundROMNames();
		assertList(soundROMNames);
	}
	
	/**
	 * Tests the getMysteryROMNames method in the PacCatalog class.
	 */
	@Test
	public final void testGetMysteryROMNames() {
		String[] mysteryROMNames = pacCatalog.getMysteryROMNames();
		assertList(mysteryROMNames);
	}
	
	/**
	 * Constructs an instance of this test class.
	 * 
	 * @param pacCatalog The type of PacCatalog used for testing purposes.
	 */
	public TestPacCatalog(final PacCatalog pacCatalog) {
		this.pacCatalog = pacCatalog;
	}
}
