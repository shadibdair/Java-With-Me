import java.util.Iterator;

public class MainTest {
    public static void main(String[] args) {
        // Create new students
        Student s1 = new Student("Shadi", "Badir", "1001", 2000);
        Student s2 = new Student("Crisiano", "Ronlado", "1002", 2001);
        Student s3 = new Student("Lionel", "Messi", "1003", 1999);

        // Create an association table with students as keys and grades as values
        AssociationTable<Student, Integer> table = new AssociationTable<>();
        table.add(s1, 85);
        table.add(s2, 90);
        table.add(s3, 88);

        // Add, update, and remove data
        Student s4 = new Student("Bob", "Williams", "1004", 2002);
        table.add(s4, 80);
        table.add(s1, 87);  // Update John's grade
        table.remove(s2);   // Remove Jane

        // Display the sorted list of students and their grades
        for (Iterator<Student> it = table.keyIterator(); it.hasNext(); ) {
            Student s = it.next();
            System.out.println(s + ": " + table.get(s) + " grade");
        }
    }
}
