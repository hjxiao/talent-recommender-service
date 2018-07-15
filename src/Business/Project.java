package Business;

import DataModel.ApplicantComparator;
import RecommenderSystem.RecommenderStrategy;
import User.*;
import User.Implementation.PrivilegedUser;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Project {
    private ArrayList<User> pendingApplicants;
    private ArrayList<User> projectMembers;
    private PrivilegedUser projectOwner;

    private HashSet<Skill> requiredSkills;
    private HashSet<Skill> optionalSkills;
    private int duration = 0;
    private int teamSize = 0;
    private Boolean isComplete = false;

    private RecommenderStrategy rs;

    public Project(RecommenderStrategy rs) {
        this.rs = rs;
    }

    public void setDuration(int i) { this.duration = i; }
    public int getDuration() { return this.duration; }

    public void setTeamSize(int i) { this.teamSize = i; }
    public int getTeamSize() { return this.teamSize; }

    public void setisComplete(boolean b) { this.isComplete = b; }
    public boolean getIsComplete() { return this.isComplete; }

    public void addRequiredSkill(Skill s) { requiredSkills.add(s); }
    public void addOptionalSkill(Skill s) { optionalSkills.add(s); }

    /*
    Purpose: Upon application, the user will be added to the project's pending applicant's list.
    Params:
        - p : Project - The project that this user wishes to apply to work on
    Returns:
        - a boolean indicating whether the application was received successfully. Successful
        receipt indicates the user has met all mandatory skill requirements.
    Throws: -
     */
    public boolean acceptApplicant(User u) {
        for (Skill s : requiredSkills) {
            if (!u.possessSkill(s)) {
                return false;
            }
        }
        pendingApplicants.add(u);
        return true;
    }

    /*
    Purpose: Installs user "u" as project owner if no current owner exists
    Params:
        - u : PrivilegedUser - User who wishes to supervise project
    Returns:
        - a boolean indicating whether ownership of project was conferred to user
    Throws: -
     */
    public boolean registerOwner(PrivilegedUser u) {
        if (this.projectOwner != null) {
            this.projectOwner = u;
            return true;
        }

        return false;
    }

    /*
    Purpose: Installs user "u" as new project member
    Params:
        - u : User - User who wishes to work on project
    Returns:
        - a boolean indicating whether membership in project was conferred
    Throws: -
     */
    public boolean registerMember(User u) {
        if (!this.projectMembers.contains(u)) {
            this.projectMembers.add(u);
            return true;
        }

        return false;
    }

    /*
    Purpose: Installs user "u" as project owner if no current owner exists
    Params:
        - u : PrivilegedUser - User who wishes to supervise project
    Returns:
        - a boolean indicating whether ownership of project was conferred to user
    Throws: -
     */
    public PriorityQueue<Pair<User, Integer>> reviewApplicants() {
        PriorityQueue<Pair<User, Integer>> ret =
                new PriorityQueue<Pair<User, Integer>>(this.teamSize, new ApplicantComparator());

        for (User u : pendingApplicants) {
            int matchScore = reviewApplicant(this, u);
            Pair<User, Integer> p = new Pair<User, Integer>(u, matchScore);
            ret.add(p);
        }
        return ret;
    }

    /*
    Purpose: Installs user "u" as project owner if no current owner exists
    Params: -
    Returns:
        - an integer match score between 0 to 10 indicating applicant strength
    Throws: -
     */
    public int reviewApplicant(Project p, User u) {
        return rs.analyzeMatch(p, u);
    }
}
