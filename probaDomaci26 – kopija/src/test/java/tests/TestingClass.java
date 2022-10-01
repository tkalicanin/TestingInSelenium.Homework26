package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class TestingClass {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private LogoutPage logoutPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\3200g\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        driver.manage().window().fullscreen();

        loginPage = new LoginPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");
        String expectedResult = "Swag Labs";
        String actualResult = loginPage.getDriver().getTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAddToCart () {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addOneProduct();
        Assert.assertTrue(productsPage.getNumberOfProductsInCart().isDisplayed());
    }

    @Test
    public void testQuantityOfProducts () {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addOneProduct();
        yourCartPage.goToYourCard();
        yourCartPage.getCartButton().click();
        yourCartPage.getQuantity();
        Assert.assertTrue(yourCartPage.getQuantity().isDisplayed());
    }

    @Test
    public void testGoToCheckoutPage () {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addOneProduct();
        yourCartPage.getCartButton().click();
        checkoutPage.getCheckoutPageOpened();
        Assert.assertTrue(checkoutPage.getCheckoutPageOpened().isDisplayed());
    }

    @Test
    public void testCheckoutPage () {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addOneProduct();
        yourCartPage.getCartButton().click();
        checkoutPage.getCheckoutPageOpened();
        yourCartPage.getCheckoutButton().click();
        checkoutPage.enterValidCredentials("RandomName", "RandomLastName", "23456");
        checkoutPage.continueBtnClick();
        Assert.assertTrue(checkoutPage.getOpenedOverview().isDisplayed());
    }

    @Test
    public void testCheckoutOverview () {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addOneProduct();
        yourCartPage.getCartButton().click();
        checkoutPage.getCheckoutPageOpened();
        yourCartPage.getCheckoutButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkoutPage.enterValidCredentials("RandomName", "RandomLastName", "23456");
        checkoutPage.continueBtnClick();
        checkoutOverviewPage.getFinishButton().click();
        String expectedResult = "CHECKOUT: COMPLETE!";
        String actualResult = checkoutOverviewPage.getCheckoutCompleteTitle().getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

     @Test
     private void testLogout (){
         loginPage.login("standard_user", "secret_sauce");
         productsPage.addOneProduct();
         yourCartPage.getCartButton().click();
         yourCartPage.getCheckoutButton().click();
         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         checkoutPage.enterValidCredentials("RandomName", "RandomLastName", "23456");
         checkoutPage.continueBtnClick();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
         checkoutOverviewPage.getFinishButton().click();
         logoutPage.clickOnLogoutButton();
         Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
     }

     @Test
     public void cannotOpenCartWithoutLogin () {
         loginPage.login("standard_user", "secret_sauce");
         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         logoutPage.clickOnLogoutButton();
         driver.get("https://www.saucedemo.com/cart.html ");
         WebElement message = driver.findElement
                (By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
         String expectedResult = "Epic sadface: You can only access '/cart.html' when you are logged in.";
         String actualResult = message.getText();
         Assert.assertEquals(expectedResult, actualResult);
     }

     @AfterMethod
     public void afterMethod() {
         driver.quit();
     }

     @AfterClass
     public void afterClass () {
        driver.quit();
     }

}
