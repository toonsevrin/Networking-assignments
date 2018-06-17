# Kerberos
Kerberos is a protocol for authenticating service requests between trusted hosts across an untrusted network, such as the internet.

Kerberos consists of a client, server and a Key Distribution Center (KDC). Everyone trusts the KDC.
## KDC
* Stores all user keys


## Describe the steps of the protocol
[Super easy to understand video](https://www.youtube.com/watch?v=kp5d8Yv3-0c), let's watch this during the exam..

Less easy but written: https://searchsecurity.techtarget.com/definition/Kerberos

## Why is Kerberos not used on toledo?
1. We're using ssl anyways so toledo is authenticated already (kerberos is a private-key, trusted-third-party authentication system while ssl is a public-key, certificate-based authentication system).
2. KDC stores keys of users (though these could be derived from a hashed password to improve security).

SSL is superior to kerberos because there's no accessible trusted third party (only certificate)

More info: http://www.di-srv.unisa.it/~ads/corso-security/www/CORSO-0001/kerberos/ref/kerberos-faq.html#kerbvsssl

TODO: Check how toledo does authentication on third party services
