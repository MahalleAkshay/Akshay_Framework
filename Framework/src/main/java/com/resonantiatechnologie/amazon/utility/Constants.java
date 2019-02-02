package com.resonantiatechnologie.amazon.utility;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ru.yandex.qatools.ashot.Screenshot;

public class Constants {
	
	 //Selenium constants
	public static WebDriver driver;
	public static Actions action;
	public static WebElement element;
	public static File file;
	public static Robot robo;
	public static Screenshot sc;
	public static Alert alert;
	
	 //Java constants
	public static FileInputStream fis;
	public static Properties prop;
	public static List list;
	
	//File paths
	public static String propertyFilePath="C:\\EclipseWorkspace\\Framework\\src\\main\\java\\com\\resonantiatechnologie\\amazon\\config\\config.properties";
	public static String pomexcelFilePath="C:\\EclipseWorkspace\\Framework\\src\\main\\java\\com\\resonantiatechnologie\\testdata\\PomTestData.xlsx"; 
	public static String keywordTestCasePath="C:\\EclipseWorkspace\\Framework\\src\\main\\java\\com\\resonantiatechnologie\\testdata\\KeywordTestCases.xlsx";
	//Other paths
	public static String doubleHash = "##";
	public static String singleHash = "#";
	public static String underScore = "_";
	public static String character = "";
	
	

}
