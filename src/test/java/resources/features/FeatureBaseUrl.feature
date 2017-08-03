Feature: Test test

Scenario: Check inputs
Given I will set "get" request
And I will set request body from template
And I will add request headers
When I set query parameter is "app_code" and have value "123asdapksd"
When I set query parameters


Then I will validate status code is "200"
And I will validate status message is "Forbidden"
And I will validate body contains "word"
And I will validate body not contains
And I will validate response header contains "word"


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