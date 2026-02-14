plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("CAS Parser - Track Portfolios from CDSL, NSDL, CAMS, KFintech")
                description.set("API for parsing and analyzing CAS (Consolidated Account Statement) PDF files\nfrom NSDL, CDSL, and CAMS/KFintech, with a unified response format")
                url.set("https://docs.casparser.in/reference")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Cas Parser")
                        email.set("sameer@casparser.in")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/CASParser/cas-parser-java.git")
                    developerConnection.set("scm:git:git://github.com/CASParser/cas-parser-java.git")
                    url.set("https://github.com/CASParser/cas-parser-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
    repositories {
        if (project.hasProperty("publishLocal")) {
            maven {
                name = "LocalFileSystem"
                url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
