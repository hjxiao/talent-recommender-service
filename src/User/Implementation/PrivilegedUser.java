package User.Implementation;

import Business.Project;
import User.*;

import java.util.ArrayList;

public class PrivilegedUser extends User {
    private ArrayList<Project> managingProjects;

    public PrivilegedUser(String nm, int id) {
        this.name = nm;
        this.employeeID = id;
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
}
