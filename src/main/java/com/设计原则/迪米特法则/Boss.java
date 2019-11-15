package com.设计原则.迪米特法则;

public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader){
        teamLeader.checkNumberOfProject();
    }
}

