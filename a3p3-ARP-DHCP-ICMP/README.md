# A3p3: ARP, DHCP and ICMP packet encapsulation
- Are they encapsulated directly in a l2 frame?
- Are they encapsulated in an IP datagram?
- Are they transported on a higher level?
### ARP (Address Resolution Protocol)
ARP is directly encapsulated in an l2 frame because the messages are never routed across internetworking nodes. This property places them into the link layer. Note that the discovery probes are encapsulated in l2 broadcast frames.

### DHCP (Dynamic Host Configuration Protocol)
DHCP is encapsulated in UDP and then in IP. 

### ICMP (Internet Control Message Protocol)
Encapsulated in IP packet, because it sends control messages to specific nodes. It is an alternative to UDP/TCP (thus not encapsulated in one of these protocols).
