@ignore
Feature: Login Admin

  Background:
    * configure ssl = { trustAll: true }
    * def tokenHeaders = read('../config/tokenHeaders.json')
    * def loginDetails = read('../config/loginDetails.json')
    * def adminCredentials = read('../config/adminCredentials.json')
    * def proprietaryCredentials = read('../config/proprietaryCredentials.json')
    * def clientCredentials = read('../config/clientCredentials.json')


  Scenario: Get access token

    And def userCredentials = type === 'admin' ? adminCredentials : type === 'client' ? clientCredentials : proprietaryCredentials
    Given url loginDetails.url
    And header Content-Type = 'application/x-www-form-urlencoded'
    And form field grant_type = loginDetails.grant_type
    And form field client_id = loginDetails.client_id
    And form field client_secret = loginDetails.client_secret
    And form field username = userCredentials.username
    And form field password = userCredentials.password
    When method POST
    Then status 200
    And copy credentials = tokenHeaders
    And set credentials.Authorization = 'Bearer ' + response.access_token
    And def headers = credentials

