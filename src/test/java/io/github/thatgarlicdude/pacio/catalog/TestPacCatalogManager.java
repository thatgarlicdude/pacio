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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class of the PacCatalogManager class.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class TestPacCatalogManager {
	
	/**
	 * Tests the getPacCatalogs method in PacCatalogManager.
	 */
	@Test
	public final void testGetPacCatalogs() {
		PacCatalog[] pacCatalogs = PacCatalogManager.getPacCatalogs();
		// pacCatalogs should not be the same as the original.
		// Also, the contents in the array are the same pointers.
		assertNotNull(pacCatalogs);
	}
	
	/**
	 * Tests the getPacCatalog method in PacCatalogManager.
	 */
	@Test
	public final void testGetPacCatalog() {
		PacCatalog pacCatalog = PacCatalogManager.getPacCatalog(0);
		// First object in the array should not be null.
		assertNotNull(pacCatalog);
	}
}
