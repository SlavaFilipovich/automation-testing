package class_03.worker;

import class_03.entity.Result;
import class_03.entity.ATest;

public class TestEngineer extends Engineer {

    @Override
    public Result executeTest(ATest ATest) {
        return ATest.apply(this);
    }
}
