package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
	
	@Parameters({"i","j","k"})
	@Test
	public void addition(int a,int b,String s)
	{
		System.out.println(a+b);
		System.out.println(s);
	}

}
