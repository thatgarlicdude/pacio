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

package io.github.thatgarlicdude.pacio;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

import io.github.thatgarlicdude.pacio.file.PacDirectory;
import io.github.thatgarlicdude.pacio.file.PacFile;

/**
 * <p>The main class of the PacIO library.</p>
 * 
 * <p>This class features factory methods for {@link PacFile} and
 * {@link PacDirectory}.</p>
 * 
 * @author GarlicDude
 */
public final class PacIO {
	
	/**
	 * <p>Creates a new PacFile through a Path interface.</p>
	 * 
	 * @param path the file path to the file in the system's disk.
	 * @return a {@link PacFile} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static final PacFile newPacFile(final Path path)
			throws IOException {
		return PacFile.from(path);
	}
	
	/**
	 * <p>Creates a new PacFile through a URI object.</p>
	 * 
	 * @param pathURI the URI reference of the file path to the file in
	 * the system's disk.
	 * @return a {@link PacFile} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static final PacFile newPacFile(
			final URI pathURI
	) throws IOException {
		return PacFile.from(pathURI);
	}
	
	/**
	 * <p>Creates a new PacFile through a string.</p>
	 * 
	 * @param pathString the string of the file path to the file in the
	 * system's disk.
	 * @return a {@link PacFile} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static final PacFile newPacFile(
			final String pathString
	) throws IOException {
		return PacFile.from(pathString);
	}
	
	/**
	 * <p>Creates a new PacDirectory through a Path interface.</p>
	 * 
	 * @param path the file path to the directory in the system's disk.
	 * @return a {@link PacDirectory} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static final PacDirectory newPacDirectory(
			final Path path
	) throws IOException {
		return PacDirectory.from(path);
	}
	
	/**
	 * <p>Creates a new PacDirectory through a URI object.</p>
	 * 
	 * @param pathURI the URI reference of the file path to the directory
	 * in the system's disk.
	 * @return a {@link PacDirectory} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static final PacDirectory newPacDirectory(
			final URI pathURI
	) throws IOException {
		return PacDirectory.from(pathURI);
	}
	
	/**
	 * <p>Creates a new PacDirectory through a string.</p>
	 * 
	 * @param pathString the string of the file path to the directory in
	 * the system's disk.
	 * @return a {@link PacDirectory} that's automatically opened.
	 * @throws IOException if reading from disk fails.
	 */
	public static final PacDirectory newPacDirectory(
			final String pathString
	) throws IOException {
		return PacDirectory.from(pathString);
	}
}
