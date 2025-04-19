package Ex03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Manager {

	public static LinkedList<Student> getTxtToList(LinkedList<Student> list) {
		try {
			File file = new File("student.txt");
			Scanner sc = new Scanner(file);
			Student std;
			while (sc.hasNextLine()) {
				String stn = sc.nextLine();
				String[] data = stn.split("/");
				int no = Integer.parseInt(data[0]);
				String name = data[1];
				int score = Integer.parseInt(data[2]);
				String className = data[3];
				std = new Student(no, name, score, className);
				list.offer(std);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		LinkedList<Student> studentList = getTxtToList(new LinkedList<>());
		
		Collections.sort(studentList);
		
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		System.out.println();
		
		// 이름순 정렬 1
//		Collections.sort(studentList, Comparator.comparing(Student::getName));
		
		// 이름순 정렬 2
//		Collections.sort(studentList, (s1, s2) -> s1.getName().compareTo(s2.getName()));
		
		// 이름순 정렬 3
		Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
	
}

