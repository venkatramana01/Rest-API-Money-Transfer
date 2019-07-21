# Rest-API-Money-Transfer

Design and implement a RESTful API  for money transfers between accounts.

Technology stack
Java
JAX-RS API(Jersey)
In memory database
Apache HTTP Client


Features

Account creation/update/deletion
Transfer creation
Transfer execution
Meaningful HTTP return codes
In-memory datastore




How to use services
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
"balance":8542344
}
3>getting all accounts
Get:	 http://localhost:8090/moneytransferrestapi/webapi/accounts/allaccounts
[
        {
            "id": “1”,
            "balance": 245,
         },
        {
            "id": “2”,
            "balance": 345,
        },
        {
		"id": “3”,
             "balance": 567,
        }
    ]

4>Transferring funds between accounts

POST: http://localhost:8090/moneytransferrestapi/webapi/transactions/transfer
Source:
	{
	"source":"1",
	"target":"2",
	"amount":555
}
Output:
{
	"id":"2",
	"amount":590
}


Available Services
HTTP METHOD	PATH	USAGE
GET	/accounts	Welcome Message
POST	/accounts/account	Add account
GET	/accounts/{accountId}	get account by accountId
GET	/accounts/allaccounts	get all accounts
POST	/transactions/transfer	perform transaction between 2 users 
accounts

