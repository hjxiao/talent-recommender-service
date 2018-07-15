package User;

import Business.Company;
import Business.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class User {
    protected String name;
    protected int employeeID;
    protected ArrayList<Skill> skills;
    protected ArrayList<Skill> interests;
    protected Company c;

    protected ArrayList<Project> workingProjects;
    protected HashMap<Project, String> feedback;

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

    /*
    Purpose: Adds a project to the user's portfolio. The user should not be able to invoke this
    function as it is done through the Project class.
    Params:
        - p : Project - The project that this user wishes to apply to work on
    Returns:
        - a boolean indicating whether the application was received successfully. Successful
        receipt indicates the user has met all mandatory skill requirements.
    Throws: -
     */
    public void acceptProject(Project p) {
        if (!workingProjects.contains(p)) {
            workingProjects.add(p);
        }
    }

    /*
    Purpose: Adds a project to the user's portfolio. The user should not be able to invoke this
    function as it is done through the Project class.
    Params:
        - p : Project - The project that this user wishes to apply to work on
    Returns:
        - a boolean indicating whether the application was received successfully. Successful
        receipt indicates the user has met all mandatory skill requirements.
    Throws: -
     */
    public void receiveEndorsement(HashSet<Skill> skl) {
        for (Skill s : skl) {
            if (interests.contains(s)) {
                interests.remove(s);
                s.receiveEndorsement();
                skills.add(s);
            } else if (skills.contains(s)) {
                int pos = indexOf(skills, s);
                if (pos != -1) {
                    skills.get(pos).receiveEndorsement();
                }
            }
        }
    }

    // HELPERS

    /*
    Purpose: Returns index of item in list
    Params:
        - ss : ArrayList<Skill> - The list to search
        - s : Skill - The item to search the index of in list
    Returns:
        - integer position of item in list or -1 if item is not found
    Throws: -
     */
    public int indexOf(ArrayList<Skill> ss, Skill s) {
        int pos = 0;
        for (Skill skl : ss) {
            if (skl.equals(s)) {
                return pos;
            }
            pos++;
        }

        return -1;
    }

    // GETTERS & SETTERS

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

    public void addFeedback(Project p, String feedback) {
        this.feedback.put(p, feedback);
    }

    public Company getCompany() { return c; }
    public void setCompany(Company c) { this.c = c; }
}
