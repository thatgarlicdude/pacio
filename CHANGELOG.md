2025-05-01 GarlicDude <garlicdudedev@gmail.com>

	PacIO Version 1.0.0-alpha
	* Added PacIO.java.
		* This is the main class of the library.
	* Added PacCatalogs.
		* PacCatalogs are a categorized list of ROM filenames in a ROM set ZIP file.
		* There's PacCatalog.java, which is an abstract base class for all PacCatalogs.
		* So far, there is PacManCatalog.java, PuckManCatalog.java, and TestCatalog.java.
		* There's also a PacCatalogManager.java, which has the PacCatalogs available in memory.
	* Added PacROMSet.java.
		* This represents a unified ROM set, which means it has the program ROM data concated together in one array. Same for the graphic ROMs and other ROMs.
	* Added PacROMSetFilenames.java.
		* This is an interface that contains all the filenames for a unified ROM set ZIP file.
	* Added PacROMSetImporter.java.
		* This class imports original Pac-Man ROM set ZIP files into unified ROM sets in memory.
	* Added PacROMSetOpener.java.
		* This class opens unified ROM set ZIP files from disk to memory.
	* Added PacROMSetSaver.java.
		* This class saves unified ROM set ZIP files to disk.
