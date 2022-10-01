package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProductsPage extends BasePage {

    private By productOne = By.id("item_4_title_link");
    private By addToCardBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By numberOfProductsInCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    public ProductsPage (WebDriver driver) {
        super(driver);
    }

    public WebElement getProductOne() {
        return getDriver().findElement(productOne);
    }

    public WebElement getAddToCardBtn() {
        return getDriver().findElement(addToCardBtn);
    }

    public WebElement getNumberOfProductsInCart() {
        return getDriver().findElement(numberOfProductsInCart);
    }

    public void addOneProduct () {
        getProductOne().isDisplayed();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getAddToCardBtn().click();
    }

    public void productsInCart () {
        getNumberOfProductsInCart().isDisplayed();
    }

}
