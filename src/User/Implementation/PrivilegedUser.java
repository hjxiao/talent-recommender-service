package User.Implementation;

import Business.Company;
import Business.Project;
import User.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class PrivilegedUser extends User {
    private ArrayList<Project> managingProjects;

    public PrivilegedUser(String nm, int id, Company c) {
        this.name = nm;
        this.employeeID = id;
        this.c = c;

        this.workingProjects = new ArrayList<Project>();
        this.feedback = new HashMap<Project, String>();
    }

    /*
    Purpose: The privileged owner will be added as project owner if project does not have
    a current owner
    Params:
        - p : Project - The project that this user wishes to own
    Returns:
        - a boolean indicating whether the user was successfully installed as sole project
        owner
    Throws: -
     */
    public boolean supervise(Project p) {
        if (p.registerOwner(this)) {
            return false;
        }

        this.managingProjects.add(p);
        return true;
    }

    public void rateProjectMember(Project p, Pair<User, Integer> rating) {
        c.addRating(p, rating);
    }

    public void endorseProjectSkills(Project p, User u) {
        p.endorse(u);
    }

    public void provideFeedback(Project p, User u, String feedback) {
        u.addFeedback(p, feedback);
    }
}
