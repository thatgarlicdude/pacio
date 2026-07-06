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
 * TODO: In the future, the PacCatalog class should be in its own separate
 * library, PacCatalogs. I feel like there can be a lot more with the
 * PacCatalog classes than it meets the eye.
 */

/**
 * An abstract class that represents as a categorized list of ROM file
 * names in a <i>Pac-Man</i> ROM set.
 * 
 * @since 1.0.0-alpha
 * @author GarlicDude
 * @see PacCatalogManager
 * @see PacManCatalog
 * @see PuckManCatalog
 * @see TestCatalog
 */
public abstract class PacCatalog {
	
	/**
	 * The list of program ROM filenames that are in a <i>Pac-Man</i>
	 * ROM set.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getProgramROMNames()
	 */
	protected final String[] programROMNames;
	
	/**
	 * The list of graphic ROM filenames that are in a <i>Pac-Man</i>
	 * ROM set.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getGraphicROMNames()
	 */
	protected final String[] graphicROMNames;
	
	/**
	 * The list of color ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getColorROMNames()
	 */
	protected final String[] colorROMNames;
	
	/**
	 * The list of palette ROM filenames that are in a <i>Pac-Man</i>
	 * ROM set.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getPaletteROMNames()
	 */
	protected final String[] paletteROMNames;
	
	/**
	 * The list of sound ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getSoundROMNames()
	 */
	protected final String[] soundROMNames;
	
	/**
	 * The list of mystery ROM filenames that are in a <i>Pac-Man</i>
	 * ROM set.
	 * 
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #getMysteryROMNames()
	 */
	protected final String[] mysteryROMNames;
	
	/**
	 * Gets a cloned array of the {@link #programROMNames} array, which is
	 * a list of program ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @return A cloned array of the {@link #programROMNames} array.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #programROMNames
	 */
	public final String[] getProgramROMNames() {
		return programROMNames.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #graphicROMNames} array, which is
	 * a list of graphic ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @return A cloned array of the {@link #graphicROMNames} array.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #graphicROMNames
	 */
	public final String[] getGraphicROMNames() {
		return graphicROMNames.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #colorROMNames} array, which is
	 * a list of color ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @return A cloned array of the {@link #colorROMNames} array.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #colorROMNames
	 */
	public final String[] getColorROMNames() {
		return colorROMNames.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #paletteROMNames} array, which is
	 * a list of palette ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @return A cloned array of the {@link #paletteROMNames} array.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #paletteROMNames
	 */
	public final String[] getPaletteROMNames() {
		return paletteROMNames.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #soundROMNames} array, which is
	 * a list of sound ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @return A cloned array of the {@link #soundROMNames} array.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #soundROMNames
	 */
	public final String[] getSoundROMNames() {
		return soundROMNames.clone();
	}
	
	/**
	 * Gets a cloned array of the {@link #mysteryROMNames} array, which is
	 * a list of mystery ROM filenames that are in a <i>Pac-Man</i> ROM
	 * set.
	 * 
	 * @return A cloned array of the {@link #mysteryROMNames} array.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 * @see #colorROMNames
	 */
	public final String[] getMysteryROMNames() {
		return mysteryROMNames.clone();
	}
	
	/**
	 * Constructs an instance of the {@link PacCatalog} class.
	 * 
	 * @param programROMNames The list of program ROM filenames that are
	 * in a <i>Pac-Man</i> ROM set.
	 * @param graphicROMNames The list of graphic ROM filenames that are
	 * in a <i>Pac-Man</i> ROM set.
	 * @param colorROMNames The list of color ROM filenames that are in a
	 * <i>Pac-Man</i> ROM set.
	 * @param paletteROMNames The list of palette ROM filenames that are
	 * in a <i>Pac-Man</i> ROM set.
	 * @param soundROMNames The list of sound ROM filenames that are in a
	 * <i>Pac-Man</i> ROM set.
	 * @param mysteryROMNames The list of mystery ROM filenames that are
	 * in a <i>Pac-Man</i> ROM set.
	 * @since 1.0.0-alpha
	 * @author GarlicDude
	 */
	protected PacCatalog(
			final String[] programROMNames,
			final String[] graphicROMNames,
			final String[] colorROMNames,
			final String[] paletteROMNames,
			final String[] soundROMNames,
			final String[] mysteryROMNames) {
		this.programROMNames = programROMNames;
		this.graphicROMNames = graphicROMNames;
		this.colorROMNames = colorROMNames;
		this.paletteROMNames = paletteROMNames;
		this.soundROMNames = soundROMNames;
		this.mysteryROMNames = mysteryROMNames;
	}
}
