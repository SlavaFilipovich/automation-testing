package class_03;

abstract class Human {
    private int age;

    void speak(){
        System.out.println("I'm a human, I can speak");
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

}
