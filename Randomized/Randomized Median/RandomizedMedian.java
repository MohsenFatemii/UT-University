import java.util.ArrayList;
import java.util.Collections;


/*
	Randomized Algorithm to Find The Median
	Algorithm has been Chosen Form Probability and Computing Randomized Algorithms and Probabilistic Analysis book
	By Michael Mitzenmacher & Eli Upfal

	Mohsen Fatemi
	mohsen.fatemi73@gmail.com
*/


public class RandomizedMedian {
	public static void main(String args[]){
		//An sample  Array To test the Algorithm
		int input[] = {12,11,10,9,1,2,2,2,2,3,4,5,6,7,8};
		try{
			System.out.println(FindMedian(input));
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	public static int FindMedian(int input[]) throws FailCase{
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0 ; i < input.length ; i++)
			a.add(input[i]);

		// Calculating ceil(n^(3/4))
		int size = (int) Math.ceil(Math.pow(a.size(), 0.75));

		//Shuffling the input
		Collections.shuffle(a);

		// Defining a Selected Arraylist to randomly choose numbers
		ArrayList<Integer> Selected = new ArrayList<>();
		for(int i = 0 ; i < size ; i++)
			Selected.add(a.get(i));
		Selected.sort(null);

		// calculating d and u
		int d = (int) Math.floor(0.5*Math.pow(a.size(),0.75)-Math.sqrt(a.size()));
		int u = (int) Math.ceil(0.5*Math.pow(a.size(),0.75)+Math.sqrt(a.size()));

		// Making Array C
		ArrayList<Integer> C = new ArrayList<>();
		int ld = 0,lu = 0;
		for(int i = 0 ; i < input.length ; i++){
			if(input[i]>=d&&input[i]<=u) C.add(input[i]);
			else if(input[i]<d) ld++;
			else if(input[i]>u) lu++;
		}

		// handling the failure Cases here
		if(ld>input.length/2||lu>input.length/2) throw new FailCase();
		else if(C.size()>4*Math.pow(input.length, 0.75)) throw new FailCase();

		// if the algorithm does not fail return the predicted Median
		C.sort(null);
		return C.get(input.length/2-ld>=0?input.length/2-ld:0);
	}
}
class FailCase extends Exception{
	String message = "The Algorithm Failed !";
	FailCase(){
		System.out.println(message);
	}
}