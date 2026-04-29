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
 * A class that represents a unified <i>Pac-Man</i> ROM set.
 * 
 * <p>This class contains all the bytes loaded from disk via the {@link
 * io.github.thatgarlicdude.pacio.PacIO#importROMSet(String) importROMSet}
 * or {@link io.github.thatgarlicdude.pacio.PacIO#openROMSet(String)
 * openROMSet} methods in the {@link io.github.thatgarlicdude.pacio.PacIO
 * PacIO} class, or using the {@link
 * io.github.thatgarlicdude.pacio.io.PacROMSetImporter PacROMSetImporter}
 * or {@link io.github.thatgarlicdude.pacio.io.PacROMSetOpener
 * PacROMSetOpener} classes. Those bytes are stored and concatenated
 * together into categorized arrays, such as {@link #programData} from the
 * <i>Pac-Man</i> PCB's multiple program ROMs. In other words, it's
 * basically a digital, editable ROM set that has everything it needs to
 * represent <i>Pac-Man</i> as a game.</p>
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class PacROMSet {
	
	/**
	 * The unified byte data of the program ROMs.
	 * 
	 * <p>This is the data loaded from multiple program ROMs in the
	 * <i>Pac-Man</i> and <i>Puck-Man</i> PCBs. They contain instructions
	 * for the Zilog Z80, and some static data like music, sound effects,
	 * mazes, and text.</p>
	 */
	private final byte[] programData;
	
	/**
	 * The unified byte data of the graphic ROMs.
	 * 
	 * <p>This is the data loaded from multiple graphic ROMs. The
	 * <i>Pac-Man</i> ROM set has two of these ROMs being <b>5e</b> and
	 * <b>5f</b>, while <i>Puck-Man</i> has four being <b>5e</b>,
	 * <b>5h</b>, <b>5f</b>, and <b>5j</b>. The first half should be the
	 * tile data while the second is the sprite data. Tiles are 8x8 in
	 * size, while sprites are 16x16. Each pixel should be 2 bits in
	 * length, therefore creating four possible colors in a palette to
	 * choose from.</p>
	 */
	private final byte[] graphicData;
	
	/**
	 * The byte data of the color ROM.
	 * 
	 * <p>This is the data loaded from the <b>7f</b> ROM, which is the
	 * <i>Pac-Man</i> PCB's one and only color ROM. The colors are
	 * encoded into a single byte, with the first three bits being the
	 * red bits, other three being green, and the last two being blue.</p>
	 */
	private final byte[] colorData;
	
	/**
	 * The byte data of the palette ROM.
	 * 
	 * <p>This is the data loaded from the <b>4a</b> ROM, which is the
	 * <i>Pac-Man</i> PCB's sole palette ROM. Each palette contains four
	 * colors that are represented from the {@link #colorData}, loaded
	 * from the <b>7f</b> ROM.</p>
	 */
	private final byte[] paletteData;
	
	/**
	 * The byte data of the sound ROM.
	 * 
	 * <p>This is the data loaded from the <b>1m</b> ROM, which is the
	 * sound chip of the <i>Pac-Man</i> PCB. The sound chip contains
	 * multiple waveforms that are 32 bytes long, and each byte in a
	 * waveform ranges from 0 (0x0) to 15 (0xF), which is the amplitude.
	 * Each byte powers the speakers depending on its strength.</p>
	 */
	private final byte[] soundData;
	
	/**
	 * The byte data of the mystery ROM.
	 * 
	 * <p>This is the data that is usually loaded from the <b>3m</b> ROM
	 * of the <i>Pac-Man</i> PCB. Nobody knows what this data is used for,
	 * aside from the fact that it's slightly associated with the {@link
	 * #soundData}, loaded from the <b>1m</b> ROM of the PCB. That is why
	 * it is called the mysteryData.</p>
	 */
	private final byte[] mysteryData;
	
	/**
	 * Gets the {@link #programData}, a byte array that has all the byte
	 * data from the PCB's program ROMs.
	 * 
	 * <p>This does not return a cloned array of the byte data, meaning it
	 * can be modified when obtained by other programs. This is useful for
	 * ROM-hacking <i>Pac-Man</i> as a game.</p>
	 * 
	 * <p>For more information about this data, see {@link
	 * #programData} to learn more.</p>
	 * 
	 * @return The unified byte array of program ROM data.
	 */
	public final byte[] getProgramData() {
		return programData;
	}
	
	/**
	 * Gets the {@link #graphicData}, a byte array that has all the byte
	 * data from the PCB's graphic ROMs.
	 * 
	 * <p>This does not return a cloned array of the byte data, meaning it
	 * can be modified when obtained by other programs. This is useful for
	 * ROM-hacking <i>Pac-Man</i> as a game.</p>
	 * 
	 * <p>For more information about this data, see {@link
	 * #graphicData} to learn more.</p>
	 * 
	 * @return The unified byte array of graphic ROM data.
	 */
	public final byte[] getGraphicData() {
		return graphicData;
	}
	
	/**
	 * Gets the {@link #colorData}, a byte array that has the byte data
	 * from the PCB's color ROM.
	 * 
	 * <p>This does not return a cloned array of the byte data, meaning it
	 * can be modified when obtained by other programs. This is useful for
	 * ROM-hacking <i>Pac-Man</i> as a game.</p>
	 * 
	 * <p>For more information about this data, see {@link
	 * #colorData} to learn more.</p>
	 * 
	 * @return The byte array of color ROM data.
	 */
	public final byte[] getColorData() {
		return colorData;
	}
	
	/**
	 * Gets the {@link #paletteData}, a byte array that has the byte data
	 * from the PCB's palette ROM.
	 * 
	 * <p>This does not return a cloned array of the byte data, meaning it
	 * can be modified when obtained by other programs. This is useful for
	 * ROM-hacking <i>Pac-Man</i> as a game.</p>
	 * 
	 * <p>For more information about this data, see {@link
	 * #paletteData} to learn more.</p>
	 * 
	 * @return The byte array of palette ROM data.
	 */
	public final byte[] getPaletteData() {
		return paletteData;
	}
	
	/**
	 * Gets the {@link #soundData}, a byte array that has the byte data
	 * from the PCB's sound ROM.
	 * 
	 * <p>This does not return a cloned array of the byte data, meaning it
	 * can be modified when obtained by other programs. This is useful for
	 * ROM-hacking <i>Pac-Man</i> as a game.</p>
	 * 
	 * <p>For more information about this data, see {@link
	 * #soundData} to learn more.</p>
	 * 
	 * @return The byte array of sound ROM data.
	 */
	public final byte[] getSoundData() {
		return soundData;
	}
	
	/**
	 * Gets the {@link #mysteryData}, a byte array that has the byte
	 * data from the PCB's mystery ROM.
	 * 
	 * <p>This does not return a cloned array of the byte data, meaning it
	 * can be modified when obtained by other programs. This is useful for
	 * ROM-hacking <i>Pac-Man</i> as a game.</p>
	 * 
	 * <p>For more information about this data, see {@link
	 * #mysteryData} to learn more.</p>
	 * 
	 * @return The byte array of mystery ROM data.
	 */
	public final byte[] getMysteryData() {
		return mysteryData;
	}
	
	/**
	 * Constructs an instance of the unified <i>Pac-Man</i> ROM set.
	 * 
	 * @param programData The unified array of bytes in the program ROMs.
	 * @param graphicData The unified array of bytes in the graphic ROMs.
	 * @param colorData The array of bytes in the color ROM.
	 * @param paletteData The array of bytes in the palette ROM.
	 * @param soundData The array of bytes in the sound ROM.
	 * @param mysteryData The array of bytes in the mystery ROM.
	 */
	public PacROMSet(
			final byte[] programData,
			final byte[] graphicData,
			final byte[] colorData,
			final byte[] paletteData,
			final byte[] soundData,
			final byte[] mysteryData) {
		this.programData = programData;
		this.graphicData = graphicData;
		this.colorData = colorData;
		this.paletteData = paletteData;
		this.soundData = soundData;
		this.mysteryData = mysteryData;
	}
}
