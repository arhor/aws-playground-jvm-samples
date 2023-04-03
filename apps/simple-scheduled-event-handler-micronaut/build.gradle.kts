plugins {
    id("io.micronaut.library")
    id("com.github.johnrengelman.shadow")
}

java {
    toolchain {
        languageVersion.set(
            property("versions.java")
                .let { it.toString() }
                .let { JavaLanguageVersion.of(it) }
        )
    }
}

micronaut {
    runtime("lambda_java")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.github.arhor.aws.playground.samples.*")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("ch.qos.logback:logback-classic")

    implementation(platform(rootProject))
    implementation("com.amazonaws:aws-lambda-java-events")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.aws:micronaut-function-aws")

    testImplementation("io.micronaut:micronaut-http-client")
}
