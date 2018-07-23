package by.htp.selenium.run;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumExample {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe";
	
	private static int count;
	
	public static void main(String[] args) {
		System.setProperty(CHROME, CHROME_PATH);
		WebDriver driver = new ChromeDriver();

		mailru(driver,"http://www.mail.ru");
		
		task3Registration(driver, "http://www.quizful.net");
			
		//driver.close();
		
	}

	public static void mailru(WebDriver driver, String path) {
		driver.get(path);
		WebElement loginElem = driver.findElement(By.id("mailbox:login"));
		loginElem.sendKeys("tathtp");
		WebElement passElem = driver.findElement(By.id("mailbox:password"));
		passElem.sendKeys("Klopik123");
		WebElement submitButton = driver.findElement(By.id("mailbox:submit"));
		submitButton.click();
	}
	
	public static void task3Registration(WebDriver driver, String path) {
		driver.get(path);
		WebElement registration = driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[3]/a"));
		registration.click();
		WebElement loginElem = driver.findElement(By.id("login"));
		loginElem.sendKeys("dmitrov888");
		WebElement passElem = driver.findElement(By.name("registrationForm.password"));
		passElem.sendKeys("44524452klerk");
		WebElement repeatPassElem = driver.findElement(By.name("registrationForm.repassword"));
		repeatPassElem.sendKeys("44524452klerk");
		WebElement mailElem = driver.findElement(By.name("registrationForm.email"));
		mailElem.sendKeys("dmitrov.v888@gmail.com");
		WebElement corpElem = driver.findElement(By.id("corporate"));
		corpElem.click();
		inputCaptcha(driver);
		WebElement submitButton = driver.findElement(By.name("ok"));
		submitButton.click();
	}
	
	private static void inputCaptcha(WebDriver driver) {
		String capchaVal = JOptionPane.showInputDialog("¬ведите capcha  значение");
		driver.findElement(By.name("registrationForm.captcha")).sendKeys(capchaVal);
	}
	
	
}
