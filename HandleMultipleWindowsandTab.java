package LearnSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindowsandTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prave\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		String oldwindow = driver.getWindowHandle();
		//Handling with new Tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("http://leafground.com/pages/Button.html");
		
		 String Currentwindow = driver.getWindowHandle(); 
		 driver.switchTo().window(oldwindow);
		 WebElement start = driver.findElement(By.xpath("//button[@id='home']")); 
		 start.click();
		 Set<String> newwindows = driver.getWindowHandles(); 
		 for (String opennew : newwindows) 
		 { 
		 driver.switchTo().window(opennew); 
		 } 
		 WebElement newclick = driver.findElement(By.xpath("//*[@alt='Buttons']")); 
		 newclick.click();
		 driver.quit(); 
		 driver.switchTo().window(Currentwindow);
		 
		
	}

}
