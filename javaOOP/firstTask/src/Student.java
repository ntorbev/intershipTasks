public class Student extends Human implements Comparable<Student> {
    private int grade;

    public Student(String first_name, String last_name) {
        super(first_name, last_name);
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    @Override
    public int compareTo(Student comparedStudent) {
        return comparedStudent.getGrade() > this.getGrade() ? -1 : 0;
    }
}
