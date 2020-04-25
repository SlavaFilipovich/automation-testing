package activity;

public interface Function<Engineer, Result> {

    default Result apply(Engineer engineer) {
        return null;
    }
}
