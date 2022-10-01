package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

     private By checkoutPageOpened = (By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
     private By titleCheckout = By.xpath("//*[@id=\"checkout_complete_container\"]/div/text()");
             //("//*[@id=\"header_container\"]/div[2]/span");
     private By firstNameField = By.id("first-name");
     private By lastNameField = By.id("last-name");
     private By zipPostalCode = By.id("postal-code");
     private By continueButton = By.id("continue");

     private By openedOverview = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public CheckoutPage (WebDriver driver) {
        super(driver);
    }

    public WebElement getTitleCheckout() {
        return getDriver().findElement(titleCheckout);
    }

    public WebElement getFirstNameField() {
        return getDriver().findElement(firstNameField);
    }

    public WebElement getLastNameField() {
        return getDriver().findElement(lastNameField);
    }

    public WebElement getZipPostalCode() {
        return getDriver().findElement(zipPostalCode);
    }

    public WebElement getOpenedOverview() {
        return getDriver().findElement(openedOverview);
    }

    public WebElement getCheckoutPageOpened() {
        return getDriver().findElement(checkoutPageOpened);
    }

    public WebElement getContinueButton() {
        return getDriver().findElement(continueButton);
    }

    public void enterValidCredentials (String firstNameB, String lastNameB, String zipPostalCodeZ) {

        getFirstNameField().sendKeys(firstNameB);
        getLastNameField().sendKeys(lastNameB);
        getZipPostalCode().sendKeys(zipPostalCodeZ);

    }

    public void continueBtnClick () {
        getContinueButton().click();
    }

    public void clickOnTitleCheckout () {
        getTitleCheckout().click();
    }

}
