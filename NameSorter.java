
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;





class LastNameOnlyComparator implements Comparator<String>{

	//Put the logic to compare the last name of two inputs.
	@Override
	public int compare(String s1, String s2) {
		//1. Split the name to compare by empty space.
		String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        //2. Compare the last name 
        if (arr1.length > 1 && arr2.length > 1)
            return arr1[arr1.length-1].compareTo(arr2[arr2.length-1]);
        else
            return 0;
	}
	
}

public class NameSorter{
	public static void main (String[] args) throws IOException {
		
		//1. Read the input from the file on the args[0] and  put them on the array list.
		Scanner s = new Scanner(new File(args[0]));
		ArrayList<String> people = new ArrayList<String>();
		
		while (s.hasNextLine()) {
			String people2 = s.nextLine();
		    people.add(people2);
		     
		}
		s.close();
        		
		//2. Sort the input on the array list based on the last name.
		
		Collections.sort(people, new LastNameOnlyComparator());
		
		
		
		//3. Display the sorted input on the screen
		for (String person: people) {
		System.out.println(person);
		}
		
		//4. Write the sorted input into a file on the working directory.
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\dedyw\\eclipse-workspace\\SortingByLastName\\src\\sorted-names-list.txt")); 
		for(String str: people) {
		  writer.write(str);
		  writer.newLine();
		 
		}
		writer.close();
		
		
		
	}
}