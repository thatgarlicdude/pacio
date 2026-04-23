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
	 * The PacCatalog manager.
	 */
	private final PacCatalogManager manager;
	
	/**
	 * Tests the getPacManCatalog in the PacCatalogManager class.
	 */
	@Test
	public final void testGetPacManCatalog() {
		PacManCatalog pacManCatalog = manager.getPacManCatalog();
		assertSame(pacManCatalog, manager.pacManCatalog);
	}
	
	/**
	 * Tests the getPuckManCatalog in the PacCatalogManager class.
	 */
	@Test
	public final void testGetPuckManCatalog() {
		PuckManCatalog puckManCatalog = manager.getPuckManCatalog();
		assertSame(puckManCatalog, manager.puckManCatalog);
	}
	
	/**
	 * Tests the getTestCatalog in the PacCatalogManager class.
	 */
	@Test
	public final void testGetTestCatalog() {
		TestCatalog testCatalog = manager.getTestCatalog();
		assertSame(testCatalog, manager.testCatalog);
	}
	
	/**
	 * Constructs an instance of the test class.
	 */
	public TestPacCatalogManager() {
		this.manager = new PacCatalogManager();
	}
}
