# reward-service 

Spring boot application to demonstrate the real time reward system. 

Followed data driven testing apporach for a building a system.It does allows you to undertsand the system and all edge cases.

## Requirements

1. How a customer can acquire new points:


1 pending point for every euro until 5000 euro value of transaction
2 pending points for every euro from 5001 euro to 7500 euro value of transaction
3 pending points from 7501 euro value of transaction
Examples:

A.         A transaction of 4500 euro => 4500 points


B.       A transaction of 7800 euro -> 10900 points

5000 points for first 5000 euro
2*2500 points for 5001 -> 7500 euro
3*300 points for 7501 -> 7800 euro 
New pending points become available points for use at the end of every week if:

The customer has spent at least 500 euro that week
At least one transaction exists for that customer on every day of the week
A user will lose all the points if no transaction was made in the last 5 weeks.

2. How a customer can use the available points:

User can use some or all available points. Every point is worth 1 eurocent.

3. A customer should be able to query for balance of pending and available points and history of loyalty points allocation & usage   



API documentation available for below functionality

Registering a new cusotmer 

![image](https://user-images.githubusercontent.com/11241862/183064132-256d5235-e8de-4aae-8615-17b151ee9c75.png)





