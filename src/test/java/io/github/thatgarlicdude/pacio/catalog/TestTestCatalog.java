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

/*
 * TODO: Delete this, since there wouldn't be a need to have a
 * TestCatalog class in the future.
 * 
 * Also, imagine being named "TestTestCatalog".
 */

/**
 * A test class of the {@link TestCatalog} class.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 * @see TestCatalog
 */
public final class TestTestCatalog extends TestPacCatalog {
	
	/**
	 * The test catalog used for testing purposes.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	private static final TestCatalog pacCatalog = new TestCatalog();
	
	/**
	 * Constructs an instance of the {@link TestTestCatalog} class.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	public TestTestCatalog() {
		// Build the test with the PacCatalog object.
		super(pacCatalog);
	}
}
