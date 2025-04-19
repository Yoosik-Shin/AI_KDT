package Ex03;

public class Student implements Comparable<Student> {

	int no;
	String name;
	int score;
	String className;
	
	
	
	
	public Student(int no, String name, int score, String className) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
		this.className = className;
	}
	
	
	
	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public String getClassName() {
		return className;
	}



	public void setClassName(String className) {
		this.className = className;
	}



	@Override
	public String toString() {
		return "" + no + ", " + name + ", " + score + ", " + className + "";
	}



	@Override
	public int compareTo(Student o) {
		return Integer.compare(o.score, this.score);
	}

	
	
	
}
