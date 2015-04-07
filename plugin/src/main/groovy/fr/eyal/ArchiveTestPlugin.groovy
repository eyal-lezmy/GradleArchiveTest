package main.groovy.fr.eyal

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

class ArchiveTestPlugin implements Plugin<Project> {

    static final String EXTENSION = "archivetest"

    void apply(Project project) {

        def instantiator = project.gradle.services.get(Instantiator)

        def reportCalls = project.container(ReportCall, new ReportCallFactory(instantiator, project))
        project.extensions.create(EXTENSION, ArchiveTestPluginExtension, project, reportCalls)

        project.afterEvaluate {
            project[EXTENSION].injectTasks()
        }
    }
}