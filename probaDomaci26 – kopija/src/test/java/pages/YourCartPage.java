package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class YourCartPage extends BasePage {

    private By cartButton = By.id("shopping_cart_container");

    private By quantity = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]");

    private By checkoutButton = By.id("checkout");

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCartButton() {
        return getDriver().findElement(cartButton);
    }

    public WebElement getQuantity() {
        return getDriver().findElement(quantity);
    }

    public WebElement getCheckoutButton() {
        return getDriver().findElement(checkoutButton);
    }

    public void goToYourCard () {
        getCartButton().click();
    }

    public void goToCheckout () {
        getCheckoutButton().isDisplayed();
        getCheckoutButton().click();
    }
}
