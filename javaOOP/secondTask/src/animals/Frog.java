package animals;

public class Frog extends Animals {
    private String noise = "ribit";

    public Frog(int age, String name, String gender) {
        super(age, name, gender);
    }

    public void say() {
        System.out.println(this.noise);
    }
}

