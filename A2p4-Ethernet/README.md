# Collision detection in 100Mb ethernet
How to detect collisions in higher throughput ethernets?

## Introduction
The multiple access ethernet standard makes use of CSMA Collision detection. In this standard the maximum round-trip delay is 51.2 us (function of the signal speed, max distance and handling time). At 10Mbps this means 512 bits of data.

When host A sends a frame to host B, worst case scenario, B starts transmitting right before the first bit arrives (if it has already arrived, B will not transmit). This means that about 256 bits are in transit to B. For A to detect the collision as well, the signal of B should interfere with the transmission, thus at least another 256 bits of data are required.


## How can we make this work on say a 100Mbps ethernet
With an RTT of 51.2us, the minimum packet size would have to be 5120 bits, instead of 512 bits. If this is fine then there is no problem. We can still do the same collision detection. To reduce this minimum packet size we can reduce the maximum length of the medium or use a faster medium.

Another solution (and this scales to arbitrary fast ethernets) is to make the link collision free, this can be done by using two physical cables, making the link full-duplex.

Another solution may be collision avoidance (This needs to be verified).

## Moving past CSMA/CD
In modern networks most ethernet connections are point-to-point between a host and a switch. Therefore packets can only collide when these two emit at the same time. Modern ethernet standards make use of full-duplex by using twisted-pair cables (one for each direction), creating a collision free environment.
