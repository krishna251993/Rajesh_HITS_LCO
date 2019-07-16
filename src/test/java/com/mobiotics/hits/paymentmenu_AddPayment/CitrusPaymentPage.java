package com.mobiotics.hits.paymentmenu_AddPayment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;

public class CitrusPaymentPage extends BasePage {

	public CitrusPaymentPage() 
    {
		PageFactory.initElements(driver, this);
	 }
    
    @FindBy(xpath="//div[@class='brandlogo']")
    private WebElement NxtDigitalBrandLogo;
    
    @FindBy(xpath="//input[@id='systemp_Mobile']")
    private WebElement enterMobileNumber;
    
    @FindBy(xpath="//input[@id='systemp_Email']")
    private WebElement enterEmailId;
    
    @FindBy(xpath="//input[@id='systemp_firstName']")
    private WebElement enterFirstName;
    
    @FindBy(xpath="//input[@id='systemp_lastName']")
    private WebElement enterLastName;
    
    @FindBy(xpath="//button[@id='register']")
    private WebElement clickToRegister;
    
    @FindBy(xpath="//li[@class='active']//a")
    private WebElement clickForCardPayments;
    
    @FindBy(xpath="//input[@id='cardNumber']")
    private WebElement enterCardNumber;
    
    @FindBy(xpath="//input[@id='cardExp']")
    private WebElement enterExpireDate;
    
    @FindBy(xpath="//input[@id='cardCvv']")
    private WebElement enterCvvNumber;
    
    @FindBy(xpath="//input[@id='cardHolder']")
    private WebElement enterCardHolderName;
    
    @FindBy(xpath="//button[@id='citrusCardPayButton']")
    private WebElement citrusCardPayButton;
    
    @FindBy(xpath="//button[@id='register']")
    private WebElement clickToContinue;
    
    
    public void goToCirtusPaymentPage() throws InterruptedException
    {
   	 waitTillElementIsVisible(enterMobileNumber);
   	 enterMobileNumber.sendKeys("9535985980");
   	 
   	 waitTillElementIsVisible(enterEmailId);
   	 enterEmailId.sendKeys("santhosh.shiva@mobiotics.com");
   	 
   	 clickToContinue.click();
   	 Thread.sleep(5000);
   	 
   	/* waitTillElementIsVisible(enterFirstName);
   	 enterFirstName.sendKeys("santhosh");
   	 
   	 waitTillElementIsVisible(enterLastName);
   	 enterLastName.sendKeys("S");
   	 
   	 waitTillElementIsVisible(clickToRegister);
   	 clickToRegister.click();
   	 
   	 
   	 
   	 waitTillElementIsVisible(clickForCardPayments);
   	 clickForCardPayments.click();*/
   	 
   	 waitTillElementIsVisible(enterCardNumber);
   	 enterCardNumber.sendKeys("5123 4567 8901 2346");
   	 
   	 waitTillElementIsVisible(enterExpireDate);
   	 enterExpireDate.sendKeys("12/17");
   	 
   	 waitTillElementIsVisible(enterCvvNumber);
   	 enterCvvNumber.sendKeys("123");
   	 
   	 waitTillElementIsVisible(enterCardHolderName);
   	 enterCardHolderName.sendKeys("test");
   	 
   	 waitTillElementIsVisible(citrusCardPayButton);
   	 citrusCardPayButton.click();
    }
   
}
