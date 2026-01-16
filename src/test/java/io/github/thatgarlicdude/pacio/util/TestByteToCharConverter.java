package io.github.thatgarlicdude.pacio.util;

import org.junit.jupiter.api.Test;

public final class TestByteToCharConverter {
	
	private static final String MSG = "Index %d: %c";
	
	@Test
	public final void testConvert() {
		ByteToCharConverter converter = new ByteToCharConverter();
		byte index = 0;
		do {
			char character = converter.convert(index);
			String message = String.format(MSG, index, character);
			System.out.println(message);
			index++;
		} while (index != 0);
	}
}
