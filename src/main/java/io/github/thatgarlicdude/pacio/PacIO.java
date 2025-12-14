package io.github.thatgarlicdude.pacio;

import io.github.thatgarlicdude.pacio.rom.PacRom;
import io.github.thatgarlicdude.pacio.rom.PacRomOpener;
import io.github.thatgarlicdude.pacio.rom.PacRomSet;
import io.github.thatgarlicdude.pacio.rom.PacRomSetOpener;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

/**The main class of the PacIO library.*/
public final class PacIO {
	
	/**Creates a new PacRom through a Path interface, and automatically opens it.*/
	public static final PacRom newPacRom(final Path path) throws IOException {
		return PacRomOpener.open(path);
	}
	
	/**Creates a new PacRom through a URI object, and automatically opens it.*/
	public static final PacRom newPacRom(final URI pathURI) throws IOException {
		return PacRomOpener.open(pathURI);
	}
	
	/**Creates a new PacRom through a string, and automatically opens it.*/
	public static final PacRom newPacRom(final String pathString) throws IOException {
		return PacRomOpener.open(pathString);
	}
	
	/**Creates a new PacRomSet through a Path interface, and automatically opens it.*/
	public static final PacRomSet newPacRomSet(final Path path) throws IOException {
		return PacRomSetOpener.open(path);
	}
	
	/**Creates a new PacRomSet through a URI object, and automatically opens it.*/
	public static final PacRomSet newPacRomSet(final URI pathURI) throws IOException {
		return PacRomSetOpener.open(pathURI);
	}
	
	/**Creates a new PacRomSet through a string, and automatically opens it.*/
	public static final PacRomSet newPacRomSet(final String pathString) throws IOException {
		return PacRomSetOpener.open(pathString);
	}
}
