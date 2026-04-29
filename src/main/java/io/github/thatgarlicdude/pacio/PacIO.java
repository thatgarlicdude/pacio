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

import io.github.thatgarlicdude.pacio.io.PacROMSet;
import io.github.thatgarlicdude.pacio.io.PacROMSetImporter;
import io.github.thatgarlicdude.pacio.io.PacROMSetOpener;
import io.github.thatgarlicdude.pacio.io.PacROMSetSaver;

import java.io.IOException;

/**
 * The main class of the PacIO library.
 * 
 * <p>This class serves as the main gateway for importing <i>Pac-Man</i>
 * ROM sets into a {@link
 * io.github.thatgarlicdude.pacio.io.PacROMSet PacROMSet} instance, which
 * resemble <b>unified ROM sets</b>, using the {@link #importROMSet}
 * method. It can also save the unified ROM sets to disk as ZIP files via
 * the {@link #saveROMSet} method, and open them into memory with the
 * {@link #openROMSet} method. It is the go-to class for accessing and
 * managing <i>Pac-Man</i> ROM sets.</p>
 * 
 * <p>Because this is a main class for a library, it cannot be
 * instantiated by any means via its private constructor,
 * {@link #PacIO()}. All methods in this class are static, and can easily
 * be accessed. No need to worry about creating an instance of this
 * class.</p>
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class PacIO {
	
	/**
	 * Error message used when the constructor has been called.
	 */
	private static final String ERROR_MESSAGE =
			"PacIO can't be instantiated";
	
	/**
	 * Imports an existing <i>Pac-Man</i> ROM set into a
	 * {@link io.github.thatgarlicdude.pacio.io.PacROMSet PacROMSet}
	 * instance, which is the unified version of the said ROM set.
	 * 
	 * <p>A notable example for this is importing a ZIP file called
	 * <b>pacman.zip</b>, which contains all the original ROM files from
	 * the ROM set ZIP file. Another example would be <b>puckman.zip</b>,
	 * which is the same thing. Both ROM set ZIP files can be converted
	 * into their respective unified ROM sets via this method.</p>
	 * 
	 * <p>On the other note, this method should not work on existing
	 * unified versions of the ROM set ZIP file. To open these kinds of
	 * ZIP files, the {@link #openROMSet} method should be relied on.</p>
	 * 
	 * @param path The file path to the original ROM set ZIP file.
	 * @return An instance of the unified <i>Pac-Man</i> ROM set.
	 * @throws IOException When accessing the ZIP file from disk fails.
	 */
	public static final PacROMSet importROMSet(final String path)
			throws IOException {
		return new PacROMSetImporter(path).importROMSet();
	}
	
	/**
	 * Opens an existing unified <i>Pac-Man</i> ROM set ZIP file to
	 * memory.
	 * 
	 * <p>This method should only work on unified versions of the
	 * <i>Pac-Man</i> ROM set ZIP files, which contains entries like
	 * <b>program.bin</b> and <b>graphic.bin</b>. It should not work on
	 * the original ROM set ZIP files, which have their own ROM files.
	 * They should be imported via the {@link #importROMSet} method
	 * instead.</p>
	 * 
	 * @param path The file path to the universal ROM set ZIP file.
	 * @return An instance of the unified <i>Pac-Man</i> ROM set.
	 * @throws IOException When accessing the ZIP file from disk fails.
	 */
	public static final PacROMSet openROMSet(final String path)
			throws IOException {
		return new PacROMSetOpener(path).openROMSet();
	}
	
	/**
	 * Saves the unified <i>Pac-Man</i> ROM set to disk as a ZIP file.
	 * 
	 * <p>This should create a new ZIP file if it doesn't exist on disk.
	 * Otherwise, it'll just overwrite the data.</p>
	 * 
	 * @param path The destination file path to the ZIP file.
	 * @param pacROMSet The unified <i>Pac-Man</i> ROM set.
	 * @throws IOException When saving the ZIP file from disk fails.
	 */
	public static final void saveROMSet(
			final String path,
			final PacROMSet pacROMSet) throws IOException {
		new PacROMSetSaver(pacROMSet, path).saveROMSet();
	}
	
	/**
	 * Private constructor; class cannot be instantiated by any means.
	 * 
	 * <p>Even if the constructor has somehow been called, it will throw
	 * an error, saying that the class cannot instantiated.</p>
	 * 
	 * @throws UnsupportedOperationException When the constructor is
	 * called.
	 */
	private PacIO() {
		throw new UnsupportedOperationException(ERROR_MESSAGE);
	}
}
