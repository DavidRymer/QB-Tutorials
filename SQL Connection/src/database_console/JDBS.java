import java.sql.Statement;
import java.sql.Time;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBS {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/qb_tutorials";
	static final String USER = "root";
	static final String PASS = "password";
	static Connection conn = null;
	static Statement stmt = null;


	public static void accessDB() {


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		//make a connection

		System.out.println("Connecting to database");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void createTestQuestion(String question, String topic, String answer) {

		System.out.println("Inserting records into the table...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO test_questions(question, topic, answer) VALUES (" + "'" + question + "'" +", " + "'" + topic + "'" + ", " +"'" +answer+"'" +")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");
		System.out.println(sql);

	}
	
	public static void createQuestionLine(int questionLineID, int questionID) {

		System.out.println("Inserting records into the table...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO question_line (question_line_id, question_id) VALUES (" + questionLineID + ", " +questionID +")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");

	}

	public static void createTest(String topic, String difficulty, String level, int questionLineID) {


		System.out.println("Inserting records into the table...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO test (topic, difficulty, level, question_line_id) VALUES (" + "'" + topic + "'" +", " + "'" + difficulty + "'" + ", " +"'"+ level +"',"+ questionLineID+")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");
		System.out.println(sql);

	}
	
	public static void createTestResult(int userID, int score, int testID) {

		System.out.println("Inserting records into the table...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO test_results (user_id, score, test_id) VALUES (" + userID +", " + score + ", " + testID + ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");
		System.out.println(sql);

	}
	
	public static void createUser(String firstName, String lastName, String email, int assignedTutor) {

		System.out.println("Inserting records into the table...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO user_details (first_name, last_name, email, assigned_tutor) VALUES (" +"'" + firstName +"'"+", " +"'"+ lastName +"'"+ ", " +"'"+ email+"' , " +assignedTutor+ ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");
		System.out.println(sql);

	}

	public static void createTutor(String firstName, String lastName, String speciality, String email) {

		System.out.println("Inserting records into the table...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO tutors (first_name, last_name, speciality, email) VALUES (" +"'" + firstName +"'"+", " +"'"+ lastName +"'"+ ", " +"'"+ speciality+"' , " +"'"+ email+"'"+ ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");
		System.out.println(sql);

	}
	
	public static void createTutorSession(int tutorID, int userID, int length, String dateTime) {

		System.out.println("Inserting records into the table...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO tutor_session (tutor_id, user_id, length, date_time) VALUES (" + tutorID +", "+ userID +", " + length + ", " +"'"+ dateTime +"'"+ ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");
		System.out.println(sql);
	}

	
	public static void read() {
        ResultSet rs = null;
        
		System.out.println("Creating statement...");
		try {
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2= "SELECT id, name, date FROM Languages";
		
		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while(rs.next()) {
				int id= rs.getInt("id");
				String name= rs.getString("name");
				int date= rs.getInt("date");
				System.out.println("ID: "+ id+ ", name: "+ name+ ", date: "+ date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


}






