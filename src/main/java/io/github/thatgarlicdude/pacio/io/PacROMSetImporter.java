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
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import io.github.thatgarlicdude.pacio.catalog.PacCatalog;
import io.github.thatgarlicdude.pacio.catalog.PacCatalogManager;
import io.github.thatgarlicdude.pacio.exception.PacROMNotFoundException;
import io.github.thatgarlicdude.pacio.rom.PacROMSet;

/**
 * A class used to import Pac-Man ROMs to universal ROM sets.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacROMSetImporter {
	
	/**
	 * The size of a buffer used to read ZIP entry files.
	 */
	private static final int BUFFER_SIZE = 256;
	
	/**
	 * The ZIP file required to import the universal ROM set.
	 */
	private final ZipFile zipFile;
	
	/**
	 * Imports an existing Pac-Man ROM set into a universal ROM set.
	 * 
	 * @return A universal ROM set built off of the existing ROM set.
	 * @throws IOException When accessing the ZIP file fails.
	 */
	public final PacROMSet importROMSet() throws IOException {
		PacCatalog[] pacCatalogs = PacCatalogManager.getPacCatalogs();
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
				programData = concatProgramROMs(pacCatalog);
				graphicData = concatGraphicROMs(pacCatalog);
				colorData = concatColorROMs(pacCatalog);
				paletteData = concatPaletteROMs(pacCatalog);
				soundData = concatSoundROMs(pacCatalog);
				mysteryData = concatMysteryROMs(pacCatalog);
			} catch(final PacROMNotFoundException exception) {
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
	 * @param filenames A list of filenames that the ZIP file will look
	 * for.
	 * @return A single byte array that has all the byte data from the ROM
	 * files.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatROMs(final String[] filenames)
			throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = 0;
		// Go through each of the filenames in the PacCatalog list.
		for (String filename : filenames) {
			ZipEntry zipEntry = zipFile.getEntry(filename);
			// Throw an error when a ROM file name is not found.
			if (zipEntry == null)
				throw new PacROMNotFoundException(filename);
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
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of program data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatProgramROMs(final PacCatalog pacCatalog)
			throws IOException {
		return concatROMs(pacCatalog.getProgramROMNames());
	}
	
	/**
	 * Concatenate the graphic ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of graphic data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatGraphicROMs(final PacCatalog pacCatalog)
			throws IOException {
		return concatROMs(pacCatalog.getGraphicROMNames());
	}
	
	/**
	 * Concatenate the color ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of color data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatColorROMs(final PacCatalog pacCatalog)
			throws IOException {
		return concatROMs(pacCatalog.getColorROMNames());
	}
	
	/**
	 * Concatenate the palette ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of palette data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatPaletteROMs(final PacCatalog pacCatalog)
			throws IOException {
		return concatROMs(pacCatalog.getGraphicROMNames());
	}
	
	/**
	 * Concatenate the sound ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of sound data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatSoundROMs(final PacCatalog pacCatalog)
			throws IOException {
		return concatROMs(pacCatalog.getProgramROMNames());
	}
	
	/**
	 * Concatenate the mystery ROMs from the ZIP file into a single byte
	 * array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return A concatenated byte array of mystery data.
	 * @throws IOException When reading the ZIP file fails.
	 */
	private final byte[] concatMysteryROMs(final PacCatalog pacCatalog)
			throws IOException {
		return concatROMs(pacCatalog.getGraphicROMNames());
	}
	
	/**
	 * Constructs an instance of the ROM set importer.
	 * 
	 * @param zipFile The ZIP file needed to import the universal ROM set.
	 */
	public PacROMSetImporter(final ZipFile zipFile) {
		this.zipFile = zipFile;
	}
}
