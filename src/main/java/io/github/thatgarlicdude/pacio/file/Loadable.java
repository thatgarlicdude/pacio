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
 * An interface used for loading file objects to memory by "opening"
 * them from the system's disk, and "closing" them, freeing the
 * memory.
 * 
 * <p>Classes that implement this interface should make use of the
 * {@link #open()} and {@link #close()} methods, as they access the
 * system's disk and memory. {@link #open} will load contents from the
 * system's disk to memory, and {@link #close} will free contents from the
 * system's memory.</p>
 * 
 * <p>The classes that implement the interface are {@link PacObject},
 * {@link PacFile}, and {@link PacDirectory}. Each of these classes handle
 * the {@link #open()} and {@link #close()} methods differently.
 * {@link PacObject} keeps them abstract, {@link PacFile} will load the
 * file's bytes to memory, and {@link PacDirectory} loads the directory's
 * entries to memory.</p>
 */
public interface Loadable {
	
	/**
	 * Opens a file object from the system's disk, loading its
	 * contents to memory.
	 * 
	 * <p>This method should only work when a file path is valid, hence
	 * why this method throws the {@link IOException}. If the file path
	 * is invalid, then it'll throw the exception instead.</p>
	 * 
	 * @throws IOException if reading from disk fails.
	 */
	void open() throws IOException;
	
	/**
	 * Closes a file object, freeing its contents from memory.
	 * 
	 * <p>Classes that implement this interface can call this method as
	 * many times, even if the file object was already closed and freed
	 * from memory.</p>
	 */
	void close();
}
