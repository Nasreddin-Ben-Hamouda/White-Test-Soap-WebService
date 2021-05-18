package com.whitetest.soap.data.models;
import java.util.ArrayList;
import java.util.List;


public class SingletonData {
	
	private static  List<Student> students=null;
	private  static List<Exam> exams=null;
	
	private SingletonData() {}
	
	public static List<Student> getStudents(){
		
		if(students==null) {
			students=new ArrayList<Student>();
			students.add(
							new Student(1,"Nasr Eddine Ben Hamouda",
							new Address("tastour street","bizerte","7016")
							)
						);
			students.add(
					new Student(2,"Oussama Abdelwahed",
					new Address("palastine street","bizerte","7016")
					)
				);
			students.add(
					new Student(3,"Mouin Lahbib",
					new Address("liberty street","bizerte","7016")
					)
				);
			students.add(
					new Student(4,"Bilel Lahbib",
					new Address("Karam street","bizerte","7016")
					)
				);
			students.add(
					new Student(5,"Hamadi Limem",
					new Address("14 January street","bizerte","7016")
					)
				);
			students.add(
					new Student(6,"Abadalah Mokchah",
					new Address("9 April street","bizerte","7016")
					)
				);
			students.add(
					new Student(7,"Khmaiess Tlich",
					new Address("tastour street","bizerte","7016")
					)
				);
		}
		return students;
		
	}
	
	public static List<Exam> getExams(){
		if(exams==null) {
			exams=new ArrayList<Exam>();

			exams.add(
						new Exam("123","OCA JAVA")
					);
			exams.add(
					new Exam("456","AWS Architect")
				);
			exams.add(
					new Exam("789","AWS Devops")
				);
			exams.add(
					new Exam("1000","AWS Developer")
				);
			exams.add(
					new Exam("2000","AWS Security")
				);
			exams.add(
					new Exam("3000","AWS Machine Learning")
				);
			exams.add(
					new Exam("3000","AWS Big Data")
				);
		}
		return exams;
		
	}

}
