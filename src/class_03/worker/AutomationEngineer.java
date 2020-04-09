package class_03.worker;

import class_03.entity.Result;
import class_03.entity.Test;

public class AutomationEngineer extends Engineer {

    @Override
    public Result executeTest(Test test) {
        return test.apply(this);
    }

}
