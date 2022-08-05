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
 


## API documentation available for below functionality

http://localhost:8081/swagger-ui/index.html#/

       -> Registering / Deleting / Modifying a new customer 
       -> Adding / Deleting / Modifying / Retreiving a transactions
       -> Linking a transaction to the customer
       -> All available loyalty poits based on the pre connditions per customer
       -> All pending loyalty points per customer
       -> convert points to the amount for redemption






