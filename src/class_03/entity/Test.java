package class_03.entity;

import class_03.Function;
import class_03.worker.AutomationEngineer;
import class_03.worker.Engineer;
import class_03.worker.TestEngineer;

public abstract class Test implements Function<Engineer, Result> {
    protected int complexity;
    protected int instability;

    public Test(TestLevel testLevel, int instability) {
        this.complexity = testLevel.COMPLEXITY;
        if(instability==0)
            this.instability = 1;
        else if(instability>10)
            this.instability = 10;
        else
        this.instability = instability;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        if ((engineer instanceof AutomationEngineer && this instanceof ManualTest) ||
                (engineer instanceof TestEngineer && this instanceof AutomatedTest)){
            anxiety = engineer.getAnxiety();
        } else
            anxiety = 1;
        int result = anxiety * instability * complexity/engineer.getSkill();
        if (result > 30)
            return Result.FAILED;
        else
            return Result.PASSED;
    }
}
