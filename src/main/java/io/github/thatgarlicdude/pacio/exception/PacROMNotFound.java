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

package io.github.thatgarlicdude.pacio.exception;

/**
 * An exception class used when a ROM is not found in the ROM set.
 * 
 * @version 1.0.0
 * @author GarlicDude
 */
public final class PacROMNotFound extends PacIOException {
	
	/**
	 * The serial version UID of the exception.
	 */
	private static final long serialVersionUID = 6043878143295530574L;
	
	/**
	 * The placeholder message when the exception occurs.
	 */
	private static final String PLACEHOLDER_MESSAGE =
			"ROM not found: %s";
	
	/**
	 * Formats the error message for the exception.
	 * 
	 * @param romName The name for the missing ROM file.
	 * @return The formatted error message.
	 */
	private static final String format(final String romName) {
		return String.format(PLACEHOLDER_MESSAGE, romName);
	}
	
	/**
	 * Constructs an instance of the exception.
	 * 
	 * @param romName The name for the missing ROM file.
	 */
	public PacROMNotFound(final String romName) {
		super(format(romName));
	}
}
