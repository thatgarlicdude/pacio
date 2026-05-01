# Installing PacIO

## Requirements

- Java 8 or above.

If you are not sure what Java version you're on, go to your terminal and type `java -version`. It should be Java 8 or above. If you meet the requirement, you're good to go!

Also, Gradle is **not** a prerequisite for this project. As a fair warning, Gradle will be automatically downloaded by running `./gradlew build` on Linux, or `gradle.bat build` on Windows. Just a heads up.

## Steps (Mac OS X / Linux)

1. Clone the repository from GitHub by typing `git clone https://github.com/thatgarlicdude/pacio.git` to your terminal.

2. In your terminal, change your working directory to the root of the cloned repository by typing `cd pacio`.

3. Now that you're in the repository, type `./gradlew build` to build the project.

4. The built JAR file will be located in the **build/libs** directory. From there, you should see a JAR file named **pacio-<version>.jar**.

## Steps (Windows)

1. Clone the repository from GitHub by typing `git clone https://github.com/thatgarlicdude/pacio.git` to your terminal.

2. In your terminal, change your working directory to the root of the cloned repository by typing `cd pacio`.

3. Now that you're in the repository, type `gradlew.bat build` to build the project.

4. The built JAR file will be located in the **build/libs** directory. From there, you should see a JAR file named **pacio-<version>.jar**.
