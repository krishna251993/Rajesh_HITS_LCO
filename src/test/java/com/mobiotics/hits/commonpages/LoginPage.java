package com.mobiotics.hits.commonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.constants.BaseTest;

public class LoginPage extends BaseTest {

	
	public LoginPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	@FindBy(xpath="//div[@class='first form-group']//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath="//div[@class='form-group']//input[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-info']")
	private WebElement btnLogin;
	
	public void setUserName(String UserName)
	{
		userName.sendKeys(UserName);
	}
	
	public void setPassword(String pw)
	{
		txtPassword.sendKeys(pw);
	}
	
	public void clickToProceed() {
		btnLogin.click();
	}
	
	public void login(String un,String pw)
	{
		setUserName(un);
		setPassword(pw);
		clickToProceed();
	}
}
