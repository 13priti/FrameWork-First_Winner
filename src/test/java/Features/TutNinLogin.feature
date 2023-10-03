Feature: TutorialsNinja Application Login

@Login 
Scenario Outline: User should only be able to login with valid credential

Given User open any browser
And User navigates to Application Login page
When User enters username as <someusername> and password as <somepassword> into the fields
And User clicks on Login button
Then Verify user should be able to Login based upon <expected_result> login status


Examples:

|someusername         |somepassword |expected_result|
|priti13234@gmail.com |@first123    |Failure|
|babysitting@gmail.com|12345        |Success|

