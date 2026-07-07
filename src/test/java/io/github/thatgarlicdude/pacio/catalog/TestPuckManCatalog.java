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
 * PuckManCatalog class in the future.
 */

/**
 * A test class of the {@link PuckManCatalog} class.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 * @see PuckManCatalog
 */
public final class TestPuckManCatalog extends TestPacCatalog {

	/**
	 * The <i>Puck-Man</i> catalog used for testing purposes.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	private static final PuckManCatalog pacCatalog = new PuckManCatalog();
	
	/**
	 * Constructs an instance of the {@link TestPuckManCatalog} class.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	public TestPuckManCatalog() {
		// Build the test with the PacCatalog object.
		super(pacCatalog);
	}
}
