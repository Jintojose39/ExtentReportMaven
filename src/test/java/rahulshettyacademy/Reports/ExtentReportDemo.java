package rahulshettyacademy.Reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;

	@BeforeTest()

	public void config() {
		// ExtendeReport,ExtendedSparkReports
		String path = System.getProperty("user.dir") + "\\reports\\indes.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		// to change the report name

		reporter.config().setReportName("Web Automation Report");

		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();

		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Jinto Jose");

	}

	@Test
	public void initialDemo() {

		ExtentTest test=extent.createTest("Initial Demo");
		System.setProperty("WebDriver.ChromeDriver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		System.out.println(driver.getTitle());
		
		driver.close();
		
		test.fail("Results do not match");
		
		extent.flush();
	}

}
