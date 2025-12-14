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

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**A class that handles opening the Pac-Man ROM set.*/
public interface PacRomOpener {
	
	/**Creates a new PacRom in memory and opens it automatically.*/
	public static PacRom open(final Path path) throws IOException {
		String name = path.getFileName().toString();
		byte[] data = Files.readAllBytes(path);
		PacRom rom = new PacRom(path, name, data);
		return rom;
	}
	
	/**Creates a new PacRom using a URI and opens it automatically.*/
	public static PacRom open(final URI pathURI) throws IOException {
		Path path = Paths.get(pathURI);
		PacRom rom = open(path);
		return rom;
	}
	
	/**Creates a new PacRom using a string and opens it automatically.*/
	public static PacRom open(final String pathString) throws IOException {
		Path path = Paths.get(pathString);
		PacRom rom = open(path);
		return rom;
	}
}
