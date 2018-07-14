package User;

import Business.Project;

public abstract class User {
    private String name;
    private int employeeID;

    public abstract void apply(Project p);
}
