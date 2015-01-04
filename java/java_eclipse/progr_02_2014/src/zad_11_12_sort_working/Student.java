package zad_11_12_sort_working;
//package temp;

import java.util.Comparator;
import java.util.GregorianCalendar;

public abstract class Student implements Comparable<Student> {

	private String imie;
	private String nazwisko;
	private String indeks;
	private GregorianCalendar dataUrodzenia;

	public Student(String imie, String nazwisko, String indeks,
			GregorianCalendar dataUrodzenia) {

		this.imie = imie;
		this.nazwisko = nazwisko;
		this.indeks = indeks;
		this.dataUrodzenia = dataUrodzenia;
	}

	public Student(String imie, String nazwisko, String indeks) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.indeks = indeks;
	}

	public static Comparator<Student> nazwisko2 = new Comparator<Student>() {

		public int compare(Student s1, Student s2) {
			String StudentName1 = s1.get_nazwisko();
			String StudentName2 = s2.get_nazwisko();

			return StudentName1.compareTo(StudentName2);

			// descending order
			// return StudentName2.compareTo(StudentName1);
		}
	};

	@Override
	public int compareTo(Student student) {

		int zmienna = get_nazwisko().compareTo(student.get_nazwisko());

		if (zmienna == 0)
			zmienna = get_imie().compareTo(student.get_imie());

		if (zmienna == 0)
			zmienna = get_dataUrodzenia()
					.compareTo(student.get_dataUrodzenia());
		return zmienna;
	}

	@Override
	public String toString() {

		if (this.dataUrodzenia.get(2) >= 10) {
			return "\n" + this.imie + "  " + this.nazwisko + "  " + this.indeks
					+ "  " + this.dataUrodzenia.get(5) + "."
					+ this.dataUrodzenia.get(2) + "."
					+ this.dataUrodzenia.get(1);
		} else {
			return "\n" + this.imie + "  " + this.nazwisko + "  " + this.indeks
					+ "  " + this.dataUrodzenia.get(5) + ".0"
					+ this.dataUrodzenia.get(2) + "."
					+ this.dataUrodzenia.get(1);
		}
	}

	public String get_imie() {
		return imie;
	}

	public String get_nazwisko() {
		return nazwisko;
	}

	public String get_indeks() {
		return indeks;
	}

	public GregorianCalendar get_dataUrodzenia() {
		return dataUrodzenia;
	}

	public String get_dataUrodzenia_czyt() {
		if (this.dataUrodzenia.get(2) >= 10) {
			return this.dataUrodzenia.get(5) + "." + this.dataUrodzenia.get(2)
					+ "." + this.dataUrodzenia.get(1);
		} else {
			return this.dataUrodzenia.get(5) + ".0" + this.dataUrodzenia.get(2)
					+ "." + this.dataUrodzenia.get(1);
		}

	}

	public void set_imie(String imie) {
		this.imie = imie;
	}

	public void set_nazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void set_indeks(String indeks) {
		this.indeks = indeks;
	}

	public void set_dataUrodzenia(GregorianCalendar dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

}
