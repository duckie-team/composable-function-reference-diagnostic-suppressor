/*
 * Developed by 2022 SungbinLand, Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/composable-function-reference-diagnostic-suppressor/blob/main/LICENSE
 */

package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.maven

class ComposableReferenceSuppressorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            repositories.maven(uri("https://maven.pkg.jetbrains.space/public/p/compose/dev"))
            dependencies {
                add(
                    org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME,
                    "land.sungbin:composable.reference.suppressor.plugin:${Versions.ComposableReferenceSuppressor}"
                )
            }
        }
    }
}
