import java.util.Properties

plugins {
    id("com.android.library")
    `maven-publish`
    signing
}

val publishGroupId = "io.appwrite"
val publishArtifactId = "sdk-for-android"
val publishVersion: String = System.getenv("SDK_VERSION") ?: "0.0.0"
val pomUrl = "https://github.com/appwrite/sdk-for-android"
val pomScmUrl = "https://github.com/appwrite/sdk-for-android"
val pomDescription = "Appwrite is an open-source backend as a service server that abstracts and simplifies complex and repetitive development tasks behind a very simple to use REST API. Appwrite aims to help you develop your apps faster and in a more secure way. Use the Android SDK to integrate your app with the Appwrite server to easily start interacting with all of Appwrite backend APIs and tools. For full API documentation and tutorials go to [https://appwrite.io/docs](https://appwrite.io/docs)"
val pomLicenseUrl = "https://opensource.org/licenses/GPL-3.0"
val pomLicenseName = "GPL-3.0"
val pomDeveloperId = "appwrite"
val pomDeveloperName = "Appwrite Team"
val pomDeveloperEmail = "team@appwrite.io"
val githubScmConnection = "scm:git:git://github.com/appwrite/sdk-for-android.git"

version = publishVersion

val signingKeyId: String = System.getenv("SIGNING_KEY_ID") ?: ""
val signingPassword: String = System.getenv("SIGNING_PASSWORD") ?: ""
val signingSecretKeyRingFile: String = System.getenv("SIGNING_SECRET_KEY_RING_FILE") ?: ""

val secretPropsFile = project.rootProject.file("local.properties")
val localProperties = Properties().apply {
    if (secretPropsFile.exists()) {
        secretPropsFile.inputStream().use { load(it) }
    }
}

extra["signing.keyId"] = signingKeyId.ifEmpty { localProperties.getProperty("signing.keyId", "") }
extra["signing.password"] = signingPassword.ifEmpty { localProperties.getProperty("signing.password", "") }
extra["signing.secretKeyRingFile"] = signingSecretKeyRingFile.ifEmpty { localProperties.getProperty("signing.secretKeyRingFile", "") }

android {
    namespace = publishGroupId

    compileSdk = 36

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 21
        buildConfigField("String", "SDK_VERSION", "\"$publishVersion\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    testOptions {
        unitTests.all {
            it.systemProperty("robolectric.conscryptMode", "OFF")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    api("com.squareup.okhttp3:okhttp:5.3.2")
    implementation("com.google.code.gson:gson:2.11.0")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.8.7")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.fragment:fragment-ktx:1.8.5")
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.browser:browser:1.8.0")
    implementation("androidx.core:core-ktx:1.15.0")

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test.ext:junit-ktx:1.2.1")
    testImplementation("androidx.test:core-ktx:1.6.1")
    testImplementation("org.robolectric:robolectric:4.16.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])

                groupId = publishGroupId
                artifactId = publishArtifactId
                version = publishVersion

                pom {
                    name.set(publishArtifactId)
                    description.set(pomDescription)
                    url.set(pomUrl)

                    licenses {
                        license {
                            name.set(pomLicenseName)
                            url.set(pomLicenseUrl)
                        }
                    }

                    developers {
                        developer {
                            id.set(pomDeveloperId)
                            name.set(pomDeveloperName)
                            email.set(pomDeveloperEmail)
                        }
                    }

                    scm {
                        connection.set(githubScmConnection)
                        url.set(pomScmUrl)
                    }
                }
            }
        }
    }

    signing {
        sign(publishing.publications)
    }
}
