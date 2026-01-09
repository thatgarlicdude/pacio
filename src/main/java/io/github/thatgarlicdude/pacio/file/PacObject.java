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
import java.nio.file.Path;

/**
 * <p>A class that represents a file object within the file system.</p>
 */
public abstract class PacObject implements Loadable, Savable {
	
	/**
	 * <p>The file path of the file object.</p>
	 */
	protected final Path path;
	
	/**
	 * <p>Opens the file object from memory.</p>
	 */
	@Override
	public abstract void open() throws IOException;
	
	/**
	 * <p>Closes the file object from memory.</p>
	 */
	@Override
	public abstract void close();
	
	/**
	 * <p>Saves the file object from memory.</p>
	 */
	@Override
	public abstract void save() throws IOException;
	
	/**
	 * <p>Returns the file path of the file object.</p>
	 */
	public final Path getPath() {
		return path;
	}
	
	/**
	 * <p>Returns the filename of the file object.</p>
	 */
	public final String getName() {
		return path.getFileName().toString();
	}
	
	/**
	 * <p>Constructs an instance of this class.</p>
	 */
	protected PacObject(final Path path) {
		this.path = path;
	}
}
