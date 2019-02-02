package com.resonantiatechnologie.amazon.pom.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.resonantiatechnologie.amazon.keywords.Keyword;
import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;

public class OnlineShoppingSiteInIndiaTestCases extends POMBase {
//this object will give us the right to access the methods in OnlineShopingSiteInIndia
	OnlineShopingSiteInIndia online;
	

	// Constructor of above class
	public OnlineShoppingSiteInIndiaTestCases() {
		super();
	}

	@BeforeTest
	public void setUp() {
		openBrowser();
		online = new OnlineShopingSiteInIndia();
		Keyword.windowMaximize();

	}

	@Test
	public void url() {
		System.out.println("open url");
	}

	@Test
	public void verifyhello() {
		online.mouseMovementOnhelloSignInYourOrdersLink();
		online.clickOnhelloSignInYourOrdersLink();
	}

//	@AfterMethod
//	public void tearDown() {
//		Constants.driver.quit();
//
//	}

}
