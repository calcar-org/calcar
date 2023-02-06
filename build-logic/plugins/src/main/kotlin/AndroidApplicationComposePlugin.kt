import com.android.build.api.dsl.ApplicationExtension
import com.calcar.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            val extension = extensions.getByType<ApplicationExtension>()
            extension.apply {
                configureKotlinAndroid(this)

                defaultConfig.targetSdk = 33

                // configureFlavors(this)
            }
        }
    }
}