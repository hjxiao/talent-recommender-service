package User.Implementation;

import Business.Company;
import Business.Project;
import User.User;

import java.util.ArrayList;
import java.util.HashMap;

public class RegularUser extends User{

    public RegularUser(String nm, int id, Company c) {
        this.name = nm;
        this.employeeID = id;
        this.c = c;

        this.workingProjects = new ArrayList<Project>();
        this.feedback = new HashMap<Project, String>();
    }
}
