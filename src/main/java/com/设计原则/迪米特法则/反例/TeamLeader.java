package com.设计原则.迪米特法则.反例;

import java.util.List;

public class TeamLeader {
    public void checkNumberOfProject(List<Project> projectList){
        System.out.println("项目数量是: "+projectList.size());
    }
}

