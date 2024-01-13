package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
	
	//@Parameters({"i","j","k"})
	@DataProvider(name="addition of data")
	public Object[][]additiondata()
	{
		return new Object[][] {{10,20,"Arise"},{30,50,"Pune"},{25,45,"Welcome"},{20,40,"you"}};
	}
	@Test(dataProvider = "addition of data")
	public void addition(int a,int b,String s)
	{
		System.out.println(a+b);
		System.out.println(s);
	}

}
