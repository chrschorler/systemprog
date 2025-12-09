Monitor lässt nur ein Thread zu der drin arbeitet

warteschlange iws1 (interne warteschlange1)

erster kommt rein, zweiter wartet in iws1
monitor kann beliebig viele warteschlangen instanziieren

man kann gezielt einen in warteschlange setzen und rausholen, net alle auf einmal 

zweite warteschlange iws2
wenn einer aus einer warteschlange rausgeholt wird kommt er da rein und wird dann geweckt
über belegeMonitor 

ich prüf also zuerst is einer in iws2, wenn ja wird er geweckt, wenn net guckt er in iws1

