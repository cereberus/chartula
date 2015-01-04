package z_TEMP;

public class pi {
  public static void main(String[] args) {
double pi=2;
   	for (int i=3;i<10000;i=i+2)
   		{
pi = pi *(double)(i-1)/(double)(i);  
pi = pi *(double)(i+1)/(double)(i); 
  	 	}
  	System.out.println(pi*2+" to jest pi");
  	}
}