Feature: FB login/out testing
	I want to use this template for my feature file

Scenario Outline: login

Given I want to launch fb url
When User enters "<userID>" and "<password>"
And clicks login button
And then user clicks logout button

Examples:
    |userID               |password| 
    |srekanth.me@gmail.com|Sree@123| 
    
    