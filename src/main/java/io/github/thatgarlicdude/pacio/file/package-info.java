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
 * The file package of the PacIO library. It handles generic IO
 * handling to the system's disk.
 * 
 * <p>This package features two key classes:
 * {@link io.github.thatgarlicdude.pacio.file.PacFile}, and
 * {@link io.github.thatgarlicdude.pacio.file.PacDirectory}.
 * PacFile is a class that is treated like a regular file in the system's
 * disk, while PacDirectory is treated like a directory. These classes can
 * be opened and closed via the
 * {@link io.github.thatgarlicdude.pacio.file.Loadable} interface, and
 * saved via the {@link io.github.thatgarlicdude.pacio.file.Savable}
 * interface. Those classes are used to modify any file within the
 * <i>Pac-Man</i> ROM set, and not just ROMs themselves.</p>
 * 
 * @author GarlicDude
 */
package io.github.thatgarlicdude.pacio.file;