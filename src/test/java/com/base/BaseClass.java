package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;


	/**
	 * @creationDate 03/10/2022
	 * @Description to launch browser
	 */
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	}
	
	/**
	 * 
	 * @param url
	 * @creationDate 03/10/2022
	 * @Description To load url
	 */

	public static void loadUrl(String url) {
		driver.get(url);

	}
	public static void getUrl(String url) {
		driver.get(url);

	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 * @creationDate 03/10/2022
	 * @Description to pass values
	 */

	public static void sendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	/**
	 * 
	 * @param element
	 * @creationDate 03/10/2022
	 * @Description To click Button
	 */
	
	public static void click(WebElement element) {
		element.click();
	}
	
	/**
	 * 
	 * @param element
	 * @creationDate 03/10/2022
	 * @Description To clear values
	 */
	public static void clear(WebElement element) {
		element.clear();
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @creationDate 03/10/2022
	 * @Description get text from element
	 */

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;

	}
	
/**
 * @creationDate 03/10/2022
 * @Description To Maximize Window
 */
	public static void maximize() {
		driver.manage().window().maximize();

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description To current opened Window
	 */

	public static void closeWindow() {
		driver.close();
	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description To close all opened Windows
	 */

	public static void closeallWindows() {
		driver.quit();
	}
	/**
	 * 
	 * @param idvalue
	 * @return WebElement
	 * @creationDate 03/10/2022
	 * @Description to find locator by id
	 */
	

	public static WebElement findElementById(String idvalue) {
		WebElement idelement = driver.findElement(By.id(idvalue));
		return idelement;

	}
	
	/**
	 * 
	 * @param namevalue
	 * @return WebElement
	 *  @creationDate 03/10/2022
	 * @Description to find locator by Name
	 */

	public static WebElement findElementByNmae(String namevalue) {
		WebElement nameelement = driver.findElement(By.name(namevalue));
		return nameelement;

	}
	
/**
 * 
 * @param classvalue
 * @return WebElement
 *  @creationDate 03/10/2022
 * @Description to find locator by Classname
 */

	public static WebElement findElementByClassName(String classvalue) {
		WebElement classelement = driver.findElement(By.className(classvalue));
		return classelement;

	}

	/**
	 * 
	 * @param xpath
	 * @return WebElement
	 *  @creationDate 03/10/2022
	 * @Description to find locator by xpath
	 */
	
	public static WebElement findElementByXpath(String xpath) {
		WebElement xpathelement = driver.findElement(By.xpath(xpath));
		return xpathelement;

	}
	
	/**
	 * 
	 * @param element
	 * @return String
	 * @creationDate 03/10/2022
	 * @Description to get Attribute value from value
	 */

	public static String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}
	
	/**
	 * 
	 * @param element
	 * @param attributename
	 * @return String
	 * @creationDate 03/10/2022
	 * @Description to get Attribute value from attributename
	 */

	public static String getAttributeValue(WebElement element, String attributename) {
		String attribute = element.getAttribute(attributename);
		return attribute;

	}
	
/**
 * 
 * @param element
 * @return Object
 * @creationDate 03/10/2022
 * @Description to get Attribute value by javaScript
 */
	public static Object getAttributeJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object attribute = executor.executeScript("return arguments[0].getAttribute('value')", element);
		return attribute;
	}
	
	/**
	 * 
	 * @param element
	 * @creationDate 03/10/2022
	 * @Description mouse over action
	 */

	public static void moveToElement(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * 
	 * @param element
	 * @creationDate 03/10/2022
	 * @Description to right Click
	 */

	public static void toRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @return Alert
	 * @creationDate 03/10/2022
     * @Description to navigate Alert box
	 */

	public static Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description accept alert
	 */

	public static void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description dismiss Alert
	 */

	public static void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	/**
	 * 
	 * @param value
	 * @creationDate 03/10/2022
	 * @Description to handle prompt Alert
	 */

	public static void handlePromptAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}
	
	/**
	 * 
	 * @param element
	 * @creationDate 03/10/2022
	 * @Description scrollDown through JavaScript
	 */

	public static void scrollDownJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeAsyncScript("arguments[0].scrollIntoView(true)", element);

	}
	
	/**
	 * 
	 * @param element
	 * @creationDate 03/10/2022
	 * @Description scrollUp through JavaScript
	 */

	public static void scrollUpJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeAsyncScript("arguments[0].scrollIntoView(false)", element);

	}
	
	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @creationDate 03/10/2022
	 * @Description get all options in dropdown
	 */

	public static List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	
	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @creationDate 03/10/2022
	 * @Description get all selected options in dropdown
	 */

	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> alloptions = select.getAllSelectedOptions();
		return alloptions;

	}
	
	/**
	 * 
	 * @param element
	 * @return WebElement
	 *  @creationDate 03/10/2022
	 * @Description get first selected selected options in dropdown
	 */

	public static WebElement getFirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstselected = select.getFirstSelectedOption();
		return firstselected;

	}

	/**
	 * 
	 * @param element
	 * @param index
	 * @creationDate 03/10/2022
	 * @Description select dropdown option by index
	 */
	public static void selectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 * @creationDate 03/10/2022
	 * @Description select dropdown option by value
	 */

	public static void SelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @creationDate 03/10/2022
	 * @Description select dropdown option by Text
	 */
	public static void SelectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @creationDate 03/10/2022
	 * @Description deselect dropdown option by index
	 */
	public static void deSelectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.deselectByIndex(index);

	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 * @creationDate 03/10/2022
	 * @Description deselect dropdown option by value
	 */

	public static void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @creationDate 03/10/2022
	 * @Description deselect dropdown option by text
	 */
	public static void deSelectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);

	}
	
	/**
	 * 
	 * @param element
	 * @creationDate 03/10/2022
	 * @Description deselect all options
	 */

	public static void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 * @creationDate 03/10/2022
	 * @Description isMultiple
	 */

	public static boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	
	/**
	 * 
	 * @param idorname
	 * @creationDate 03/10/2022
	 * @Description switch to frame by id or frame
	 */
	public static void switchToFrameByidOrname(String idorname) {
		driver.switchTo().frame(idorname);

	}
	
	/**
	 * 
	 * @param frameelement
	 * @creationDate 03/10/2022
	 * @Description switch to frame by element
	 */

	public static void switchToFrameByElement(WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}

	/**
	 * 
	 * @param index
	 * @creationDate 03/10/2022
	 * @Description switch to frame by index
	 */
	public static void switchToFrameByindex(int index) {
		driver.switchTo().frame(index);

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description close frames
	 */

	public static void closeFrames() {
		driver.switchTo().defaultContent();

	}
	
	/**
	 * 
	 * @param url
	 * @creationDate 03/10/2022
	 * @Description to navigate url byString
	 */

	public static void navigateToBystring(String url) {
		driver.navigate().to(url);
	}
	
	/**
	 * 
	 * @param url
	 * @creationDate 03/10/2022
	 * @Description launch url by to navigate
	 */

	public static void navigatetobyUrl(URL url) {
		driver.navigate().to(url);

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description to move forward by navigate
	 */

	public static void toMoveForward() {
		driver.navigate().forward();

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description to move backward by navigate
	 */

	public static void toMoveBackward() {
		driver.navigate().back();

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description to refresh by navigate
	 */

	public static void toRefresh() {
		driver.navigate().refresh();

	}
	
	/**
	 * 
	 * @param windowid
	 * @creationDate 03/10/2022
	 * @Description switch To Window By Window Id
	 */

	public static void switchToWindowByWindowId(String windowid) {
		driver.switchTo().window(windowid);

	}
	
	/**
	 * 
	 * @param title
	 * @creationDate 03/10/2022
	 * @Description switch To Window By Window Title
	 */

	public static void switchToWindowByTitle(String title) {
		driver.switchTo().window(title);

	}
	
	/**
	 * 
	 * @param url
	 * @creationDate 03/10/2022
	 * @Description switch To Window By Window url
	 */

	public static void switchToWindowByUrl(String url) {
		driver.switchTo().window(url);

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description get parent window
	 * @return String
	 */

	

	public static void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}
	
	/**
	 * 
	 * @param value
	 * @return List<WebElement>
	 * @creationDate 03/10/2022
	 * @Description find elements by  Id
	 */

	public static List<WebElement> findAllElementsById(String value) {

		List<WebElement> allElements = driver.findElements(By.id(value));
		return allElements;

	}
	
	/**
	 * 
	 * @param value
	 * @return List<WebElement>
	 * @creationDate 03/10/2022
	 * @Description find elements by  Name
	 */
	
	public static List<WebElement> findAllElementsByName(String value) {

		List<WebElement> allElements = driver.findElements(By.name(value));
		return allElements;

	}
	
	/**
	 * 
	 * @param value
	 * @return List<<WebElement>
	 * @creationDate 03/10/2022
	 * @Description find elements by  ClassName
	 */

	public static List<WebElement> findAllElementsByClassName(String value) {

		List<WebElement> allElements = driver.findElements(By.className(value));
		return allElements;

	}
	
	/**
	 * 
	 * 
	 * @param xpath
	 * @return List<WebElement>
	 * @creationDate 03/10/2022
	 * @Description find elements by Xpath
	 */

	public static List<WebElement> findAllElementsByXpath(String xpath) {

		List<WebElement> allElements = driver.findElements(By.xpath(xpath));
		return allElements;

	}
	
	/**
	 * 
	 * @param seconds
	 * @throws InterruptedException
	 * @creationDate 03/10/2022
	 * @Description to temporary halt program
	 */

	public static void TempSleep(long seconds) throws InterruptedException {
		Thread.sleep(seconds);

	}
	
	/**
	 * 
	 * @param sec
	 * @creationDate 03/10/2022
	 * @Description to temporary halt program
	 */

	@SuppressWarnings("deprecation")
	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @creationDate 03/10/2022
	 * @Description get value from config property file
	 */

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");

		Properties properties = new Properties();

		properties.load(stream);

		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	
	/**
	 * 
	 * @param browserType
	 * @creationDate 03/10/2022
	 * @Description to launch Browser
	 */
	public static void getDriver(String browserType) {
		switch(browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
		default:
			break;
		}
		
		}

}
