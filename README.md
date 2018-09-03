TO LAUNCH GRID HUB
```bash
java -jar environment/selenium-server-standalone-3.13.0.jar -role hub
```
TO LAUNCH GRID NODE
```bash
    java -jar environment/selenium-server-standalone-3.13.0.jar -role node -hub http://localhost:4444/grid/register -port 5556
```