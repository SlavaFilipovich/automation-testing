package tests_engineers;

import entity.ATest;
import entity.AutomatedATest;
import entity.ManualATest;
import entity.TestLevel;
import org.junit.runner.RunWith;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BaseEngineerTests {
    public static final String MSG = "Test: %s; Anxiety: %d; Skill: %d; ";

    private int skill;
    private Engineer engineer;
    private ATest test;
    private int expectedSkill;
    private int expectedAnx;


    public BaseEngineerTests(Engineer engineer, int skill, ATest test, int expectedSkill, int expectedAnx) {
        this.engineer = engineer;
        this.skill = skill;
        this.test = test;
        this.expectedSkill = expectedSkill;
        this.expectedAnx = expectedAnx;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumber() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), 1, new AutomatedATest(TestLevel.UNIT,10), 1,3},
                {new TestEngineer(), 10, new ManualATest(TestLevel.GUI,1), 10, 1},
                {new AutomationEngineer(), 10, new ManualATest(TestLevel.API,1), 10, 3},
                {new AutomationEngineer(), 10, new AutomatedATest(TestLevel.GUI,1), 10, 1}
        });
    }

    @Test
    public void testEngineerAnxiety(){
        test.apply(engineer);
        Assert.assertEquals(String.format(MSG, getClass().getSimpleName(), engineer.getAnxiety(), engineer.getSkill()),
                expectedAnx, engineer.getAnxiety());
    }

    @Test
    public void testEngineerSkill(){
        engineer.setSkill(skill);
        Assert.assertEquals(String.format(MSG, getClass().getSimpleName(),engineer.getAnxiety(), engineer.getSkill()),
                expectedSkill, engineer.getSkill());
    }

}