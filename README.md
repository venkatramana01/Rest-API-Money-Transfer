
# Rest-API-Money-Transfer
-------------------------
Design and implement a RESTful API  for money transfers between accounts.

Technology stack
--------------------
Java

JAX-RS API(Jersey)

In memory database

Apache HTTP Client

Features
-------------------
Account creation

Getting Account using ID

Getting All accounts

Transfer amount between accounts

Meaningful HTTP return codes

In-memory datastore

How to use services
----------------------
Application starts a Tomcat server on localhost port 8080.

1>posting an account

POST:       http://localhost:8090/moneytransferrestapi/webapi/accounts/account
Ex: 
{

	"id":"1",
	"balance":8542344

}


2>Getting an account

Get:	http://localhost:8090/moneytransferrestapi/webapi/accounts/account/{id}
Ex: 
{

		"id":"1",
		"balance":1000

}


3>getting all accounts

Get:	 http://localhost:8090/moneytransferrestapi/webapi/accounts/allaccounts
[

        {
            "id": “1”,
            "balance": 1000,
         },
	 
        {
            "id": “2”,
            "balance": 550,
        },
	
        {
		"id": “3”,
             "balance": 2000,
        }
	
    ]


4>Transferring funds between accounts

POST: http://localhost:8090/moneytransferrestapi/webapi/transactions/transfer
Source:

Input

{

	"source":"1",
	"target":"2",
	"amount":1000
	
}


Output:
[

    {
    
        "balance": "0",
        "id": "1"
	
    },
    
    {
        "balance": "1550",
        "id": "2"
    }
]
