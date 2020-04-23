package tests_engineers;
import entity.AutomatedATest;
import entity.ManualATest;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.AutomationEngineer;

import static entity.Result.PASSED;
import static entity.Result.FAILED;


/*
We will do the different tests to cover all the possible situations.
We have 4 changeable parameters: complexity (level of Test 1, 3 or 9),
instability (from 1 to 10), anxiety (1 or 3 depending on type of Test) and skill (random in a range from 1 to 10).
We can set following combinations of parameters to do the tests:

 */
public class AutomationEngineerTests {
    public static final String MSG = "Test: %s; Level: %s; Instability: %d; Anxiety: %d; Skill: %d";
    AutomationEngineer engineer = new AutomationEngineer();

    @Test
    public void testEngineerSkills(){
        Assert.assertEquals("Value of Skill is not correct: ",
                (engineer.getSkill()>1 && engineer.getSkill()<11), engineer.getSkill()<11);
    }

    @Test
    public void testEngineerAnxietyVer1(){
        AutomatedATest testUnit = new AutomatedATest(TestLevel.UNIT,10);
        testUnit.apply(engineer);
        Assert.assertEquals("Value of Anxiety is not correct: ",
                1, engineer.getAnxiety());
    }

    @Test
    public void testEngineerAnxietyVer2(){
        ManualATest testUnit = new ManualATest(TestLevel.API,1);
        testUnit.apply(engineer);
        Assert.assertEquals("Value of Anxiety is not correct: ",
                3, engineer.getAnxiety());
    }

    @Test
    public void testEngineerComplexity(){
        AutomatedATest testGui = new AutomatedATest(TestLevel.GUI,10);
        Assert.assertEquals("Value of Complexity is not correct: ",
                9, testGui.getComplexity());
    }

    //UNIT Version #1 Passed: automatedTest, UNIT(1), instability <= 10, anxiety 1, skill >= 1;
    @Test
    public void autoTestUnitVersion1(){
        AutomatedATest test = new AutomatedATest(TestLevel.UNIT,10);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //API Version #1 Passed: automatedTest, API(3), instability <= 10, anxiety 1, skill >= 1;
    @Test
    public void autoTestApiVersion1(){
        AutomatedATest test = new AutomatedATest(TestLevel.API,10);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //GUI Version #1 Passed: automatedTest, GUI(9), instability <= 3, anxiety 1, skill >= 1;
    @Test
    public void autoTestGuiVersion1(){
        AutomatedATest test = new AutomatedATest(TestLevel.GUI,3);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //GUI Version #2 Failed: automatedTest, GUI(9), instability >= 7, anxiety 1, skill <= 2;
    @Test
    public void autoTestGuiVersion2(){
        AutomatedATest test = new AutomatedATest(TestLevel.GUI,7);
        engineer.setSkill(2);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), FAILED, engineer.executeTest(test));
    }

    //GUI Version #3 Passed: automatedTest, GUI(9), instability <= 10, anxiety 1, skill >= 3;
    @Test
    public void autoTestGuiVersion3(){
        AutomatedATest test = new AutomatedATest(TestLevel.GUI,10);
        engineer.setSkill(3);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //UNIT Version #1 Passed: manualTest, UNIT(1), instability <= 10, anxiety 3, skill >= 1;
    @Test
    public void manualTestUnitVersion1(){
        ManualATest test = new ManualATest(TestLevel.UNIT,10);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //API Version #1 Passed: manualTest, API(3), instability <= 10, anxiety 3, skill >= 3;
    @Test
    public void manualTestApiVersion1(){
        ManualATest test = new ManualATest(TestLevel.API,10);
        engineer.setSkill(3);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //API Version #2 Failed: manualTest, API(3), instability 10, anxiety 3, skill < 3;
    @Test
    public void manualTestApiVersion2(){
        ManualATest test = new ManualATest(TestLevel.API,10);
        engineer.setSkill(2);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), FAILED, engineer.executeTest(test));
    }

    //GUI Version #1 Passed: manualTest, GUI(9), instability <= 10, anxiety 3, skill >= 9;
    @Test
    public void manualTestGuiVersion1(){
        ManualATest test = new ManualATest(TestLevel.GUI,10);
        engineer.setSkill(9);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //GUI Version #2 Failed: manualTest, GUI(9), instability = 10, anxiety 3, skill <= 8;
    @Test
    public void manualTestGuiVersion2(){
        ManualATest test = new ManualATest(TestLevel.GUI,10);
        engineer.setSkill(8);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), FAILED, engineer.executeTest(test));
    }

    //GUI Version #3 Passed: manualTest, GUI(9), instability <= 5, anxiety 3, skill >= 5;
    @Test
    public void manualTestGuiVersion3(){
        ManualATest test = new ManualATest(TestLevel.GUI,5);
        engineer.setSkill(5);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

}
