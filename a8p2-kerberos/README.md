# Kerberos
Kerberos is a protocol for authenticating service requests between trusted hosts across an untrusted network, such as the internet.

Kerberos consists of a client, server and a Key Distribution Center (KDC). Everyone trusts the KDC.
## KDC
* Stores all user keys


## Describe the steps of the protocol

https://searchsecurity.techtarget.com/definition/Kerberos

1. Client requests access to a service from an auth server.
2. Server receives clients key from KDC database (if non existent, auth fails here).
3. Auth server generates session key and a ticket granting ticket (timestamped and encrypted), these are sent to client encrypted with the client key.

...
