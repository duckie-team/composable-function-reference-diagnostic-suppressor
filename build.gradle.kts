/*
 * Developed by 2022 SungbinLand, Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/composable-function-reference-diagnostic-suppressor/blob/main/LICENSE
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    kotlin("kapt") version "1.7.20"
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.vanniktech.maven.publish") version "0.22.0"
}

gradlePlugin {
    plugins {
        create("composableReferenceSuppressor") {
            id = "land.sungbin.composable.reference.suppressor"
            implementationClass = "plugin.ComposableReferenceSuppressorPlugin"
        }
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

// [The latest version of Compose Compiler]
// https://maven.pkg.jetbrains.space/public/p/compose/dev/org/jetbrains/compose/compiler/compiler/
dependencies {
    compileOnly(gradleApi())
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.7.20")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("org.jetbrains.compose.compiler:compiler:1.3.2-alpha01")
    compileOnly("com.google.auto.service:auto-service:1.0.1")
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
