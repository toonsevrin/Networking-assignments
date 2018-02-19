# Frame formats

## Ethernet frame format
More information can be found in https://books.google.be/books?id=MRChaUQr0Q0C&q=
### Why preamble of 8 bytes (compared to BSC, HDLC...)
The preamble consists of a 56-bit (seven-byte) pattern of alternating 1 and 0 bits, allowing devices on the network to easily synchronize their receiver clocks, providing bit-level synchronization. - Wikipedia

There is also an 8-bit SFD (which we consider as part of the preamble): 10101011.

Because of the time slot strategy used in ethernet, it is important to have exact clock synchronisation. Though I couldn't find information on why 8 bytes exactly, strong clock sync and a clear start delimitation are the underlying reason of using a preamble.

Note: The preamble and SFD are stripped away by the NIC, before being passed to L2.

Note 2: Ethernet has components in both layers 1 (because it can run over different media) and 2 (because the frames are the same on the different media). The Preamble, SoF Delimiter, and Inter-packet Gap are really in layer-1 (waking up the receiver, etc.), while the frame (including the header, payload, and FCS) is in layer-2.

Note 3: Though both 100Mbps and Gigabit ethernet keep the preamble for compatibility. They have more complex synchronisation mechanisms (which do not rely on the preamble), 'constant signaling'.

Note 4: Before sending the jam signal, nodes always complete the preamble (that way all nodes will notice it). The node will continue to send 1,0s after that until the signal is 96 bits long (same reason).

### Why is there a source address in ethernet
One reason could be that you do not require service discovery (eg. ARP) to reply to a packet on the same network.

Not sure if there are other reasons, the first one is pretty convincing (think tcp fe.).


### Why is there no end-of-frame delimiter in ethernet
The end of a frame is usually indicated by the end-of-data-stream symbol at the physical layer or by loss of the carrier signal. So this is handled at L1 (usually in the extra values of a 4B/5B or 8B/10B encoding scheme.

### No sliding window mechanism?
Frames are barely ever lost in ethernet, so it just provides a best effort service, without guarantees. The collision detection protocol with the time slots does a lot of the ordering work.

## Wi-Fi 802.11
### Four addresses?
Two addresses for the APs (See distributed systems), these are A2 and A3.
A1 is the destination (this is the first address because it needs to be read quickly), A4 is the source.

### End of frame marking?

### Preamble?
Depends on physical layer. Either a 'synch' (80bit preamble sequence) or a SFD (16 bit pattern)

