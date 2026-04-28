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

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * A class used to save unified Pac-Man ROM sets.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacROMSetSaver implements PacROMSetFilenames {
	
	/**
	 * The unified ROM set that is used to save on disk.
	 */
	private final PacROMSet pacROMSet;
	
	/**
	 * The destination file path.
	 */
	private final String path;
	
	/**
	 * Saves the unified ROM set to disk.
	 * 
	 * @throws IOException When the saving process fails.
	 */
	public final void saveROMSet() throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		ZipOutputStream zos = new ZipOutputStream(fos);
		saveProgramROM(zos);
		saveGraphicROM(zos);
		saveColorROM(zos);
		savePaletteROM(zos);
		saveSoundROM(zos);
		saveMysteryROM(zos);
		zos.close();
		fos.close();
	}
	
	/**
	 * Saves a specific ROM entry in the unified ROM set ZIP file.
	 * 
	 * @param zos The ZipOutputStream.
	 * @param name The name of the ZIP file entry.
	 * @param data The byte array that will be written on the ZIP file
	 * entry.
	 * @throws IOException When the saving process fails.
	 */
	private final void saveROM(
			final ZipOutputStream zos,
			final String name,
			final byte[] data) throws IOException {
		ZipEntry zipEntry = new ZipEntry(name);
		zos.putNextEntry(zipEntry);
		zos.write(data);
		zos.closeEntry();
	}
	
	/**
	 * Saves the program ROM entry in the unified ROM set ZIP file.
	 * 
	 * @param zos The ZipOutputStream.
	 * @throws IOException When the saving process fails.
	 */
	private final void saveProgramROM(final ZipOutputStream zos)
			throws IOException {
		saveROM(zos, getProgramName(), pacROMSet.getProgramData());
	}
	
	/**
	 * Saves the graphic ROM entry in the unified ROM set ZIP file.
	 * 
	 * @param zos The ZipOutputStream.
	 * @throws IOException When the saving process fails.
	 */
	private final void saveGraphicROM(final ZipOutputStream zos)
			throws IOException {
		saveROM(zos, getGraphicName(), pacROMSet.getGraphicData());
	}
	
	/**
	 * Saves the color ROM entry in the unified ROM set ZIP file.
	 * 
	 * @param zos The ZipOutputStream.
	 * @throws IOException When the saving process fails.
	 */
	private final void saveColorROM(final ZipOutputStream zos)
			throws IOException {
		saveROM(zos, getColorName(), pacROMSet.getColorData());
	}
	
	/**
	 * Saves the palette ROM entry in the unified ROM set ZIP file.
	 * 
	 * @param zos The ZipOutputStream.
	 * @throws IOException When the saving process fails.
	 */
	private final void savePaletteROM(final ZipOutputStream zos)
			throws IOException {
		saveROM(zos, getPaletteName(), pacROMSet.getPaletteData());
	}
	
	/**
	 * Saves the sound ROM entry in the unified ROM set ZIP file.
	 * 
	 * @param zos The ZipOutputStream.
	 * @throws IOException When the saving process fails.
	 */
	private final void saveSoundROM(final ZipOutputStream zos)
			throws IOException {
		saveROM(zos, getSoundName(), pacROMSet.getSoundData());
	}
	
	/**
	 * Saves the mystery ROM entry in the unified ROM set ZIP file.
	 * 
	 * @param zos The ZipOutputStream.
	 * @throws IOException When the saving process fails.
	 */
	private final void saveMysteryROM(final ZipOutputStream zos)
			throws IOException {
		saveROM(zos, getMysteryName(), pacROMSet.getMysteryData());
	}
	
	/**
	 * Constructs an instance of the unified ROM set saver.
	 * 
	 * @param pacROMSet The unified Pac-Man ROM set as an object.
	 * @param path The destination file path where the unified ROM Set
	 * will be saved on.
	 */
	public PacROMSetSaver(final PacROMSet pacROMSet, final String path) {
		this.pacROMSet = pacROMSet;
		this.path = path;
	}
}
