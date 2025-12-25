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

import io.github.thatgarlicdude.pacio.file.PacDirectory;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**A class that represents a ROM set directory.*/
public final class PacRomSet extends PacDirectory {
	
	/**The version of the ROM set.*/
	private final RomSetVersion romSetVersion;
	
	/**Returns the version of the ROM set.*/
	public RomSetVersion getRomSetVersion() {
		return romSetVersion;
	}
	
	/**Creates a new PacRomSet with a Path.*/
	public static PacRomSet from(final Path path) {
		PacRomSet romSet = new PacRomSet(path, RomSetVersion.UNKNOWN);
		return romSet;
	}
	
	/**Creates a new PacRomSet with a URI.*/
	public static PacRomSet from(final URI pathURI) {
		Path path = Paths.get(pathURI);
		return from(path);
	}
	
	/**Creates a new PacRomSet with a string.*/
	public static PacRomSet from(final String pathString) {
		Path path = Paths.get(pathString);
		return from(path);
	}
	
	/**Constructs an instance of this class.*/
	public PacRomSet(final Path path, final RomSetVersion romSetVersion) {
		super(path);
		this.romSetVersion = romSetVersion;
	}
}
