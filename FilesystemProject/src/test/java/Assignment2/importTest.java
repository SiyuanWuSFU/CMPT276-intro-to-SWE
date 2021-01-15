package Assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class importTest {

	@Test
	public void test() {

		/*
		 * import file called pathexample 
		 */

		node root =FileSystem.Import("pathexample");
		assertEquals(root.parent,null);
		/*
		 * test file system structure with find()
		 */
		System.out.println( "finding file containing substring'pdf' ");
		System.out.println( root.find("pdf"));
		
		file testfile = root.find_file("pdf");
		file file1 = root.find_file("pdf");

		
		System.out.println("adding observer to "+testfile.name);
		/*
		 * test file system structure with observer
		 */
		Fileobserved b = new Fileobserved("Leon", testfile);
		
		testfile.write("assignment finished");


	}

}
