package BookManagement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JdbcConnection.DatabaseConnectionManager;

public class Manage {

	private final List<user>listRaeder = new ArrayList<>();
	public List<user> getReaders() {
	 DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "root", "", "qlsach");
	 try ( Connection connection = dcm.getConnection();  Statement statement = connection.createStatement();){
         String sql = "SELECT * FROM slsach";
         try ( ResultSet resultSet = statement.executeQuery(sql);) {

             while (resultSet.next()) {
                 int type = resultSet.getByte("type");
                 if (type == 2) { // textbook
					this.listRaeder.add(TextBook.createObject(resultSet));
                 }
                 if (type == 1) { // documentation
                     this.listRaeder.add(Documentation.createObject(resultSet));

                 }

             }

         }
	 }catch (SQLException e) {
         e.printStackTrace(System.err);
     }

     return listRaeder;

 }

 public float calculateSum() {

     float sum = 0.0f;

     for (user user : this.listRaeder) {
         sum = sum + user.calculateFee();
     }

     return sum;
 }

}
