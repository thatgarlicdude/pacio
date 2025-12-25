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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PacDirectory extends PacPath implements Openable, Closeable, Clearable, Savable {
	
	/**The file entries in the directory.*/
	private final List<PacFile> files = new ArrayList<PacFile>();
	
	/**Opens the directory from memory.*/
	@Override
	public void open() throws IOException {
		// Close all the files before reading them.
		close();
		// Create the directory stream.
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
			// Add the entry to the list.
			for (Path entry : directoryStream) {
				files.add(new PacFile(entry));
			}
		}
	}
	
	/**Closes all the files in the directory.*/
	@Override
	public void close() {
		// Close the files before clearing the list.
		for (PacFile file : files) {
			file.close();
		}
		// Clear the list.
		clear();
	}
	
	/**Clears all the files in the directory.*/
	@Override
	public void clear() {
		files.clear();
	}
	
	/**Saves all the files in the directory.*/
	@Override
	public void save() throws IOException {
		// Save the files that are opened.
		for (PacFile file : files) {
			file.save();
		}
	}
	
	/**Returns a specific file in the directory.*/
	public PacFile getFile(final int index) {
		return files.get(index);
	}
	
	/**Returns the size of the directory.*/
	public int getSize() {
		return files.size();
	}
	
	/**Creates a new PacDirectory with a Path.*/
	public static PacDirectory from(final Path path) throws IOException {
		PacDirectory directory = new PacDirectory(path);
		return directory;
	}
	
	/**Creates a new PacDirectory with a URI.*/
	public static PacDirectory from(final URI pathURI) throws IOException {
		Path path = Paths.get(pathURI);
		return from(path);
	}
	
	/**Creates a new PacDirectory with a string.*/
	public static PacDirectory from(final String pathString) throws IOException {
		Path path = Paths.get(pathString);
		return from(path);
	}
	
	/**Constructs an instance of the class.*/
	public PacDirectory(final Path path) {
		super(path);
	}
}
