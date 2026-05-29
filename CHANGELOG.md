2026-05-29 GarlicDude <garlicdudedev@gmail.com>

	PacIO Version 1.0.3-alpha
	* Updated build.gradle.
		* Removed Maven Local support.
		* The publications block now has POM and Maven Central data.
		* Added the signing block.
	* Updated INSTALL.md.
		* Removed instructions about publishing to Maven Local.
	* Updated CHANGELOG.md.
		* Corrected the dates of each version to be 2026 instead of 2025.

2026-05-03 GarlicDude <garlicdudedev@gmail.com>

	PacIO Version 1.0.2-alpha
	* Updated build.gradle.
		* Removed JitPack functionality.
		* Added Maven Local functionality.
	* Updated INSTALL.md.
		* Added instructions about publishing to Maven Local.
	* Updated README.md.
		* Added the version shield.
		* Added the license shield.

2026-05-02 GarlicDude <garlicdudedev@gmail.com>

	PacIO Version 1.0.1-alpha
	* Updated build.gradle.
		* Cleaned the layout of the file to be more friendly to JitPack, if possible.
		* Added the ability to publish to Maven Local.

2026-05-01 GarlicDude <garlicdudedev@gmail.com>

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
