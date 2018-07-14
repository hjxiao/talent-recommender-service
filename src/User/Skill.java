package User;

import DataModel.SkillType;

public class Skill {
    private String name;
    private SkillType type;
    private int years;

    public Skill(String nm, SkillType t, int yrs) {
        this.name = nm;
        this.type = t;
        this.years = yrs;
    }
}
