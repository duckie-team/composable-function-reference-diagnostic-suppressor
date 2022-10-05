/*
 * Developed by 2022 SungbinLand, Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/composable-function-reference-diagnostic-suppressor/blob/main/LICENSE
 */

@file:Suppress(
    "unused",
    "OVERRIDE_DEPRECATION",
)

package land.sungbin.composable.reference.suppressor

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(CommandLineProcessor::class)
class ComposableReferenceSuppressorProcessor : CommandLineProcessor {
    override val pluginId = "land.sungbin.composable.reference.suppressor"

    override val pluginOptions = emptyList<CliOption>()

    override fun processOption(
        option: CliOption,
        value: String,
        configuration: CompilerConfiguration,
    ) {
        // Do nothing
    }
}