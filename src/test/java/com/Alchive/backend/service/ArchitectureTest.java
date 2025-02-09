package com.Alchive.backend.service;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.Alchive.backend")
public class ArchitectureTest {
    @ArchTest
    public static final ArchRule noClassess_in_domain_should_depends_on_adapter =
            noClasses()
            .that()
            .resideInAPackage("..model..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("..adapter..");

    @ArchTest
    public static final ArchRule classes_in_application_adapter_mapper_should_depends_on_model = classes()
            .that()
            .resideInAnyPackage("..application.service..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("..model..");
}