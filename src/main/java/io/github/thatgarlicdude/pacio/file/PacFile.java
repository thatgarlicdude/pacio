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

package io.github.thatgarlicdude.pacio.file;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**A class that represents a file in the file system.*/
public class PacFile extends PacPath implements Openable, Closeable, Clearable, Savable {
	
	/**The byte array for the file.*/
	private byte[] data;
	
	/**Opens the file.*/
	@Override
	public void open() throws IOException {
		// Stop if the file was already opened.
		if (data != null) return;
		// Set the data with the bytes inside the file in the file system.
		data = Files.readAllBytes(path);
	}
	
	/**Closes the file by clearing the class's byte array and nullifying it.*/
	@Override
	public void close() {
		// Clear the byte array with zeroes.
		clear();
		// Nullify it too.
		data = null;
	}
	
	/**Clears the byte array of the class with zeroes.*/
	@Override
	public void clear() {
		// Stop if the byte array is null.
		if (data == null) return;
		// Set each byte to a zero.
		for (int index = 0; index < this.data.length; index++) {
			data[index] = 0;
		}
	}
	
	/**Saves the file in the file system.*/
	@Override
	public void save() throws IOException {
		// Stop if the byte array is null.
		if (data == null) return;
		// Write the file in the file system with the byte array.
		Files.write(path, data, StandardOpenOption.TRUNCATE_EXISTING);
	}
	
	/**Reads a single byte from memory.*/
	public final byte read(final int offset) {
		// Return 0 if the the file hasn't been opened.
		if (data == null) return 0;
		// Return 0 if it goes out of bounds.
		if (offset < 0 || offset >= data.length) return 0;
		// Return the byte in the array.
		return data[offset];
	}
	
	/**Reads multiple bytes from memory.*/
	public final byte[] readN(final int offset, final int size) {
		// Create a new byte array.
		byte[] bytes = new byte[size];
		// Set each byte in the local array to the file's data array plus offset.
		for (int index = 0; index < size; index++) {
			bytes[index] = read(index + offset);
		}
		// Return the byte array.
		return bytes;
	}
	
	/**Reads all the bytes from memory.*/
	public final byte[] readAll() {
		// Get the length of the data array.
		int size = data.length;
		// Return the newly copied data array.
		return readN(0, size);
	}
	
	/**Writes a single byte to memory.*/
	public final void write(final int offset, final byte b) {
		// Return 0 if the the file hasn't been opened.
		if (data == null) return;
		// Return 0 if it goes out of bounds.
		if (offset < 0 || offset >= data.length) return;
		// Set the byte in the array to b.
		data[offset] = b;
	}
	
	/**Writes multiple bytes to memory.*/
	public final void writeN(final int offset, final byte[] bytes) {
		// Write each byte in the data array with the local byte array.
		for (int index = 0; index < bytes.length; index++) {
			write(index + offset, bytes[index]);
		}
	}
	
	/**Returns the size of the data array.*/
	public final int getSize() {
		return data.length;
	}
	
	/**Creates a new PacFile with a Path.*/
	public static PacFile from(final Path path) {
		PacFile file = new PacFile(path);
		return file;
	}
	
	/**Creates a new PacFile with a URI.*/
	public static PacFile from(final URI pathURI) {
		Path path = Paths.get(pathURI);
		return from(path);
	}
	
	/**Creates a new PacFile with a string.*/
	public static PacFile from(final String pathString) {
		Path path = Paths.get(pathString);
		return from(path);
	}
	
	/**Constructs an instance of this class using a file path and byte array.*/
	public PacFile(final Path path, final byte[] data) {
		super(path);
		this.data = data;
	}
	
	/**Constructs an instance of this class only using a file path.*/
	public PacFile(final Path path) {
		this(path, null);
	}
}
