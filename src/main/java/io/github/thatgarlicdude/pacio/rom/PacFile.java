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

import java.nio.file.Path;

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
	
	/**The main constructor of the PacFile.*/
	protected PacFile(final Path path, final String name) {
		this.path = path;
		this.name = name;
	}
}
