package ChickenFarm;

import java.util.*;
import java.util.List;
import java.util.Random;

public class Chicken {

    public static class Eggs {
        private int age;

        private int count;

        Eggs(int age, int count) {
            this.age = age;
            this.count = count;
        }

        public int getAge() {
            return age;
        }
    }

    private int age;

    private String name;

    public List<Eggs> eggs;

    public int getAge() {
        return age;
    }

    public void setAge() {
        ++this.age;
    }

    public String getName() {
        return name;
    }

    public Chicken(String name, int age) {
        this.name = name;
        this.age = age;
        this.eggs = new ArrayList<>();
    }

    public void lays(int age, int eggs) {
        this.eggs.add(new Eggs(age, eggs));
    }

    public static int eggsPerWeek() {
        Random randomGenerator = new Random();
        int eggsPerWeek = randomGenerator.nextInt(3);
        if ( eggsPerWeek == 2 ) eggsPerWeek = 3;

        return eggsPerWeek;
    }

    public static void eggToChicken(Chicken chick, List<Chicken> newChicks) {
        for ( int i = 0; i < chick.eggs.get(0).count; i++ ) {
            newChicks.add(new Chicken(Integer.toHexString(chick.eggs.get(i).hashCode() + i), 0));
        }
        chick.eggs.remove(0);
    }

}
