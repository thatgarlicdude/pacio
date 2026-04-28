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
 * An interface containing filenames for a unified ROM-set.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public interface PacROMSetFilenames {
	
	/**
	 * The filename for the file containing program data.
	 */
	static final String programName = "program.bin";
	
	/**
	 * The filename for the file containing graphic data.
	 */
	static final String graphicName = "graphic.bin";
	
	/**
	 * The filename for the file containing color data.
	 */
	static final String colorName = "color.bin";
	
	/**
	 * The filename for the file containing palette data.
	 */
	static final String paletteName = "palette.bin";
	
	/**
	 * The filename for the file containing sound data.
	 */
	static final String soundName = "sound.bin";
	
	/**
	 * The filename for the file containing mystery data.
	 */
	static final String mysteryName = "mystery.bin";
	
	/**
	 * Gets the filename for the program file.
	 * 
	 * @return The file name for the file containing unified program
	 * data.
	 */
	public default String getProgramName() {
		return programName;
	}
	
	/**
	 * Gets the filename for the graphic file.
	 * 
	 * @return The file name for the file containing unified graphic
	 * data.
	 */
	public default String getGraphicName() {
		return graphicName;
	}
	
	/**
	 * Gets the filename for the color file.
	 * 
	 * @return The file name for the file containing unified color data.
	 */
	public default String getColorName() {
		return colorName;
	}
	
	/**
	 * Gets the filename for the palette file.
	 * 
	 * @return The file name for the file containing unified palette
	 * data.
	 */
	public default String getPaletteName() {
		return paletteName;
	}
	
	/**
	 * Gets the filename for the sound file.
	 * 
	 * @return The file name for the file containing unified sound data.
	 */
	public default String getSoundName() {
		return soundName;
	}
	
	/**
	 * Gets the filename for the mystery file.
	 * 
	 * @return The file name for the file containing unified mystery
	 * data.
	 */
	public default String getMysteryName() {
		return mysteryName;
	}
}
