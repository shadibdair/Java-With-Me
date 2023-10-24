public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String id;
    private int birthYear;

    // Constructor to initialize student attributes
    public Student(String firstName, String lastName, String id, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthYear = birthYear;
    }

    // Getters and setters for each attribute (omitted for brevity)

    // Implement the compareTo method based on student ID
    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + id + "), " + birthYear;
    }
}
