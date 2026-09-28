# Search Replace

> Search and Replace Function for Text and XML Files

## Build Setup

Setup [Eclipse](https://www.eclipse.org/downloads/) 

Install JDK 17 or newer. Use the included Gradle wrapper, which pins Gradle 9.7.1.

Setup [Lombok](https://projectlombok.org/download)



``` bash
# Run the project from command line in project path
./gradlew --console=plain shadowJar

# command line for XML File
java -Xmx11264m -jar build/libs/SearchReplace.jar --fileType xml --searchString trace --replaceString error --sourceFile fileplace/configuration.xml --targetFile fileplace/result.xml


# command line for Text File
java -Xmx11264m -jar build/libs/SearchReplace.jar --fileType txt --searchString customer --replaceString client --sourceFile fileplace/manifest.txt --targetFile fileplace/result.txt

```

On Windows PowerShell, use `.\gradlew.bat --console=plain shadowJar`.

## Code formatting

Spotless uses Google Java Format to format main and test Java sources.
Java compilation and Gradle Java execution tasks automatically run `spotlessApply`.
IntelliJ is configured to build, run, and test using Gradle, so running a Java
`main` method formats the sources first. Reload the Gradle project after changing
these settings. No separate formatting or clean command is required.
The `clean` task automatically runs `spotlessApply` after deleting build outputs.

```powershell
# Format sources and remove build outputs
.\gradlew.bat clean

# Format, rebuild, and run tests
.\gradlew.bat clean build

# Format without cleaning
.\gradlew.bat spotlessApply

# Check formatting without changing files (also included in build)
.\gradlew.bat spotlessCheck
```

For a detailed explanation on working of Shadow Jar, check out the [guide](https://imperceptiblethoughts.com/shadow/introduction/#benefits-of-shadow) for shadow jar

For gradle and lombok the setup links provide the informatioon
