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

package io.github.thatgarlicdude.pacio;

import io.github.thatgarlicdude.pacio.rom.PacRom;
import io.github.thatgarlicdude.pacio.rom.PacRomSet;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

/**The main class of the PacIO library.*/
public final class PacIO {
	
	/**Creates a new PacRom through a Path interface, and automatically opens it.*/
	public static final PacRom newPacRom(final Path path) throws IOException {
		return PacRom.open(path);
	}
	
	/**Creates a new PacRom through a URI object, and automatically opens it.*/
	public static final PacRom newPacRom(final URI pathURI) throws IOException {
		return PacRom.open(pathURI);
	}
	
	/**Creates a new PacRom through a string, and automatically opens it.*/
	public static final PacRom newPacRom(final String pathString) throws IOException {
		return PacRom.open(pathString);
	}
	
	/**Creates a new PacRomSet through a Path interface, and automatically opens it.*/
	public static final PacRomSet newPacRomSet(final Path path) throws IOException {
		return PacRomSet.open(path);
	}
	
	/**Creates a new PacRomSet through a URI object, and automatically opens it.*/
	public static final PacRomSet newPacRomSet(final URI pathURI) throws IOException {
		return PacRomSet.open(pathURI);
	}
	
	/**Creates a new PacRomSet through a string, and automatically opens it.*/
	public static final PacRomSet newPacRomSet(final String pathString) throws IOException {
		return PacRomSet.open(pathString);
	}
}
