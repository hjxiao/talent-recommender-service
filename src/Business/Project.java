package Business;

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
    private int duration;
    private Boolean isComplete;

    public Project() {
        // stub
    }

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

    public PriorityQueue<Pair<User, Integer>> reviewApplicants(RecommenderStrategy rs) {
        // stub
        return null;
    }

    public int reviewApplicant(RecommenderStrategy rs) {
        // stub
        return 0;
    }
}
