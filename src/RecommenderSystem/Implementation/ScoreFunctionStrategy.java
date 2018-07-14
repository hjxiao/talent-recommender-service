package RecommenderSystem.Implementation;

import Business.Project;
import User.*;
import DataModel.SkillType;
import RecommenderSystem.RecommenderStrategy;

import java.util.HashMap;

public class ScoreFunctionStrategy implements RecommenderStrategy{
    private HashMap<SkillType, Integer> skillValues;
    private int requiredSkillModifier;
    private int optionalSkillModifier;
    private int experienceModifier;

    public int analyzeMatch(Project p, User u) {
        // stub
        return 0;
    }

    private int calculateScore() {
        // stub
        return 0;
    }
}
