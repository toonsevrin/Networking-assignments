# RTP

## How does the receiving host know that the UDP datagram contains RTP?

UDP is IP protocol=17, `[SrcPort, DstPort, Checksum, Length, Data]`, there is no protocol demux key! The port is used for demuxing. Thus the receiving host simply expects RTP packets on this port.

Is there a way for a router to tell apart RTP packets?

> No, if the router doesn't have access to the protocol that established a session, there is no way by looking at a single packet to tell that it is an RTP packet. However, if the router maintains state, it can inspect the sequence number and, with probability, determine that a particular UDP port pair carries RTP if the sequence number increases by one (or a small number) for each packet. In addition, the first two bits of every packet will be the same, namely the RTP version identifier. It is also likely that the payload type will stay constant from packet to packet.

\- https://www.cs.columbia.edu/~hgs/rtp/faq.html

Should the RTP payload type (PT) field be used for multiplexing different streams?

> It has been suggested that in some environments (such as RTP over AAL5) that lack lower-layer muxing abilities, the RTP payload type (PT) field be used to differentiate streams originating from different sources. This is a fundamentally bad idea and violates the letter and intent of the specification. It makes use of multiple PTs in a single stream difficult (see previous question). It is also unnecessary, as the SSRC was designed for distinguishing several sources.

\- https://www.cs.columbia.edu/~hgs/rtp/faq.html

Should the RTP SSRC be used for demultiplexing different streams for the same RTP session?

> The RTP SSRC is meant to label streams from different sources, that is, each sender in a conference has its own SSRC. It has been suggested to have a single source, using the same RTP session (identified by source and destination addresses and ports), send different media, such as an audio and video stream, using different SSRCs. This is generally a bad idea for the following reasons:

\- https://www.cs.columbia.edu/~hgs/rtp/faq.html

## Why not use a single well-known port?
Because a port is used for every session? Because certain firewalls would not allow this? 

> A single fixed port number pair cannot be required because multiple applications using this profile are likely to run on the same host, and there are some operating systems that do not allow multiple processes to use the same UDP port with different multicast addresses.
\- https://people.kth.se/~eskil/DV/faq.html

5004, 5005 are assigned as default pair however.

## How does the sender know which port to use?
The port (pair for combo with RTCP) can be assigned randomly by a session management program.

Sides can also indicate where they wish to receive packets (eg. using SDP).

Note that the SSRC values used for each source are always different.
