# Crypto
* Confidentiality: Privacy
	* Forward: Even if key is blown later on, the data cannot be recovered
* Authentication: Comes from sender
* Integrity: Not manipulated

## Does it make sense to use RSA for integrity?
`m + RSA(m, PrivateA)`

We can manipulate the message to giberish: Example: we decrement RSA(m, PrivateA) by one bit, which would result in a whole new message. Now we can fake integrity on `m' + RSA(m', PrivateA)` with m' the new message. This new message would be giberish though. We can buy a 30$ FGPA to create about 500 signatures (128bit security) per second. With a ROI of 1 year this would result in 5mil signatures per dollar cent. We can brute force pick the first 32 bits for about 8$, if we want to brute force pick the first 64 bits, we're paying $37 billion USD (might be a lot cheaper actually because we don't need to resign, and we can actually use the 45$ sun crypto accelerator for 1GBps of signatures).

For the other options, see powerpoint to see their security parameters.


Note: The manipulation that is possible with the m + RSA example is called [existential forgery](https://en.wikipedia.org/wiki/Digital_signature_forgery)

I proposed m + RSA(pre + m, PrivateA) (with pre a sufficiently long sequence), but even this can be vulnerable. The vulnerability is also described here https://crypto.stackexchange.com/questions/37168/forgery-attack-against-textbook-rsa-with-simple-redundancy the vulnerability occurs when you pad with zeros because these do not modify the actual message integer.
