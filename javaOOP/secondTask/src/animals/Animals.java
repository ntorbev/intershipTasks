package animals;

public abstract class Animals {
    public int age;
    public String name;
    public String gender;

    public Animals(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public abstract void say();
}
