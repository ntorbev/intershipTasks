import animals.*;


public class Main {

    public static void main(String[] args) {
        /*Implement objects for a Dog, Frog, Cat, Kitten, Tomcat.
        All of them are Animals (inheritance). All animals have age, name, gender.
        Different animals produce different noises
        (virtual method of the Animal class, produceNoise(woof, ribbit, meaw, mew, grr)
        Create an array of at least 8 animals and write their name, gender and sound. Print them*/

        Animals[] allPack = new Animals[]{
                new Cat(45, "angry", "female"),
                new Dog(4, "sharo", "male"),
                new Frog(5, "yellow", "female"),
                new Kitten(4, "Kity", "female")
        };

        for (Animals member : allPack) {
            System.out.print(member.age);
            System.out.print(" " + member.name);
            System.out.print(" " + member.gender + " ");
            member.say();

        }
    }
}
