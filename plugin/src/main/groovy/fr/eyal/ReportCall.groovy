package main.groovy.fr.eyal

import org.gradle.api.Project

import static java.lang.System.currentTimeMillis

class ReportCall {

    String name
    def from
    def into

    ReportCall(String name, Project project) {
        this.name = name

        from = project.reportsDir
        into = "${project.projectDir}/reports/report-${currentTimeMillis()}"
    }
}
