package RecommenderSystem.Implementation;

import Business.Project;
import User.*;
import DataModel.SkillType;
import RecommenderSystem.RecommenderStrategy;

import java.util.HashMap;
import java.util.HashSet;

public class ScoreFunctionStrategy implements RecommenderStrategy{
    private HashMap<SkillType, Integer> skillValues;
    private int requiredSkillModifier;
    private int optionalSkillModifier;
    private int experienceModifier;

    public ScoreFunctionStrategy(int rsm, int osm, int em) {
        this.requiredSkillModifier = rsm;
        this.optionalSkillModifier = osm;
        this.experienceModifier = em;
    }

    public int analyzeMatch(Project p, User u) {
        int score = 0;
        HashSet<Skill> req = p.getRequiredSkill();
        HashSet<Skill> opt = p.getOptionalSkill();

        for (Skill s : req) {
            score += calculateScore(s, requiredSkillModifier);
        }
        for (Skill s : opt) {
            score += calculateScore(s, optionalSkillModifier);
        }

        return score;
    }

    private int calculateScore(Skill s, int mod) {
        if (skillValues.get(s) == null) {
            return 0;
        }

        return skillValues.get(s) * mod + experienceModifier;
    }

    public void addSkillValue(SkillType t, int val) {
        skillValues.put(t, val);
    }
}
