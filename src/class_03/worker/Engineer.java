package class_03.worker;

import class_03.Person;
import class_03.entity.Result;
import class_03.entity.Test;

public abstract class Engineer extends Person {
    private int skill = (int) (Math.random() * 10) + 1;
    private int anxiety = 3;

    public Result executeTest(Test test) {
        return this.executeTest(test);
    }

    public int getAnxiety() {
        return anxiety;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }
}
