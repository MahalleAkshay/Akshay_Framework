package com.resonantiatechnologie.amazon.pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.math.IEEE754rUtils;
import org.apache.xpath.compiler.Keywords;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.resonantiatechnologie.amazon.keywords.Keyword;
import com.resonantiatechnologie.amazon.utility.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMBase {
	// This is a constructor of POMBase class
	public POMBase() {

		try {
			Constants.fis = new FileInputStream("C:\\EclipseWorkspace\\Framework\\src\\main\\"
					+ "java\\com\\resonantiatechnologie\\amazon\\config\\config.properties");
			Constants.prop = new Properties();
			Constants.prop.load(Constants.fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// This method is used to open the particular browser
	public static void openBrowser() {
		Keyword.openBrowser(Constants.prop.getProperty("BROWSERNAME"));
	}// End of method

	// This method will maximize the particular window
	public static void openURL() {
		Keyword.openUrl(Constants.prop.getProperty("URL"));
	}// End of method
}
