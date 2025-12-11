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

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**A class that represents a file within a file system.*/
abstract class PacFile {
	
	/**The file path of the PacFile.*/
	protected final Path path;
	
	/**The filename of the PacFile.*/
	protected final String name;
	
	/**Returns the file path of the PacFile.*/
	public final Path getPath() {
		return this.path;
	}
	
	/**Returns the filename of the PacFile.*/
	public final String getName() {
		return this.name;
	}
	
	protected PacFile(final Path path, final String name) {
		this.path = path;
		this.name = name;
	}
	
	/**The main constructor of the PacFile, using the Path interface as the argument.*/
	protected PacFile(final Path path) {
		String name = path.getFileName().toString();
		this.path = path;
		this.name = name;
	}
	
	/**A constructor using a URI for the file path.*/
	protected PacFile(final URI pathURI) {
		this(Paths.get(pathURI));
	}
	
	/**A constructor using a String for the file path.*/
	protected PacFile(final String pathString) {
		this(Paths.get(pathString));
	}
}
