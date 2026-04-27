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

import java.io.IOException;
import java.util.zip.ZipFile;

import io.github.thatgarlicdude.pacio.io.PacROMSetImporter;
import io.github.thatgarlicdude.pacio.rom.PacROMSet;

/**
 * The main class of the PacIO library.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacIO {
	
	/**
	 * Error message used when the constructor has been called.
	 */
	private static final String ERROR_MESSAGE =
			"PacIO can't be instantiated";
	
	/**
	 * Imports an existing Pac-Man ROM set to a universal ROM set.
	 * 
	 * @param path The file path to the original ROM set.
	 * @return A universal, assembled Pac-Man ROM set.
	 * @throws IOException When accessing the ZIP file from disk fails.
	 */
	public static final PacROMSet importROMSet(final String path)
			throws IOException {
		ZipFile zipFile = new ZipFile(path);
		return new PacROMSetImporter(zipFile).importROMSet();
	}
	
	/**
	 * Opens an existing universal Pac-Man ROM set to memory.
	 * 
	 * @param path The file path to the universal ROM set.
	 * @return A universal, assembled Pac-Man ROM set.
	 * @throws IOException When accessing the ZIP file from disk fails.
	 */
	public static final PacROMSet openROMSet(final String path)
			throws IOException {
		// TODO: There needs to be a ROM builder for this.
		PacROMSet pacROMSet = null;
		return pacROMSet;
	}
	
	/**
	 * Saves the universal Pac-Man ROM set to disk.
	 * 
	 * @param path The destination file path.
	 * @throws IOException When saving the ZIP file from disk fails.
	 */
	public static final void saveROMSet(final String path)
			throws IOException {
		return;
	}
	
	/**
	 * Private constructor; object cannot be instantiated by any means.
	 * 
	 * @throws UnsupportedOperationException When the constructor is
	 * called.
	 */
	private PacIO() {
		throw new UnsupportedOperationException(ERROR_MESSAGE);
	}
}
