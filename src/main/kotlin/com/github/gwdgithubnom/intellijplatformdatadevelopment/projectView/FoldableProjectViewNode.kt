package com.github.gwdgithubnom.intellijplatformdatadevelopment.projectView

import com.github.gwdgithubnom.intellijplatformdatadevelopment.MyBundle
import com.intellij.icons.AllIcons.General.CollapseComponent
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ProjectViewNode
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.SimpleTextAttributes

class FoldableProjectViewNode(
    project: Project,
    settings: ViewSettings?,
    private val children: Set<AbstractTreeNode<*>>,
) : ProjectViewNode<String>(project, MyBundle.message("foldableProjectView.name"), settings) {

    override fun update(presentation: PresentationData) {
        presentation.apply {
            val text = MyBundle.message("foldableProjectView.node", children.size)
            val toolTip = children.mapNotNull { it.name }.joinToString(", ")
            val textAttributes = SimpleTextAttributes.GRAY_SMALL_ATTRIBUTES
            addText(ColoredFragment(text, toolTip, textAttributes))
            setIcon(CollapseComponent)
        }
    }

    override fun getChildren() = children

    override fun contains(file: VirtualFile) = children.firstOrNull {
        it is ProjectViewNode && it.virtualFile == file
    } != null
}
