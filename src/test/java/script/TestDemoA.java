package script;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;

public class TestDemoA extends BaseTest
{
	@Test
	public void test()
	{
		int b = FWUtils.getXLRowCount(XL_PATH, "ValidData");
		System.out.println(b);
		String s = FWUtils.getXLData(XL_PATH, "ValidData", 1, 0);
		Reporter.log(s, true);
		Assert.fail();
	}
	
	@Test
	public void m1()
	{
		
	}

	@Test
	public void m2()
	{
		
	}
	
	@Test
	public void m3()
	{
		
	}
	
	
	
}
