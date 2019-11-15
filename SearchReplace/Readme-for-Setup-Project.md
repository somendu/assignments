# Search Replace

> Search and Replace Function for Text and XML Files

## Build Setup

Setup [Eclipse](https://www.eclipse.org/downloads/) 

Setup [Gradle](https://gradle.org/install/)

Setup [Lombok](https://projectlombok.org/download)



``` bash
# Run the project from command line in project path
gradle --console=plain shadowJar

# command line for XML File
java -jar build/libs/SearchReplace.jar --fileType xml --searchString trace --replaceString error --sourceFile fileplace/configuration.xml --targetFile fileplace/result.xml


# command line for Text File
java -jar build/libs/SearchReplace.jar --fileType txt --searchString customer --replaceString client --sourceFile fileplace/manifest.txt --targetFile fileplace/result.txt

```

For a detailed explanation on how things work, check out the [guide](https://imperceptiblethoughts.com/shadow/introduction/#benefits-of-shadow) for shadow jar
