package Assignment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class system {

	public static void main(String[] args) {

		/*
		 * import file called pathexample 
		 */

		node root =FileSystem.Import("pathexample");
		
		/*
		 * test file system structure with find()
		 */
		System.out.println( "finding file containing substring'png' ");
		System.out.println( root.find("png"));
		
		file testfile = root.find_file("pdf");
		
		System.out.println("adding observer to "+testfile.name);
		/*
		 * test file system structure with observer
		 */
		Fileobserved b = new Fileobserved("Leon", testfile);
		
		testfile.write("Assignment finished");



			
		

		
	}
}
