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

package io.github.thatgarlicdude.pacio.file;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
 * TODO: Work on the method descriptions and rework the class description.
 * Compact the code.
 */

/**
 * <p>A class that represents a file in a file system.</p>
 */
public final class PacFile extends PacObject implements Loadable, Savable {
	
	/**
	 * <p>The byte data inside the file.</p>
	 */
	private byte[] data = null;
	
	/**
	 * <p>Opens the file.</p>
	 */
	@Override
	public final void open() throws IOException {
		// Stop if the data array is already opened.
		if (data != null) return;
		data = Files.readAllBytes(path);
	}
	
	/**
	 * <p>Closes the file.</p>
	 */
	@Override
	public final void close() {
		// Stop if the data array is already closed.
		if (data == null) return;
		for (int index = 0; index < data.length; index++) {
			data[index] = 0;
		}
		data = null;
	}
	
	/**
	 * <p>Saves the file.</p>
	 */
	@Override
	public final void save() throws IOException {
		// Stop if the data array is closed.
		if (data == null) return;
		Files.write(path, data, StandardOpenOption.TRUNCATE_EXISTING);
	}
	
	/**
	 * <p>Reads a single byte in the data array.</p>
	 */
	public final byte read(final int offset) {
		return data[offset];
	}
	
	/**
	 * <p>Reads multiple bytes in the data array.</p>
	 */
	public final byte[] read(final int offset, final int size) {
		byte[] data = new byte[size];
		for (int index = 0; index < size; index++) {
			data[index] = read(index + offset);
		}
		return data;
	}
	
	/**
	 * <p>Reads all the bytes in the data array.</p>
	 */
	public final byte[] readAll() {
		int size = data.length;
		byte[] data = new byte[size];
		data = read(0, size);
		return data;
	}
	
	/**
	 * <p>Writes a single byte in the data array.</p>
	 */
	public final void write(final int offset, final byte b) {
		data[offset] = b;
	}
	
	/**
	 * <p>Writes multiple bytes in the data array.</p>
	 */
	public final void write(final int offset, final byte[] bytes) {
		int size = bytes.length;
		for (int index = 0; index < size; index++) {
			write(index + offset, bytes[index]);
		}
	}
	
	/**
	 * <p>Creates a new PacFile using a Path.</p>
	 */
	public static PacFile from(final Path path) throws IOException {
		PacFile rom = new PacFile(path);
		return rom;
	}
	
	/**
	 * <p>Creates a new PacFile using a URI.</p>
	 */
	public static PacFile from(final URI pathURI) throws IOException {
		Path path = Paths.get(pathURI);
		PacFile rom = from(path);
		return rom;
	}
	
	/**
	 * <p>Creates a new PacFile using a string.</p>
	 */
	public static PacFile from(final String pathString) throws IOException {
		Path path = Paths.get(pathString);
		PacFile rom = from(path);
		return rom;
	}
	
	/**
	 * <p>Constructs an instance of this class.</p>
	 */
	protected PacFile(final Path path) {
		super(path);
	}
}
