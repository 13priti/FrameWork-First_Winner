Feature: Tutorials Ninja Registration Tests

@Register
Scenario: Verifying user registration
Given User open browser
And User navigates to Application Registration page
When User provides the following details into the input fields
    |firstname      |Deepak					  |
		|lastname       |Pandey						|
		|emailid		    |Saydeep@gmail.com|
		|telephone		  |4568791560				|
		|password	      |12345            |
		|Confirmpassword|12345	          |
		
And User select the privacy policy option	
And Clicks on Continue button
Then Verify user already registered or not
		
		