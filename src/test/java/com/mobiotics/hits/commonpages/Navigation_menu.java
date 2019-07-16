package com.mobiotics.hits.commonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation_menu extends BasePage {
	public Navigation_menu() {
		PageFactory.initElements(driver, this);
		
	}
	
	//---------------------This is the payment menu------------------------
	@FindBy(partialLinkText="Add Payment")
	public WebElement payment_AddPayment;
	
	@FindBy(partialLinkText="Pay for Box")
	public WebElement payment_PayForBox;
	
	//-----------------------------This is customer ---------------------------
	
	@FindBy(partialLinkText="Create Customer")
	public WebElement customer_createCustomer;
	
	@FindBy(partialLinkText="List Customer")
	public WebElement customer_ListCustomer;
	
	@FindBy(partialLinkText="Modify Customer")
	WebElement customer_Modify_Customer;
	
	@FindBy(partialLinkText="Subscriber Corner")
	WebElement customer_Subscriber_Corner;
	
	@FindBy(partialLinkText="Customer Selection")
	WebElement customer_customer_selection;
	
	@FindBy(partialLinkText="Refund Request")
	public WebElement customer_RefundRequest;
	
	
	//--------------------------------------This is Product-----------------------------------------
	
	@FindBy(partialLinkText="Add Products")
	WebElement product_AddProduct;
	
	//-----------This is Add Product Sub Menu----------------
	
	@FindBy(partialLinkText="Add Base Plans(FTA)")
	WebElement addProdoct_AddBasePack;
	
	@FindBy(partialLinkText="Add NXT Pay Bouquets")
	WebElement addProduct_AddNXTPayBouquets;
	
	@FindBy(xpath="//a[@href='lcoaddbroadcasterbouquet.php']")
	WebElement addProduct_AddNxtDegitalAddOns;
	
	@FindBy(partialLinkText="Add A-la-carte")
	WebElement add_product_Add_Al_A_carte;
	
	//----------------------------------This is the Add-Al-A-Carte sub Menu of Add product-------------
	
	
	
	
	
	
	@FindBy(partialLinkText="Know Your Products")
	WebElement product_Know_your_Product;
	
	@FindBy(partialLinkText="Connections")
	WebElement product_connections;
	
	@FindBy(partialLinkText="Disconnect")
	WebElement DisconnectLink;
	
	@FindBy(partialLinkText="Reconnect")
	WebElement product_Reconnect;
	
	@FindBy(partialLinkText="Cancel Product")
	WebElement product_CancelProduct;
	
	@FindBy(xpath="//a[@href='lcoaddnxtbouquet.php']")
	WebElement addProduct_AddNxtPayBouquet;
	
	
	
	
	@FindBy(partialLinkText="Activate Pending Plans")
	WebElement product_ActivatePendingPlans;
	
	
	//---------------------------------Renew--------------------------------------------------------------
	@FindBy(partialLinkText="After Expiry")
	WebElement Renew_After_Expiry;
	
	@FindBy(partialLinkText="Before Expiry")
	WebElement Renew_Before_Expiry;
	
	
	//---------------------------------Report-------------------------------------------------------------
	
	@FindBy(partialLinkText="Expiry Report")
	WebElement Report_Expiry_Report;
	
	@FindBy(partialLinkText="Job Report")
	WebElement Report_Job_Report;
	
	@FindBy(partialLinkText="SMS Report")
	WebElement Report_SMS_Report;
	
	@FindBy(partialLinkText="List Payments")
	WebElement Report_List_Payment;
	
	//-----------------------------------------------Device--------------------------------------------------------------
	
	@FindBy(partialLinkText="List Devices")
	WebElement Device_List_Devices;
	
	@FindBy(partialLinkText="OSD")
	WebElement Device_OSD;
	
	@FindBy(partialLinkText="Retrack ACTIVE")
	WebElement Device_Retrack_Active;
	
	@FindBy(partialLinkText="Retrack DEACTIVE")
	WebElement Device_Retrack_Deactivate;
	
	@FindBy(partialLinkText="Hardware Replacement")
	WebElement Device_Hardware_Replacement;
	
	@FindBy(partialLinkText="Suspension")
	WebElement Device_Suspension;
	
	@FindBy(partialLinkText="Remove Suspension")
	WebElement Device_Remove_Suspension;
	
	//----------------------------------this is Ticket Menu------------------------------------------------------------------
		@FindBy(partialLinkText="Create Ticket")
		public WebElement ticket_CreateTicket;
		
		@FindBy(partialLinkText="List Ticket")
		public WebElement ticket_ListTicket;
		
	//------------------------------------this is Profile Menu---------------------------------------------------------
		@FindBy(partialLinkText="My Profile")
		public WebElement profile_MyProfile;
		
		@FindBy(partialLinkText="Add Subuser")
		public WebElement profile_AddSubuser;
		
		@FindBy(partialLinkText="Modify Subuser")
		public WebElement profile_ModifySubuser;
		
		

}
