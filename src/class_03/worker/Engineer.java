package class_03.worker;

import class_03.Person;
import class_03.entity.Result;
import class_03.entity.Test;

public abstract class Engineer extends Person {
    private int skill = (int) (Math.random() * 10 + 1);
    private int anxiety = 3;

    public int getAnxiety() {
        return anxiety;
    }

    public Result executeTest(Test test) {
        return this.executeTest(test);
    }

    public int getSkill() {
        return skill;
    }
}
