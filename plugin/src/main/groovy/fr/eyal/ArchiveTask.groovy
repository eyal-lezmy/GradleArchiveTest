package main.groovy.fr.eyal

import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskAction

class ArchiveTask extends Copy {

    ArchiveTask() {
    }

    @TaskAction
    def exec() {
        println "Reports copied into " + project.archivetest.into
    }
}
