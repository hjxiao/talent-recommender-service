package Business;

import RecommenderSystem.RecommenderStrategy;
import User.*;
import User.Implementation.PrivilegedUser;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Project {
    private PrivilegedUser projectOwner;
    private HashSet<Skill> requiredSkills;
    private HashSet<Skill> optionalSkills;
    private int duration;
    private Boolean isComplete;

    public Project() {
        // stub
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
