
```mermaid
graph TD
 subgraph "P1"
     D["d = 2 * 2"]
     A["a = 2 * 25 * 2"]
     Y["y = 8 * 5 * 3"]
     Z["z = 2 * 5"]
 end

 subgraph "P2"
     G["g = d * 3"]
     H["h = d * 5"]
     U["u = y * z"]
 end

 subgraph "P3"
     I["i = g * h"]
 end

 subgraph "P4"
     V["v = a * i"]
 end

 subgraph "P5"
     C["c = v / u"]
 end

 D --> G
 D --> H
 A --> V
 Y --> U

 G --> I
 H --> I
 Z --> U

 I --> V

 V --> C
 U --> C