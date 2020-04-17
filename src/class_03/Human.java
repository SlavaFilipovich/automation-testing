package class_03;

abstract class Human {
    private int age;

    protected void speak(){
        System.out.println("I'm a human, I can speak");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
