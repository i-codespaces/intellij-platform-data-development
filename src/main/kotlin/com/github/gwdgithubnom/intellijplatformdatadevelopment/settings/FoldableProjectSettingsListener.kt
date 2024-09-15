package com.github.gwdgithubnom.intellijplatformdatadevelopment.settings

import com.intellij.util.messages.Topic
import java.util.EventListener

@FunctionalInterface
interface FoldableProjectSettingsListener : EventListener {

    companion object {
        @Topic.ProjectLevel
        val TOPIC = Topic(FoldableProjectSettingsListener::class.java)
    }

    fun settingsChanged(settings: FoldableProjectSettings)
}
