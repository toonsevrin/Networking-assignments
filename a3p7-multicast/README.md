# Multicast

[Server](https://p.cygnus.cc.kuleuven.be/bbcswebdav/pid-19684541-dt-content-rid-105512787_2/courses/B-KUL-D0I64a-1718/Assignments/%C2%A74.2%20-%20Multicasting/MulticastDemoServer.java)

[Client](https://p.cygnus.cc.kuleuven.be/bbcswebdav/pid-19684541-dt-content-rid-105512788_2/courses/B-KUL-D0I64a-1718/Assignments/%C2%A74.2%20-%20Multicasting/MulticastDemoClient.java)

Client registered via `socket.joinGroup(group);`, server periodically send a connectionless datagram packet to this group IP.

## Will this work with ipv6 multicast?
Totally worked!


## Can the client still receive the multicast packets on a different network?
Only if the intermediate routers support multicast. Don't think this is the case.

## Does multicast traffic go via network or loopback?
When sending unicast datagrams, the routing tables dictate which network interface is used to send the packet. For multicast, you need to specify the interface. You can do that with a MulticastSocket.

I checked this with wireshark, and the packet is indeed just sent over the loopback address.

When I change the sockets to MulticastSockets and force it to use the wifi adapter, the packets show up just fine (all though my wireshark crashes quickly afterwards, due to the load)!
