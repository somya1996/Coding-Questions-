package Sorting_Techniques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		List<Student_class> students = new ArrayList<>();
		students.add(new Student_class(23 , "Ram"));
		students.add(new Student_class(35 , "Shyam"));
		students.add(new Student_class(83 , "Aman"));
		students.add(new Student_class(13 , "Rohit"));
		students.add(new Student_class(13 , "Anuj"));
		students.add(new Student_class(12 , "Ram"));


		Collections.sort(students , new SortByNameThenMarks());
		students.forEach(System.out::println);
	}
}
class SortByNameThenMarks implements Comparator<Student_class>{
	@Override
	public int compare(Student_class s1 , Student_class s2){
		if(s1.name.equals(s2.name)){
			return s1.marks - s2.marks;
		}
		else{
			return s1.name.compareTo(s2.name);
		}
	}
}
