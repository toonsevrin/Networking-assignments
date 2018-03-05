# Situate in the OSI architecture
## Bridge - Layer 2: Data-link
In contrast to repeaters (L1), bridges reside on layer 2. This is because they access frame headers for their learning algo's, CD (store- and forward), frame integrity verification...

Bridges often use the Mac address of the source to build their forwarding table. More information [here](https://en.wikibooks.org/wiki/Switches,_Routers,_Bridges_and_LANs/Bridges).


## Ethernet switch - Layer2: Data-link
Usually an ethernet swith operates at layer2 (though it may also operate at higher layers, making it a _multilayer switch_).

Switches are very similar to bridges, though a bridge is often called a switch once it has multiple ports (more then 2). It often has more complex software/hardware as well.

### Wireless AP - Layer 2: Data-link
See assignment 2. But it's essentially a bridge that converts between frame formats. Thus l2.
