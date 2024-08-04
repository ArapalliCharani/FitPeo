package WebDriverUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public  WebDriver driver;
	
	// Launch Browser
    public void initializeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    // basic actions which are common for whole application like navigate clear etc
    public void navigateTo(String url) {
        if (driver == null) {
            initializeDriver();
        }
        driver.get(url);
    }
    public void clear(WebElement element) {
    	element.clear();
    }
    public void javascriptClick(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void click(WebElement element) {
    	element.click();
    }
    public void sendInt(WebElement element,int num) {
    	String numberStr = Integer.toString(num);
        for (char digit : numberStr.toCharArray()) {
            element.sendKeys(String.valueOf(digit));
        }
    }
    public void sendText(WebElement element,int i) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].value=arguments[1];", element, i);
    	
    }
	public void scrollBy(int x,int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}
	public String gettext(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = (String) js.executeScript("return arguments[0].value;", element);
		return text;
	}
	public String getString(WebElement element) {
		return element.getText();
	}
	//code for action done on application
	public void slider() {
		WebElement SliderHandle=driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']//following::span[3]"));
		Actions actions = new Actions(driver);
        actions.dragAndDropBy(SliderHandle,108, 0) // Drag slider by 200 pixels horizontally
               .perform();
	}
	public void SliderTextBox() throws InterruptedException {
		WebElement slidertextbox=driver.findElement(By.id(":R57alklff9da:"));
		String text=gettext(slidertextbox);
		System.out.println("the value of textbox is:" + text);
		Thread.sleep(5000);
        for (int i = 0; i <text.length(); i++) {
            slidertextbox.sendKeys(Keys.BACK_SPACE);
            // Adding a short sleep to visualize the process, can be removed in real scenarios
            Thread.sleep(5000); 
         }
        sendInt(slidertextbox,520);
	}
	public void Slidervalue() throws InterruptedException {
		WebElement SliderHandle=driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']//following::span[3]"));
		WebElement SliderHandleValue=driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']//following::span[4]//input"));
		System.out.println("The value of slider is " + gettext(SliderHandleValue));
		Actions actions = new Actions(driver);
        actions.dragAndDropBy(SliderHandle, 84, 0) // Drag slider by 200 pixels horizontally
               .perform();
		
	}
	public void CPTValues() {
		WebElement CPTOne_chckbox=driver.findElement(By.xpath("//p[text()='CPT-99091']//following::input[1]"));
		WebElement CPTTwo_chckbox=driver.findElement(By.xpath("//p[text()='CPT-99453']//following::input[1]"));
		WebElement CPTThree_chckbox=driver.findElement(By.xpath("//p[text()='CPT-99454']//following::input[1]"));
		WebElement CPTFour_chckbox=driver.findElement(By.xpath("//p[text()='CPT-99474']//following::input[1]"));
		javascriptClick(CPTOne_chckbox);
		javascriptClick(CPTTwo_chckbox);
		javascriptClick(CPTThree_chckbox);	
		javascriptClick(CPTFour_chckbox);
	}
	public void HeaderValue() {
		WebElement header=driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']"));
		WebElement headervalue=driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']//following::p[1]"));
		String stringOne=getString(header);
		String stringtwo=getString(headervalue);
		System.out.println(stringOne +":"+ stringtwo);
	}
}