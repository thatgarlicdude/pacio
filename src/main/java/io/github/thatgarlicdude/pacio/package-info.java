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

/**
 * A Java library for accessing <i>Pac-Man</i> ROM sets and opening,
 * saving, and modifying unified ROM sets.
 * 
 * <p>This package is home to the
 * {@link io.github.thatgarlicdude.pacio.PacIO PacIO} class, which is the
 * main class of the PacIO library. The
 * {@link io.github.thatgarlicdude.pacio.PacIO PacIO} class is used to
 * import existing <i>Pac-Man</i> ROM set ZIP files from disk, and turning
 * them into the
 * {@link io.github.thatgarlicdude.pacio.io.PacROMSet PacROMSet} object to
 * memory, which is described as a <b>unified ROM set</b>. Not just that,
 * but it can also save unified ROM sets to disk as ZIP files and open
 * them from disk. The main class serves as a gateway to importing
 * existing <i>Pac-Man</i> ROM sets, opening unified ROM sets, and saving
 * them to disk.</p>
 * 
 * @author GarlicDude
 */
package io.github.thatgarlicdude.pacio;