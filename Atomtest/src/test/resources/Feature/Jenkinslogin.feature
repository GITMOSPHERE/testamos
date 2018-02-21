Feature: Jenkins login and logout test
	I want to use this feature file to login logout behaviour of Jenkins local server

Scenario: Jenkins user login

Given I want to launch localhost URL
When entered the "username" and "password" in the login page
And  click login button
Then click logout button

