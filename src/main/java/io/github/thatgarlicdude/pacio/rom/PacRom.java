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

import io.github.thatgarlicdude.pacio.file.PacFile;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**A class that represents a ROM within a ROM set.*/
public final class PacRom extends PacFile {
	
	/**The type of the ROM.*/
	private final RomType romType;
	
	/**Opens the ROM.*/
	@Override
	public void open() throws IOException {
		super.open();
	}
	
	/**Returns the ROM type.*/
	public RomType getRomType() {
		return romType;
	}
	
	/**Creates a new PacRom with a Path.*/
	public static PacRom from(final Path path) {
		PacRom rom = new PacRom(path, RomType.UNKNOWN);
		return rom;
	}
	
	/**Creates a new PacRom with a URI.*/
	public static PacRom from(final URI pathURI) {
		Path path = Paths.get(pathURI);
		return from(path);
	}
	
	/**Creates a new PacRom with a string.*/
	public static PacRom from(final String pathString) {
		Path path = Paths.get(pathString);
		return from(path);
	}
	
	/**Constructs an instance of the class.*/
	public PacRom(final Path path, final RomType romType) {
		super(path);
		this.romType = romType;
	}
	
	/**Constructs an instance of the class.*/
	public PacRom(final Path path) {
		this(path, RomType.UNKNOWN);
	}
}
