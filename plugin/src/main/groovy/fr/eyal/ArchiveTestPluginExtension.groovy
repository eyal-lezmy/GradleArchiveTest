package main.groovy.fr.eyal

import org.gradle.api.Project

import static java.lang.System.currentTimeMillis

class ArchiveTestPluginExtension {

    final static String DEFAULT_TASK = "test"

    final Project project
    def from
    def into
    def task = DEFAULT_TASK

    ArchiveTestPluginExtension(Project project) {
        this.project = project
        from = project.reportsDir
        print "REPORT NAME " + project.reportsDir.toString()
        into = "${project.projectDir}/reports/report-${currentTimeMillis()}"
    }
}