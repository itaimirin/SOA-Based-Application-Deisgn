////////////////////////////////
///Author: Itai Marongwe///
///Student: 100885911  ///
///////////////////////////////

- In collaboration with Hamza (verbal assisstance) 

ZIP contains: 3 Different Packages
-SOAP
-SOAPCLIENT
-SOAPServer
-README.txt


-------------------FILES-------------------------
SOAP contains Java files for:
API Gateway Implementation 
API Interface
API Publisher

The API is the Gateway to which the client communicates to the servers through.

SOAPServer contains Java files for:
Servers Implementation
Server Interface
Server(s) Publisher

The Server(s) are the EndPoints of the API that provide the service the Client is looking for

SOAPCLIENT contains Java files for: 
The Client

----------------Description---------------------
Implementation files handle the Remode Methods invoked by the client as well as the API to the server.
It provides the instructions on the methods invoked remotely. 

Interfaces provide an access point to the methods of interest by the Client and the API (with respect to the server), as a invokable method, that may or may not accept passed parameters.

Publishers open ports that listen for services being requested by the client.

----------------Usage--------------------------
1. Publish Servers
2. Publish SOAP API Gateway
3. Intiate Client

-The Client is capable of making a request from the SOAP Server to request either Service A or Service B.
-The Client is prompted as to which service it is requesting.
-The Client will have a response returned to it by the appropriate server.
