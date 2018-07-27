import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
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

	
	public static void read(ArrayList<String> fields, String table, String whereField, String whereFieldEquals) {
        ResultSet rs = null;
        
		System.out.println("Creating statement...");
		try {
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql2 = "SELECT " + fields.get(0) +", ";
		
		for (int i = 1; i < fields.size() - 1; i++) {
			sql2 += fields.get(i) +", ";
			
		}
		
		sql2 += fields.get(fields.size() - 1);
		sql2 += " FROM " + table + " WHERE " + whereField + " = " + whereFieldEquals;
		System.out.println(sql2);
		
		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fieldString;
		String selected = "";

		try {
			while(rs.next()) {
				for (String field: fields) {
				fieldString = rs.getString(field);
				selected += "\n" + field +": " + fieldString + "\n";
				
				}
				
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
		System.out.println(selected);
	}
	
	public static void update(String field, String table, String edit, String whereField, String whereFieldEquals) {
		
		System.out.println("Creating statement...");
		try {
			stmt= conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql3= "UPDATE " + table +" SET " + field + " = " + edit +" WHERE " +whereField + " = " + whereFieldEquals;
		System.out.println(sql3);
		
		try {
			stmt.executeUpdate(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}






