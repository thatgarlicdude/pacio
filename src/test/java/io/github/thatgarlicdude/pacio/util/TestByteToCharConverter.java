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

import org.junit.jupiter.api.Test;

/**
 * A test class for the ByteToCharConverter class.
 * 
 * @author GarlicDude
 */
public final class TestByteToCharConverter {
	
	/**
	 * Placeholder message for the testConvert method.
	 */
	private static final String MSG = "Index %d: %c";
	
	/**
	 * A test method for the ByteToCharConverter class's convert method.
	 */
	@Test
	public final void testConvert() {
		byte index = 0;
		do {
			char character = ByteToCharConverter.convert(index);
			String message = String.format(MSG, index, character);
			System.out.println(message);
			index++;
		} while (index != 0);
	}
}
