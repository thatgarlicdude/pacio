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

/**
 * A class that represents a file in a file system.
 * 
 * <p>This class extends from {@link PacObject}, keeping its file path
 * variable and the methods related to it. But because this class is
 * treated like a regular file in the file system, it features new
 * variables and methods that are unique to it and is related to files
 * in the system's disk.</p>
 * 
 * <p>Most notably, this class features the byte array called
 * {@link #data}. It acts like the file's bytes from the system's disk, and
 * can be loaded to memory using {@link #open()} and saved back to the
 * system's disk using {@link #save()}. Additionally, it can be read by
 * calling the {@link #read(int)}, {@link #read(int, int)}, and
 * {@link #readAll()} methods. Lastly, it can be written by calling the
 * {@link #write(int, byte)} and {@link #write(int, byte[])} methods.</p>
 * 
 * <p>{@link PacFile} also features the from methods, {@link #from(Path)},
 * {@link #from(URI)}, and {@link #from(String)}. Those methods are used
 * to automatically open the {@link PacFile} without needing to write extra
 * lines of code.</p>
 * 
 * @author GarlicDude
 */
public final class PacFile extends PacObject implements Loadable, Savable {
	
	/**
	 * The byte data inside the file.
	 * 
	 * <p>This variable is null by default. When the byte array is null,
	 * it indicates that the {@link PacFile} is closed via the
	 * {@link #close()} method. On the contrary, when the byte array is
	 * loaded, the {@link PacFile} is opened via the {@link #open()}
	 * method.</p>
	 * 
	 * <p>Additionally, this variable can only be accessed through the
	 * {@link #read(int)} and {@link #write(int, byte)} methods. The
	 * {@link #read(int)} and {@link #read(int, int)} methods, based on
	 * their names, can read the byte array. On the other hand,
	 * {@link #write(int, byte)}, and {@link #write(int, byte[])} methods
	 * can write the bytes inside the array.</p>
	 * 
	 * <p>Lastly, these bytes can be saved onto the file in the system's
	 * disk via {@link #save()}. By saving, they overwrite contents from
	 * the data array to the file.</p>
	 */
	private byte[] data = null;
	
	/**
	 * Opens the file from the system's disk.
	 * 
	 * <p>This will load the bytes inside the file to the class's byte
	 * data, {@link #data}. It can only work if the class's {@link #path}
	 * is valid. Otherwise, it will throw the {@link IOException}.</p>
	 * 
	 * @throws IOException if reading from disk fails.
	 */
	@Override
	public final void open() throws IOException {
		// Stop if the data array is already opened.
		if (data != null) return;
		data = Files.readAllBytes(path);
	}
	
	/**
	 * Closes the file, freeing its {@link #data} from memory.
	 * 
	 * <p>When this method is called, it will clear every byte from
	 * {@link #data} with zeroes, and then nullify the array, clearing
	 * it from memory.</p>
	 */
	@Override
	public final void close() {
		// Stop if the data array is already closed.
		if (data == null) return;
		// Clear every byte inside the array with zeroes.
		for (int index = 0; index < data.length; index++) {
			data[index] = 0;
		}
		data = null;
	}
	
	/**
	 * Saves the file from the system's disk by overwriting it with the
	 * contents from {@link #data}.
	 * 
	 * <p>This method only works when the {@link #path} is valid.
	 * Otherwise, it will throw the {@link IOException} instead.</p>
	 * 
	 * @throws IOException if writing from disk fails.
	 */
	@Override
	public final void save() throws IOException {
		// Stop if the data array is closed.
		if (data == null) return;
		Files.write(path, data, StandardOpenOption.TRUNCATE_EXISTING);
	}
	
	/**
	 * Reads a single byte in the class's {@link #data}.
	 * 
	 * <p>If the {@code offset} is out of bounds, it will return 0
	 * instead.</p>
	 * 
	 * @param offset the index for the class's {@link #data}.
	 * @return the byte that was read from {@link #data}.
	 */
	public final byte read(final int offset) {
		if (offset < 0 || offset >= data.length) return 0;
		return data[offset];
	}
	
	/**
	 * Reads multiple bytes in the class's {@link #data}.
	 * 
	 * <p>Like {@link #read(int)}, it will return 0 if the {@code offset}
	 * is out of bounds. The same happens when the {@code size} is not
	 * within the boundaries of {@link #data}.</p>
	 * 
	 * @param offset the index for the class's {@link #data}.
	 * @param size the amount of bytes that will be read.
	 * @return the bytes that were read from {@link #data}.
	 */
	public final byte[] read(final int offset, final int size) {
		byte[] data = new byte[size];
		for (int index = 0; index < size; index++) {
			data[index] = read(index + offset);
		}
		return data;
	}
	
	/**
	 * Reads all the bytes in the class's {@link #data}.
	 * 
	 * <p>This does not return the pointer of the {@link #data}, but rather
	 * returns a copy of it. This was done for safety reasons, as no
	 * program should tamper this variable.</p>
	 * 
	 * @return the bytes that were read from {@link #data}.
	 */
	public final byte[] readAll() {
		int size = data.length;
		byte[] data = new byte[size];
		data = read(0, size);
		return data;
	}
	
	/**
	 * Writes a single byte in the class's {@link #data}.
	 * 
	 * <p>If the {@code offset} is out of bounds, it will not do
	 * anything, and continue like normal. The {@link #data} won't be
	 * affected if this happens.</p>
	 * 
	 * @param offset the index for the class's {@link #data}.
	 * @param b the byte that will get written in {@link #data}.
	 */
	public final void write(final int offset, final byte b) {
		if (offset < 0 || offset >= data.length) return;
		data[offset] = b;
	}
	
	/**
	 * Writes multiple bytes in the class's {@link #data}.
	 * 
	 * <p>Like {@link #write(int, byte)}, it will not do anything if
	 * {@code offset} is out of bounds. This also happens when the method
	 * tries to write bytes outside of {@link #data}.</p>
	 * 
	 * @param offset the index for the class's {@link #data}.
	 * @param bytes the bytes that will be written to {@link #data}.
	 */
	public final void write(final int offset, final byte[] bytes) {
		int size = bytes.length;
		for (int index = 0; index < size; index++) {
			write(index + offset, bytes[index]);
		}
	}
	
	/**
	 * Creates a new PacFile using a file path, and automatically opens it
	 * to memory.
	 * 
	 * @param path the file path to the file in the system's disk.
	 * @return a PacFile that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static PacFile from(final Path path) throws IOException {
		PacFile file = new PacFile(path);
		file.open();
		return file;
	}
	
	/**
	 * Creates a new PacFile using a URI reference of the file path, and
	 * automatically opens it to memory.
	 * 
	 * @param pathURI the URI reference of the file path.
	 * @return a PacFile that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static PacFile from(final URI pathURI) throws IOException {
		Path path = Paths.get(pathURI);
		PacFile file = from(path);
		return file;
	}
	
	/**
	 * Creates a new PacFile using a string of the file path, and
	 * automatically opens it to memory.
	 * 
	 * @param pathString the string of the file path.
	 * @return a PacFile that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static PacFile from(final String pathString)
			throws IOException {
		Path path = Paths.get(pathString);
		PacFile file = from(path);
		return file;
	}
	
	/**
	 * Creates a new {@link PacFile} using a file path.
	 * 
	 * <p>This does not automatically open the {@link PacFile} when
	 * created. If the {@link PacFile} is created and needs to be opened,
	 * calling {@link #open()} from the object will do the trick.</p>
	 * 
	 * <p>The sole parameter, {@code path}, cannot be null. Otherwise, it
	 * will throw the {@link IllegalArgumentException} if this happens.</p>
	 * 
	 * @param path the file path to the file object in the system's disk.
	 * @throws IllegalArgumentException if {@code path} is null.
	 */
	public PacFile(final Path path) {
		super(path);
	}
}
