# Amortiguador

> **Estructuras Lineales** — Simulación con una **pila estática**.

## Planteamiento

Elabore un programa Java que simule el funcionamiento de un **amortiguador**.

- El amortiguador estará formado por **N discos** (15 – 50).
- A cada uno de los discos se le generará un valor entero (**95 – 100**) que representa la **vida útil** que le queda al disco.
- Los discos que se encuentren en los **extremos** del amortiguador son los que sufrirán un desgaste de **1 – 3 puntos** de su vida útil.
- Los discos que amortiguaron pasarán al **centro** del amortiguador, siempre que su vida útil sea **mayor al 30 %**; de no cumplirse, el disco **se desintegra**.
- Si el amortiguador tiene **menos de 4 discos**, ya no sirve para amortiguar.
- Cada vez que se use el amortiguador, debe poder **reportar los números de los discos** que absorbieron la energía y la vida útil que les queda.

> 📌 El amortiguador se representará por medio de una **ED Pila estática**.

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`Disco.java`](Disco.java) | Disco con número y durabilidad (vida útil). |
| [`Amortiguador.java`](Amortiguador.java) | Pila de discos; el método `Bache()` simula cada uso del amortiguador. |
