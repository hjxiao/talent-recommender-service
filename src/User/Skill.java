package User;

import DataModel.SkillType;

public class Skill {
    private String name;
    private SkillType type;
    private int years;
    private int endorsements = 0;

    public Skill(String nm, SkillType t, int yrs) {
        this.name = nm;
        this.type = t;
        this.years = yrs;
    }

    public void reeiveEndorsement() {
        endorsements++;
    }
}
