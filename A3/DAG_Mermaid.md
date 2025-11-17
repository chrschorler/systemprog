
```mermaid
graph TD
 subgraph "P1"
     D["d = 2 * 2"]
     X["x = 2 * 25"]
     B["b = 8 * 5"]
     Z["z = 2 * 5"]
 end

 subgraph "P2"
     G["g = d * 3"]
     A["a = x * 2"]
     Y["y = b * 3"]
     H["h = d * 5"]
 end

 subgraph "P3"
     I["i = g * h"]
     U["u = y * z"]
 end

 subgraph "P4"
     V["v = a * i"]
 end

 subgraph "P5"
     C["c = v / u"]
 end

 D --> G
 D --> H
 X --> A
 B --> Y

 G --> I
 H --> I
 Y --> U
 Z --> U

 A --> V
 I --> V

 V --> C
 U --> C

