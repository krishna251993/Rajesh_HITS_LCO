package com.mobiotics.hits.commonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.Device_RetrackActiveDevicePage.RetrackActiveDevicePage;
import com.mobiotics.Device_RetrackDeactiveDevicePage.RetrackDeActiveDevicePage;
import com.mobiotics.Product_ReconnectPage.ProductReconnectPage;
import com.mobiotics.hits.ActvatePendingPlanPage.ActivatePendingPlanPage;
import com.mobiotics.hits.AddNxtDegital_AddonsPage.AddNxt_PayBouquet_Page;
import com.mobiotics.hits.AddNxt_Pay_Bouquets.AddNxtPayBouquet1Page;
import com.mobiotics.hits.BeforeExpiryPageTest.BeforeExpiryPage;
import com.mobiotics.hits.CreateCustomer.CreateCustomerPage;
import com.mobiotics.hits.Customer_RefundRequestPage.Customer_Refund_RequestPage;
import com.mobiotics.hits.Customer_RefundRequestPage.Customer_Refund_RequestPage_New;
import com.mobiotics.hits.Customer_SubscriberCornerPage.SubscriberCornerPage;
import com.mobiotics.hits.DeviceSuspensionPage.DeviceSuspensionPage;
import com.mobiotics.hits.JobReportPageTest.JobReportPage;
import com.mobiotics.hits.ListDevicePageTest.ListDevicePage;
import com.mobiotics.hits.OSDPage.OSDMessageServicePage;
import com.mobiotics.hits.Renew_AfterExpiryPage.AfterExpiryPage;
import com.mobiotics.hits.Report_ExpiryReportPage.ExpiryReportPage;
import com.mobiotics.hits.Report_ListPayments.ListPaymentPage;
import com.mobiotics.hits.customer_CustomerModification.CustomerModificationPage;
import com.mobiotics.hits.customer_ListCustomer.ListCustomerPage;

import com.mobiotics.hits.paymentmenu_AddPayment.AddPaymentPage;
import com.mobiotics.hits.paymentmenu_PayForBox.PayForBox;
import com.mobiotics.hits.product_AddProduct_AddBasePackPage.Product_AddProduct_AddBasePackPage;
import com.mobiotics.hits.product_Addproduct_AddALCartePage.AddAla_CartePage;
import com.mobiotics.hits.product_CancelPeroduct.CancelProductTestPage;
import com.mobiotics.hits.product_ProductDisconnect.ProductDisconnectPage;


import generic.Property;

public class HomePage extends Navigation_menu {
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(partialLinkText="Dashboard")
	private WebElement dashboardMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Payment')]")
	private WebElement paymentsMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Customer')]")
	private WebElement customersMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Product')]")
	private WebElement productMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Renew')]")
	private WebElement renewMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Report')]")
	private WebElement reportMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Device')]")
	private WebElement deviceMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Ticket')]")
	private WebElement ticketMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Profile')]")
	private WebElement profileMenu;

	@FindBy(partialLinkText="Logout")
	private WebElement logout;
	
	
	//----------------------------------------This is for Customer_Refund Request---------------------------------
	
	public Customer_Refund_RequestPage_New navigateTo_refundRequestPage() {
		customersMenu.click();
		waitTillElementIsVisible(customer_RefundRequest);
		customer_RefundRequest.click();
		return new Customer_Refund_RequestPage_New();
		
	}
	
	
	
	//---------------This is Dash-Bord menu---------------------------------------
	public void nevigateToDashBoard_DashBoard() {
		dashboardMenu.click();
	}
	
	//-----------------------------------This is Payment_List Payment-----------------------
	public AddPaymentPage navigateToPaymentMenu_AddPayment() {
		paymentsMenu.click();
		waitTillElementIsVisible(payment_AddPayment);
		payment_AddPayment.click();
		
		return new AddPaymentPage();
	}
	
	
	//---------------------This is payment_List Payment-----------------------------------
	
	public ListPaymentPage navigateToPaymentMenu_ListPayment()
	{
		reportMenu.click();// here we need to modified in the code
		waitTillElementIsVisible(Report_List_Payment);
		Report_List_Payment.click();
		return new ListPaymentPage();
	}
	
	//---------------------This is the Payment_menu PayForBox--------------------------------
	public PayForBox navigateToPaymentMenu_PayForBoxPage() {
		paymentsMenu.click();
		waitTillElementIsVisible(payment_PayForBox);
		payment_PayForBox.click();
		return new PayForBox();
	}
	
	public CreateCustomerPage navigateToCustomerMenu_CreateCustomer() {
		customersMenu.click();
		waitTillElementIsVisible(customer_createCustomer);
		customer_createCustomer.click();
		return new CreateCustomerPage();
		
	}
	
	//--------------------------This is the List Customer Page-----------------------
	
	public ListCustomerPage navigateToCustomerMenu_ListCustomer() {
		customersMenu.click();
		waitTillElementIsVisible(customer_ListCustomer);
		customer_ListCustomer.click();
		return new ListCustomerPage();
	}
	
	//----------------------------This is modification of customer--------------------
	
	public CustomerModificationPage navigateToCustomerMenu_ModifyCustomer() {
		customersMenu.click();
		waitTillElementIsVisible(customer_Modify_Customer);
		customer_Modify_Customer.click();
		return new CustomerModificationPage();
		
	}
	
	
	public SubscriberCornerPage navigateToCustomerMenu_SubscriberCornerPage()
	{
		deviceMenu.click();
		waitTillElementIsVisible(customer_Subscriber_Corner);
		customer_Subscriber_Corner.click();
		return new SubscriberCornerPage();
	}
	
	//---------------This is Product_AddBasePackPage-----------------------
	
	public Product_AddProduct_AddBasePackPage navigateToProductMenu_AddBasePackPage() {
		productMenu.click();
		waitTillElementIsVisible(product_AddProduct);
		Property.action_Move_To_Element(driver, product_AddProduct);
		waitTillElementIsVisible(addProdoct_AddBasePack);
		addProdoct_AddBasePack.click();
		return new Product_AddProduct_AddBasePackPage();
	}
	
	//---------------This is Product_AddAlACartePackPage-----------------------

	
	public AddAla_CartePage nevigateToProductMenu_AddAl_A_CtrePage() {
		productMenu.click();
		Property.action_Move_To_Element(driver, product_AddProduct);
		waitTillElementIsVisible(add_product_Add_Al_A_carte);
		
		add_product_Add_Al_A_carte.click();
		return new AddAla_CartePage();
	}
	
	
	//-----------------------------This is Product_AddNxtPayBouquet----------------------------------------------

	public AddNxt_PayBouquet_Page navigateToProductMenu_AddNxtPayBouquet() {
		productMenu.click();
		Property.action_Move_To_Element(driver, product_AddProduct);
		waitTillElementIsVisible(addProduct_AddNxtDegitalAddOns);
		addProduct_AddNxtDegitalAddOns.click();
		return new AddNxt_PayBouquet_Page();
	}

	/*
	public AddAla_CartePage navigateToProductMenu_AddAlaCartePage() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	//-----------------------------------This is for Product_Disconnect-------------------------------
	
	public ProductDisconnectPage navigateToProductMenu_ProductDisconnectPage() {
		productMenu.click();
		waitTillElementIsVisible(product_connections);
		Property.action_Move_To_Element(driver, product_connections);
		waitTillElementIsVisible(DisconnectLink);
		DisconnectLink.click();
		return new ProductDisconnectPage();
		
	}
	
	
	//-------------------------------This is for Product_Reconnect-Page--------------------------------------
	
	
	public ProductReconnectPage navigateToProductMenue_ProductReconnectPage() {
		productMenu.click();
		
		waitTillElementIsVisible(product_connections);
		Property.action_Move_To_Element(driver, product_connections);
		waitTillElementIsVisible(product_Reconnect);
		
		product_Reconnect.click();
		return new ProductReconnectPage();
		
	}
	
	
	//------------------------------Add plane 2nd option-----------------------------
	
	public AddNxtPayBouquet1Page navigateToProductMenu_AddNxtPayBouquet1() {
		productMenu.click();
		Property.action_Move_To_Element(driver, product_AddProduct);
		waitTillElementIsVisible(addProduct_AddNxtPayBouquet);
		addProduct_AddNxtPayBouquet.click();
		return new AddNxtPayBouquet1Page();
	}
	
	
	//--------------------This is the Activate Pending Plan----------------------
	
	public ActivatePendingPlanPage navigateToProductMenu_ActivatePendingPlans()
	{
		productMenu.click();
		waitTillElementIsVisible(product_connections);
		Property.action_Move_To_Element(driver, product_connections);
		waitTillElementIsVisible(product_ActivatePendingPlans);
		product_ActivatePendingPlans.click();
		return new ActivatePendingPlanPage();
	}
	
	
	//---------------------------------------this is Report_ExpiryReportPage----------------------------------------------
	
	public ExpiryReportPage navigateToReportMenu_ExpiryReportPage()
	{
		reportMenu.click();
		waitTillElementIsVisible(Report_Expiry_Report);
		Report_Expiry_Report.click();
		return new ExpiryReportPage();
		
		
	}
	
	//-------------------------This is Report_JobReport-------------------------
	
	public JobReportPage navigateToReportMenu_JobReportPage()
	{
	
		reportMenu.click();
		waitTillElementIsVisible(Report_Job_Report);
		Report_Job_Report.click();
		return new JobReportPage();
		
	}
	
	//----------------------------------This is Device_ListDevicePage------------------------------------------
	
	public ListDevicePage navigateToDeviceMenu_ListDevicePage()
	{
		deviceMenu.click();
		waitTillElementIsVisible(Device_List_Devices);
		Device_List_Devices.click();
		return new ListDevicePage();
	} 
	
	
	//This is Device_OSD Mesage ServicePage-----------------------
	public OSDMessageServicePage navigateToDeviceMenu_OsdMesssageServicePage()
	{
		deviceMenu.click();
		waitTillElementIsVisible(Device_OSD);
		Device_OSD.click();
		return new OSDMessageServicePage();
	}
	
	
	//-------------------This for device Re-Track of the active devices--------------------------
	
	
	
	public RetrackActiveDevicePage navigateToDeviceMenu_RetrackActiveDevicePage()
	{
		deviceMenu.click();
		waitTillElementIsVisible(Device_Retrack_Active);
		Device_Retrack_Active.click();
		return new RetrackActiveDevicePage();
	}
	
	//---------------------------This ReTrack-De-Active Device-------------------------------
	
	
	public RetrackDeActiveDevicePage navigateToDeviceMenu_RetrackDeactiveDevivePage() {
		deviceMenu.click();
		waitTillElementIsVisible(Device_Retrack_Deactivate);
		Device_Retrack_Deactivate.click();
		return new RetrackDeActiveDevicePage();
	}
	
	
	//--------------------This is Renew_AfterExpiryPage-----------------------
	
	public AfterExpiryPage navigateToRenewMenu_AfterExpiryPage()
	{
		renewMenu.click();
		waitTillElementIsVisible(Renew_After_Expiry);
		Renew_After_Expiry.click();
		return new AfterExpiryPage();
	}
	
	//-----------------------This is Renew-BeforeExpiryPage------------------------------
	
	
	public BeforeExpiryPage navigateToRenewMenu_BeforeExpiryPage() {
		renewMenu.click();
		
		waitTillElementIsVisible(Renew_Before_Expiry);
		Renew_Before_Expiry.click();
		return new BeforeExpiryPage();
	}
	
	
	//-------------------------This Is Renew_Before Expiry page-------------------
	/*
	public BeforeExpiryPage navigateToRenewMenu_BeforeExpiryPage()
	{
		renewMenu.click();
		waitTillElementIsVisible(Renew_Before_Expiry);
		Renew_Before_Expiry.click();
		return new BeforeExpiryPage();
	}
	*/
	//---------------------------This is the product_Cancel Product---------------------
	
	public CancelProductTestPage navigateToProduct_CancelProduct() {
        productMenu.click();
		
		waitTillElementIsVisible(product_connections);
		Property.action_Move_To_Element(driver, product_connections);
		waitTillElementIsVisible(product_CancelProduct);
		
		product_CancelProduct.click();
		return new CancelProductTestPage();
	}
	
	//======================Device SuspensionPage========================
	
	
	public DeviceSuspensionPage navigateToSuspensionPage()
	{
		deviceMenu.click();
		waitTillElementIsClickable(Device_Suspension);
		Device_Suspension.click();
		return new DeviceSuspensionPage();
	}
	
	
	//this is for device Remove-Suspension page-------------------------
	/*
	public DeviceRemoveSuspensionPage navigateToRemoveSuspensionPage()
	{
		deviceMenu.click();
		waitTillElementIsClickable(Device_Remove_Suspension);
		Device_Remove_Suspension.click();
		return new DeviceRemoveSuspensionPage();
	}
	*/
}
