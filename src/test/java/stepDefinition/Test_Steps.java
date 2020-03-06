package stepDefinition;

import com.bookmyshow.pom.pages.MovieTicketBooking;
import com.bookmyshow.pom.testcases.base.BaseSteps;
import com.bookmyshow.pom.testcases.base.ThreadLocalDriver;
import com.bookmyshow.pom.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps extends BaseSteps{
	
	public ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest startExtent;
	 public static ExtentTest test;

	 @Given("^The application is launched$")
	 public void application_Launched() {
		 System.out.println("hello");
	 }
	 
	   
	 @When("^English is selected as the language$")	
	 public void SelectEngLang () throws Exception
	 {startExtent=extent.startTest("End To End Scenario cucumber");
	 	Thread.sleep(5000);		
		MovieTicketBooking.SelectEngLang(startExtent);
	
	 } 
	 
	 @Then ("^Movies is selected in the header$")
	 public void Movies() throws Exception{		 
		 MovieTicketBooking.Movies(startExtent,(ThreadLocalDriver.getTLDriver()));

	 }
	 
	 @Then("^Movie name is entered in the field$")
	 public void EnterMovieName() throws Exception{		 		 
		MovieTicketBooking.EnterMovieName(startExtent,(ThreadLocalDriver.getTLDriver()));

	 }
	 
	 @Then("^I enter the second Movie name in the field$")
	 public void i_enter_the_second_Movie_name_in_the_field() throws Throwable {
		 MovieTicketBooking.EnterSecondMovieName(startExtent,(ThreadLocalDriver.getTLDriver()));
	 }
	 
	 @Then("^proceed to booking$")
	 public void Book() throws Exception{		 		 
		 MovieTicketBooking.Book(startExtent,(ThreadLocalDriver.getTLDriver()));

	 }
	 @When("^the date and time is selected$")
	 public void DateTime() throws Exception{		 		 
		 MovieTicketBooking.DateTime(startExtent,(ThreadLocalDriver.getTLDriver()));
	 }
	 @Then("^accept the terms and conditions$")
	 public void Tc() throws Exception{		 		 
		 MovieTicketBooking.Tc(startExtent,(ThreadLocalDriver.getTLDriver()));
	 }
	 @When("^seat is selected$")
	 public void Selecttheseats() throws Exception{		 		 
		 MovieTicketBooking.Selecttheseats(startExtent,(ThreadLocalDriver.getTLDriver()));
	 }
	 @Then("^Enter the personal details$")
	 public void Details() throws Exception{		
		 MovieTicketBooking.Details(startExtent,(ThreadLocalDriver.getTLDriver()));
	 } 
	 

}
