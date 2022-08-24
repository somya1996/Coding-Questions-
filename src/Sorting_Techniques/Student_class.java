package Sorting_Techniques;

public class Student_class implements Comparable<Student_class>{
	int marks;
	String name;

	public Student_class(int marks , String name){
		super();
		this.marks = marks;
		this.name = name;
	}
	public String toString(){
		return "Student [marks="+marks+",name="+name+"]";
	}

	public  int getMarks(){
		return marks;
	}

	public void setMarks(int marks){
		this.marks = marks;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	@Override
	public int compareTo(Student_class obj) {
		if(this.marks > obj.marks)
			return 1;
		else if(this.marks < obj.marks)
			return -1;
		return 0;
	}
}
