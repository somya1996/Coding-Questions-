package Sorting_Techniques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		List<Student_class> students = new ArrayList<>();
		students.add(new Student_class(23 , "Ram"));
		students.add(new Student_class(35 , "Shyam"));
		students.add(new Student_class(83 , "Aman"));
		students.add(new Student_class(13 , "Rohit"));
		students.add(new Student_class(13 , "Anuj"));

		Collections.sort(students);
		students.forEach(System.out::println);
	}
}
