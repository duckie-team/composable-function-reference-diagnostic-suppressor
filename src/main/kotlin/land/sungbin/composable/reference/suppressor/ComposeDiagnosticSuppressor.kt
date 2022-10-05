/*
 * Developed by 2022 SungbinLand, Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/composable-function-reference-diagnostic-suppressor/blob/main/LICENSE
 */

@file:Suppress("DEPRECATION")

package land.sungbin.composable.reference.suppressor

import androidx.compose.compiler.plugins.kotlin.ComposeErrors
import org.jetbrains.kotlin.com.intellij.openapi.extensions.Extensions
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.diagnostics.Diagnostic
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.diagnostics.DiagnosticSuppressor

open class ComposeDiagnosticSuppressor : DiagnosticSuppressor {
    companion object {
        fun registerExtension(
            project: Project,
            extension: DiagnosticSuppressor,
        ) {
            Extensions
                .getRootArea()
                .getExtensionPoint(DiagnosticSuppressor.EP_NAME)
                .registerExtension(extension, project)
        }
    }

    override fun isSuppressed(
        diagnostic: Diagnostic,
    ) = isSuppressed(
        diagnostic = diagnostic,
        bindingContext = null,
    )

    // COMPOSABLE_FUNCTION_REFERENCE 타입의 diagnostic 은 항상 무시합니다.
    //
    // COMPOSABLE_FUNCTION_REFERENCE 타입의 diagnostic 이 발생하기 위한 조건이 이미
    // 보장되므로 추가적으로 해당 diagnostic 의 발생 환경을 검사할 필요가 없습니다.
    override fun isSuppressed(
        diagnostic: Diagnostic,
        bindingContext: BindingContext?,
    ) = diagnostic.factory == ComposeErrors.COMPOSABLE_FUNCTION_REFERENCE
}