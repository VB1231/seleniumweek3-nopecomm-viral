package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityTest;

public class TopMenuTest extends UtilityTest{
    @Before
    public void setUp(){
        openBrowser();
    }

    @Test
//1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
//select the Menu and click on it and verify the page navigation.
    public void verifyPageNavigation(){
        String m=getTextOnElement(By.xpath("//body/div[6]/div[2]"));
        selectM(m);
    }
//1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    public void selectM(String m){
        String s=getTextOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]")) ;

        if(m.contains(s)){
            clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        }
    }
    @After
    public void tearDown(){
         closeBrowser();
    }



}
