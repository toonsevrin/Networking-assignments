# Routing

## Distance Vectors
Step based protocol, each step: Publish known route distances to neighbors (and aggregate incoming distances + 1 if they are shorter than existing ones).

Issue: Link between A and F goes down and A detects this. Problem when F is only reachable through A: A sends to B that F is no longer reachable. C sends to F that it's still reachable via an alternative route (because it hasn't received As message yet).

__We thus need a loop breaking mechanism:__ \
Because every iteration the distance to F increases (because the nodes keep using eachothers incrementally long routes), setting a number after which distance is considered as "infinite" will do the trick. Not sending an update back to the origin of the request also helps (see slides...).

TODO: Better understand the loop issue and rewrite this.

## Link State Routing
Flooding protocol to distribute the complete network topology. Every node 'broadcasts' (logically, in reality the message is gossiped onwards) the cost to it's neighbors. At the end of the protocol, every node knows the network topology and cost and can run a shortest path algorithm (dijkstra) to build its routing table.
