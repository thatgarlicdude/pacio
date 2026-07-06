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

/*
 * TODO: This test needs to be deleted like its source counterpart. The
 * reasoning for this is that there shouldn't be a need to have a
 * PacCatalogManager, and the PacCatalog class itself will be reworked as
 * something that can be saved to disk and loaded to memory.
 */

/**
 * A test class of the {@link PacCatalogManager} class.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 * @see PacCatalogManager
 */
public final class TestPacCatalogManager {
	
	/**
	 * Tests the {@link PacCatalogManager#getPacCatalogs()} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalogManager#getPacCatalogs()
	 */
	@Test
	public final void testGetPacCatalogs() {
		// Get the array of PacCatalogs.
		final PacCatalog[] pacCatalogs =
				PacCatalogManager.getPacCatalogs();
		// Just assert it as not null. There's not much else to do with it.
		assertNotNull(pacCatalogs);
	}
	
	/**
	 * Tests the {@link PacCatalogManager#getPacCatalog(int)} method.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see PacCatalogManager#getPacCatalog(int)
	 */
	@Test
	public final void testGetPacCatalog() {
		// Get the first PacCatalog object in the array.
		final PacCatalog pacCatalog =
				PacCatalogManager.getPacCatalog(0);
		// Assert that as not null. It should not be null.
		assertNotNull(pacCatalog);
	}
}
