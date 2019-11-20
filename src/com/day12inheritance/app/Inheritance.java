package com.day12inheritance.app;
import java.util.Scanner;
/*
* HackerRank 30 Days of Code
* ========== Day 12 Inheritance ===========
* You are given two classes, Person and Student, where Person is the base class and Student is the derived class. Completed 
* code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the
* properties of Person.
* Complete the Student class by writing the following:
* - A Student class constructor, which has 4 parameters:
* 	1. A string firstName.
* 	2. A string lastName.
* 	3. An integer, id.
* 	4. An integer array (or vector) of test scores, scores.
* - A char calculate() method that calculates a Student object's average and returns the grade character representative
* 	of their calculated average: 
* 	Grading Scale
* 	Letter  | Average 
* 		O	| 90<=a<=100
* 		E	| 80<=a<90
* 		A	| 70<=a<80
* 		p	| 55<=a<70
* 		D	| 40<=a<55
* 		T	| a<40
 */
class Person{
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	//Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	public void printPerson() {
		System.out.println(
				"Name: " + lastName + ", " + firstName
				+ "\nID: " + idNumber);
	}
}
class Student extends Person{
	private int[] testScores;
	private int average;
	
	Student(String name, String lastName, int id, int[] scores){
		super(name,lastName,id);
		this.testScores = scores;
	}
	
	public char calculate() {
		int average = 0;
		char grade = Character.MIN_VALUE;
		for(int i=0;i<this.testScores.length;i++) {
			average += this.testScores[i]; 
		}
		average = Math.round(average / testScores.length);
        if(average>=90 && average<=100)
            grade = 'O';
        else if(average>=80 && average<90)
            grade = 'E';
        else if(average>=70 && average < 80)
            grade = 'A';
        else if(average >= 55 && average < 70)
            grade = 'P';
        else if(average >= 40 && average < 55 )
            grade = 'D';
        else
            grade = 'T';
        return grade;
	}
}

class Inheritance {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		String firstName = scanner.next();
		String lastName = scanner.next();
		int id = scanner.nextInt();
		int numScores = scanner.nextInt();
		int[] testScores = new int[numScores];
		for(int i=0;i<numScores;i++) {
			testScores[i] = scanner.nextInt();
		}
		scanner.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: "+s.calculate());
	}
}
