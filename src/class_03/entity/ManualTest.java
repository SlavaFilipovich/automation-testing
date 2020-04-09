package class_03.entity;

import class_03.worker.AutomationEngineer;
import class_03.worker.Engineer;

public class ManualTest extends Test {

    public ManualTest(TestLevel testLevel, int instability) {
        super(testLevel);
        this.instability = instability;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        if (engineer instanceof AutomationEngineer) {
            anxiety = engineer.getAnxiety();
        } else
            anxiety = 1;
        int result = anxiety * instability * complexity;
        if (result > 30)
            return Result.FAILED;
        else
            return Result.PASSED;
    }
}
