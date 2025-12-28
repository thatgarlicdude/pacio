package io.github.thatgarlicdude.pacio.rom;

import java.nio.file.Path;

/**A class that represents a file object within the file system.*/
public abstract class PacObject {
	
	/**The file path of the file object.*/
	protected final Path path;
	
	/**The filename of the file object.*/
	protected final String name;
	
	/**Returns the file path of the file object.*/
	public final Path getPath() {
		return path;
	}
	
	/**Returns the filename of the file object.*/
	public final String getName() {
		return name;
	}
	
	/**Constructs an instance of this class.*/
	protected PacObject(final Path path, final String name) {
		this.path = path;
		this.name = name;
	}
}
