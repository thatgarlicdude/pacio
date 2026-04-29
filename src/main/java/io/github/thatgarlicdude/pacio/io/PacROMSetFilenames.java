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

/**
 * An interface containing filenames for a unified <i>Pac-Man</i>
 * ROM-set.
 * 
 * <p>This interface is implemented by the {@link
 * io.github.thatgarlicdude.pacio.io.PacROMSetOpener PacROMSetOpener}
 * and the {@link
 * io.github.thatgarlicdude.pacio.io.PacROMSetSaver PacROMSetSaver}
 * classes. It is used to get the filenames such as <b>program.bin</b> and
 * <b>graphic.bin</b>, which are used when accessing or saving the
 * entries from a unified ROM set ZIP file.</p>
 * 
 * <p>Methods include {@link #getProgramName}, {@link #getGraphicName},
 * {@link #getColorName}, {@link #getPaletteName}, {@link #getSoundName},
 * and {@link #getMysteryName}. They are all default methods, so the
 * classes that implement this interface don't need to fill out the
 * methods with their own code.</p>
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public interface PacROMSetFilenames {
	
	/**
	 * The filename for the <b>program.bin</b> entry.
	 */
	static final String programName = "program.bin";
	
	/**
	 * The filename for the <b>graphic.bin</b> entry.
	 */
	static final String graphicName = "graphic.bin";
	
	/**
	 * The filename for the <b>color.bin</b> entry.
	 */
	static final String colorName = "color.bin";
	
	/**
	 * The filename for the <b>palette.bin</b> entry.
	 */
	static final String paletteName = "palette.bin";
	
	/**
	 * The filename for the <b>sound.bin</b> entry.
	 */
	static final String soundName = "sound.bin";
	
	/**
	 * The filename for the <b>mystery.bin</b> entry.
	 */
	static final String mysteryName = "mystery.bin";
	
	/**
	 * Gets the {@link #programName}, which is the filename of the
	 * <b>program.bin</b> entry.
	 * 
	 * @return The filename of the <b>program.bin</b> entry as a string.
	 */
	public default String getProgramName() {
		return programName;
	}
	
	/**
	 * Gets the {@link #graphicName}, which is the filename of the
	 * <b>graphic.bin</b> entry.
	 * 
	 * @return The filename of the <b>graphic.bin</b> entry as a string.
	 */
	public default String getGraphicName() {
		return graphicName;
	}
	
	/**
	 * Gets the {@link #colorName}, which is the filename of the
	 * <b>color.bin</b> entry.
	 * 
	 * @return The filename of the <b>color.bin</b> entry as a string.
	 */
	public default String getColorName() {
		return colorName;
	}
	
	/**
	 * Gets the {@link #paletteName}, which is the filename of the
	 * <b>palette.bin</b> entry.
	 * 
	 * @return The filename of the <b>palette.bin</b> entry as a string.
	 */
	public default String getPaletteName() {
		return paletteName;
	}
	
	/**
	 * Gets the {@link #soundName}, which is the filename of the
	 * <b>sound.bin</b> entry.
	 * 
	 * @return The filename of the <b>sound.bin</b> entry as a string.
	 */
	public default String getSoundName() {
		return soundName;
	}
	
	/**
	 * Gets the {@link #mysteryName}, which is the filename of the
	 * <b>mystery.bin</b> entry.
	 * 
	 * @return The filename of the <b>mystery.bin</b> entry as a string.
	 */
	public default String getMysteryName() {
		return mysteryName;
	}
}
