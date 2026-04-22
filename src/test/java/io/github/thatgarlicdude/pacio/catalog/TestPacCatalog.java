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

package io.github.thatgarlicdude.pacio.catalog;

import org.junit.Test;

/**
 * A test class of the PacCatalog class.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public abstract class TestPacCatalog {
	
	/**
	 * Tests the getProgramROMs method in the PacCatalog class.
	 */
	@Test
	public abstract void testGetProgramROMs();
	
	/**
	 * Tests the getGraphicROMs method in the PacCatalog class.
	 */
	@Test
	public abstract void testGetGraphicROMs();
	
	/**
	 * Tests the getColorROMs method in the PacCatalog class.
	 */
	@Test
	public abstract void testGetColorROMs();
	
	/**
	 * Tests the getPaletteROMs method in the PacCatalog class.
	 */
	@Test
	public abstract void testGetPaletteROMs();
	
	/**
	 * Tests the getSoundROMs method in the PacCatalog class.
	 */
	@Test
	public abstract void testGetSoundROMs();
}
