package worker;

import entity.ATest;
import entity.Result;

public class TestEngineer extends Engineer {

    @Override
    public Result executeTest(ATest ATest) {
        return ATest.apply(this);
    }
}
