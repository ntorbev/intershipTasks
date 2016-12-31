import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*Define a class Human with properties “first name”, “last name”.
    Define a class Student which inherits Human, with a property “grade”.
    Define a class Worker (inherits Human) with properties “daily wage”, “hours spent at work”.
    Implement a method “calculate wage per hour” (wage/hours).
     Write the appropriate modifiers (getters/setters) and .ctors(constructors)
    •Initialize an array of 10 students, sort by grade
    •you can use Arrays.sort
    •Implement Comparable or write your own Comparator
    •Print to console (one student per line)*/
        Student[] students = new Student[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            students[i] = new Student("niki" + i, "tor" + i);
            students[i].setGrade(rand.nextInt(25 - 1) + 1);
        }

        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].first_name);
        }

       /*Initialize 10 workers in an array and sort by salary in decreasing order*/
        Worker[] workers = new Worker[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("niki" + i, "tor" + i);
            workers[i].setDaily_wage(i + 1);
            workers[i].setHours_spent_at_work(i + 1);
        }

        Arrays.sort(workers, Collections.reverseOrder());
    }
}
