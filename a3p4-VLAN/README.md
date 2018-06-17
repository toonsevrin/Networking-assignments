# a3p4 VLAN
VLANs partition an extended LAN into seperate logical LANs. Frames cannot transfer between two different logical LANs.

> Early network designers often segmented physical LANs with the aim of reducing the size of the Ethernet collision domain—thus improving performance. When Ethernet switches made this a non-issue (because each switch port is a collision domain), attention turned to reducing the size of the broadcast domain at the MAC layer. VLANs were first employed to separate several broadcast domains across one physical medium.
\- Wikipedia

VLAN in practice: https://www.ovh.com/world/solutions/vrack/. 4000 VLANs per server coincidence? No, each VLAN label field has 12bits (=4096). They likely use a stacked labels with one end label for each costumer.

[Good explanation of VLAN with use cases etc.](https://serverfault.com/questions/188350/how-do-vlans-work)

## What if nodes on two seperate VLANs want to communicate?
If they don't want to setup another VLAN they will have to use a layer 3 protocol for this. Thus a router (could be a node) is required. In the image provided in the slides of this question, it is not clear whether or not a router is present.

You can also be a hacker and use a [VLAN hopping](https://en.wikipedia.org/wiki/VLAN_hopping) exploit. These exploits can be mitigated by properly configuring your switches.

## What happens with the spanning tree protocol?
The topology is divided into multiple spanning trees, with a root bridge per VLAN.

## Is a VLAN scalable?
Multiple spanning trees improve aggregate bandwidth. 

Going beyond that:

It all depends on which routing protocols are used. There's no inherent limit 


Using label stacking is a lot more scalable: QinQ (nested VLAN tags): [IEEE 802.1AQ](https://en.wikipedia.org/wiki/IEEE_802.1aq) raises vlan limit to 16million (previously 4.094, 12 bits limit in 802.1Q, so 4.094^2). So this does not use a spanning tree protocol! Instead it uses shortest path bridging.

https://networkengineering.stackexchange.com/questions/28446/how-can-hosts-on-two-different-vlans-communicate


## Extra
The IEEE 802.3ac standard increased the maximum Ethernet frame size from 1518 bytes to 1522 bytes to accommodate the four-byte VLAN tag. Some network devices that do not support the larger frame size will process these frames successfully, but may report them as "baby giant" anomalies.[9]

### Assigning parts of subnet to different Vlans
> Since ARP is broadcast based, assigning different parts of the same IP subnet to different VLANs would be problematic because hosts in one VLAN wouldn't be able to receive ARP replies from hosts in the other VLAN, since broadcasts aren't forwarded between VLANs. You could solve this "problem" by using proxy-ARP but, ultimately, unless you have a really good reason to need to split an IP subnet across multiple VLANs it's better not to do so.

\- Evan Anderson

### Security?
In theory traffic cannot be forwarded to other VLANs, though switches have a lot of bugs in the vlan protocol, making it possible to send frames to another vlan. Bug free switches do provide some security, but even then, we may still be going over untrusted networks, which are vulnerable to MITM attacks. Ideally you want to encrypt and authenticate all your traffic, which can still be done on top of a vlan (TLS on top of a vlan).


### Router ip to vlan
If router supports configuring virtual sub-interfaces on its ethernet ports,it allows to map ips to vlans. You're essentially multiplexing an ethernet port to simulate multiple physical ethernet ports.
