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

import static io.github.thatgarlicdude.pacio.ResourceGetter.*;
import io.github.thatgarlicdude.pacio.file.PacDirectory;
import io.github.thatgarlicdude.pacio.file.PacFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**A test class used for testing out the PacIO class.*/
public final class TestPacIO {
	
	/**
	 * Tests the newPacFile method using the Path interface.
	 * 
	 * @throws URISyntaxException if URI creation fails.
	 * @throws IOException if reading from disk fails.
	 */
	@Test
	public void testNewPacFilePath()
			throws URISyntaxException, IOException {
		URI testRomURI = getTestRom1URI();
		Path testRomPath = Paths.get(testRomURI);
		PacFile pacFile = PacIO.newPacFile(testRomPath);
		assertNotNull(pacFile);
		System.out.println("File path: " + pacFile.getPath());
		System.out.println("Filename: " + pacFile.getName());
	}
	
	/**
	 * Tests the newPacFile method using the URI object.
	 * 
	 * @throws URISyntaxException if URI creation fails.
	 * @throws IOException if reading from disk fails.
	 */
	@Test
	public void testNewPacFileURI()
			throws URISyntaxException, IOException {
		URI testRomURI = getTestRom1URI();
		PacFile pacFile = PacIO.newPacFile(testRomURI);
		assertNotNull(pacFile);
		System.out.println("File path: " + pacFile.getPath());
		System.out.println("Filename: " + pacFile.getName());
	}
	
	/**
	 * Tests the newPacFile method using a String object.
	 * 
	 * @throws URISyntaxException if URI creation fails.
	 * @throws IOException if reading from disk fails.
	 */
	@Test
	public void testNewPacFileString()
			throws URISyntaxException, IOException {
		URI testRomURI = getTestRom1URI();
		String testRomString = testRomURI.getPath();
		PacFile pacFile = PacIO.newPacFile(testRomString);
		assertNotNull(pacFile);
		System.out.println("File path: " + pacFile.getPath());
		System.out.println("Filename: " + pacFile.getName());
	}
	
	/**
	 * Tests the newPacDirectory method using a Path interface.
	 * 
	 * @throws URISyntaxException if URI creation fails.
	 * @throws IOException if reading from disk fails.
	 */
	@Test
	public void testNewPacDirectoryPath()
			throws URISyntaxException, IOException {
		URI testRomSetURI = getTestRomSetURI();
		Path testRomPath = Paths.get(testRomSetURI);
		PacDirectory pacDirectory =
				PacIO.newPacDirectory(testRomPath);
		assertNotNull(pacDirectory);
		System.out.println("File path: " + pacDirectory.getPath());
		System.out.println("Filename: " + pacDirectory.getName());
	}
	
	/**
	 * Tests the newPacDirectory method using a URI object.
	 * 
	 * @throws URISyntaxException if URI creation fails.
	 * @throws IOException if reading from disk fails.
	 */
	@Test
	public void testNewPacDirectoryURI()
			throws URISyntaxException, IOException {
		URI testRomSetURI = getTestRomSetURI();
		PacDirectory pacDirectory =
				PacIO.newPacDirectory(testRomSetURI);
		assertNotNull(pacDirectory);
		System.out.println("File path: " + pacDirectory.getPath());
		System.out.println("Filename: " + pacDirectory.getName());
	}
	
	/**
	 * Tests the newPacDirectory method using a String object.
	 * 
	 * @throws URISyntaxException if URI creation fails.
	 * @throws IOException if reading from disk fails.
	 */
	@Test
	public void testNewPacDirectoryString()
			throws URISyntaxException, IOException {
		URI testRomSetURI = getTestRomSetURI();
		String testRomSetString = testRomSetURI.getPath();
		PacDirectory pacDirectory =
				PacIO.newPacDirectory(testRomSetString);
		assertNotNull(pacDirectory);
		System.out.println("File path: " + pacDirectory.getPath());
		System.out.println("Filename: " + pacDirectory.getName());
	}
}
