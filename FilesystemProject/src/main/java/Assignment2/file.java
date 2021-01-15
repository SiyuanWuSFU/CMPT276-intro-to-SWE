package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class file extends node {
	private List<observer> editor = new ArrayList<observer>();
	ArrayList<node> children = new ArrayList<node>();
	
	public file(String n, directory p){
		 this.name = n;
		 this.parent = p;
		p.children.add(this);
		 }

		@Override
		public List<String> find(String s) {
			String currentpath = "";
			List<String> result = new ArrayList<String>();
			if(name.indexOf(s)!=-1) {
				currentpath = process( this);
				result.add(currentpath + this.name);
			}
			return result;
		}
		
		public file find_file(String s) {
			if(name.indexOf(s)!=-1) {
				return this;
			}
			return null;
		}
		
		 public String process( node d) {
			 String some = "";
			 if(d.parent != null) {

				 String p_name = d.parent.name;
				 some = some  +p_name +"/" ; 

				 some = process( d.parent)+some  ;
			 }
			
				 return some;

			 
		 }
	

	
	public void subscribe(observer follower) {
		
		editor.add(follower);
		
	}  
	 
	public void unsubscribe(observer follower) {
		
		editor.remove(follower);
		
	}  
	
	
	public void notifys(String s, String c) {
		
		for(observer i : editor) {

			i.update();
		}
		
	}
	
	
	public void write(String content) {
		
		System.out.println("Write "+"'" +content+ "'"+ " to the content of file "+ this.name);
		this.content = content;
		notifys(this.name, this.content);
				
	}




};
