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

package io.github.thatgarlicdude.pacio.io;

import java.io.IOException;
import java.util.zip.ZipFile;

import io.github.thatgarlicdude.pacio.rom.PacROM;

/**
 * A class that represents a Pac-Man ROM set ZIP file.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacZip extends ZipFile {
	
	/**
	 * Turns the ZIP file into a universal Pac-Man ROM set.
	 * 
	 * @return The universal Pac-Man ROM set.
	 */
	public final PacROM toPacROM() {
		// TODO: This is not finished.
		PacROM pacROM = null;
		return pacROM;
	}
	
	/**
	 * Constructs an instance of the ZIP file.
	 * 
	 * @param path The file path to the ZIP file.
	 * @throws IOException When accessing from disk fails.
	 */
	public PacZip(final String path) throws IOException {
		super(path);
	}
}
