package Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSystem {

	
	public static  node Import(String s) {
		
		String path;

		String temptoken = null;
		String token;
		int slash_index = 0;
		int coma_index= 2;

		int temp=0;
		directory root = new directory("root");


		boolean root_flag  = true;
		ArrayList<directory> contain_d = new ArrayList<directory>();

		File file = new File(s);

		contain_d.add(root);
	    try {

	        Scanner sc = new Scanner( file,StandardCharsets.UTF_8.name());

	        while (sc.hasNextLine()) {

	        	root_flag  = true;
	        	path = sc.nextLine();
	            System.out.println(path);

	        	 coma_index = path.indexOf(":",slash_index);

	        		while(slash_index< path.length()) {
	        			
	        			slash_index = path.indexOf('/',slash_index);

	        			
	        			if(root_flag) {
	        				temptoken=path.substring(coma_index+1,slash_index);  

	        				root_flag = false;
	        			}
	        			else {
		        			if(slash_index==-1) {
		        		        

			        			
		        				 token=path.substring(temp,path.length());  

		        				new file(token,directory.exist(contain_d,temptoken));
		        				
		        				
		        				temptoken = token;
		        				break;
		        			}
	        				 token=path.substring(temp,slash_index);  
		        				if(directory.exist(contain_d,token)==null) {
		        					

		        					contain_d.add(new directory(token,directory.exist(contain_d,temptoken)));

		        				}
	        				temptoken = token;
	        				//System.out.println(token);
	        			}


	        			

	        			slash_index++;
	        			temp = slash_index;
	        		}
	        		slash_index = 0;
	        		temp = 0;

	        	}
	        	
	        sc.close();
	      

	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		



		
		
		
		
		return root;
		
		
		
	}
}
