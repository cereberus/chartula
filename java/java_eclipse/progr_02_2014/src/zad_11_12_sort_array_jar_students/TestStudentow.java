package zad_11_12_sort_array_jar_students;

import java.util.*;
import java.awt.*;

public class TestStudentow {

	private ArrayList<String> names = null;
	private ArrayList<String> forenames = null;
	private ArrayList<Student> students = null;
	private int index = 0;
	
	public static void main(String[] args)
	{
	    new TestStudentow();
	}
	
	public TestStudentow()
	{
	    createNames();	         
	    //w tym miejscu kolekcja names musi zawierać 10 nazwisk
	    
//	    createForenames();
	    
	    //w tym miejscu kolekcja forenames musi zawierać 10 imion
	    
//	    createRandomStudents();
	    
	    //w tym miejscu kolekcja students musi zawierać 50 studentów, dane studentów są losowane, 
	    //imię i nazwisko z utworzonych kolekcji, 
	    //indeks winien być ciągiem cyfr o długości 6 zaczynającym sie od "38", niepowtarzalność indeksów nie jest wymagana, 
	    //data urodzenia z 1993 roku
	    
//	    appendStudents();
	    
	    //w tym miejscu kolekcja students musi zawierać 60 studentów, ich indeksy i dany urodzenia są nadal losowe, 
	    //wszyscy mają mieć nazwisko identyczne jak pięćdziesiąty student, 
	    //pięciu z nich musi mieć też identyczne imię
	    
	    
//	    checkDates();
//	    System.out.println(students); 
//	    Collections.sort(students);
//	    System.out.println(students);
//	    Collections.sort(students,...);
//	    System.out.println(students);    
	}
	private void createNames()
	{
		names.add("Anna");
	    names.add("Piotr");
	    names.add("Zbychu");
	}
	private void createForenames()
	{
	    forenames.add("Nowak");
	    forenames.add("Kowalski");
	    forenames.add("Lubuski");
	    
	}
	private void createRandomStudents()
	{
		int name_randomed = 0;
		int forename_randomed = 0;
		
	    for(int i=0; i<50;i++){
	    	Random r = new Random();
	    	index = 380000+r.nextInt(10000);
	    	
	    	
	    	Random s = new Random();
	    	name_randomed = r.nextInt(names.size());
	    	
	    	Random t = new Random();
	    	forename_randomed = r.nextInt(forenames.size());
	    	
	    	students.add(new Student(forenames.get(forename_randomed), names.get(name_randomed), Integer.toString(index)));
	    	
	    }
	}
	private void checkDates()
	{
//	    ...
	}
}


