/*
 * Copyright 2025 GarlicDude
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

package io.github.thatgarlicdude.pacio.rom;

import io.github.thatgarlicdude.pacio.ResourceGetter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**The test class for PacRomSetOpener*/
final class TestPacRomSetOpener {
	
	/**Opens a PacRomSet using a path.*/
	@Test
	void testOpenPath() throws URISyntaxException, IOException {
		URI testRomSetURI = ResourceGetter.getTestRomSetURI();
		Path testRomSetPath = Paths.get(testRomSetURI);
		PacRomSet romSet = PacRomSetOpener.open(testRomSetPath);
		assertNotNull(romSet);
		romSet.close();
	}
	
	/**Opens a PacRomSet using a URI.*/
	@Test
	void testOpenURI() throws URISyntaxException, IOException {
		URI testRomSetURI = ResourceGetter.getTestRomSetURI();
		PacRomSet romSet = PacRomSetOpener.open(testRomSetURI);
		assertNotNull(romSet);
		romSet.close();
	}
	
	/**Opens a PacRomSet using a String.*/
	@Test
	void testOpenString() throws URISyntaxException, IOException {
		URI testRomSetURI = ResourceGetter.getTestRomSetURI();
		String testRomSetString = testRomSetURI.getPath();
		PacRomSet romSet = PacRomSetOpener.open(testRomSetString);
		assertNotNull(romSet);
		romSet.close();
	}
}
