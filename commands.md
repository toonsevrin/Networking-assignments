# Commands
## Windows
### Ping
`ping <address>` gives the RTT
* `-t <amount>` how many times to ping
* `-i <ttl>` time to live of ping (hops) 

### Netsh
`netsh wlan show interfaces` describes the wireless lan interfaces \
`netsh wlan show networks mode=bssid` shows all visible networks

=> Note that these commands are OS commands, they are probably not even pushed to the adaptor, instead the response is pulled from the OS memory.

### Route print
`route print` prints the routing table


### Tracert / traceroute
`tracert <destination>` Traces the route to the destination \
* `-6` forces ipv6
* `-4` forces ipv4
It does so by incrementing the ttl of a ICMP echo message in the case of windows (or udp/.. on unix-likes) to the destination and each time reading the ICMP `time exceeded` messages. For the full functionality, read [this](https://en.wikipedia.org/wiki/Traceroute).

