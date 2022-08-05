# reward-service 

Spring boot application to demonstrate the real time reward system for credit pr debit card users 

Followed data driven testing apporach for a building a system.It does allows you to undertsand the system functional floe and all the edge cases.

## Requirements

1. How a customer can acquire new points:


pending point for every euro until 5000 euro value of transaction
pending points for every euro from 5001 euro to 7500 euro value of transaction
pending points from 7501 euro value of transaction

Examples:

       A transaction of 4500 euro => 4500 points


       A transaction of 7800 euro -> 10900 points

5000 points for first 5000 euro
2*2500 points for 5001 -> 7500 euro
3*300 points for 7501 -> 7800 euro 

New pending points become available points for use at the end of every week if:

## Desing and development features includes
       Domain design
       DTO patern
       JPA repository for CRUD operations
       Open API documentations.
       Java 8 strems API
       
## Service has test data available for demonstration 

       Available loyalty points transactions http://localhost:8081/customers/available/1

              {
         "customerId": 1,
         "customerName": "ALBERT",
         "customerCity": "New York",
         "transactions": [
           {
             "transactionDescription": "USA",
             "transactionAmount": 100000,
             "transactionDate": [
               2022,
               8,
               1
             ],
             "loyaltyPoints": 287500,
             "transactionId": 1,
             "status": "AVAILABLE"
           },
           {
             "transactionDescription": "USA",
             "transactionAmount": 2222,
             "transactionDate": [
               2022,
               8,
               2
             ],
             "loyaltyPoints": 2222,
             "transactionId": 3,
             "status": "AVAILABLE"
           },
       .....
         ],
         "availableLoyaltyBonus": 113332
       }
       
       

       Pending loyalty points http://localhost:8081/customers/pending/2

              {
         "customerId": 2,
         "customerName": "GEORGE",
         "customerCity": "Berlin",
         "transactions": [
           {
             "transactionDescription": "USA",
             "transactionAmount": 10,
             "transactionDate": [
               2022,
               8,
               1
             ],
             "loyaltyPoints": 10,
             "transactionId": 2,
             "status": "PENDING"
           },
           {
             "transactionDescription": "USA",
             "transactionAmount": 20,
             "transactionDate": [
               2022,
               8,
               2
             ],
             "loyaltyPoints": 20,
             "transactionId": 9,
             "status": "PENDING"
           },
           .
           .
           .
         ],
         "availableLoyaltyBonus": 150
       }

## API documentation available for below functionality

http://localhost:8081/swagger-ui/index.html#/

       -> Registering / Deleting / Modifying a new customer 
       -> Adding / Deleting / Modifying / Retreiving a transactions
       -> Linking a transaction to the customer
       -> All available loyalty points based on the pre connditions per customer
       -> All pending loyalty points per customer
       -> convert points to the amount for redemption






