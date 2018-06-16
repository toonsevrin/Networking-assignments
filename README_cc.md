# Congestion Control

## Question: TCP settings for communication over satellite links
See [this](https://tools.ietf.org/html/bcp28) for detailed explanation.

Characteristics:
- High latency/RTT
  - fundamental light speed delay to and from satellite
  - RTT \> 0.5s in geostationary (somewhat less of a problem in lower orbits)
  - RTT is variable over time in lower orbits
- Limited bandwidth 
  - limited capacity of radio signals and legal limitations
- High `delay x bandwidth` product (due to latency)
- Expensive send equipment (receiving is cheap)
- Connection handover required in lower orbits

Goals:
1. High data per packet to reduce packet amount
2. a. Congestion control capable of dealing with high (and possibly variable) RTT, b. does not congest satellite (limited bandwidth)
3. Recover from bit errors: bit errors are expensive because they will trigger the congestion control mechanism (which is expensive due to high RTT).

### Solutions
#### Path-MTU Disovery
Helps with 1, not required because it slows down connection setup (though on-ground caching can solve that).

##Forward Error Correction (FEC)
Helps with 3

> There are some situations where FEC cannot be expected to solve the noise problem (such as military jamming, deep space missions, noise caused by rain fade, etc.). \[...\] Finally, FEC is not without cost.  FEC requires additional hardware and uses some of the available bandwidth.  It can add delay and timing jitter due to the processing time of the coder/decoder.

\- Enhancing TCP Over Satellite Channels using Standard Mechanisms, M. Allman ea.
## Slow start
Required because of 2b.

## Congestion avoidance
Very slowly expand window size further without causing any congestion, helps with 2b.


## Fast retransmit/recovery
Helps with 2a.

>  Note that the fast retransmit/fast recovery algorithms, as discussed above can lead to a phenomenon that allows multiple fast retransmits per window of data [Flo94].  This can reduce the size of the congestion window multiple times in response to a single "loss event".  The problem is particularly noticeable in connections that utilize large congestion windows, since these connections are able to inject enough new segments into the network during recovery to trigger the multiple fast retransmits.  Reducing cwnd multiple times for a single loss event may hurt performance [GJKFV98].

\- Enhancing TCP over Satellite Channels using Standard Mechanisms

## SACK

> The best way to improve the fast retransmit/fast recovery algorithms is to use a selective acknowledgment (SACK) based algorithm for loss recovery.  As discussed below, these algorithms are generally able to quickly recover from multiple lost segments without needlessly reducing the value of cwnd.  In the absence of SACKs, the fast retransmit and fast recovery algorithms should be used.  Fixing these algorithms to achieve better performance in the face of multiple fast retransmissions is beyond the scope of this document.  Therefore, TCP implementers are advised to implement the current version of fast retransmit/fast recovery outlined in RFC 2001 [Ste97] or subsequent versions of RFC 2001.

\- Enhancing TCP over Satellite Channels using Standard Mechanisms

## Large windows
The standard window size is sometimes not sufficient to make use of the entire satellite bandwidth (with few connections)
=\>                       `throughput = window size / RTT`
=\>            `throughput = 65,535 bytes / 560 ms = 117,027 bytes/second`

Recommended because with many flows, larger windows will never be required.


