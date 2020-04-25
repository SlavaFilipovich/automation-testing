package worker;

import abstractPeople.Person;
import entity.ATest;
import entity.Result;


public abstract class Engineer extends Person {
    private int skill = (int) (Math.random() * 10) + 1;
    private int anxiety = 3;

    public Result executeTest(ATest ATest) {
        return this.executeTest(ATest);
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
