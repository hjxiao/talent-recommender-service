package User;

import Business.Project;

import java.util.ArrayList;

public abstract class User {
    protected String name;
    protected int employeeID;
    protected ArrayList<Skill> skills;
    protected ArrayList<Skill> interests;

    protected ArrayList<Project> workingProjects;

    /*
    Purpose: Upon application, the user will be added to the project's pending applicant's list.
    Params:
        - p : Project - The project that this user wishes to apply to work on
    Returns:
        - a boolean indicating whether the application was received successfully. Successful
        receipt indicates the user has met all mandatory skill requirements.
    Throws: -
     */
    public boolean apply(Project p) {
        return p.acceptApplicant(this);
    }

    public boolean possessSkill(Skill s) {
        return this.skills.contains(s);
    }

    public void addSkills(ArrayList<Skill> ss) {
        for (Skill s : ss) {
            addSkill(s);
        }
    }

    public void addSkill(Skill s) {
        if (!this.skills.contains(s)) {
            this.skills.add(s);
        }
    }

    public void addInterests(ArrayList<Skill> ss) {
        for (Skill s : ss) {
            addInterest(s);
        }
    }

    public void addInterest(Skill s) {
        if (!this.interests.contains(s)) {
            this.interests.add(s);
        }
    }
}
