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

/*
 * TODO: Perhaps this class needs to be reworked so it doesn't rely on
 * subclasses that are using the non-abstracted PacCatalog classes. With
 * the PacCatalog class turning to a different direction, like becoming
 * something that can be saved to disk and loaded back to memory, this
 * test class should be reworked somehow.
 */

/**
 * A test class of the PacCatalog class.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 * @see PacCatalog
 */
public abstract class TestPacCatalog {
	
	/**
	 * Placeholder message for the {@link #assertList(String[])} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #assertList(String[])
	 */
	private static final String PLACEHOLDER_MESSAGE =
			"List index %d: %s";
	
	/**
	 * The {@link PacCatalog} used for testing purposes.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	private final PacCatalog pacCatalog;
	
	/**
	 * Asserts a list within the {@link #pacCatalog} to check if it's not
	 * null, and makes sure its contents are not null either.
	 * 
	 * @param list The list the method wants to assert.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	private final void assertList(
			final String[] list) {
		// Make sure the list isn't null.
		assertNotNull(list);
		// Go through each of the list's filenames.
		for (int index = 0; index < list.length; index++) {
			// Get the filename in the list.
			final String filename = list[index];
			// Format the test message with the index and filename.
			final String message =
					String.format(PLACEHOLDER_MESSAGE, index, filename);
			// Make sure the filename isn't null either.
			assertNotNull(filename);
			// Print the test message.
			System.out.println(message);
		}
	}
	
	/**
	 * Tests the {@link PacCatalog#getProgramROMNames()} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalog#getProgramROMNames()
	 */
	@Test
	public final void testGetProgramROMNames() {
		// Get the array of program ROM filenames.
		final String[] programROMNames =
				pacCatalog.getProgramROMNames();
		// Make sure the list and its contents are not null.
		assertList(programROMNames);
		// Because this is a cloned array, of course they're not the same.
		assertNotSame(programROMNames, pacCatalog.programROMNames);
	}
	
	/**
	 * Tests the {@link PacCatalog#getGraphicROMNames()} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalog#getGraphicROMNames()
	 */
	@Test
	public final void testGetGraphicROMNames() {
		// Get the array of graphic ROM filenames.
		final String[] graphicROMNames =
				pacCatalog.getGraphicROMNames();
		// Make sure the list and its contents are not null.
		assertList(graphicROMNames);
		// Because this is a cloned array, of course they're not the same.
		assertNotSame(graphicROMNames, pacCatalog.graphicROMNames);
	}
	
	/**
	 * Tests the {@link PacCatalog#getColorROMNames()} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalog#getColorROMNames()
	 */
	@Test
	public final void testGetColorROMNames() {
		// Get the array of color ROM filenames.
		final String[] colorROMNames =
				pacCatalog.getColorROMNames();
		// Make sure the list and its contents are not null.
		assertList(colorROMNames);
		// Because this is a cloned array, of course they're not the same.
		assertNotSame(colorROMNames, pacCatalog.colorROMNames);
	}
	
	/**
	 * Tests the {@link PacCatalog#getPaletteROMNames()} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalog#getPaletteROMNames()
	 */
	@Test
	public final void testGetPaletteROMNames() {
		// Get the array of palette ROM filenames.
		final String[] paletteROMNames =
				pacCatalog.getPaletteROMNames();
		// Make sure the list and its contents are not null.
		assertList(paletteROMNames);
		// Because this is a cloned array, of course they're not the same.
		assertNotSame(paletteROMNames, pacCatalog.paletteROMNames);
	}
	
	/**
	 * Tests the {@link PacCatalog#getSoundROMNames()} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalog#getSoundROMNames()
	 */
	@Test
	public final void testGetSoundROMNames() {
		// Get the array of sound ROM filenames.
		final String[] soundROMNames =
				pacCatalog.getSoundROMNames();
		// Make sure the list and its contents are not null.
		assertList(soundROMNames);
		// Because this is a cloned array, of course they're not the same.
		assertNotSame(soundROMNames, pacCatalog.soundROMNames);
	}
	
	/**
	 * Tests the {@link PacCatalog#getMysteryROMNames()} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalog#getMysteryROMNames()
	 */
	@Test
	public final void testGetMysteryROMNames() {
		// Get the array of mystery ROM filenames.
		final String[] mysteryROMNames =
				pacCatalog.getMysteryROMNames();
		// Make sure the list and its contents are not null.
		assertList(mysteryROMNames);
		// Because this is a cloned array, of course they're not the same.
		assertNotSame(mysteryROMNames, pacCatalog.mysteryROMNames);
	}
	
	/**
	 * Constructs an instance of the {@link TestPacCatalog} class.
	 * 
	 * @param pacCatalog The type of {@link PacCatalog} used for testing
	 * purposes.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	public TestPacCatalog(final PacCatalog pacCatalog) {
		this.pacCatalog = pacCatalog;
	}
}
