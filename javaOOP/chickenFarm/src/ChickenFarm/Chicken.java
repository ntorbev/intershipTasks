package ChickenFarm;

import java.util.*;
import java.util.List;
import java.util.Random;

public class Chicken {

    public static class Eggs {
        public int age;
        private int count;

        public Eggs(int age, int count) {
            this.age = age;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

    }

    private String name;
    public List<Eggs> eggs;

    public int getAge() {
        return age;
    }

    public void setAge() {
        ++this.age;
    }

    private int age;

    public Chicken(String name, int age) {
        this.name = name;
        this.age = age;
        this.eggs = new ArrayList<Eggs>();
    }

    public void lays(int age, int eggs) {
        this.eggs.add(new Eggs(age, eggs));
    }

    public static int eggsPerWeek() {
        Random randomGenerator = new Random();
        int eggsPerWeek = randomGenerator.nextInt(3);
        if (eggsPerWeek == 2) eggsPerWeek = 3;

        return eggsPerWeek;

    }

    public static void eggChicken(Chicken chick, List<Chicken> newChicks) {
//        newChicks.add(chick.eggs.get(0));
        chick.eggs.remove(0);
    }

}
