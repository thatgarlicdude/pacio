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

import java.nio.file.Path;

/**A class that represents a file path in the file system.*/
public abstract class PacPath {
	
	/**The file path.*/
	protected final Path path;
	
	/**Returns the file path.*/
	public final Path getPath() {
		return this.path;
	}
	
	/**The main constructor. Sets up the file path when created.*/
	protected PacPath(final Path path) {
		this.path = path;
	}
}
