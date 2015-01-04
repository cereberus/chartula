package z_TEMP;

public class pi_02_comments {
	  public static void main(String[] args) {
	double pi=1;
	   	for (int i=3;i<10000;i=i+4)
	   		{
	//System.out.println(i);
	pi = pi - (double)(1)/(double)(i);
	//System.out.println("minus 1/" + (double)(i));
	//System.out.println(i);
	pi = pi +(double)(1)/(double)(i+2);
	//System.out.println("plus  1/" + (double)(i+2));
	
	  	 	}
	  	System.out.println(pi*4+" to jest pi");
	  	}
	}