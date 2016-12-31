package animals;

public class Cat extends Animals {
    private String noise = "meow";

    public Cat(int age, String name, String gender) {
        super(age, name, gender);
    }

    public void say() {
        System.out.println(this.noise);
    }
}

