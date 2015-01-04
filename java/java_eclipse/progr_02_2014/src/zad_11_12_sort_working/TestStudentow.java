package zad_11_12_sort_working;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Random;

import zad_11_12_sort_working.SortujStudentPoImieniu;

public class TestStudentow {

	
	
	private ArrayList<String> names = new   ArrayList<String>();
	private ArrayList<String> forenames = new   ArrayList<String>();
	private ArrayList<Student> students = new   ArrayList<Student>();
	Random rn = new Random();
	
	
	public static void main(String[] args)
	{
	    new TestStudentow();
	}
	
	public TestStudentow()
	{
	    createNames();
	    //w tym miejscu kolekcja names musi zawiera� 10 nazwisk
	    createForenames();
	    //w tym miejscu kolekcja forenames musi zawiera� 10 imion
	    createRandomStudents();
	    //w tym miejscu kolekcja students musi zawiera� 50 student�w, dane student�w s� losowane, 
	    //imi� i nazwisko z utworzonych kolekcji, 
	    //indeks winien by� ci�giem cyfr o d�ugo�ci 6 zaczynaj�cym sie od "38", niepowtarzalno�� indeks�w nie jest wymagana, 
	    //data urodzenia z 1993 roku
	   
	    //w tym miejscu kolekcja students musi zawiera� 60 student�w, ich indeksy i daty urodzenia s� nadal losowe, 
	    //wszyscy maj� mie� nazwisko identyczne jak pi��dziesi�ty student, 
	    //pi�ciu z nich musi mie� te� identyczne imi�
	    checkDates();
	    appendStudents();
	   
	    System.out.println(students);
	    System.out.println(" ");
	    System.out.println("----------------------------------------------- ");
	    System.out.println(" ");
	    Collections.sort(students);
	    System.out.println(students);    
	    
	   Collections.sort(students, new SortujStudentPoImieniu());
	   System.out.println(" ");
	    System.out.println("----------------------------------------------- ");
	    System.out.println(" ");
	   
	    System.out.println(students);  
	   
	}
	
	private void createNames()
	{
	  forenames.add("Kowalski");
	  forenames.add("Nowek");
	  forenames.add("Szczery");
	  forenames.add("Bury");
	  forenames.add("Kolorowy");
	  forenames.add("Nowik");
	  forenames.add("Czarny");
	  forenames.add("Dziedzic");
	  forenames.add("Krowa");
	  forenames.add("Piesek");
	  forenames.add("Enek");
	}
	private void createForenames()
	{
	    names.add("Jan");
	    names.add("Marcin");
	    names.add("Marek");
	    names.add("Kazimierz");
	    names.add("Stefan");
	    names.add("Jakub");
	    names.add("Piotr");
	    names.add("Robert");
	    names.add("Mateusz");
	    names.add("Franciszek");
	    names.add("Leszek");
	}
	private void createRandomStudents()
	{
		Student student;
	   for (int i=0; i<50 ; i++){
		students.add( new Student( names.get(rn.nextInt(10)),forenames.get(rn.nextInt(10)) , tworz_indeks(),  stworz_date()  ) {});
	   }
	
	}
	
	
	private String tworz_indeks() {
		String indekss;
		int i1 = 3;
		int i2 = 8;
		int i3 = rn.nextInt(10);
		int i4 = rn.nextInt(10);
		int i5 = rn.nextInt(10);
		int i6 = rn.nextInt(10);
		indekss = String.valueOf(i1) + String.valueOf(i2) + String.valueOf(i3)+ String.valueOf(i4)+ String.valueOf(i5)+ String.valueOf(i6);
		
		return indekss;	
	}
		
		private GregorianCalendar stworz_date(){
			int month = rn.nextInt(11) + 1;
			int date = rn.nextInt(30) + 1;

			GregorianCalendar kalendarz = new GregorianCalendar(1993, month  , date);
//			System.out.println(kalendarz.getTime());
//			System.out.println(kalendarz.get(2)+1);
//			System.out.println(kalendarz.getClass());
	
		
			return kalendarz;
		}
		
		
		private void appendStudents() {
		String nazwisko2 =	students.get(students.size()-1).get_nazwisko();
		
		String imie2 =	students.get(students.size()-1).get_imie();
	
		Student student;
		   for (int i=0; i<5 ; i++){
			students.add( new Student(names.get(rn.nextInt(10)),  nazwisko2  , tworz_indeks(),  stworz_date()  ) {});
			students.add( new Student(  imie2, nazwisko2 , tworz_indeks(),  stworz_date()  ) {});
		   }
		   
		 			
		}
	
	private void checkDates()
	{
		ArrayList<Student> students2 = new   ArrayList<Student>();
		students2= students;
	    int licz=0;
		for ( int i=0; i< students.size()-1; i++){
			 for ( int j=0; j < students.size()-2; j++) {
		
			if (students.get(i).get_dataUrodzenia().equals(students.get(j).get_dataUrodzenia())&&(i!=j)){
				System.out.println(students.get(i).get_dataUrodzenia_czyt());
				System.out.println(i + ". " + students.get(i).get_imie() +" " + students.get(i).get_nazwisko());
				System.out.println(j + ". " + students.get(j).get_imie()+ " " + students.get(j).get_nazwisko());
				licz= licz+1;
			}
		}
		}
		if ( licz == 0 ) System.out.println("Zadna data urodzenia sie nie powtarza");
		
	}
	
	
}
