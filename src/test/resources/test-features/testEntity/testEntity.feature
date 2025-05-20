Feature: TestControllerBase API

  Background:
    * def baseUrl = 'http://localhost:8080'
    * url baseUrl
    * print 'Base URL is:', baseUrl
    * def req = read('./requests.json')
    * def res = read('./responses.json')
    * def sign = read('../config/login.feature')
    * def adminLogin = call sign { type: 'admin' }
    * def clientLogin = call sign { type: 'client' }
    * def driverLogin = call sign { type: 'driver' }
    * def adminToken = adminLogin.headers
    * def clientToken = clientLogin.headers
    * def driverToken = driverLogin.headers

  Scenario: Manage Test Entities

    # Should get all entities
    Given path 'api', 'v1', 'test'
    And headers adminToken
    When method GET
    Then status 200

    # Should create a new entity
    Given path 'api', 'v1', 'test'
    And headers adminToken
    And request req.createTest
    When method POST
    Then status 201
    * print 'Actual response for creation:', response

    # Should get all entities
    Given path 'api', 'v1', 'test'
    And headers adminToken
    When method GET
    Then status 200
    * print 'Should get all entities:', response

    # Should get a single entity
    Given path 'api', 'v1', 'test', '1'
    And headers adminToken
    When method GET
    Then status 200
    * print 'Should get a single entity:', response

    # Should not find a non-existent entity
    Given path 'api', 'v1', 'test', '9999'
    And headers adminToken
    When method GET
    Then status 404



    # Should update an existing entity
    Given path 'api', 'v1', 'test', '1'
    And headers adminToken
    And request req.updateTest
    When method PUT
    Then status 200

    # Should delete an existing entity
    Given path 'api', 'v1', 'test', '1'
    And headers adminToken
    When method DELETE
    Then status 200

    # Should not delete a non-existent entity
    Given path 'api', 'v1', 'test', '9999'
    And headers adminToken
    When method DELETE
    Then status 404
