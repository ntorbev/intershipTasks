/**
 * Created by vili on 9/29/2016.
 */
public class Worker extends Human implements Comparable<Worker> {
    private int daily_wage;
    private int hours_spent_at_work;

    public Worker(String first_name, String last_name) {
        super(first_name, last_name);
    }

    public void setHours_spent_at_work(int hours_spent_at_work) {
        this.hours_spent_at_work = hours_spent_at_work;
    }

    public int getHours_spent_at_work() {
        return hours_spent_at_work;
    }

    public int getDaily_wage() {
        return daily_wage;
    }

    public void setDaily_wage(int daily_wage) {
        this.daily_wage = daily_wage;
    }

    public int calculate_wage_per_hour() {
        return this.daily_wage / this.hours_spent_at_work;
    }

    @Override
    public int compareTo(Worker comparedworker) {
        return comparedworker.calculate_wage_per_hour() > this.calculate_wage_per_hour() ? -1 : 0;
    }
}
