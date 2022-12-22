package Pages;

import jdk.jfr.Timespan;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage extends DefaultPage{

    WebDriverWait wait;

    public CareersPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='See all teams']")
    WebElement seeAllTeamsButton;

    @FindBy(xpath = "//h3[contains(text(),'Quality Assurance')]")
    WebElement qualityAssButton;


    public void gotoQaPage () throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,2500)");
        Thread.sleep(1000);
        seeAllTeamsButton.click();
        je.executeScript("window.scrollBy(0,3000)");
        qualityAssButton.click();
        cookies.click();
    }

}
