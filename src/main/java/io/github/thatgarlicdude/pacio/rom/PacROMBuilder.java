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

package io.github.thatgarlicdude.pacio.rom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

import io.github.thatgarlicdude.pacio.catalog.PacCatalog;
import io.github.thatgarlicdude.pacio.catalog.PacCatalogManager;
import io.github.thatgarlicdude.pacio.exception.PacROMNotFoundException;
import io.github.thatgarlicdude.pacio.io.PacZip;

/**
 * A class that builds universal ROM sets.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacROMBuilder {
	
	/**
	 * The size of a buffer used to read ZIP entry files.
	 */
	private static final int BUFFER_SIZE = 256;
	
	/**
	 * The ZIP file required to build the universal ROM set.
	 */
	private final PacZip pacZip;
	
	/**
	 * Turns the ZIP file into a universal ROM set.
	 * 
	 * @return A universal, assembled ROM set.
	 * @throws IOException 
	 */
	public final PacROMSet buildROM() throws IOException {
		PacROMSet pacROM = null;
		PacCatalog[] pacCatalogs = PacCatalogManager.getPacCatalogs();
		byte[] programData = null;
		byte[] graphicData = null;
		byte[] colorData = null;
		byte[] paletteData = null;
		byte[] soundData = null;
		byte[] mysteryData = null;
		// Go through each of the PacCatalogs to scan through.
		for (PacCatalog pacCatalog : pacCatalogs) {
			// Assemble the ROMs, and make sure they're found.
			try {
				programData = assembleProgramROMs(pacCatalog);
				graphicData = assembleGraphicROMs(pacCatalog);
				colorData = assembleColorROMs(pacCatalog);
				paletteData = assemblePaletteROMs(pacCatalog);
				soundData = assembleSoundROMs(pacCatalog);
				mysteryData = assembleMysteryROMs(pacCatalog);
			} catch(final PacROMNotFoundException exception) {
				continue;
			}
		}
		// Build the PacROM.
		pacROM = new PacROMSet(programData, graphicData, colorData,
				paletteData, soundData, mysteryData);
		// Return the PacROM.
		return pacROM;
	}
	
	/**
	 * Assembles multiple ROM files into a single byte array.
	 * 
	 * @param filenames A list of filenames in a PacCatalog.
	 * @return A single byte array containing all the bytes in the files.
	 * @throws IOException When accessing the ZIP entries fails.
	 */
	private final byte[] assembleROMs(final String[] filenames)
			throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = 0;
		// Go through each of the filenames in the PacCatalog list.
		for (String filename : filenames) {
			ZipEntry zipEntry = pacZip.getEntry(filename);
			// Throw an error when a ROM file name is not found.
			if (zipEntry == null)
				throw new PacROMNotFoundException(filename);
			// Create the InputStream for the ZIP entry.
			try (InputStream inputStream =
					pacZip.getInputStream(zipEntry)) {
				/*
				 * Stop when the buffer is full or it reached the end of
				 * the ZIP entry.
				 */
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					stream.write(buffer, 0, bytesRead);
				}
			}
		}
		return stream.toByteArray();
	}
	
	/**
	 * Assembles all the program ROMs into a single byte array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return An assembled byte array of the program ROMs.
	 * @throws IOException When accessing the ZIP entries fails.
	 */
	private final byte[] assembleProgramROMs(final PacCatalog pacCatalog)
			throws IOException {
		String[] programROMs = pacCatalog.getProgramROMNames();
		byte[] programData = assembleROMs(programROMs);
		return programData;
	}
	
	/**
	 * Assembles all the graphic ROMs into a single byte array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return An assembled byte array of the graphic ROMs.
	 * @throws IOException When accessing the ZIP entries fails.
	 */
	private final byte[] assembleGraphicROMs(final PacCatalog pacCatalog)
			throws IOException {
		String[] graphicROMs = pacCatalog.getGraphicROMNames();
		byte[] graphicData = assembleROMs(graphicROMs);
		return graphicData;
	}
	
	/**
	 * Assembles all the color ROMs into a single byte array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return An assembled byte array of the color ROMs.
	 * @throws IOException When accessing the ZIP entries fails.
	 */
	private final byte[] assembleColorROMs(final PacCatalog pacCatalog)
			throws IOException {
		String[] colorROMs = pacCatalog.getColorROMNames();
		byte[] colorData = assembleROMs(colorROMs);
		return colorData;
	}
	
	/**
	 * Assembles all the palette ROMs into a single byte array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return An assembled byte array of the palette ROMs.
	 * @throws IOException When accessing the ZIP entries fails.
	 */
	private final byte[] assemblePaletteROMs(final PacCatalog pacCatalog)
			throws IOException {
		String[] paletteROMs = pacCatalog.getPaletteROMNames();
		byte[] paletteData = assembleROMs(paletteROMs);
		return paletteData;
	}
	
	/**
	 * Assembles all the sound ROMs into a single byte array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return An assembled byte array of the sound ROMs.
	 * @throws IOException When accessing the ZIP entries fails.
	 */
	private final byte[] assembleSoundROMs(final PacCatalog pacCatalog)
			throws IOException {
		String[] soundROMs = pacCatalog.getSoundROMNames();
		byte[] soundData = assembleROMs(soundROMs);
		return soundData;
	}
	
	/**
	 * Assembles all the mystery ROMs into a single byte array.
	 * 
	 * @param pacCatalog The PacCatalog needed to access the list.
	 * @return An assembled byte array of the mystery ROMs.
	 * @throws IOException When accessing the ZIP entries fails.
	 */
	private final byte[] assembleMysteryROMs(final PacCatalog pacCatalog)
			throws IOException {
		String[] mysteryROMs = pacCatalog.getMysteryROMNames();
		byte[] mysteryData = assembleROMs(mysteryROMs);
		return mysteryData;
	}
	
	/**
	 * Constructs an instance of the ROM builder.
	 * 
	 * @param pacZip The ZIP file required to build the universal ROM set.
	 */
	public PacROMBuilder(final PacZip pacZip) {
		this.pacZip = pacZip;
	}
}
