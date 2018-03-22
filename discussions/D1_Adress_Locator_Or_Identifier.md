# Is it possible to use an address as both an identifier and a locator of a node?

Let's start with explaining the difference:

Identification: The address serves as the identifier for the node. This identification functionality allows a node to drop (broadcasted) packets that are not destined for that node.

Locator: The locator functionality has to do with routing. For an address to serve a locator functionality it should provide aid in finding the actual location of the node in the network.


# Answer: Possible
In IP this is done to some extend with the network/host segmentation. The IP address serves as an identifier for the node, while it also helps a little with routing by providing the network address.

An extreme case for a locator + identification address would be having the address include all intermediate switches and finaly the actual node ID.
