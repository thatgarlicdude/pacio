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

import io.github.thatgarlicdude.pacio.rom.PacFile;
import io.github.thatgarlicdude.pacio.rom.PacDirectory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

/**The main class of the PacIO library.*/
public final class PacIO {
	
	/**Creates a new PacFile through a Path interface.*/
	public static final PacFile newPacFile(final Path path) throws IOException {
		return PacFile.from(path);
	}
	
	/**Creates a new PacFile through a URI object.*/
	public static final PacFile newPacFile(final URI pathURI) throws IOException {
		return PacFile.from(pathURI);
	}
	
	/**Creates a new PacFile through a string.*/
	public static final PacFile newPacFile(final String pathString) throws IOException {
		return PacFile.from(pathString);
	}
	
	/**Creates a new PacDirectory through a Path interface.*/
	public static final PacDirectory newPacDirectory(final Path path) throws IOException {
		return PacDirectory.from(path);
	}
	
	/**Creates a new PacDirectory through a URI object.*/
	public static final PacDirectory newPacDirectory(final URI pathURI) throws IOException {
		return PacDirectory.from(pathURI);
	}
	
	/**Creates a new PacDirectory through a string.*/
	public static final PacDirectory newPacDirectory(final String pathString) throws IOException {
		return PacDirectory.from(pathString);
	}
}
