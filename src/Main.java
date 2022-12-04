import java.awt.Image;

public class Main {

	//start of main method
	public static void main(String []args){
		
		MinimizeApp m = new MinimizeApp();
		m.start();
	    
		Server s = new Server();
		s.startServer();

	}//end of main

}
