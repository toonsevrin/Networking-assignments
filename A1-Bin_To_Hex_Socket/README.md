# Networking A1
Socket client and server that translates an integer to it's hex representation.

There's a more bareboness implementation on Toledo which wasn't available at the time of writting this. I should probably use that. 


Written for [B-KUL-D0I64A](https://onderwijsaanbod.kuleuven.be/syllabi/n/D0I64AN.htm)


## Issue with implementation
Check on the TCP window system to understand the issues.

### Why is the stream so shocky?

Reason: Output is not forcely flushed, thus it waits for the timer to expire (because we are sending very little data, the packet limit is not hit). Adding an `output.flush()` statement solves this.


### Why does a second client have to wait?

Reason: The server is single threaded.


### Why does the second client not have the shocky behavior
Reason: The packets are already in the buffer. Add a `System.out.println("Written")` after the writeInt() line to show that the loop does not block before it's handled.
