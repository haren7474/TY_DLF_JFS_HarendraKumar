package com.tyss.executionflow;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMyBase extends BaseTest{
	@Test
	public void test1() {
		Reporter.log("test1", true);
	}
	
	@Test
	public void test2() {
		Reporter.log("test2", true);
	}
}
