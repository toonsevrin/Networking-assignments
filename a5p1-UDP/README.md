# UDP

[Demo server](https://p.cygnus.cc.kuleuven.be/bbcswebdav/pid-19684544-dt-content-rid-105512795_2/xid-105512795_2)

[Demo client](https://p.cygnus.cc.kuleuven.be/bbcswebdav/pid-19684544-dt-content-rid-105512796_2/xid-105512796_2)

## Why do we not have the problems we had with tcp at a1?
No sending buffer, thus datagrams are send immediately, each with a single message.

All though this server is still single threaded, because the protocol is connectionless, it is able to handle packet sending REALLY quickly.

When we introduce a Thread.sleep in the sending function, we quickly notice that the single threaded nature.

## How does client react to server restart?
It doesn't, the protocol is connectionless... Thus the missed packets are just skipped

If we make the disconnect longer, a SocketTimeoutException will occur because the read timed out.
