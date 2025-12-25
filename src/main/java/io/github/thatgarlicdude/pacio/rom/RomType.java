/*
 * Copyright 2025 GarlicDude
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

/**An enum that represents a type for a ROM.*/
public enum RomType {
	UNKNOWN("Unknown ROM"),
	PROGRAM("Program ROM"),
	COLOR("Color ROM"),
	PALETTE("Palette ROM"),
	SPRITE("Sprite ROM"),
	TILE("Tile ROM"),
	MUSIC("Music ROM"),
	SOUND("Sound ROM");
	
	/**The type of the ROM.*/
	private final String type;
	
	/**Constructs an instance of this class.*/
	RomType(final String type) {
		this.type = type;
	}
	
	/**Returns the type of the ROM.*/
	public final String getType() {
		return type;
	}
}
