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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * A class used to open unified <i>Pac-Man</i> ROM set ZIP files from
 * disk.
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class PacROMSetOpener implements PacROMSetFilenames {
	
	/**
	 * The size of a buffer used to read the file entries in a ZIP file.
	 */
	private static final int BUFFER_SIZE = 256;
	
	/**
	 * The file path to the unified ROM set ZIP file.
	 */
	private final String path;
	
	/**
	 * Opens the unified ROM set from disk.
	 * 
	 * @return A unified Pac-Man ROM set with all the data loaded to
	 * memory.
	 * @throws IOException When the opening process fails.
	 */
	public final PacROMSet openROMSet() throws IOException {
		ZipFile zipFile = new ZipFile(path);
		byte[] programData = openProgramROM(zipFile);
		byte[] graphicData = openGraphicROM(zipFile);
		byte[] colorData = openColorROM(zipFile);
		byte[] paletteData = openPaletteROM(zipFile);
		byte[] soundData = openSoundROM(zipFile);
		byte[] mysteryData = openMysteryROM(zipFile);
		return new PacROMSet(
				programData, graphicData, colorData, paletteData,
				soundData, mysteryData);
	}
	
	/**
	 * Opens a ROM entry in the unified ROM set ZIP file, loading its byte
	 * data to memory.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param name The name of the ROM entry in the unified ROM set ZIP
	 * file.
	 * @return The loaded byte data from the ROM entry.
	 * @throws IOException When the opening process fails.
	 */
	private final byte[] openROM(final ZipFile zipFile, final String name)
			throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ZipEntry zipEntry = zipFile.getEntry(name);
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = 0;
		// Throw an error when the ROM entry isn't found.
		if (zipEntry == null) throw new FileNotFoundException(name);
		// Create the InputStream for the ZIP entry.
		try (InputStream inputStream =
				zipFile.getInputStream(zipEntry)) {
			/*
			 * Stop when the buffer is full or it reached the end of
			 * the ZIP entry.
			 */
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				stream.write(buffer, 0, bytesRead);
			}
		}
		// Return the byte array.
		return stream.toByteArray();
	}
	
	/**
	 * Opens the program.bin file in the unified ROM set.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @return The full byte data of the program.bin file.
	 * @throws IOException When the opening process fails.
	 */
	private final byte[] openProgramROM(final ZipFile zipFile)
			throws IOException {
		return openROM(zipFile, getProgramName());
	}
	
	/**
	 * Opens the graphic.bin file in the unified ROM set.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @return The full byte data of the graphic.bin file.
	 * @throws IOException When the opening process fails.
	 */
	private final byte[] openGraphicROM(final ZipFile zipFile)
			throws IOException {
		return openROM(zipFile, getGraphicName());
	}
	
	/**
	 * Opens the color.bin file in the unified ROM set.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @return The full byte data of the color.bin file.
	 * @throws IOException When the opening process fails.
	 */
	private final byte[] openColorROM(final ZipFile zipFile)
			throws IOException {
		return openROM(zipFile, getColorName());
	}
	
	/**
	 * Opens the palette.bin file in the unified ROM set.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @return The full byte data of the palette.bin file.
	 * @throws IOException When the opening process fails.
	 */
	private final byte[] openPaletteROM(final ZipFile zipFile)
			throws IOException {
		return openROM(zipFile, getPaletteName());
	}
	
	/**
	 * Opens the sound.bin file in the unified ROM set.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @return The full byte data of the sound.bin file.
	 * @throws IOException When the opening process fails.
	 */
	private final byte[] openSoundROM(final ZipFile zipFile)
			throws IOException {
		return openROM(zipFile, getSoundName());
	}
	
	/**
	 * Opens the mystery.bin file in the unified ROM set.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @return The full byte data of the mystery.bin file.
	 * @throws IOException When the opening process fails.
	 */
	private final byte[] openMysteryROM(final ZipFile zipFile)
			throws IOException {
		return openROM(zipFile, getMysteryName());
	}
	
	/**
	 * Constructs an instance of the unified ROM set opener.
	 * 
	 * @param path The file path to the unified ROM set.
	 */
	public PacROMSetOpener(final String path) {
		this.path = path;
	}
}
