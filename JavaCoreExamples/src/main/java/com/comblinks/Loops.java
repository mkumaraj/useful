
package com.comblinks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Loops {

	public static void main(String[] args) {

		// Simple For loop
		int[] numbers = { 1, 2, 3, 4, 5 };
		for (int num : numbers) {
			System.out.println(num);
		}

		// Loop an Array
		String[] array = { "one", "two", "three" };
		Arrays.stream(array).forEach(element -> System.out.println(triggerMethod(element)));

		// Collect array of method returns
		List<String> originalList = Arrays.asList("one", "two", "baz");
		List<String> modifiedList = originalList.stream().map(element -> triggerMethod(element))
				.collect(Collectors.toList());
		System.out.println(modifiedList.toString());

		
		//Comparator
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student("Alice", 85));
		studentList.add(new Student("Bob", 75));
		studentList.add(new Student("Charlie", 92));
		studentList.add(new Student("Dave", 63));

		// Sort by name
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		Collections.sort(studentList, nameComparator);
		System.out.println("Sorted by name:");
		for (Student student : studentList) {
			System.out.println(student.getName() + " - " + student.getGrade());
		}

		// Sort by grade
		Comparator<Student> gradeComparator = Comparator.comparing(Student::getGrade);
		Collections.sort(studentList, gradeComparator);
		System.out.println("Sorted by grade:");
		for (Student student : studentList) {
			System.out.println(student.getName() + " - " + student.getGrade());
		}
		
		List<Student> studentListComparable = new ArrayList<>();
        
		studentListComparable.add(new Student("Alice", 85));
		studentListComparable.add(new Student("Bob", 75));
		studentListComparable.add(new Student("Charlie", 92));
		studentListComparable.add(new Student("Dave", 63));
        
        // Sort the list
        Collections.sort(studentListComparable);
        
        // Print out the sorted list
        for (Student student : studentList) {
            System.out.println(student.getName() + " - " + student.getGrade());
        }
		

	}

	private static String triggerMethod(String temp) {
		return temp;

	}

	static class Student implements Comparable<Student>{
		private String name;
		private int grade;

		public Student(String name, int grade) {
			this.name = name;
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public int getGrade() {
			return grade;
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.grade - o.grade;
		}
	}

}
