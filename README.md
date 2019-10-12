# Simple spring example.

## Description

Banks have customers. Customers have accounts.
Accounts hold money. Transfers are done between accounts. Account holds a list of all
transfers.

There can be two types of transfers:

● Intra-bank transfers, between accounts of the same bank. They don't have commissions,
they don't have limits and they always succeed.

● Inter-bank transfers, between accounts in different banks. They have 5€ commissions,
they have a limit of 1000€ per transfer and they have a 30% chance of failure.

There is a Transfer Agent that receives an order to transfer money from account A to account B,
it issues transfers to the banks considering commissions, limits and handles the possibility of
failures.
The TA functionality is exposed through a rest controller.
For this example scope consider that transfer agent holds the banks.

### Steps to run:

`mvn install`

`mvnw spring-boot:run`


### Steps to test:

`mvn test`
