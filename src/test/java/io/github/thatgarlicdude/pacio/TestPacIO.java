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

import io.github.thatgarlicdude.pacio.rom.PacROM;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

/**
 * A test class of the PacIO class.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class TestPacIO {
	
	/**
	 * The file path to the test ROM set ZIP file.
	 */
	private static final URL zipFile = TestPacIO.class.getClassLoader()
			.getResource("testROMSet.zip");
	
	/**
	 * Test method for the isLibrary method in the PacIO class.
	 */
	@Test
	public final void testIsLibrary() {
		boolean isLibrary = PacIO.isLibrary();
		assertSame(isLibrary, true);
		System.out.println("Is this program a library?: " + isLibrary);
	}
	
	/**
	 * Test method for the importROMSet method in the PacIO class.
	 * 
	 * @throws IOException When accessing the ZIP file fails.
	 */
	@Test
	public final void testImportROMSet() throws IOException {
		PacROM pacROM = PacIO.importROMSet(zipFile.getFile());
		System.out.println(new String(pacROM.getProgramData()));
		System.out.println(new String(pacROM.getGraphicData()));
		System.out.println(new String(pacROM.getColorData()));
		System.out.println(new String(pacROM.getPaletteData()));
		System.out.println(new String(pacROM.getSoundData()));
	}
	
	/**
	 * Test method for the openROMSet method in the PacIO class.
	 */
	@Test
	public final void testOpenROMSet() {
		
	}
	
	/**
	 * Test method for the saveROMSet method in the PacIO class.
	 */
	@Test
	public final void testSaveROMSet() {
		
	}
}
