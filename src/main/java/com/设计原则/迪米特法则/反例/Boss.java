package com.设计原则.迪米特法则.反例;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader){
        List<Project> list = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            list.add(new Project());
        }
        teamLeader.checkNumberOfProject(list);
    }
}
