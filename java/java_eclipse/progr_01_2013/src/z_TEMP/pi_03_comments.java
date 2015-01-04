package z_TEMP;

public class pi_03_comments {
	  public static void main(String[] args) {
	double pi=0;
	   	for (int i=1;i<10000;i=i+1)
	   		{
//	System.out.println(i);
//	pi = pi - (double)(1)/(double)(i);
//	System.out.println("minus 1/" + (double)(i));
	System.out.println(i);
	pi = pi +(double)(1)/((double)(i)*(double)(i));
	System.out.println("plus  1/" + ((double)(i)*(double)(i)));
	
	  	 	}
	  	System.out.println(Math.sqrt(pi*6)+" to jest pi");
	  	}
	}