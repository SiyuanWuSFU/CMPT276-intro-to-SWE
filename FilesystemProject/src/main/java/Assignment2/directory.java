package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class directory extends node   {
	ArrayList<node> children = new ArrayList<node>();
	
	public directory(String n ){
		this.name = n;
		this.parent = null;
	}
	
	
	public directory(String n , directory p){
		this.name = n;
		this.parent = p;
		p.children.add(this);


	}
	
	

	 public void add(node n) {
		 children.add(n);
	 }
	
	public void write(String content) {
		
		this.content = null;
		System.out.println("Warning: cannot write into directory content");
				
	}


	@Override
	public List<String> find(String s) {
		String currentpath = "";
		List<String> result = new ArrayList<String>();
		if(name.indexOf(s) != -1) {
			currentpath = process( this);
			result.add(currentpath + this.name);
		}
		
		for(node child : children) {
	
			result.addAll(child.find(s));
		}
		return result;
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
	 
		public static directory exist(ArrayList<directory> d, String s) {
			for(int i = 0; i<d.size(); i++) {


				//System.out.println(d.get(i).name);
				if(d.get(i).name.equals(s)) {

					return d.get(i);
				}
				
			}

			return null;
		}
		public file find_file(String s) {
			file temp = null;
			for(node child : children) {
				
				temp= (child.find_file(s));
				if(temp!=null) {
					return temp;
				}
			}
			return temp;
		}
		
}
