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

/**
 * An interface used for saving file objects from memory to the system's
 * disk.
 * 
 * <p>Classes that implement this interface should make use of the
 * {@link #save()} method, as it accesses system's disk and memory.
 * The {@link #save()} method saves the file object's contents from
 * memory to the system's disk.</p>
 * 
 * <p>The classes that implement this interface are {@link PacObject}.
 * {@link PacFile}, and {@link PacDirectory}. Each of these classes handle
 * the {@link #save()} method differently. {@link PacObject} keeps the
 * method abstract, {@link PacFile} will save the file's bytes from memory
 * to the system's disk, and {@link PacDirectory} will save the
 * directory's entries's bytes to the system's disk.</p>
 * 
 * @author GarlicDude
 */
public interface Savable {
	
	/**
	 * Saves a file object's contents from memory to the system's disk.
	 * 
	 * <p>This method should only work when a file path is valid, hence
	 * why the method throws the {@link IOException}. If the file path
	 * is invalid, then it'll throw the exception instead.</p>
	 * 
	 * @throws IOException if writing from disk fails.
	 */
	void save() throws IOException;
}
