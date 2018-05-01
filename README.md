# java.lang.Object.finalize() is finally deprecated
Gradle source code repository for the examples from my blog post, http://bit.ly/javafinalize.
Built and tested on Linux Mint, SUSE Linux. As gradle does not currently support Java 11, this application can be run 
using the standard java commands.

![alt text](https://raw.githubusercontent.com/afinlay5/finalize-/master/blog.png)

# Platform 
- Any supporting the Oracle JVM for Java SE 11+.

# Requirements
- Gradle 4.7 
- Java 11 or greater

# Gradle Tasks
- ./gradlew build - Build Application
- ./gradlew run - Runs the main file in the console.

# Known Problems
- Fails with openJDK 11 EA+11 (04/30/2018).
- Fails with Oracle JDK 11 EA+11 (04/30/2018).

# Execution Screenshot
<!-- ![alt text](https://raw.githubusercontent.com/afinlay5/finalize-/master/gradle_run.png) -->
![alt text](https://raw.githubusercontent.com/afinlay5/finalize-/master/run.png)
