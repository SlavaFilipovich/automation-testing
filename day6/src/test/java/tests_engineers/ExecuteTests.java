package tests_engineers;

import entity.ATest;
import entity.ManualATest;
import entity.Result;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

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
                {new TestEngineer(), 1, new ManualATest(TestLevel.UNIT, 10), PASSED},
                {new TestEngineer(), 10, new ManualATest(TestLevel.UNIT, 5), PASSED},
                {new TestEngineer(), 1, new ManualATest(TestLevel.API, 10), PASSED},
                {new TestEngineer(), 10, new ManualATest(TestLevel.API, 9), PASSED},
                {new TestEngineer(), 1, new ManualATest(TestLevel.GUI, 9), PASSED},
                {new TestEngineer(), 10, new ManualATest(TestLevel.GUI, 9), PASSED},
        });
    }

    @Test
    public void executeAllTests() {
        engineer.setSkill(skill);
        Assert.assertEquals(String.format(MSG, test.getClass().getSimpleName(), test.getComplexity(),
                test.getInstability(), engineer.getAnxiety(), engineer.getSkill()), expected, engineer.executeTest(test));
    }
}