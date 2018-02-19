# Situate in the OSI architecture

## Repeater - Layer 1: Physical
"In telecommunications, a repeater is an electronic device that receives a signal and retransmits it." - Wikipedia

Because these devices work with the actual physical signals and don't interpret any data (except the preamble, which is L1), they reside on the first layer.



## Hub - Layer 1: Physical
An Ethernet hub, active hub, network hub, repeater hub, multiport repeater, or simply hub is a network hardware device for connecting multiple Ethernet devices together and making them act as a single network segment. 

Same story as repeater on why it resides on the first layer (Similar devices that don't are called 'Switches')

## Access point: Layer 2: Data-link
In computer networking, a wireless access point (WAP), or more generally just access point (AP), is a networking hardware device that allows a Wi-Fi device to connect to a wired network.

As with bridges (which an AP essentially is), an AP resides on layer 2. This is because they have to convert (fe) 802.11 Wifi frames to 802.3 ethernet frames.
