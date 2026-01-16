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

package io.github.thatgarlicdude.pacio.util;

/**
 * @author GarlicDude
 */
public final class ByteToCharConverter {
	
	/**
	 * The starting point of the printable characters in the ASCII table.
	 */
	public static final byte MINIMUM_POINT = 32;
	
	/**
	 * The point to the last printable ASCII character, which is DEL.
	 */
	public static final byte MAXIMUM_POINT = 127;
	
	/**
	 * The output character when the conversion is out of bounds.
	 */
	public static final char GENERIC_CHAR = '.';
	
	/**
	 * Converts a single byte to a character. Returns '.' if out of bounds.
	 * @param b a byte used to convert to a character.
	 * @return a character that was converted.
	 */
	public char convert(final byte b) {
		if (b < MINIMUM_POINT || b == MAXIMUM_POINT) return GENERIC_CHAR;
		return (char) b;
	}
}
