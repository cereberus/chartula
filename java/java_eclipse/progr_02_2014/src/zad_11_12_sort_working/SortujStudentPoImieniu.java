package zad_11_12_sort_working;

import java.util.Comparator;

public class SortujStudentPoImieniu implements Comparator<Student> {
	
	
	
	public int compare(String s1, String s2) {
	    if (s1 == null && s2 == null) {
	        return 0;
	    } else if (s1 == null) {
	        return -1;
	    } else if (s2 == null) {
	        return 1;
	    } else {
	        return s1.compareTo(s2);
	    }
	
	 
}

	@Override
	public int compare(Student s1, Student s2) {
		 
		 
		 int zmienna = s1.get_imie().compareTo(s2.get_imie());
		 
	        if(zmienna == 0)
	        	zmienna = s1.get_nazwisko().compareTo(s2.get_nazwisko());
	        if(zmienna == 0)
	            zmienna = s1.get_indeks().compareTo(s2.get_indeks());
	        
	        
	        return zmienna;
		
	
	}




}