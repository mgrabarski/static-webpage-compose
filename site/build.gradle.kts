import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "org.example.empty"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("My own description of the first landing page that I created")

            head.add {
                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("empty")

    @Suppress("UNUSED_VARIABLE") // Suppress spurious warnings about sourceset variables not being used
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                // implementation(libs.kobwebx.markdown)
             }
        }
        // val jvmMain by getting {
        //     dependencies {
        //         implementation(libs.kobweb.api)
        //      }
        // }
    }
}