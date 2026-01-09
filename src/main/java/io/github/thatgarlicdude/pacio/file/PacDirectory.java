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

/**A class that represents a directory in a file system.*/
public final class PacDirectory extends PacObject implements Loadable, Savable {
	
	/**The files within the directory.*/
	private final List<PacFile> files = new ArrayList<PacFile>();
	
	/**Loads the directory.*/
	@Override
	public void load() throws IOException {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
			for (Path path : directoryStream) {
				PacFile rom = PacFile.from(path);
				files.add(rom);
			}
		}
	}
	
	/**Unloads the directory and its files.*/
	@Override
	public void unload() {
		for (PacFile file : files) {
			file.unload();
			file = null;
		}
		files.clear();
	}
	
	/**Saves the files within the directory.*/
	@Override
	public final void save() throws IOException {
		for (PacFile file : files) {
			file.save();
		}
	}
	
	/**Returns an unmodifiable list of files in the PacDirectory.*/
	public List<PacFile> getFiles() {
		return Collections.unmodifiableList(files);
	}
	
	/**Finds a specific file within the directory.*/
	public final PacFile find(final String name) {
		for (PacFile file : files) {
			if (file.getName().matches(name)) return file;
		}
		return null;
	}
	
	/**Creates a new PacDirectory using a path.*/
	public static PacDirectory from(final Path path) throws IOException {
		PacDirectory romSet = new PacDirectory(path);
		return romSet;
	}
	
	/**Creates a new PacDirectory using a URI.*/
	public static PacDirectory from(final URI pathURI) throws IOException {
		Path path = Paths.get(pathURI);
		PacDirectory romSet = from(path);
		return romSet;
	}
	
	/**Creates a new PacDirectory using a string.*/
	public static PacDirectory from(final String pathString) throws IOException {
		Path path = Paths.get(pathString);
		PacDirectory romSet = from(path);
		return romSet;
	}
	
	/**The main constructor of the PacRomSet.*/
	protected PacDirectory(final Path path) {
		super(path);
	}
}
