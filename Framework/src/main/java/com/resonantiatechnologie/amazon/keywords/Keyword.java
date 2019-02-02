package com.resonantiatechnologie.amazon.keywords;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resonantiatechnologie.amazon.utility.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	static Logger log = Logger.getLogger(Keyword.class);

	/*
	 * 1 This method is used to launch the browser
	 * 
	 * @parameter is browserName
	 */
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			log.info("your " + browserName + " is open successfuly");
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			log.info("your " + browserName + " is open successfuly");
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			log.info("your " + browserName + " is open successfuly");
			break;
		case "Opera":
			WebDriverManager.operadriver().setup();
			log.info("your " + browserName + " is open successfuly");
			break;
		default:
			System.out.println("Enter a valid browser name");
			log.error("Enter a valid browser name");
			break;
		}// End of open browser
	}

	// 2 This method is used to open particular url
	public static void openUrl(String url) {
		Constants.driver.get(url);
		log.info("url is open");
	}// end of open url

	// 3 This method is used to locate webelement
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "xpath":
			Constants.element = Constants.driver.findElement(By.xpath(locatorValue));
			log.info("locate WebElement on Page");
			break;
		case "id":
			Constants.element = Constants.driver.findElement(By.id(locatorValue));
			log.info("locate WebElement on Page");
			break;
		case "name":
			Constants.element = Constants.driver.findElement(By.name(locatorValue));
			log.info("locate WebElement on Page");
			break;
		case "linkedText":
			Constants.element = Constants.driver.findElement(By.linkText(locatorValue));
			log.info("locate WebElement on Page");
			break;
		case "partiallinkedText":
			Constants.element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			log.info("locate WebElement on Page");
			break;
		case "cssSelector":
			Constants.element = Constants.driver.findElement(By.cssSelector(locatorValue));
			log.info("locate WebElement on Page");
			break;
		case "tagName":
			Constants.element = Constants.driver.findElement(By.tagName(locatorValue));
			log.info("locate WebElement on Page");
			break;
		case "className":
			Constants.driver.findElement(By.className(locatorValue));
			log.info("locate WebElement on Page");
			break;
		default:
			System.out.println("Enter valid locator");
			log.error("Element not found please enter valid locator");
			break;
		}
		return Constants.element;

	}

	// 4 This method is used to enter text
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
		log.info("Text is entered uccessfully");
	}// end of the method

	// 5 This method is used to click on particular button
	public static void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
		log.info("Succesfully click on WebElement");
	}// end of this method

	// 6 This method is used to maximize particular window
	public static void windowMaximize() {
		Constants.driver.manage().window().maximize();
		log.info("Window maximize successfully");
	}// end of method

	// 7 This method is used to minimize window
	public static void windowMinimize() {
		Dimension dim = new Dimension(800, 800);
		Constants.driver.manage().window().setSize(dim);
		log.info("Window minimize successfully");
	}// end of the method

	// 8 This method is used to close the particular browser
	public static void windowClose(String window) {
		Constants.driver.close();
		log.info("Window close successfully");
	}// end of method

	// 9 This method is used to take screen shot
	public static void takeScreenshot() {
		AShot as = new AShot();
		Date d = new Date();
		SimpleDateFormat Formatter = new SimpleDateFormat("-E, dd MMM yyyy, HH_mm_ss");

		String DateFormat = Formatter.format(d);

		Screenshot sc = as.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Constants.driver);

		try {
			ImageIO.write(sc.getImage(), "PNG",
					new File("C:\\EclipseWorkspace\\Framework\\ScreenShot\\" + DateFormat + ".png"));
			log.info("Screenshot has been taken");
		} catch (IOException e) {

			e.printStackTrace();
		} // End of method

	}

	// 10 This method is used to move mouse cursor to one element to another
	public static void mouseMovement(String locatorType, String locatorValue) {
		Actions bk = new Actions(Constants.driver);
		bk.moveToElement(getWebElement(locatorType, locatorValue)).build().perform();
		log.info("Mouse movement done successfully");
		// getWebElement(locatorType, locatorValue).click();
	}// end of the method

	// 11 This method is used to drag and drop one element to another Not
	public static void dragAndDrop(String locatorType, String locatorValue) {
		Constants.driver.switchTo().frame(locatorValue);
		Actions al = new Actions(Constants.driver);
		al.clickAndHold(getWebElement(locatorType, locatorValue))
				.moveToElement(getWebElement(locatorType, locatorValue)).release().build().perform();
	}// End of method

	// 12 This method is used to upload file
	public static void uploadFile(String locatorType, String locatorValue, String filePath) {
		getWebElement(locatorType, locatorValue).sendKeys(filePath);
		log.info("File is upload successfully");
	}// End of the method

	// 13 This method is used to apply explicit wait on any any particular
	// webelement
	public static void explicitWait(String locatorType, String locatorValue, int timeout) {
		clickOn(Constants.driver, getWebElement(locatorType, locatorValue), timeout);
		log.info("Explicit wait is applied" + timeout);
	}

	public static void clickOn(WebDriver driver, WebElement webElement, int timeout) {
		WebElement locator = null;
		new WebDriverWait(Constants.driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}// End of the explicitWait method

	// 14 This method is used to apply implicit wait
	public static void implicitWait(int time, TimeUnit Timeunit) {
		Constants.driver.manage().timeouts().implicitlyWait(time, Timeunit);
		log.info("Implicite wait is applied for");
	}// End of the method

	// 15 This mehtod is used to close the PopUp
	public static void handlePopUp(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
		Set<String> handler = Constants.driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String Parentwindowid = it.next();
		String childwindowid = it.next();
		Constants.driver.switchTo().window(childwindowid).close();
		log.info("PopUp is handled successfully");
		Constants.driver.switchTo().window(Parentwindowid);
	}// End the of the method

	// 16 This method is used to navigate on external url
	public static void navgateTo(String url) {
		Constants.driver.navigate().to(url);
		log.info("Navigate operation is perform successfully");
	}// End of the method

	// 17 This method is used to navigate forward from the current url
	public static void navgateForward(String url) {
		Constants.driver.navigate().forward();
		log.info("Navigate forward successfully");
	}// End of the method

	// 18 This method is used to navigate back from the current url
	public static void navgateBack(String url) {
		Constants.driver.navigate().back();
		log.info("Navigate backward successfully");
	}// End of the method

	// 19 This method is used to get the links on the current page
	public static void howManyLinksOnPage() {
		// This code will print the links which is not related to images links
		List<WebElement> list = Constants.driver.findElements(By.tagName("a"));
		// This code will print the links which is related to images links
		list.addAll(Constants.driver.findElements(By.tagName("img")));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i).getText();
			System.out.println(s);
			log.info("Total links printed successfully");
		}
	}// End of the method

	// 20 This method is used to accept particular alert
	public static void acceptAlert(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
		Alert alert = Constants.driver.switchTo().alert();
		alert.accept();
		log.info("Alert is accept successfully");
	}// End of the method

	// 21 This method is used to dismiss any particular alert
	public static void dismissAlert(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
		Alert alert = Constants.driver.switchTo().alert();
		alert.dismiss();
		log.info("Alert is dismiss successfully");
	}// End of the method

	// 22 This method is used to get the text of any webelement
	public static void takeTextOfElement(String locatorType, String locatorValue) {
		System.out.println(getWebElement(locatorType, locatorValue).getText());
		log.info("Text is get successfully");
	}// End of the method

	// 23 This method is used to handle any frame
	public static void handleFrame(String locatorType, String locatorValue) {
		// it will create parent handle
		String parenthandle = Constants.driver.getWindowHandle();
		// it will shift the control from parent window to child window
		Constants.driver.switchTo().frame(getWebElement(locatorType, locatorValue));
		log.info("Frame is handled successfully");
		// it will shift the control again on parent window
		Constants.driver.switchTo().window(parenthandle);
	}// End of the method

	// 24 This method is used to check the element is displayed on the page or not
	public static void elementIsDisplayed(String locatorType, String locatorValue) {
		boolean bool = getWebElement(locatorType, locatorValue).isDisplayed();
		System.out.println("Element is present there:" + bool);
		log.info("Element is Displayed" + bool);
	}// End of the method

	// 25 This method is used to check whether a element is clickable or not
	public static void elementIsEnabled(String locatorType, String locatorValue) {
		boolean bool = getWebElement(locatorType, locatorValue).isEnabled();
		System.out.println("Element is Enabled:" + bool);
		log.info("Element is enabled:" + bool);
	}// End of the method

	// 26 This method check whether element is selected or not checkbox, dropdown
	// and Radio buttons
	public static void elementIsSelected(String locatorType, String locatorValue) {
		boolean bool = getWebElement(locatorType, locatorValue).isSelected();
		System.out.println("Element is selected:" + bool);
		log.info("Element is selected:" + bool);
	}// End of the method

	// 27 This method is used to get the title of any web page
	public static void takeTitle() {
		System.out.println(Constants.driver.getTitle());
		log.info("Title get successfully");
	}// End of the method

	// 28 This method is used to handle windows by switching from parent to child
	// window
	public static void handleWindow(String locatorType, String locatorValue) {
		// this is to get the parent handle
		String parentWindowhandle = Constants.driver.getWindowHandle();
		getWebElement(locatorType, locatorValue).click();
		Set<String> allWindows = Constants.driver.getWindowHandles();
		Iterator itr = allWindows.iterator();
		for (String child : allWindows) {
			if (!parentWindowhandle.equals(child)) {
				// this is to switch from parent handle to child handle
				Constants.driver.switchTo().window(child);
			}
		}
	}// End of the method

	// 29 This method is used to get the auto search suggetions of any searching
	// word Not
	public static void getAutoSearchSuggestions(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
		List<WebElement> list = (List<WebElement>) getWebElement(locatorType, locatorValue);
		System.out.println("total number of suggestions in searrch box is===" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
//			if (list.get(i).getText().contains(textToEnter)) {
//				list.get(i).click();
//				break;
		}
	}// End of the method

	// 30 This method is used to handle bootstrapDropDown Not
	public static void bootstrapDropDown(String locatorType, String locatorValue, String enterElementToClick) {
		List<WebElement> list = (List<WebElement>) getWebElement(locatorType, locatorValue);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(enterElementToClick)) {
				list.get(i).click();// this will click on any individual checkbox
				log.info("BootstrapDropDown is successfull");
				break;
			}
		}
	}// End of the method

	// 31 this method is used submit
	public static void submit(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).submit();
		log.info("Submit operation is perform successfully");
	}// End of the method

	// 32 This method is used to select element from dropdown
	public static void handleDropdown(String locatorType, String locatorValue, String text) {
		Select select = new Select(getWebElement(locatorType, locatorValue));
		select.selectByVisibleText(text);
		log.info("Desired Element is selected from given Dropdown");
	}// End of the method

}
