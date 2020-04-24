package tests_engineers;

import class_03.entity.AutomatedATest;
import class_03.entity.ManualATest;
import class_03.entity.TestLevel;
import class_03.worker.AutomationEngineer;
import class_03.worker.Engineer;
import class_03.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckEngParamATest {
    public static final String MSG = "Test: %s; Level: %s; Instability: %d; Anxiety: %d; Skill: %d";
    private Engineer engineer;

    public CheckEngParamATest(Engineer engineer){
        this.engineer = engineer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumber() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer()},
                {new AutomationEngineer()}
        });
    }

    @Test
    public void testEngineerAnxietyVer1(){
        AutomatedATest testUnit = new AutomatedATest(TestLevel.UNIT,10);
        testUnit.apply(engineer);
        Assert.assertEquals("Value of Anxiety is not correct: ",
                3, engineer.getAnxiety());
    }

    @Test
    public void testEngineerAnxietyVer2(){
        ManualATest testUnit = new ManualATest(TestLevel.API,1);
        testUnit.apply(engineer);
        Assert.assertEquals("Value of Anxiety is not correct: ",
                1, engineer.getAnxiety());
    }

    @Test
    public void testEngineerSkills(){
        Assert.assertEquals("Value of Skill is not correct: ",
                (engineer.getSkill()>1 && engineer.getSkill()<11), engineer.getSkill()<11);
    }

}
