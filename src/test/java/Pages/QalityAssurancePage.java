package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class QalityAssurancePage extends DefaultPage{

    public QalityAssurancePage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement seeAllJobs;

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    WebElement filterLocation;

    @FindBy(xpath = "//ul[contains(@class,'select2-results__options')]//li[14]")
    WebElement istanbulTurkey;

    @FindBy(xpath = "//div[@class='position-list-item col-12 col-lg-4 qualityassurance istanbul-turkey full-timeremote']//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'][normalize-space()='Apply Now']")
    WebElement ApplyNow;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void fiterQaJobs () throws InterruptedException {
        Thread.sleep(1000);
        seeAllJobs.click();
        js.executeScript("window.scrollBy(0,100)");
        cookies.click();
        filterLocation.click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        js.executeScript( "document.querySelector(\".select2-results__options\").scrollBy(0,400)");
        Thread.sleep(1000);
        istanbulTurkey.click();
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(1000);
        ApplyNow.click();
    }
    public void checkAllJobContainQA () {
        List <WebElement> allQAOptions = driver.findElements(By.xpath("//div[@id='jobs-list']//div//div//span"));
        List <WebElement> QAnamelist = allQAOptions.stream().filter(s->s.getText().contains("Quality Assurance")).collect(Collectors.toList());
        Assert.assertEquals(allQAOptions.size(),QAnamelist.size());
    }

    public void checkAllJobContainIstanbulTurkey () {
        List <WebElement> allOptions = driver.findElements(By.xpath("//div[@id='jobs-list']//div//div//div"));
        List <WebElement> namelist = allOptions.stream().filter(s->s.getText().contains("Istanbul, Turkey")).collect(Collectors.toList());
        Assert.assertEquals(allOptions.size(),namelist.size());
    }

}
