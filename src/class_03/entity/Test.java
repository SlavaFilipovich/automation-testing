package class_03.entity;

import class_03.Function;
import class_03.worker.Engineer;

public abstract class Test implements Function<Engineer, Result> {
    protected int complexity;
    protected int instability;

    public Test(TestLevel testLevel) {
        this.complexity = testLevel.COMPLEXITY;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        return this.apply(engineer);
    }
}
