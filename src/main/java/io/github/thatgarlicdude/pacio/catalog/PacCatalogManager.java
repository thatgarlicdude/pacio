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
 * TODO: In the future, this class shouldn't exist. All it really does is
 * manage objects that are in memory, and will stay in memory throughout
 * the duration of a program, let's say Relaxian. The Pac-Man, Puck-Man,
 * and test catalogs shouldn't exist either. The best solution for this
 * issue is to treat PacCatalog classes as data stored from disk, and can
 * be read to memory and written back to disk.
 * 
 * Also, the name of the class is very misleading. It's more of a static
 * container of PacCatalog objects than a manager. No wonder it should be
 * deleted.
 */

/**
 * A static class used for managing {@link PacCatalog} objects.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 * @see PacCatalog
 */
public final class PacCatalogManager {
	
	/**
	 * The list of {@link PacCatalog} objects that are currently available
	 * in memory.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getPacCatalogs()
	 * @see #getPacCatalog(int)
	 */
	private static final PacCatalog[] pacCatalogs = {
			new PacManCatalog(),
			new PuckManCatalog(),
			new TestCatalog()
	};
	
	/**
	 * Gets the {@link #pacCatalogs} array, which is a list of available
	 * {@link PacCatalog} objects that are currently in memory.
	 * 
	 * @return A list of PacCatalog objects.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #pacCatalogs
	 * @see #getPacCatalog(int)
	 */
	public static final PacCatalog[] getPacCatalogs() {
		// Clone the PacCatalogs array.
		return pacCatalogs.clone();
	}
	
	/**
	 * Gets a specific {@link PacCatalog} object that is within the
	 * {@link #pacCatalogs} array.
	 * 
	 * <p>Here's a list of available {@link PacCatalog} objects that can
	 * be obtained from the {@link #pacCatalogs} array:</p>
	 * 
	 * <ol>
	 * 	<li>{@link PacManCatalog}</li>
	 * 	<li>{@link PuckManCatalog}</li>
	 * 	<li>{@link TestCatalog}</li>
	 * </ol>
	 * 
	 * @param index The index of the array.
	 * @return A specific PacCatalog object from the list.
	 * @since 1.0.0-alpha
	 * @see #pacCatalogs
	 * @see #getPacCatalogs()
	 */
	public static final PacCatalog getPacCatalog(
			final int index) {
		// Get a specific PacCatalog in the array based on the index.
		return pacCatalogs[index];
	}
	
	/**
	 * Private constructor; class cannot be instantiated by any means.
	 * 
	 * <p>Even if the constructor has somehow been called, it will throw
	 * an error, which is an {@code UnsupportedOperationException}.</p>
	 * 
	 * @throws UnsupportedOperationException When the constructor is
	 * called.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	private PacCatalogManager() {
		// Throw the exception when the constructor has been called.
		throw new UnsupportedOperationException();
	}
}
