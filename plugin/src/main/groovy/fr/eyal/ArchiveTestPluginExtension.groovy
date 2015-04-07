package main.groovy.fr.eyal

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.Task

import static java.lang.System.currentTimeMillis

class ArchiveTestPluginExtension {

    final static String DEFAULT_TASK = "test"
    protected static final String TASK_NAME = "archivetest"
    protected static final String PLUGIN_GROUP = "ArchiveTest"

    private final NamedDomainObjectContainer<ReportCall> reportCalls

    final Project project
    def from
    def into

    ArchiveTestPluginExtension(Project project, reportCalls) {
        this.project = project
        this.reportCalls = reportCalls

        from = project.reportsDir
        into = "${project.projectDir}/reports/report-${currentTimeMillis()}"
    }

    def reports(Closure closure) {
        reportCalls.configure(closure)
    }

    def injectTasks() {
        if (reportCalls?.empty) {

            project.task(TASK_NAME, type: ArchiveTask) {
                description 'Copy all your tests reports files to another destination, following your parameters'
                group PLUGIN_GROUP
                from project.archivetest.from
                into project.archivetest.into
            }

            Task t = project.tasks.getByName(DEFAULT_TASK)
            t.finalizedBy TASK_NAME
        }

        reportCalls.each {
            Task t = project.tasks.getByName(it.name)

            //we create and initialize the task
            Task copyTask = project.tasks.create("achivetest-" + t.name, ArchiveTask)
            copyTask.from it.from
            copyTask.into it.into

            t.finalizedBy copyTask

            println "INSERTION TASK " + copyTask.name + " INTO " + t.name
        }
    }
}
