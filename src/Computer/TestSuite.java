package Computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.UtilityTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends UtilityTest {
    @Before
    public void setUp(){
        openBrowser();
    }
    @Test
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBeticalOrder(){
         //1.1 Click on Computer Menu.
        //1.2 Click on Desktop
        WebElement computer= driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
       WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //WebElement desktop= driver.findElement(By.xpath("////li[@class='active last']//a[contains(text(),'Desktops ')]"));
        Actions a= new Actions(driver);
        a.moveToElement(computer).moveToElement(desktop).click().build().perform();
        //1.3 Select Sort By position "Name: Z to A"
        //1.4 Verify the Product will arrange in Descending order.
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectByTextFromVisibleDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        List<WebElement> manageBookingList= driver.findElements(By.xpath("//span[contains(text(),'Sort by')]"));
        List<String> beforeSorted = new ArrayList<String>();
        for(WebElement p:manageBookingList){
            beforeSorted.add(p.getText());
        }
        selectByTextFromVisibleDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        List<WebElement> manageBookingList1= driver.findElements(By.xpath("//span[contains(text(),'Sort by')]"));
        List<String> afterSorted = new ArrayList<String>();
        for(WebElement q:manageBookingList){
            afterSorted.add(q.getText());
        }
        Collections.sort(beforeSorted);
       Assert.assertEquals(beforeSorted,afterSorted);
          }
          @Test
          //2. Test name verifyProductAddedToShoppingCartSuccessFully()
          public void verifyProductAddedToShoppingCartSuccessFully()throws StaleElementReferenceException,InterruptedException {
             //2.1 Click on Computer Menu.
              //2.2 Click on Desktop
              WebElement computer= driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
              WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
              Actions a= new Actions(driver);
              a.moveToElement(computer).moveToElement(desktop).click().build().perform();
              clickOnElement(By.xpath("//select[@id='products-orderby']"));
              driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
              //2.3 Select Sort By position "Name: A to Z"
              selectByTextFromVisibleDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");
             // 2.4 Click on "Add To Cart"
              //2.5 Verify the Text "Build your own computer"
             String msg="Build your own computer";
             Assert.assertEquals(msg, getTextOnElement(By.xpath("//h1[contains(text(),'Build your own computer')]")));
             //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
              clickOnElement(By.id("product_attribute_1"));
            selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_1']"),1);
            //2.7.Select "8GB [+$60.00]" using Select class.
            clickOnElement(By.id("product_attribute_2"));
              selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"),3);
              //2.8 Select HDD radio "400 GB [+$100.00]"
              clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
             // clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
              clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
              //2.11 Verify the price "$1,475.00"
              String  a1="$1,465.00";
              Assert.assertEquals(a1,getTextOnElement(By.xpath("//span[@id='price-value-1'and contains(text(),'$1,465.00')]")));
              //2.12 Click on "ADD TO CARD" Button.
              clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
              //2.13 Verify the Message "The product has been added to your shopping cart" on Top
              String aMsg="The product has been added to your shopping cart";
              Assert.assertEquals(aMsg, getTextOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]")));
              clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
              clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
              //Thread.sleep(200);
              //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
             mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
             //2.15 Verify the message "Shopping cart"
              String actual="Shopping cart";
              Assert.assertEquals(actual,getTextOnElement(By.xpath("//span[contains(text(),'Shopping cart')]")));
             clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
            // clickOnElement(By.xpath("//input[@id='itemquantity11253' and @class='qty-input']"));
             // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
            driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]")).clear();
             setTextOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]"),"2");
            clickOnElement(By.xpath("//button[@id='updatecart']"));
            //2.17 Verify the Total"$2,950.00"
            String actMsg="$2,930.00";
            Assert.assertEquals(actMsg,getTextOnElement(By.xpath("//span[@class='value-summary' and contains(text(),'$2,930.00')]")));
            //2.18 click on checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
            //2.19 Click on “CHECKOUT”
            clickOnElement(By.xpath("//button[@id='checkout']"));
            //2.20 Verify the Text “Welcome, Please Sign In!”
            String actMs="Welcome, Please Sign In!";
              //2.21Click on “CHECKOUT AS GUEST” Tab
            Assert.assertEquals(actMs,getTextOnElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
            //2.22 Fill the all mandatory field
            clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
            setTextOnElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Viral");
            setTextOnElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Brahm");
            setTextOnElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"xyz1@gmail.com");
            clickOnElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
            selectByIndexFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),1);
            clickOnElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
           selectByTextFromVisibleDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"AA (Armed Forces Americas)");
           setTextOnElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Alaska");
           setTextOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/input[1]"),"12 Avenue");
           setTextOnElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"wd23 3sd");
           setTextOnElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"01245666");
           //2.23 Click on “CONTINUE”
           clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button' and@name='save']"));
           //2.24 Click on Radio Button “Next Day Air($0.00)”
           clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/input[1]"));
          //2.25 Click on “CONTINUE”
           clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
           clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/input[1]"));
          //2.26 Select Radio Button “Credit Card”
           clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
           clickOnElement(By.xpath("//select[@id='CreditCardType']"));
           //2.27 Select “Master card” From Select credit card dropdown
           selectByTextFromVisibleDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
           //2.28 Fill all the details
           setTextOnElement(By.xpath("//input[@id='CardholderName']"),"viral Brahm");
           setTextOnElement(By.xpath("//input[@id='CardNumber']"),"1234 4564 2521 123");
           clickOnElement(By.xpath("//select[@id='ExpireMonth']"));
         selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"),3);
         clickOnElement(By.xpath("//select[@id='ExpireYear']"));
         selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"),3);
         setTextOnElement(By.xpath("//input[@id='CardCode']"),"123");
         //2.29 Click on “CONTINUE”
         clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
       /*Element(By.xpath("//label[contains(text(),'Credit Card')]")));
         clickOnElement(By.xpath("//h2[contains(text(),'Shipping method')]"));
         String aM="Next Day Air ($0.00)";
        Assert.assertEquals(aM,getTextOnElement(By.xpath("//label[contains(text(),'Next Day Air ($0.00)')]")));*/
       // mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
       // String ex="$2,930.00";
       // Assert.assertEquals(ex,getTextOnElement(By.xpath("//body[1]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/strong[1]")));
              //2.30 Verify “Payment Method” is “Credit Card”
              //2.32 Verify “Shipping Method” is “Next Day Air”
              //2.33 Verify Total is “$2,950.00”
              mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        String ex="$2,930.00";
        Assert.assertEquals(ex,getTextOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]")));
              //2.34 Click on “CONFIRM”
       clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
              //2.34 Click on “CONFIRM”
              clickOnElement(By.xpath(" //h2[contains(text(),'Confirm order')]"));
         //2.35 Verify the Text “Thank You”
          String eX="Thank you";
          Assert.assertEquals(eX,getTextOnElement(By.xpath("//h1[contains(text(),'Thank you')]")));
          //2.36 Verify the message “Your order has been successfully processed!”
          String eX1="Your order has been successfully processed!";
          Assert.assertEquals(eX1,getTextOnElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
          //2.37 Click on “CONTINUE”
               clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
               //2.37 Verify the text “Welcome to our store”
            String eXM="Welcome to our store";
            Assert.assertEquals(eXM,getTextOnElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));

          }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
