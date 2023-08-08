package Java_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Steam_demo {

	public static void main(String[] args) 
	{
	System.out.println("********************");
	
	String [] name= {"Hokka","Hari","Amal","Hellen","Sneha","Lavanya"};
	
	List<String> nameList=Arrays.asList(name);
	
	//Count the list of value from the arraylist
	//System.out.println("Display the count of the list:");
	long lcount=nameList.stream().count();
	System.out.println("Display the count of the list:"+lcount);
	System.out.println();
	
	
	//Display the List of names
	System.out.println("************");
	System.out.println("List of names are:");
	nameList.stream().filter(s->s.contains(s)).forEach(s->System.out.println(s));	
	System.out.println();
	
	
	//Sort the given list based on starting letter
	System.out.println("************");
	System.out.println("Sorted names are:");
	nameList.stream().filter(n->n.startsWith("H")).sorted().forEach(n->System.out.println(n));
	System.out.println();
	
	//Names end with letter a
		System.out.println("*************");
		System.out.println("Names ends with Char 'A' below:");
		nameList.stream().filter(n->n.endsWith("a")).forEach(n->System.out.println(n));
		System.out.println();
		
	//Display the name whose lenght is 4
	System.out.println("************");
	System.out.println("Name with length 5");
	nameList.stream().filter(s->s.length()==5).forEach(s->System.out.println(s));
	System.out.println();
	
	//String [] arr= {"Marrupa","Govind","Prakash"};
	
	List<String> arr=new ArrayList<>();
	arr.add("Murappa");
	arr.add("Govin");
	arr.add("Prakash");
	
	//Concat the two list
	System.out.println("***************");
	List<String> conlist=Stream.concat(nameList.stream(), arr.stream()).collect(Collectors.toList());
	System.out.println(conlist);
	System.out.println("********************");
	}

}
