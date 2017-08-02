Feature: To test XYZ parameter API

Scenario: Check output with different parameters
Given I will create request with xyz parameters
When I submit the valid data
|ID|X|Y|Z|STATUS|
|1|124|213|12|200|
|2|421|421|3|400|
Then I will check status code equals
