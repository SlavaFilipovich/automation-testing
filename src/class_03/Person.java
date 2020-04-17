package class_03;

public abstract class Person extends Human{
    private String name;
    private String surName;

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
