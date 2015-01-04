package zad_11_12_sort_array_jar_students;


import java.util.*;
import java.awt.*;




public class Student implements Comparable<Student>{
	

	private String imie;
	private String nazwisko;
	private String indeks;
	private GregorianCalendar dataUrodzenia;
	
	
	public Student(String imie, String nazwisko, String indeks,
			GregorianCalendar dataUrodzenia) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.indeks = indeks;
		this.dataUrodzenia = dataUrodzenia;
	}

	
	public Student(String imie, String nazwisko, String indeks) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.indeks = indeks;
		this.dataUrodzenia = new GregorianCalendar(1993,0,1);
		Random r = new Random();
		this.dataUrodzenia.add(Calendar.DAY_OF_YEAR,r.nextInt(365));		
	}

	
	
	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}


	public String getNazwisko() {
		return nazwisko;
	}


	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


	public String getIndeks() {
		return indeks;
	}


	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}


	public GregorianCalendar getDataUrodzenia() {
		return dataUrodzenia;
	}


	public void setDataUrodzenia(GregorianCalendar dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}
	
	
	public String toString(){
		return "\n"+imie+" "+nazwisko+" "+indeks+" "+dataUrodzenia.getTime();
	}	
	
	public static void main(String[] args){
		Student s = new Student("Anna","Boleyn","381111");
		System.out.println(s);
	}
	
//	Student s = new Student(...);
//	System.out.println(s); //to jest zamieniane przez kompilator na System.out.println(s.toString());
//	...
//	ArrayList<Student> studenci = new ArrayList<Student>();
//	for(...)
//	{
//	    studenci.add(new Student(...));
//	}
//	System.out.println(studenci); //przy wypisywaniu informacji o pojedyńczym studencie zostanie użyta metoda toString()
	
	public int compareTo(Student arg0){
		return 0;
	}
}

