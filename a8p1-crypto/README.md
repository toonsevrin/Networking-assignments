# Crypto
* Confidentiality: Privacy
	* Forward: Even if key is blown later on, the data cannot be recovered
* Authentication: Comes from sender
* Integrity: Not manipulated

## Does it make sense to use RSA for integrity?
`m + RSA(m, PrivateA)`

We can manipulate the message to giberish: Example: we decrement RSA(m, PrivateA) by one bit, which would result in a whole new message. Now we can fake integrity on `m' + RSA(m', PrivateA)` with m' the new message. This new message would be giberish though.

For the other options, see powerpoint to see their security parameters.

