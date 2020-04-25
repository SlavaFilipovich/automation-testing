package tests_engineers;

import entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

import static entity.Result.FAILED;
import static entity.Result.PASSED;

@RunWith(Parameterized.class)
public class ExecuteTests {
    public static final String MSG = "Test: %s; Level: %s; Instability: %d; Anxiety: %d; Skill: %d";

    private Engineer engineer;
    private ATest test;
    private int skill;
    private Result expected;

    public ExecuteTests(Engineer en, int skill, ATest test, Result expected) {
        this.engineer = en;
        this.skill = skill;
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumber() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), 1, new AutomatedATest(TestLevel.UNIT, 1), PASSED},
                {new TestEngineer(), 10, new AutomatedATest(TestLevel.GUI, 10), PASSED},
                {new TestEngineer(), 1, new ManualATest(TestLevel.UNIT, 10), PASSED},
                {new TestEngineer(), 1, new AutomatedATest(TestLevel.API, 0), PASSED},
                {new TestEngineer(), 10, new ManualATest(TestLevel.GUI, 0), PASSED},
                {new TestEngineer(), 1, new AutomatedATest(TestLevel.API, 11), FAILED},
                {new TestEngineer(), 1, new ManualATest(TestLevel.GUI, 1), PASSED},
                {new TestEngineer(), 1, new ManualATest(TestLevel.API, 11), FAILED},

                {new AutomationEngineer(), 10, new ManualATest(TestLevel.API, 1), PASSED},
                {new AutomationEngineer(), 1, new ManualATest(TestLevel.GUI, 10), FAILED},
                {new AutomationEngineer(), 10, new AutomatedATest(TestLevel.API, 10), PASSED},
                {new AutomationEngineer(), 10, new ManualATest(TestLevel.UNIT, 11), PASSED},
                {new AutomationEngineer(), 1, new AutomatedATest(TestLevel.GUI, 11), FAILED},
                {new AutomationEngineer(), 1, new AutomatedATest(TestLevel.UNIT, 0), PASSED},
                {new AutomationEngineer(), 1, new ManualATest(TestLevel.UNIT, 0), PASSED},
                {new AutomationEngineer(), 10, new AutomatedATest(TestLevel.API, 1), PASSED},
        });
    }

    @Test
    public void executeAllTests() {
        engineer.setSkill(skill);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(), test.getComplexity(),
                test.getInstability(), engineer.getAnxiety(), engineer.getSkill()), expected, engineer.executeTest(test));
    }
}