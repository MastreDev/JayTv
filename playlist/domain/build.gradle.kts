plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
kotlin{
    jvmToolchain(17)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation("javax.inject:javax.inject:1")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")

    testImplementation("io.kotest:kotest-runner-junit5:5.7.2")
}