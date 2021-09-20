package net.codejava;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoApp {
	
	public static void main(String[] args) throws SQLException {
		String jdbcUrl = "jdbc:sqlite:/C:\\Users\\nicol\\eclipse-workspace\\DemoApplication\\usersdb.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		
		try {
			Scanner myObj = new Scanner(System.in);

			System.out.println("Please select one of this following options:\r\n");
			System.out.println("1. Add Person (id, firstName, lastName)\r\n"
					+ "2. Edit Person (firstName, lastName)\r\n" + "3. Delete Person (id)\r\n"
					+ "4. Add Address to person [multiple required] (id, street, city, state, postalCode)\r\n"
					+ "5. Edit Address (street, city, state, postalCode)\r\n" + "6. Delete Address (id)\r\n"
					+ "7. Count Number of Persons\r\n" + "8. List Persons\r\n");

			System.out.println("Enter option:");
			int option = myObj.nextInt();
			
			PreparedStatement myStmt; 
			int id;
		    String firstName;
		    String lastName;
		    String street;
		    String city;
		    String state;
		    String postalCode;

			switch (option) {
			case 1:
				 System.out.println("Enter id, Name and Surname:");
			    id = myObj.nextInt();
			    firstName = myObj.next();
			    lastName = myObj.next();

			    myStmt = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, '', '', '', '')");
			    myStmt.setInt(1, id);
			    myStmt.setString(2, firstName);
			    myStmt.setString(3, lastName);
			    
			    myStmt.executeUpdate();
			    
			    System.out.println("PERSON ADDED");

				break;
			case 2:
				 System.out.println("Enter id, Name and Surname:");
				 id = myObj.nextInt();
				 firstName = myObj.next();
				 lastName = myObj.next();

				    myStmt = connection.prepareStatement("UPDATE users set firstName = ?, lastName = ? where id = ?");
				    
				    myStmt.setString(1, firstName);
				    myStmt.setString(2, lastName);
				    myStmt.setInt(3, id);
				    
				    myStmt.executeUpdate();
				    
				    System.out.println("PERSON UPDATED");
				break;
			case 3:
				System.out.println("Enter id:");
				 id = myObj.nextInt();

				    myStmt = connection.prepareStatement("DELETE from users where id = ?");
				    myStmt.setInt(1, id);
				    
				    myStmt.executeUpdate();
				    
				    System.out.println("PERSON DELETED");
				break;
			case 4:
				System.out.println("Enter id, street, city, state and postalCode:");
				 id = myObj.nextInt();
				 street = myObj.next();
				 city = myObj.next();
				 state = myObj.next();
				 postalCode = myObj.next();

				    myStmt = connection.prepareStatement("UPDATE users set street = ?, city = ?, state = ?, postalCode = ? where id = ?");
				    
				    myStmt.setString(1, street);
				    myStmt.setString(2, city);
				    myStmt.setString(3, state);
				    myStmt.setString(4, postalCode);
				    myStmt.setInt(5, id);
				    
				    myStmt.executeUpdate();
				    
				    System.out.println("ADDRESS UPDATED");
				break;
			case 5:
				System.out.println("Enter id, street, city, state and postalCode:");
				 id = myObj.nextInt();
				 street = myObj.next();
				 city = myObj.next();
				 state = myObj.next();
				 postalCode = myObj.next();

				    myStmt = connection.prepareStatement("UPDATE users set street = ?, city = ?, state = ?, postalCode = ? where id = ?");
				    
				    myStmt.setString(1, street);
				    myStmt.setString(2, city);
				    myStmt.setString(3, state);
				    myStmt.setString(4, postalCode);
				    myStmt.setInt(5, id);
				    
				    myStmt.executeUpdate();
				    
				    System.out.println("ADDRESS UPDATED");
				break;
			case 6:
				System.out.println("Enter id:");
				 id = myObj.nextInt();

				    myStmt = connection.prepareStatement("UPDATE users set street = '', city = '', state = '', postalCode = '' where id = ?"); 
				    
				    
				    myStmt.setInt(1, id);
				    
				    myStmt.executeUpdate();
				    
				    System.out.println("ADDRESS DELETED");
				break;
			case 7:
				 //System.out.println("Enter id:");
				 //id = myObj.nextInt();

				 Statement s = connection.createStatement();
				 ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM users");
				 r.next();
				 int count = r.getInt("rowcount") ;
				 r.close() ;
				 System.out.println("Table has " + count + " row(s).");
				    
				 //System.out.println("ADDRESS DELETED");
				break;
			case 8:
				String sql = "SELECT * FROM users";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);

				while (result.next()) {
					id = result.getInt("id");
					firstName = result.getString("firstName");
					lastName = result.getString("lastName");
					street = result.getString("street");
					city = result.getString("city");
					postalCode = result.getString("postalCode");

					System.out.println(id + " | " + firstName + " | " + lastName+ " | " + street+ " | " + city+ " | " + postalCode);
				}
				break;
			default:
				System.out.println("Invalid option, bye bye!");
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting to SQLite Database");
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid option, bye bye!");
			System.out.println("Restart the program!");
		}
		
	}

}
