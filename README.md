# reward-service 

Spring boot application to demonstrate the real time reward system. 

Followed data driven testing apporach for a building a system.It does allows you to undertsand the system and all edge cases.

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

 
## Service data available for initial testing

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
    {
      "transactionDescription": "USA",
      "transactionAmount": 2222,
      "transactionDate": [
        2022,
        8,
        2
      ],
      "loyaltyPoints": 2222,
      "transactionId": 4,
      "status": "AVAILABLE"
    },
    {
      "transactionDescription": "USA",
      "transactionAmount": 2222,
      "transactionDate": [
        2022,
        8,
        4
      ],
      "loyaltyPoints": 2222,
      "transactionId": 5,
      "status": "AVAILABLE"
    },
    {
      "transactionDescription": "USA",
      "transactionAmount": 2222,
      "transactionDate": [
        2022,
        8,
        5
      ],
      "loyaltyPoints": 2222,
      "transactionId": 6,
      "status": "AVAILABLE"
    },
    {
      "transactionDescription": "USA",
      "transactionAmount": 2222,
      "transactionDate": [
        2022,
        8,
        6
      ],
      "loyaltyPoints": 2222,
      "transactionId": 7,
      "status": "AVAILABLE"
    },
    {
      "transactionDescription": "USA",
      "transactionAmount": 2222,
      "transactionDate": [
        2022,
        8,
        7
      ],
      "loyaltyPoints": 2222,
      "transactionId": 8,
      "status": "AVAILABLE"
    }
  ],
  "availableLoyaltyBonus": 113332
}


## API documentation available for below functionality

http://localhost:8081/swagger-ui/index.html#/

       -> Registering / Deleting / Modifying a new customer 
       -> Adding / Deleting / Modifying / Retreiving a transactions
       -> Linking a transaction to the customer
       -> All available loyalty poits based on the pre connditions per customer
       -> All pending loyalty points per customer
       -> convert points to the amount for redemption






