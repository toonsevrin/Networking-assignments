# A3p3: ARP, DHCP and ICMP packet encapsulation
- Are they encapsulated directly in a l2 frame?
- Are they encapsulated in an IP datagram?
- Are they transported on a higher level?
### ARP (Address Resolution Protocol)
ARP is directly encapsulated in an l2 frame because the messages are never routed across internetworking nodes. This property places them into the link layer. Note that the discovery probes are encapsulated in l2 broadcast frames.

OSI: "top" of layer 2 as it uses l2 protocol for transport (eg. ethernet)

### DHCP (Dynamic Host Configuration Protocol)
DHCP is encapsulated in UDP and then in IP.

OSI on this one is a bit difficult, perhaps it's a nice example of the OSI classification? You could argue it has layer 2,3 and 7 functionality.

### ICMP (Internet Control Message Protocol)
Encapsulated in IP packet, because it sends control messages to specific nodes.

OSI: "top" of layer 3, as it uses IP for transport. Could be seen as a component of ip.
