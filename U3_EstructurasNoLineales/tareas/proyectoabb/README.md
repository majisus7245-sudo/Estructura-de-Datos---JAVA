# Proyecto 01 · Árbol de cuentas contables

> **Estructuras No Lineales** — Catálogo de cuentas contables sobre un **árbol binario de búsqueda (ABB)**.

## Planteamiento

Usted cuenta con la siguiente clase:

```java
class Cuenta {
    private String cuenta; // formada por seis caracteres
    private String nombre;
    public int nivel, cargo, abono;

    public Cuenta(String cuenta, String nombre, int nivel) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.nivel = nivel;
        cargo = abono = 0;
    }

    public String toString() {
        return cuenta;
    }
}
```

Se desea que desarrolle las clases Java necesarias que definan un **árbol binario de búsqueda** que represente información de cuentas contables y realice las siguientes acciones:

1. Registrar cuenta *(agregando nodos al árbol)*
2. Eliminar cuenta
3. Registrar cargo o abono a una sub-subcuenta
4. Eliminar todas las cuentas de mayor que no tienen cargo ni abono
5. Consultar una cuenta
6. Consultar cuentas (en orden **descendente**)
7. Salir

### Estructura de las cuentas

Las cuentas contables son de **tres niveles** y están formadas por **seis caracteres**:

| Caracteres | Nivel | Ejemplo |
|:----------:|-------|---------|
| 1 – 2 | Cuenta de mayor | `09 00 00` |
| 3 – 4 | Subcuenta | `09 01 00` |
| 5 – 6 | Sub-subcuenta | `09 01 01` |

**Ejemplo de catálogo:**

```
010000  CAJA
  010100  CAJA CHICA
    010101  GERENTE
    010102  DUEÑO
    010103  AUDITOR
    010199  HIJO DUEÑO
  010200  CAJA RECOLECTORA
    010201  CONTROL ESCOLAR
    010299  RECTORÍA
```

## Restricciones

| Opción | Regla |
|:------:|-------|
| **1** | No se podrá registrar una cuenta si no existe la subcuenta o cuenta a la que pertenece. |
| **2** | No se podrá eliminar una cuenta que tenga subcuentas o sub-subcuentas, o si su saldo de cargos y abonos es diferente entre ellos. <br>*Ej.: no se puede borrar `090000` porque tiene subcuentas; sí se puede borrar `090201` si no tiene sub-subcuentas y su cargo y abono son iguales.* |
| **3** | Sólo se podrán capturar **sub-subcuentas**, y el movimiento debe afectar los **3 niveles** de cuentas a los que pertenece. <br>*Ej.: un cargo de `1000` a la cuenta `090203` afecta 3 nodos del árbol: `090203`, `090200` y `090000`.* |
| **4** | Cuando se localice una cuenta de mayor sin cargo ni abono, se deben eliminar también todas sus subcuentas y sub-subcuentas. |
| **5** | Debe mostrar los cargos y abonos de la cuenta proporcionada y de sus subcuentas y sub-subcuentas. |
| **6** | Debe mostrar las cuentas ordenadas en forma descendente. |

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`Cuenta.java`](Cuenta.java) | Cuenta contable con nivel, cargo y abono. |
| [`ArbolCuentas.java`](ArbolCuentas.java) | Operaciones del catálogo sobre `ArbolBB<Cuenta>`. |
| [`AplArbolCuenta.java`](AplArbolCuenta.java) | Menú interactivo con las 7 opciones. |
