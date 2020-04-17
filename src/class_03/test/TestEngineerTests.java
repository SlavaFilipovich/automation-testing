package class_03.test;

import class_03.entity.AutomatedTest;
import class_03.entity.ManualTest;
import class_03.entity.TestLevel;
import class_03.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

import static class_03.entity.Result.FAILED;
import static class_03.entity.Result.PASSED;

public class TestEngineerTests {
    public static final String MSG = "Test: %s; Level: %s; Instability: %d; Anxiety: %d; Skill: %d";
    TestEngineer engineer = new TestEngineer();

    @Test
    public void testEngineerSkills(){
        Assert.assertEquals("Value of Skill is not correct: ",
                (engineer.getSkill()>1 && engineer.getSkill()<11), engineer.getSkill()<11);
    }

    @Test
    public void testEngineerAnxietyVer1(){
        AutomatedTest testUnit = new AutomatedTest(TestLevel.UNIT,10);
        testUnit.apply(engineer);
        Assert.assertEquals("Value of Anxiety is not correct: ",
                3, engineer.getAnxiety());
    }

    @Test
    public void testEngineerAnxietyVer2(){
        ManualTest testUnit = new ManualTest(TestLevel.API,1);
        testUnit.apply(engineer);
        Assert.assertEquals("Value of Anxiety is not correct: ",
                1, engineer.getAnxiety());
    }

    @Test
    public void testEngineerComplexity(){
        AutomatedTest testGui = new AutomatedTest(TestLevel.GUI,4);
        Assert.assertEquals("Value of Complexity is not correct: ",
                9, testGui.getComplexity());
    }

    //UNIT Version #1 Passed: manualTest, UNIT(1), instability <= 10, anxiety 1, skill >= 1;
    @Test
    public void manualTestUnitVersion1(){
        ManualTest test = new ManualTest(TestLevel.UNIT,10);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //API Version #1 Passed: manualTest, API(3), instability <= 10, anxiety 1, skill >= 1;
    @Test
    public void manualTestApiVersion1(){
        ManualTest test = new ManualTest(TestLevel.API,10);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //GUI Version #1 Passed: manualTest, GUI(9), instability <= 3, anxiety 1, skill >= 1;
    @Test
    public void manualTestGuiVersion1(){
        ManualTest test = new ManualTest(TestLevel.GUI,3);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //GUI Version #2 Failed: manualTest, GUI(9), instability >= 7, anxiety 1, skill <= 2;
    @Test
    public void manualTestGuiVersion2(){
        ManualTest test = new ManualTest(TestLevel.GUI,7);
        engineer.setSkill(2);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), FAILED, engineer.executeTest(test));
    }

    //GUI Version #3 Passed: manualTest, GUI(9), instability <= 10, anxiety 1, skill >= 3;
    @Test
    public void manualTestGuiVersion3(){
        ManualTest test = new ManualTest(TestLevel.GUI,10);
        engineer.setSkill(3);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //UNIT Version #1 Passed: autoTest, UNIT(1), instability <= 10, anxiety 3, skill >= 1;
    @Test
    public void autoTestUnitVersion1(){
        AutomatedTest test = new AutomatedTest(TestLevel.UNIT,10);
        engineer.setSkill(1);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //API Version #1 Passed: autoTest, API(3), instability <= 10, anxiety 3, skill >= 3;
    @Test
    public void autoTestApiVersion1(){
        AutomatedTest test = new AutomatedTest(TestLevel.API,10);
        engineer.setSkill(3);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //API Version #2 Failed: autoTest, API(3), instability 10, anxiety 3, skill < 3;
    @Test
    public void autoTestApiVersion2(){
        AutomatedTest test = new AutomatedTest(TestLevel.API,10);
        engineer.setSkill(2);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), FAILED, engineer.executeTest(test));
    }

    //GUI Version #1 Passed: autoTest, GUI(9), instability <= 10, anxiety 3, skill >= 9;
    @Test
    public void autoTestGuiVersion1(){
        AutomatedTest test = new AutomatedTest(TestLevel.GUI,10);
        engineer.setSkill(9);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }

    //GUI Version #2 Failed: autoTest, GUI(9), instability = 10, anxiety 3, skill <= 8;
    @Test
    public void autoTestGuiVersion2(){
        AutomatedTest test = new AutomatedTest(TestLevel.GUI,10);
        engineer.setSkill(8);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), FAILED, engineer.executeTest(test));
    }

    //GUI Version #3 Passed: autoTest, GUI(9), instability <= 5, anxiety 3, skill >= 5;
    @Test
    public void autoTestGuiVersion3(){
        AutomatedTest test = new AutomatedTest(TestLevel.GUI,5);
        engineer.setSkill(5);
        Assert.assertEquals(String.format(MSG,test.getClass().getSimpleName(),test.getComplexity(),
                test.getInstability(),engineer.getAnxiety(),engineer.getSkill()), PASSED, engineer.executeTest(test));
    }



}

