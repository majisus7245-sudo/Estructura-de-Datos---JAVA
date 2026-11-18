# Proyecto 02 · Métodos recursivos

> **Recursividad** — Edición de cantidades y textos mediante métodos recursivos.

## Planteamiento

Se desea que implemente en la clase Java `Recursiva` los siguientes **métodos recursivos**:

### 1. `PonComas`

```java
public static String PonComas(long cantidad) { }
```

Recibe como parámetro un valor numérico entero y debe regresar una cadena con la cantidad **editada con comas**.

> Ejemplo: `1234567` → `"1,234,567"`

### 2. `miTrim`

```java
public static String miTrim(String texto) { }
```

Recibe como parámetro un texto y debe regresar el texto **sin blancos al inicio ni al final**, y con **un solo carácter blanco entre cada palabra**.

### 3. `Proteccion`

```java
public static String Proteccion(long cantidad) { }
```

Recibe como parámetro un importe entero positivo y debe regresar un texto con la **leyenda de la cantidad** (la cantidad escrita con letra, como en la protección de un cheque).

Para construir la leyenda se sugieren los siguientes arreglos:

```java
String[] unidades = {"uno", "dos", "tres", ..., "veintinueve"};
String[] decenas  = {"diez", "veinte", "treinta", ..., "noventa"};
String[] centenas = {"cien", "doscientos", ..., "novecientos"};
```

| Unidades | Decenas | Centenas |
|----------|---------|----------|
| un | diez | cien |
| dos | veinte | doscientos |
| tres | treinta | trescientos |
| … | … | … |
| veintiocho | ochenta | ochocientos |
| veintinueve | noventa | novecientos |

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`Proyecto_02.java`](Proyecto_02.java) | Implementación de `PonComas`, `miTrim` y `Proteccion` (con sus métodos auxiliares recursivos). |
