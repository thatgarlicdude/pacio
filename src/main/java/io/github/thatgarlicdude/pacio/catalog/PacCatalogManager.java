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

/**
 * The a class used for managing PacCatalog objects.
 * 
 * @version 1.0.0-alpha
 * @author GarlicDude
 */
public final class PacCatalogManager {
	
	/**
	 * Error message used when the constructor has been called.
	 */
	private static final String ERROR_MESSAGE =
			"PacCatalogManager can't be instantiated";
	
	/**
	 * The list of PacCatalog objects.
	 */
	private static final PacCatalog[] pacCatalogs = {
			new PacManCatalog(),
			new PuckManCatalog(),
			new TestCatalog()
	};
	
	/**
	 * Returns a copied list of PacCatalog objects.
	 * 
	 * @return A list of PacCatalog objects.
	 */
	public static final PacCatalog[] getPacCatalogs() {
		PacCatalog[] newPacCatalogs = pacCatalogs.clone();
		return newPacCatalogs;
	}
	
	/**
	 * Returns a specific PacCatalog object from the list using an index.
	 * 
	 * @param index The index of the array.
	 * @return A specific PacCatalog object from the list.
	 */
	public static final PacCatalog getPacCatalog(final int index) {
		PacCatalog pacCatalog = pacCatalogs[index];
		return pacCatalog;
	}
	
	/**
	 * Private constructor; object cannot be instantiated by any means.
	 * 
	 * @throws UnsupportedOperationException When the constructor is
	 * called.
	 */
	private PacCatalogManager() {
		throw new UnsupportedOperationException(ERROR_MESSAGE);
	}
}
