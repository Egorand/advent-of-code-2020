plugins {
  kotlin("jvm") version "1.4.20"
}

group = "dev.egorand"
version = "0.1.0"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.4.20")
}
