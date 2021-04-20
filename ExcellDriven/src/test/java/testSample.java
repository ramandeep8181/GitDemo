import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// we will call method name "getData" into this class
		
		dataDriventest1 d= new dataDriventest1();
		ArrayList  data =d.getData("Add Profile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println("update for git project");
		System.out.println("More work done by india stuff guy");
		System.out.println("I made change to show new branch, develop");
	}

}
