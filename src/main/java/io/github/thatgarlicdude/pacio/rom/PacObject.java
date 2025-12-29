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

package io.github.thatgarlicdude.pacio.rom;

import java.io.IOException;
import java.nio.file.Path;

/**A class that represents a file object within the file system.*/
public abstract class PacObject implements Loadable, Savable {
	
	/**The file path of the file object.*/
	protected final Path path;
	
	/**The filename of the file object.*/
	protected final String name;
	
	/**Loads the file object from memory.*/
	@Override
	public abstract void load() throws IOException;
	
	/**Unloads the file object from memory.*/
	@Override
	public abstract void unload();
	
	/**Saves the file object from memory.*/
	@Override
	public abstract void save() throws IOException;
	
	/**Returns the file path of the file object.*/
	public final Path getPath() {
		return path;
	}
	
	/**Returns the filename of the file object.*/
	public final String getName() {
		return name;
	}
	
	/**Constructs an instance of this class.*/
	protected PacObject(final Path path, final String name) {
		this.path = path;
		this.name = name;
	}
}
