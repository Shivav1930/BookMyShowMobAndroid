@SmokeTest
Feature: BookMyShow Tickets Booking
Description: The purpose of this feature is to Book the movie tickets

@firstMovie	
    Scenario: Customer can book the ticket
    Given The application is launched
    When  English is selected as the language
    When Movies is selected in the header
    Then Movie name is entered in the field    
    Then proceed to booking
   	When the date and time is selected
   Then accept the terms and conditions
   When seat is selected
   Then Enter the personal details
   
@secondMovie
    Scenario: Customer can book Second Movie sticket
    Given The application is launched
    When  English is selected as the language
    When Movies is selected in the header
    Then I enter the second Movie name in the field
    Then proceed to booking
   	When the date and time is selected
   Then accept the terms and conditions
   When seat is selected
   Then Enter the personal details
    