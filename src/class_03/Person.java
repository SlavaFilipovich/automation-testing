package class_03;

abstract class Person extends Human{
    private String name;
    private String surName;

    String getSurName() {
        return surName;
    }

    String getName() {
        return name;
    }

    void setSurName(String surName) {
        this.surName = surName;
    }

    void setName(String name) {
        this.name = name;
    }
}
