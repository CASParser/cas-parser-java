plugins {
    id("cas-parser.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":cas-parser-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :cas-parser-java-example:run` to run `Main`
    // Use `./gradlew :cas-parser-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.cas_parser.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
