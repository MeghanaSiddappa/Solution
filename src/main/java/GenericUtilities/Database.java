package GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Database {

	/**
	 * this method is used to connect to database
	 * @throws Throwable 
	 */
	public Connection connect=null;
	public Connection connectToDB() throws Throwable
	{
	    Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connect = DriverManager.getConnection(IPathConstants.dbUrl, IPathConstants.dbUserName, IPathConstants.dbPassword);
		return connect;
	}
	/**
	 * This method is used to execute query on Database and return the matching data 
	 * @param sqlQuery
	 * @param columnIndex
	 * @param expData 
	 * @return 
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String sqlQuery, int columnIndex) throws Throwable
	{
		Statement State = connect.createStatement();
		String query=sqlQuery;
		String data="";
		boolean flag=false;

		ResultSet result = State.executeQuery(query);
		while (result.next()) {
			data = result.getString(columnIndex);
		}
		
		return data;

	}
	/**
	 * This method is used to close the Database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		connect.close();
	}
	
}

	

