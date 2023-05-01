package com.capedbaldy.thecircuitsimulator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProjectManager {
    private final ArrayList<Project> projects;

    public ProjectManager() {
        projects = new ArrayList<>();
    }

    public void createProject(String name) {
        projects.add(new Project(name));
    }

    public boolean doesProjectExist(String name) {
        return projects.stream().anyMatch(project -> project.getName().equals(name));
    }

    public ArrayList<String> getProjectNames() {
        return (ArrayList<String>) projects.stream().map(Project::getName).collect(Collectors.toList());
    }
}
