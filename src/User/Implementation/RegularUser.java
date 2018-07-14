package User.Implementation;

import Business.Project;
import User.User;

public class RegularUser extends User{

    public RegularUser(String nm, int id) {
        this.name = nm;
        this.employeeID = id;
    }
}
