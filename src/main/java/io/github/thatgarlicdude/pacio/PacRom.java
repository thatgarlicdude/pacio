/*
 * Copyright 2025 GarlicDude
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

import java.nio.file.Path;

/**A class that represents a ROM within a ROM set.*/
public final class PacRom extends PacFile {
	
	/**The default byte array for a ROM file.*/
	private static final byte[] DEFAULT_DATA = new byte[0];
	
	/**The byte data inside the ROM file.*/
	private byte[] data = DEFAULT_DATA;
	
	/**Returns the byte data inside the ROM file.*/
	public final byte[] getData() {
		return this.data;
	}
	
	/**Returns the default byte array for a ROM file.*/
	public static final byte[] getDefaultData() {
		return DEFAULT_DATA;
	}
	
	/**Closes the ROM file.*/
	public final void close() {
		this.data = DEFAULT_DATA;
	}
	
	/**Reads a single byte in the data array.*/
	public final byte read(final int offset) {
		return this.data[offset];
	}
	
	/**Reads multiple bytes in the data array.*/
	public final byte[] readN(final int offset, final int size) {
		byte[] data = new byte[size];
		for (int index = 0; index < size; index++) {
			data[index] = this.data[size + offset];
		}
		return data;
	}
	
	/**Reads all the bytes in the data array.*/
	public final byte[] readAll() {
		int size = this.data.length;
		byte[] data = new byte[size];
		this.readN(0, size);
		return data;
	}
	
	/**Writes a single byte in the data array.*/
	public final void write(final int offset, final byte data) {
		this.data[offset] = data;
	}
	
	/**Writes multiple bytes in the data array.*/
	public final void writeN(final int offset, final byte[] data) {
		int size = data.length;
		for (int index = 0; index < size; index++) {
			this.data[index + offset] = data[index];
		}
	}
	
	/**The main constructor of the PacRom.*/
	PacRom(final Path path, final String name, final byte[] data) {
		super(path, name);
		this.data = data;
	}
}
