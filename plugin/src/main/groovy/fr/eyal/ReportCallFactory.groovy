package main.groovy.fr.eyal

import org.gradle.api.NamedDomainObjectFactory
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

class ReportCallFactory implements NamedDomainObjectFactory<ReportCall> {

    final Instantiator instantiator
    final Project project

    public ReportCallFactory(Instantiator instantiator, Project project) {
        this.instantiator = instantiator
        this.project = project
    }

    @Override
    ReportCall create(String name) {
        return instantiator.newInstance(ReportCall.class, name, project)
    }
}
