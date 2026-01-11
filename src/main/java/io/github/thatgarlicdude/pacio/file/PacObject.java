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
 * A class that represents a file object within the file system.
 * 
 * <p>This is an abstract class where {@link PacFile} and
 * {@link PacDirectory} extend from. It contains the file path variable
 * called {@link #path}, as well as its methods, such as {@link #getPath()}
 * and {@link #getName()}. The class also implements the {@link Loadable}
 * and {@link Savable} interfaces, using their methods, {@link #open()},
 * {@link #close()}, and {@link #save()}. However, because this is an
 * abstract class, these methods are kept abstract and the extending
 * classes make full use of them. That being said, this is the base class
 * for {@link PacFile} and {@link PacDirectory}, providing the methods that
 * they will use when instantiated.</p>
 * 
 * @author GarlicDude
 */
public abstract class PacObject implements Loadable, Savable {
	
	/**
	 * The error message for when a {@link PacObject} is being created,
	 * but the file path is null.
	 */
	private static final String ERR_MSG_NULL = "File path cannot be null.";
	
	/**
	 * The file path to the file object in the system's disk.
	 * 
	 * <p>This variable cannot be null and is not changeable once it is
	 * instantiated.</p>
	 */
	protected final Path path;
	
	/**
	 * Opens the file object from the system's disk, loading its contents
	 * from memory.
	 * 
	 * @throws IOException if reading from disk fails.
	 */
	@Override
	public abstract void open() throws IOException;
	
	/**
	 * Closes the file object from memory, freeing its contents from
	 * memory.
	 */
	@Override
	public abstract void close();
	
	/**
	 * Saves the file object's contents from memory to the system's disk.
	 * 
	 * @throws IOException if writing from disk fails.
	 */
	@Override
	public abstract void save() throws IOException;
	
	/**
	 * Gets {@link #path}, the file path to the file object in the system's
	 * disk.
	 * 
	 * @return the file path to the file object.
	 */
	public final Path getPath() {
		return path;
	}
	
	/**
	 * Gets the filename of {@link #path} as a string. Does not return the
	 * {@link Path} version of this variable.
	 * 
	 * @return the filename of the file object.
	 */
	public final String getName() {
		return path.getFileName().toString();
	}
	
	/**
	 * Creates a new {@link PacObject} using a file path.
	 * 
	 * <p>Because {@link PacObject} is an abstract class, this cannot be
	 * called by any means, even if the constructor is public. Only the
	 * subclasses, {@link PacFile} and {@link PacDirectory}, can call this
	 * constructor as they're being created in memory.</p>
	 * 
	 * <p>The sole parameter, {@code path}, cannot be null. Otherwise, it
	 * will throw the {@link IllegalArgumentException} if this happens.</p>
	 * 
	 * @param path the file path to the file object in the system's disk.
	 * @throws IllegalArgumentException if {@code path} is null.
	 */
	protected PacObject(final Path path) {
		if (path == null) throw new IllegalArgumentException(ERR_MSG_NULL);
		this.path = path;
	}
}
