Feature: Test test

Scenario: Check inputs
Given I will set request body from template
#And I set query parameter is "app_code" and have value "99DtaMYpnxA9pNcmsnbj"
And I set query parameter is "app_id" and have value "F5LQw-YKN02C00SQ3y2TFg"
And I will set "GET" request URL
#And I will add request headers
#When I set query parameters


Then I will validate status code is "401"
And I will validate status message is "Unauthorized"
#And I will validate body contains "word"
And I will validate body not contains "pilkarzyki"
And I will validate response header contains "Content-Length"


#
#    /*
#    set request URL
#    set request body from template
#    add request header
#    set/add query parameter
#    set/add query parameters
#    send "type" request with url
#    send "type" request
#    validate status code
#    validate status message (okay forbidden)
#    validate body contains
#    validate body not contains
#    validate response header
#
#     */