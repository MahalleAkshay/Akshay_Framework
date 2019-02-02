package com.resonantiatechnologie.amazon.pom.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.resonantiatechnologie.amazon.keywords.Keyword;
import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;
import com.resonantiatechnologie.amazon.pom.pages.ShoppingCart;

public class ShoppingCartTestCases extends POMBase {
	ShoppingCart shopping;
	AmazonSignIn signIn;
	OnlineShopingSiteInIndia online;

	// this the constructor of shopping cart page
	public ShoppingCartTestCases() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		Keyword.implicitWait(20, TimeUnit.SECONDS);
		Keyword.windowMaximize();
		online = new OnlineShopingSiteInIndia();
		signIn = new AmazonSignIn();
		shopping = new ShoppingCart();
		openURL();
		online = signIn.login();
	}

	@Test()
	public void shoppingCartTest() {
		//shopping = online.clickOnCartLink();
		Keyword.handleDropdown("xpath", "//select[@name='quantity']", "1");
		shopping.proceedToCheckoutLink();
		Keyword.takeScreenshot();

	}
//	@AfterMethod
//	public void tearDown() {
//		Constants.driver.quit();
}
