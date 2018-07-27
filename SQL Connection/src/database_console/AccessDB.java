import java.util.ArrayList;

public class AccessDB {
	
	public static void main(String[] args) {
		
		JDBS.accessDB();
		
		ArrayList<String> a = new ArrayList<>();
		a.add("result_id");
		a.add("user_id");
		a.add("score");
		a.add("test_id");
		
		
		JDBS.createTestResult(2, 25, 1);

		JDBS.read(a, "test_results", "result_id", "11");
		
		


        
	}


}
