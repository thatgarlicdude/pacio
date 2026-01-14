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

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A class used for getting the testRomSet directory for the test function.
 * 
 * @author GarlicDude
 */
public final class ResourceGetter {
	
	/**
	 * The name of the test ROM set.
	 */
	public static final String testRomSet = "testRomSet";
	
	/**
	 * The first ROM in the testRomSet.
	 */
	public static final String rom1 = "testRomSet/testRom.8a";
	
	/**
	 * Returns the URI of the testRomSet directory.
	 * 
	 * @return the URI reference to the testRomSet directory.
	 * @throws URISyntaxException if URI creation fails.
	 */
	public static final URI getTestRomSetURI() throws URISyntaxException {
		URI testRomSetURI = ResourceGetter.class.getClassLoader()
				.getResource(testRomSet)
				.toURI();
		return testRomSetURI;
	}
	
	/**
	 * Returns the URI of the testRom.8a file.
	 * 
	 * @return the URI reference to the testRom.8a file.
	 * @throws URISyntaxException if URI creation fails.
	 */
	public static final URI getTestRom1URI() throws URISyntaxException {
		URI testRomURI = ResourceGetter.class.getClassLoader()
				.getResource(rom1)
				.toURI();
		return testRomURI;
	}
}
