package Task1;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.Database;

public class Scenario1 {

	@Test()
	public void validateTableData() throws Throwable
	{
		Database db= new Database();
		String sourceCount="Select count(*) from Source;";
		String targetCount="Select count(*) from Target;";
		db.connectToDB();
		String sRowCount="";
		String tRowCount="";
        sRowCount=db.executeQueryAndGetData(sourceCount, 1);
        tRowCount=db.executeQueryAndGetData(targetCount, 1);
		System.out.println("Row count in Source table is :" +sRowCount +" and Row count in Target table is :"+ tRowCount);
		db.closeDB();
		
		Assert.assertEquals(sRowCount, tRowCount);

	}
}

