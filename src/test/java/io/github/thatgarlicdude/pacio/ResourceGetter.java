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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**A class used for getting the testRomSet directory for the test function.*/
public final class ResourceGetter {
	
	/**The name of the test ROM set.*/
	public static final String testRomSet = "testRomSet";
	
	/**The first ROM in the testRomSet.*/
	public static final String rom1 = "testRom.8a";
	
	/**Returns the URI of the testRomSet directory.*/
	public static final URI getTestRomSetURI() throws URISyntaxException {
		URI testRomSetURI = ResourceGetter.class.getClassLoader().getResource(testRomSet).toURI();
		return testRomSetURI;
	}
	
	/**Returns the testRomSet directory as a PacRomSet.*/
	public static final PacRomSet getTestRomSet() throws URISyntaxException, IOException {
		URI testRomSetURI = getTestRomSetURI();
		PacRomSet testRomSet = RomOpener.openRomSet(testRomSetURI);
		return testRomSet;
	}
}
