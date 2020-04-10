package class_03;

public abstract class Person extends Human{
    private String name;
    private String surName;

    String getSurName() {
        return surName;
    }

    String getName() {
        return name;
    }

    protected void setSurName(String surName) {
        this.surName = surName;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
