Archive Test Gradle Plugin
========================

`plugin` folder contains the Gradle plugin

`sample` folder contains a sample code that uses the plugin


Testing the plugin
------------------

 - Compile the plugin

```sh
./gradlew uploadArchives
```

The result will be push into a new folder repo, at the root of this folder.

 - Then, execute the sample

```sh
cd sample
../gradlew archivetest
```
