package Task1;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.Database;

public class Scenario2 {

	@Test()
	public void validateTableData() throws Throwable
	{
		Database db= new Database();
		String sourceData="Select * from Source;";
		String targetData="Select * from Target;";
		db.connectToDB();
		String sData="";
		String tData="";
		/*ArrayList<String> Source= new ArrayList<String>();
		ArrayList<String> Target= new ArrayList<String>();
		*/
        sData=db.executeQueryAndGetData(sourceData, 1);
        tData=db.executeQueryAndGetData(targetData, 1);
		System.out.println("Data in Source table is :" +sData +" and Data in Target table is :"+ tData);
		db.closeDB();
		
		Assert.assertEquals(sData, tData);

	}
}

