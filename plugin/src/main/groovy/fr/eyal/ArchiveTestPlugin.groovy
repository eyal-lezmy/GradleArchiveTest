package main.groovy.fr.eyal

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class ArchiveTestPlugin implements Plugin<Project> {

    static final String PLUGIN_GROUP = "ArchiveTest"
    static final String TASK_NAME = "archivetest"
    static final String EXTENSION = "archivetest"

    void apply(Project project) {

        project.extensions.create(EXTENSION, ArchiveTestPluginExtension, project)

        project.task(TASK_NAME, type: ArchiveTask) {
            description 'Copy all your tests reports files to another destination, following your parameters'
            group PLUGIN_GROUP
        }

        project.afterEvaluate {
            Task t = project.tasks.getByName(project[EXTENSION].task)
            t.finalizedBy TASK_NAME
            print "INSERTION TASK " + t.name
        }
    }
}