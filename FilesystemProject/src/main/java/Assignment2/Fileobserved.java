package Assignment2;




public class Fileobserved implements observer{
	public node subject;
	public String observer_name;
	
	
	 public Fileobserved(String observer_name,file f) {
		super();
		this.observer_name = observer_name;
		f.subscribe(this);
		subject = f;
	}



	public void update() {
		System.out.println("Warning to editor "+ this.observer_name);
		System.out.println(" change has been made in file " + subject.name);
		
		System.out.println(" The content is now: " + subject.content);
	}
	

	
}
