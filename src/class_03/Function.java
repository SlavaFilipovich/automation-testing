package class_03;

public interface Function<Engineer, Result> {

    default Result apply(Engineer engineer) {
        return null;
    }
}
