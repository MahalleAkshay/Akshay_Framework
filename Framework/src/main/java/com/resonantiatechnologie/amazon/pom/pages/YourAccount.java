package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.utility.Constants;

public class YourAccount extends POMBase {
	public YourAccount() {
		// Here we are going to launch the page objects
		PageFactory.initElements(Constants.driver, this);
	}

}
