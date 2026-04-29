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

import io.github.thatgarlicdude.pacio.catalog.PacCatalog;
import io.github.thatgarlicdude.pacio.catalog.PacCatalogManager;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * A class used to import the <i>Pac-Man</i> ROM set ZIP files to
 * {@link io.github.thatgarlicdude.pacio.io.PacROMSet PacROMSet} objects,
 * which represent as digital, unified ROM sets in memory.
 * 
 * <p>The main method of this class is the {@link #importROMSet()
 * importROMSet} method, which is used to turn existing <i>Pac-Man</i>
 * ROM set ZIP files from disk into unified ROM sets to memory.</p>
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class PacROMSetImporter {
	
	/**
	 * The size of a buffer used to read the file entries in a ZIP file.
	 */
	private static final int BUFFER_SIZE = 256;
	
	/**
	 * The file path to the original source ROM set ZIP file.
	 */
	private final String path;
	
	/**
	 * Imports an existing <i>Pac-Man</i> ROM set ZIP file from disk to a
	 * {@link IOException.github.thatgarlicdude.io.PacROMSet PacROMSet}
	 * object to memory, which are unified ROM sets.
	 * 
	 * @return A unified ROM set built off of the existing ROM set ZIP
	 * file.
	 * @throws IOException When accessing the ZIP file fails.
	 */
	public final PacROMSet importROMSet() throws IOException {
		PacCatalog[] pacCatalogs = PacCatalogManager.getPacCatalogs();
		ZipFile zipFile = new ZipFile(path);
		byte[] programData = null;
		byte[] graphicData = null;
		byte[] colorData = null;
		byte[] paletteData = null;
		byte[] soundData = null;
		byte[] mysteryData = null;
		// Go through each of the PacCatalogs to scan through.
		for (PacCatalog pacCatalog : pacCatalogs) {
			// Concatenate the ROMs.
			try {
				programData = concatProgramROMs(zipFile, pacCatalog);
				graphicData = concatGraphicROMs(zipFile, pacCatalog);
				colorData = concatColorROMs(zipFile, pacCatalog);
				paletteData = concatPaletteROMs(zipFile, pacCatalog);
				soundData = concatSoundROMs(zipFile, pacCatalog);
				mysteryData = concatMysteryROMs(zipFile, pacCatalog);
				break;
			} catch(final FileNotFoundException exception) {
				// Just continue when a ROM isn't found.
				// TODO: Make this print an error instead of continuing.
				continue;
			}
		}
		// Return the PacROMSet.
		return new PacROMSet(programData, graphicData, colorData,
				paletteData, soundData, mysteryData);
	}
	
	/**
	 * Concatenate a specific group of ROMs into a single byte array.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param filenames A list of filenames that the ZIP file will look
	 * for.
	 * @return A single byte array that has all the byte data from the ROM
	 * files.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatROMs(
			final ZipFile zipFile,
			final String[] filenames) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = 0;
		// Go through each of the filenames in the PacCatalog list.
		for (String filename : filenames) {
			ZipEntry zipEntry = zipFile.getEntry(filename);
			// Throw an error when a ROM file name is not found.
			if (zipEntry == null)
				throw new FileNotFoundException(filename);
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
		}
		// Return the byte array.
		return stream.toByteArray();
	}
	
	/**
	 * Concatenate the program ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of program data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatProgramROMs(
			final ZipFile zipFile,
			final PacCatalog pacCatalog) throws IOException {
		return concatROMs(zipFile, pacCatalog.getProgramROMNames());
	}
	
	/**
	 * Concatenate the graphic ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of graphic data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatGraphicROMs(
			final ZipFile zipFile,
			final PacCatalog pacCatalog) throws IOException {
		return concatROMs(zipFile, pacCatalog.getGraphicROMNames());
	}
	
	/**
	 * Concatenate the color ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of color data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatColorROMs(
			final ZipFile zipFile,
			final PacCatalog pacCatalog) throws IOException {
		return concatROMs(zipFile, pacCatalog.getColorROMNames());
	}
	
	/**
	 * Concatenate the palette ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of palette data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatPaletteROMs(
			final ZipFile zipFile,
			final PacCatalog pacCatalog) throws IOException {
		return concatROMs(zipFile, pacCatalog.getPaletteROMNames());
	}
	
	/**
	 * Concatenate the sound ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of sound data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatSoundROMs(
			final ZipFile zipFile,
			final PacCatalog pacCatalog) throws IOException {
		return concatROMs(zipFile, pacCatalog.getSoundROMNames());
	}
	
	/**
	 * Concatenate the mystery ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param zipFile The ZIP file that will be used to access the ROM
	 * entry.
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of mystery data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatMysteryROMs(
			final ZipFile zipFile,
			final PacCatalog pacCatalog) throws IOException {
		return concatROMs(zipFile, pacCatalog.getMysteryROMNames());
	}
	
	/**
	 * Constructs an instance of the ROM set importer.
	 * 
	 * @param path The file path to the unified ROM set.
	 */
	public PacROMSetImporter(final String path) {
		this.path = path;
	}
}
