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

package io.github.thatgarlicdude.pacio;

import org.junit.Test;

import io.github.thatgarlicdude.pacio.io.PacROMSet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

/**
 * A test class of the PacIO class.
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class TestPacIO {
	
	/**
	 * The file path to the test ROM set ZIP file.
	 */
	private static final URL zipFile = TestPacIO.class.getClassLoader()
			.getResource("testROMSet.zip");
	
	/**
	 * The file path to the test unified ROM set ZIP file.
	 */
	private static final URL unifiedZipFile = TestPacIO.class
			.getClassLoader().getResource("testUnifiedROMSet.zip");
	
	/**
	 * Test method for the importROMSet method in the PacIO class.
	 * 
	 * @throws IOException When accessing the ZIP file fails.
	 */
	@Test
	public final void testImportROMSet() throws IOException {
		PacROMSet pacROMSet = PacIO.importROMSet(zipFile.getFile());
		assertNotNull(pacROMSet);
		System.out.println(new String(pacROMSet.getProgramData()));
		System.out.println(new String(pacROMSet.getGraphicData()));
		System.out.println(new String(pacROMSet.getColorData()));
		System.out.println(new String(pacROMSet.getPaletteData()));
		System.out.println(new String(pacROMSet.getSoundData()));
		System.out.println(new String(pacROMSet.getMysteryData()));
	}
	
	/**
	 * Test method for the openROMSet method in the PacIO class.
	 * 
	 * @throws IOException When the opening process fails.
	 */
	@Test
	public final void testOpenROMSet() throws IOException {
		PacROMSet pacROMSet = PacIO.openROMSet(unifiedZipFile.getFile());
		assertNotNull(pacROMSet);
		System.out.println(new String(pacROMSet.getProgramData()));
		System.out.println(new String(pacROMSet.getGraphicData()));
		System.out.println(new String(pacROMSet.getColorData()));
		System.out.println(new String(pacROMSet.getPaletteData()));
		System.out.println(new String(pacROMSet.getSoundData()));
		System.out.println(new String(pacROMSet.getMysteryData()));
	}
	
	/**
	 * Test method for the saveROMSet method in the PacIO class.
	 * 
	 * @throws IOException When the saving process fails.
	 */
	@Test
	public final void testSaveROMSet() throws IOException {
		PacROMSet pacROMSet = PacIO.importROMSet(zipFile.getFile());
		PacIO.saveROMSet(unifiedZipFile.getFile(), pacROMSet);
	}
}
