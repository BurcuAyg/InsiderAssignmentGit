package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsiderMainPage extends DefaultPage{
    public InsiderMainPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='More']")
    WebElement morebutton;

    @FindBy(xpath = "//h5[normalize-space()='Careers']")
    WebElement careersPageButn;




    public void gotoCareerPage (){
        cookies.click();
        morebutton.click();
        careersPageButn.click();

    }

}
