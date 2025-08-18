plugins {
    id("cas-parser.kotlin")
    id("cas-parser.publish")
}

dependencies {
    api(project(":cas-parser-java-core"))

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.25.3")
}
