package com.resonantiatechnologie.amazon.pom.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.resonantiatechnologie.amazon.keywords.Keyword;
import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.utility.ExcelFileReader;

public class AmazonSignInTestCases extends POMBase {
	AmazonSignIn signIn;
	ExcelFileReader excel;

	public AmazonSignInTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		Keyword.implicitWait(20, TimeUnit.SECONDS);
		signIn = new AmazonSignIn();
		openURL();
		Keyword.windowMaximize();
		excel = new ExcelFileReader();
	}

	@Test()
	public void loginOn() {
		signIn.login();

	}

	@DataProvider(name = "Akshay")
	public Object[][] getDataFromExcel() throws IOException {
		Object[][] obj = excel.excleFileReader();
		return obj;

	}

	@Test(dataProvider = "Akshay")
	public void verifyLogin(String userName, String password) {
		signIn.login(userName, password);
	}

	@AfterMethod
	public void closeBrowser() {
		Keyword.windowClose("Chrome");

	}
}

//	@AfterMethod
//	public void tearDown() {
//		Constants.driver.quit();
//
//	}
