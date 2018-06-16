# Autonomous System
An AS is a group of IP networks operated by one or more network operator(s) that has a single and clearly defined external routing policy.


Why does the KULeuven ISP use ASN 2611 (Belnet) and not have it's own ASN? 

No idea, but this does imply that they share a routing domain with other ISPs using the belnet ASN. Here's a list of ISPs they share this with: https://db-ip.com/as2611

If we look at the KULNET details, we see mnt-by BELNET-MNT, meaning that BELNET is the administrator for the isp.

Proximus uses its own ASs (See [this](https://db-ip.com/country/BE)).


Extra: [BNIX](https://www.peeringdb.com/ix/59) is used as an [IX](https://en.wikipedia.org/wiki/Internet_exchange_point)



