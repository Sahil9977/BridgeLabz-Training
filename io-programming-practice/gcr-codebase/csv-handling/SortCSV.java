package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCSV {
	public static void main(String[] args) {
		String file = "employees.csv";
	    List<String[]> list = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	        br.readLine();
	        String line;

	        while ((line = br.readLine()) != null)
	            list.add(line.split(","));

	        list.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

	        for (int i = 0; i < 5 && i < list.size(); i++)
	            System.out.println(Arrays.toString(list.get(i)));

	    } catch (Exception e) { e.printStackTrace(); }
	}

}
