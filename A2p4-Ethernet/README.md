# Collision detection in 100Mb ethernet
How to detect collisions in higher throughput ethernets?

## Introduction
The multiple access ethernet standard makes use of CSMA Collision detection. In this standard the maximum round-trip delay is 51.2 us (function of the signal speed, max distance and handling time). At 10Mbps this means 512 bits of data.

When host A sends a frame to host B, worst case scenario, B starts transmitting right before the first bit arrives (if it has already arrived, B will not transmit). This means that at most (max length link) 256 bits are in transit to B. For A to detect the collision as well, the signal of B should interfere with the transmission, thus at least another 256 bits of data are required. Thus a total of 512 bits are required (64 bytes).

Maximum of 1500 bytes is rather arbitrary, higher values are less fair and would mess with the length field (a value over 1500 is interpretted as a demux key), smaller values would enforce more header overhead (especially because packet splitting is done at the ip level, so that header is duplicated as well).


## How can we make this work on say a 100Mbps ethernet
With an RTT of 51.2us, the minimum packet size would have to be 5120 bits, instead of 512 bits. If this is fine then there is no problem. We can still do the same collision detection. To reduce this minimum packet size we can reduce the maximum length of the medium or use a faster medium.

Using a faster medium very unscalable, reducing the medium length is only somewhat scalable. One method which is a little more scalables: Only require the first packet in a stream of packets to be full length (for example 8\*512bit), subsequent packages can be smaller as the channel is already claimed.

Another solution (and this scales to arbitrary fast ethernets) is to make the link collision free, this can fe. be done by using two physical cables between each node pair, making the link full-duplex. This is of course the solution: Switches are cheap, cables are really cheap.

Another solution may be using CSMA/CA (collision avoidance), though this is not really a solution as you have to wait a round trip waiting for a CTS response to your RTS (request to send).

Real world:
100BaseT: 100m segments, up to 205m with class 2 repeaters.
1000BaseT: would be 20m with the 512bit minimum, but with larger initial packages the max range in expanded to 100m, where the CAT cable becomes the limiting factor.


## Moving past CSMA/CD
In modern networks most ethernet connections are point-to-point between a host and a switch. Therefore packets can only collide when these two emit at the same time. Modern ethernet standards make use of full-duplex by using twisted-pair cables (one for each direction), creating a collision free environment.

Ethernet hubs (L1) are completely obsolete, nobody produces these anymore. They have been replaced by the L2 switches. The only argument for a hub could be for network analysis (or perhaps connecting different physical layers, like 10base2 to 10baseT, though this could also be done with a switch). 

## Extra: MA: Deriving RTT from minimum packet size and Mbps
Say we are working with 10Base5 (10Mbps, up to 4 repeaters, 5 segments, at most 500m between repeaters, the 5 stands for 500m segments, base stands for baseband) then the total length will thus be at most 2500m.

The minimum packet length of this standard is 64 bytes (512 bits) which is transmitted in 512b/10Mbps = 51.2 us. Because the packet must span the whole medium and back, we know the RTT must be smaller than 51.2us.
