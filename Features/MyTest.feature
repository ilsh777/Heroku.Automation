Feature: Basic Automation

Scenario: Verifying the title in A/B Testing
	Given User is on Home Page
	When User navigates to A/B Testing
	Then User verifies the title
	Then Close the browser
	
Scenario: Verifying the avatar Image
	Given User is on Home Page
	When User navigates on the Broken Images text
	Then User verifies the last image
	Then Close the browser
	
Scenario: Checking and uncheking the checkboxes
	Given User is on Home Page
	When User clicks on the checkboxes text
	Then User checks and unchecks the boxes
	Then Close the browser
	
Scenario: Performing basic drag and drop
	Given User is on Home Page
	When User clicks on the drag and drop text
	Then User performs drag and drop operation
	Then Close the browser
	
Scenario: Choosing the first option on the dropdown list
	Given User is on Home Page
	When User clicks on the dropdown text
	Then User chooses the 1st option in dropdown
	Then Close the browser
	
Scenario: Uploading a file
	Given User is on Home Page
	When User clicks on the upload file text
	Then User uploads a file and verifies the message
	And Close the browser
	
Scenario: Basic authorization without Javascript
	Given User is on the Login Page
	When User enters credentials
	Then User verifies the text
	And Close the browser