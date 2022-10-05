/*
 * Developed by 2022 SungbinLand, Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/composable-function-reference-diagnostic-suppressor/blob/main/LICENSE
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    `java-gradle-plugin`
    id("com.vanniktech.maven.publish") version "0.22.0"
}

gradlePlugin {
    plugins {
        create("composableReferenceSuppressor") {
            id = "land.sungbin.composable.reference.suppressor"
            implementationClass = "land.sungbin.composable.reference.suppressor.ComposableReferenceSuppressorPlugin"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation("org.jetbrains.compose.compiler:compiler:1.1.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = JavaVersion.VERSION_11.toString()
}