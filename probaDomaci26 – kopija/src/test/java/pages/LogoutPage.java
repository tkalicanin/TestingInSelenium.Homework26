package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage {

    private By menuButton = By.id("react-burger-menu-btn");

    private By logoutButton = By.id("logout_sidebar_link");

    public LogoutPage (WebDriver driver) {
        super(driver);
    }

    public WebElement getMenuButton () {
        return getDriver().findElement(menuButton);
    }

    public WebElement getLogoutButton () {
        return getDriver().findElement(logoutButton);
    }

    public void clickOnLogoutButton () {
        getMenuButton().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getLogoutButton().click();
    }

}
