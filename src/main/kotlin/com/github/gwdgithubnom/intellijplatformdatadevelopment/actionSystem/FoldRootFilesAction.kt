package com.github.gwdgithubnom.intellijplatformdatadevelopment.actionSystem

import com.github.gwdgithubnom.intellijplatformdatadevelopment.settings.FoldableProjectSettings
import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.ToggleOptionAction
import com.intellij.openapi.components.service
import com.intellij.openapi.project.DumbAware
import java.util.function.Function

class FoldRootFilesAction : DumbAware, ToggleOptionAction(Function {
    object : Option {

        private val settings = it.project?.service<FoldableProjectSettings>()

        override fun isSelected() = settings?.foldingEnabled ?: false

        override fun setSelected(selected: Boolean) {
            val updated = selected != isSelected

            settings?.foldingEnabled = selected

            if (updated) {
                it.project?.let { project ->
                    val view = ProjectView.getInstance(project)
                    view.currentProjectViewPane?.updateFromRoot(true)
                }
            }
        }
    }
})
