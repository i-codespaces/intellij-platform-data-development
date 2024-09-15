package com.github.gwdgithubnom.intellijplatformdatadevelopment.settings

import com.intellij.openapi.observable.properties.GraphProperty

interface FoldableProjectState {

    val foldingEnabled: Boolean
    val foldDirectories: Boolean
    val foldIgnoredFiles: Boolean
    val hideEmptyGroups: Boolean
    val hideAllGroups: Boolean
    val caseInsensitive: Boolean
    val patterns: String?

    companion object {
        fun fromGraphProperties(
            foldingEnabledProperty: GraphProperty<Boolean>,
            foldDirectoriesProperty: GraphProperty<Boolean>,
            foldIgnoredFilesProperty: GraphProperty<Boolean>,
            hideEmptyGroupsProperty: GraphProperty<Boolean>,
            hideAllGroupsProperty: GraphProperty<Boolean>,
            caseInsensitiveProperty: GraphProperty<Boolean>,
            patternsProperty: GraphProperty<String>,
        ) = object : FoldableProjectState {
            override val foldingEnabled: Boolean get() = foldingEnabledProperty.get()
            override val foldDirectories: Boolean get() = foldDirectoriesProperty.get()
            override val foldIgnoredFiles: Boolean get() = foldIgnoredFilesProperty.get()
            override val hideEmptyGroups: Boolean get() = hideEmptyGroupsProperty.get()
            override val hideAllGroups: Boolean get() = hideAllGroupsProperty.get()
            override val caseInsensitive: Boolean get() = caseInsensitiveProperty.get()
            override val patterns: String get() = patternsProperty.get()
        }
    }
}
