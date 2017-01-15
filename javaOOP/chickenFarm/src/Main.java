import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ListIterator;

import ChickenFarm.Chicken;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*  Write a program that implements the following functionality:
        In a barn there are 10 chickens. Each chicken lays 1-3 eggs per week. Depending on the week type we have more
        or less eggs. E.g. in a “normal” week each chicken lays 1 eggs, during a “bad” week a chicken produces 0 egg
        and during a “good” week – a chicken produces 3 eggs. After 2 weeks the eggs hatch and becomes a chicken.
        The new chicken’s name depends on the chicken instance’s number (each chicken is numbered depending on the
         current instance). Each chicken can lay eggs only if it is 2-4 (2, 3 or 4 weeks old). When the chicken
         becomes 6 weeks old – it dies.
        Read the initial information about the chickens from a file (.txt, .xml, .json, .xls – your choice).
        The file consist of each chicken’s number and its age. Then the program asks how many weeks do you wish to
        simulate and a console number input is expected. After the simulation, the final information of the chickens
        is displayed on the console in the format:
        Chicken1/
                Chicken1/Chicken3/
                Chicken1/Chicken5/Chicken6/
                Chicken1/Chicken5/Chicken9/
                Chicken1/Chicken7/
                Chicken2/Chicken4/
        …
        Each chicken and its children should be printed on the console. After you print the result, ask the user if he
        wants to save the information in a file. If so, save the information in human readable format
        (text based, xml, json).   */

        ArrayList<Chicken> liveChicks = new ArrayList() {{
            add(new Chicken("Chicken1", 1));
            add(new Chicken("Chicken2", 1));
        }};
        ArrayList<Chicken> newChicks = new ArrayList();

        System.out.print("Enter week duration of the chicken farm simulation: ");
        Scanner in = new Scanner(System.in);
        int weekDuration = in.nextInt(), eggsWeek;

        for ( int i = 0; i < weekDuration; i++ ) {
            eggsWeek = Chicken.eggsPerWeek();
            liveChicks.addAll(newChicks);
            newChicks.clear();
            Iterator<Chicken> iter = liveChicks.listIterator();
            while ( iter.hasNext() ) {
                Chicken current = iter.next();
                current.setAge();
                if ( current.getAge() >= 2 && current.getAge() <= 4 ) {
                    current.lays(i, eggsWeek);
                    if ( current.eggs.get(0).getAge() == i - 2 )
                        Chicken.eggToChicken(current, newChicks);
                }
//                if ( current.getAge() > 5 )
//                    iter.remove();
            }
        }
        for ( int i = 0; i <liveChicks.size() ; i++ ) {

            System.out.println(liveChicks.get(i).getName());
        }

    }
}
