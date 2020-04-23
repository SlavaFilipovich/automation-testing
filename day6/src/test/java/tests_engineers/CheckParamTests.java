package tests_engineers;


import entity.AutomatedATest;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.TestEngineer;

public class CheckParamTests {
    public static final String MSG = "Test: %s; Level: %s; Instability: %d; Anxiety: %d; Skill: %d";
    TestEngineer engineer = new TestEngineer();

    @Test
    public void testEngineerSkills(){
        Assert.assertEquals("Value of Skill is not correct: ",
                (engineer.getSkill()>1 && engineer.getSkill()<11), engineer.getSkill()<11);
    }


    @Test
    public void testEngineerComplexity(){
        AutomatedATest testGui = new AutomatedATest(TestLevel.GUI,4);
        Assert.assertEquals("Value of Complexity is not correct: ",
                9, testGui.getComplexity());
    }

}
