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

package io.github.thatgarlicdude.pacio.file;

import static io.github.thatgarlicdude.pacio.ResourceGetter.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**A class used for testing the PacFile class.*/
class TestPacFile {
	
	/**Tests the constructor with only the path.*/
	@Test
	void testCreate1() throws URISyntaxException {
		Path path = Paths.get(getTestRom1URI());
		PacFile file = new PacFile(path);
		assertNotNull(file);
	}
	
	/**Tests the constructor with the path and data.*/
	@Test
	void testCreate2() throws URISyntaxException {
		Path path = Paths.get(getTestRom1URI());
		byte[] data = new byte[8];
		PacFile file = new PacFile(path, data);
		assertNotNull(file);
	}
	
	/**Tests the from method using a path.*/
	@Test
	void testFromPath() throws URISyntaxException {
		Path path = Paths.get(getTestRom1URI());
		PacFile file = PacFile.from(path);
		assertNotNull(file);
	}
	
	/**Tests the from method using a URI.*/
	@Test
	void testFromURI() throws URISyntaxException {
		URI uri = getTestRom1URI();
		PacFile file = PacFile.from(uri);
		assertNotNull(file);
	}
	
	/**Tests the from method using a string.*/
	@Test
	void testFromString() throws URISyntaxException {
		String string = getTestRom1URI().getPath();
		PacFile file = PacFile.from(string);
		assertNotNull(file);
	}
	
	/**Tests the open method of the class.*/
	@Test
	void testOpen() throws URISyntaxException, IOException {
		PacFile file = PacFile.from(getTestRom1URI());
		byte[] data = null;
		file.open();
		data = file.readAll();
		for(byte b : data) {
			System.out.println((char) b);
			assertNotNull(b);
		}
		file.close();
	}
}
