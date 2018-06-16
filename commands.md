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

The metric column represents the "distance cost". If multiple routes can be used, windows will opt for the one with the lowest metric.

Synonym for this command is `netstat -r`.


### Ipconfig
`ipconfig /all` prints the IP configuration. 

You can find your DHCP assigned ip under _IPv4 Address_. Remember that this

Your public IP may not be in this list because the router uses NAT (network address translation) to cut down on globally unique ips (common for household networks).

### Tracert / traceroute
`tracert <destination>` Traces the route to the destination \
* `-6` forces ipv6
* `-4` forces ipv4
It does so by incrementing the ttl of a ICMP echo message in the case of windows (or udp/.. on unix-likes) to the destination and each time reading the ICMP `time exceeded` messages. For the full functionality, read [this](https://en.wikipedia.org/wiki/Traceroute).

Extra: the first hop is actually the most specific router in `route print` with the lowest "metric".

### Netstat
`netstat -ano` lists the TCP/UDP ports in use.

* `-a`: Show client ports as well (along server)
* `-n`: use numeric formt
* `-o`: Only show process id (PID)

## Nslookup
`nslookup <dns address>` looks up the dns.
