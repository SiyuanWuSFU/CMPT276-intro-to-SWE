package Assignment2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileTest {



		@Test
		public void fileSystemtest() {
			List<String> path =  new ArrayList<String>();

			/*
			 * Create directory 1 called dir1
			 */
			directory root = new directory("root");


			directory dir1 = new directory("dir1",root);



			/*
			 * Create directory 2 called dir2 under directory 1
			 */
			
			
			directory dir2 = new directory("dir2",dir1);

			

			

			/*
			 * Create directory 3 called dir3 under directory 1
			 */
			directory dir3 = new directory("dir3",dir1);
	

			

			/*
			 * Create file1 called textKey.txt under directory 2
			 */
			
			file file1 = new file("textKey.txt",dir2);



			
			
			/*
			 * create subscriber called Leon
			 * subscriber subscribe File1
			 * File1 adds subscriber Leon into subscription list
			 */
			Fileobserved a = new Fileobserved("Leon", file1);

			/*
			 * create subscriber called someone
			 * subscriber subscribe File1
			 * File1 adds subscriber someone into subscription list
			 */
			Fileobserved b = new Fileobserved("else", file1);

			
			/*
			 * Create File 2 called Key.java under directory 3
			 */


			file file2 =new file("Key.java",dir3);

			/*
			 * Create File 3 called file3.pdf under directory 3
			 */
			file file3 =new file("file3.pdf",dir3);
			/*
			 * Search the file system for key word key
			 * 		 */
			path = dir1.find("Key");
			
			for(int i = 0;i<path.size();i++) {
				System.out.println(path.get(i));
				
			}
			
			
			
			/*
			 * write "something" into File1	and test observers
			 */
			file1.write("something");
			file1.unsubscribe(b);
			file1.write("some random words");
			b = new Fileobserved("else", file2);
			file2.write("lalallala");

			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}



