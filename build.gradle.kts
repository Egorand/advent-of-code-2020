import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.21"
}

group = "dev.egorand"
version = "0.1.0"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.4.21")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  freeCompilerArgs = listOf(
    "-Xinline-classes",
    "-Xopt-in=kotlin.ExperimentalStdlibApi"
  )
}
