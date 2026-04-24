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

package io.github.thatgarlicdude.pacio.rom;

import io.github.thatgarlicdude.pacio.io.PacZip;

/**
 * A class that builds universal ROM sets.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacROMBuilder {
	
	/**
	 * The ZIP file required to build the universal ROM set.
	 */
	private final PacZip pacZip;
	
	/**
	 * Turns the ZIP file into a universal ROM set.
	 * 
	 * @return A universal, assembled ROM set.
	 */
	public final PacROM buildROM() {
		PacROM pacROM = null;
		return pacROM;
	}
	
	/**
	 * Constructs an instance of the ROM builder.
	 * 
	 * @param pacZip The ZIP file required to build the universal ROM set.
	 */
	public PacROMBuilder(final PacZip pacZip) {
		this.pacZip = pacZip;
	}
}
