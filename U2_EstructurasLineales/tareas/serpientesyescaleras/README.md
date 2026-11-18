# Serpientes y Escaleras

> **Estructuras Lineales** — Juego simulado sobre una **lista doblemente ligada**.

## Planteamiento

Desarrolle las clases Java necesarias que permitan realizar el juego de **serpientes y escaleras**. Genere una **lista doblemente ligada** que permita definir el tablero de acuerdo a 2 niveles de dificultad:

| Nivel | Tamaño del tablero |
|:-----:|--------------------|
| 1 | 90 – 110 nodos |
| 2 | 100 – 120 nodos |

El nodo, en su parte de `Info`, debe representar objetos con los siguientes atributos:

- **Número de casilla**
- **Tipo**: `Normal`, `Escalera`, `Serpiente`, `Terminación`
- **Posiciones**

### Generación aleatoria

- **5 escaleras.** Las casillas válidas son de la número **5** al **total de casillas menos 20**, y se puede **avanzar de 10 a 20** casillas. La escalera sólo puede llegar a una casilla de tipo *Normal*.
- **5 serpientes.** Las casillas válidas son de la número **20 a la 90**, y se puede **retroceder de 5 a 10** casillas. La serpiente sólo puede llegar a una casilla de tipo *Normal*.

### Simulación

- Simule el juego con **N (2 – 5) jugadores**, generando de forma aleatoria el tiro de los dados (**2 – 12 puntos**).
- Cada jugador realiza los tiros de manera **alterna**.
- El programa debe **imprimir el tablero** cada vez que se realice un tiro, indicando en qué posición va cada jugador.
- El programa termina cuando un jugador llega **exactamente a la última casilla**.

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`SerpientesYEscaleras.java`](SerpientesYEscaleras.java) | Clases `Casilla`, `Jugador` y el tablero sobre `ListaDbl`. |
