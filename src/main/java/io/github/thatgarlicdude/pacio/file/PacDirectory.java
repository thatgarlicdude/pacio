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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that represents a directory in a file system.
 * 
 * <p>This class extends from {@link PacObject}, keeping its file path
 * variable and the methods related to it. But because this class is
 * treated like a directory in the file system, it features new variables
 * and methods that are unique to it and is related to directories in the
 * system's disk.</p>
 * 
 * @author GarlicDude
 */
public final class PacDirectory extends PacObject
implements Loadable, Savable {
	
	/**
	 * The list of files within the directory.
	 * 
	 * <p>By default, this list is empty, indicating that the directory is
	 * closed via the {@link #close()} method. On the contrary, if the list
	 * is loaded, it indicates that it is opened via the {@link #open()}
	 * method.</p>
	 */
	private final List<PacFile> files = new ArrayList<PacFile>();
	
	/**
	 * Opens the directory from the system's disk.
	 * 
	 * <p>This will load the entries that are within the directory to
	 * memory as {@link PacFile} objects. But this method does not open
	 * them upon creating them.</p>
	 * 
	 * @throws IOException if reading from disk fails.
	 */
	@Override
	public void open() throws IOException {
		try (DirectoryStream<Path> directoryStream =
				Files.newDirectoryStream(path)) {
			for (Path path : directoryStream) {
				PacFile file = new PacFile(path);
				files.add(file);
			}
		}
	}
	
	/**
	 * Closes the directory and its files, freeing everything from memory.
	 * 
	 * <p>What this will do is close every file entry, freeing their bytes
	 * from memory. Then the {@link #files} list will be cleared.</p>
	 */
	@Override
	public void close() {
		for (PacFile file : files) {
			file.close();
			file = null;
		}
		files.clear();
	}
	
	/**
	 * Saves the file entries within the directory to the system's disk.
	 * 
	 * <p>Because directories cannot be saved, only the file entries can
	 * be overwritten with their bytes. Additionally, only the
	 * {@link PacFile} objects that are currently opened can be saved to
	 * the system's disk.</p>
	 * 
	 * @throws IOException if writing from disk fails.
	 */
	@Override
	public void save() throws IOException {
		for (PacFile file : files) {
			file.save();
		}
	}
	
	/**
	 * Returns an unmodifiable list of {@link #files} in the PacDirectory.
	 * 
	 * @return an unmodifiable list of {@link #files}.
	 */
	public final List<PacFile> getFiles() {
		return Collections.unmodifiableList(files);
	}
	
	/**
	 * Finds a specific file within the directory.
	 * 
	 * <p>If the method cannot find a file entry that matches the
	 * {@code name}, it will return null instead.</p>
	 * 
	 * @param name the file name that the method will look for.
	 * @return the {@link PacFile} that matches the {@code name}.
	 */
	public final PacFile find(final String name) {
		for (PacFile file : files) {
			if (file.getName().matches(name)) return file;
		}
		return null;
	}
	
	/**
	 * Creates a new {@link PacDirectory} using a file path, and
	 * automatically opens it, loading its entries to memory.
	 * 
	 * @param path the file path to the directory in the system's disk.
	 * @return a {@link PacDirectory} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static PacDirectory from(final Path path) throws IOException {
		PacDirectory directory = new PacDirectory(path);
		directory.open();
		return directory;
	}
	
	/**
	 * Creates a new {@link PacDirectory} using a URI reference of the file
	 * path, and automatically opens it to memory.
	 * 
	 * @param pathURI the URI reference of the file path.
	 * @return a {@link PacDirectory} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static PacDirectory from(final URI pathURI) throws IOException {
		Path path = Paths.get(pathURI);
		PacDirectory directory = from(path);
		return directory;
	}
	
	/**
	 * Creates a new {@link PacDirectory} using a string of the file path,
	 * and automatically opens it to memory.
	 * 
	 * @param pathString the string of the file path.
	 * @return a {@link PacDirectory} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static PacDirectory from(final String pathString)
			throws IOException {
		Path path = Paths.get(pathString);
		PacDirectory directory = from(path);
		return directory;
	}
	
	/**
	 * Creates a new {@link PacDirectory} using a file path.
	 * 
	 * <p>This does not automatically open the {@link PacDirectory} when
	 * created. If the {@link PacDirectory} is created and needs to be
	 * opened, calling {@link #open()} from the object will do the
	 * trick.</p>
	 * 
	 * <p>The sole parameter, {@code path}, cannot be null. Otherwise, it
	 * will throw the {@link IllegalArgumentException} if this happens.</p>
	 * 
	 * @param path the file path to the directory in the system's disk.
	 * @throws IllegalArgumentException if {@code path} is null.
	 */
	protected PacDirectory(final Path path) {
		super(path);
	}
}
