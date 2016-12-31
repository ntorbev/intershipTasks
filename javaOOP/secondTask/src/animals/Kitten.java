package animals;

public class Kitten extends Cat {
    private String noise = "mew";

    public Kitten(int age, String name, String gender) {
        super(age, name, gender);
    }

    public void say() {
        System.out.println(this.noise);
    }
}