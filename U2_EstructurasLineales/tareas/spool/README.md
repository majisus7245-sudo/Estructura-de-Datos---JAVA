# Spool de impresión

> **Estructuras Lineales** — Simulación con una **cola estática**.

## Planteamiento

Elabore las clases Java necesarias que permitan representar el funcionamiento del **spool de impresión**, haciendo uso de las siguientes políticas:

- El spool tiene capacidad para almacenar **N (20 – 50) reportes**.
- Los reportes serán objetos con los atributos:
  - `NoComputadora` (1 – 5)
  - `NoHojas` (1 – 500)
  - `formato` (1 – 5)
- Al spool se pueden **enviar** e **imprimir** reportes.

### En la aplicación

- El programa debe realizar **AC (10 – 30) actividades exitosas** (enviar al spool y retirar del spool).
- Para realizar una actividad, el programa debe generar un valor aleatorio en el rango **1 – 3**:

  | Valor | Acción |
  |:-----:|--------|
  | 1 | Enviar reporte al spool |
  | 2 | Sacar reporte del spool (imprimir) |
  | 3 | Mostrar el estado actual del spool |

  > ⚠️ **Restricción:** después de mostrar el estado actual, el spool debe quedar **exactamente en las mismas condiciones** en que se encontraba.

- En cada operación de envío o de impresión se debe mostrar información con el resultado de la operación.

### Estructura sugerida

```java
class Spool {
    private Cola<Reporte> cola;

    public Spool() {
        cola = new Cola(Rutinas.nextInt(20, 50));
    }

    public boolean Enviar(Reporte reporte) { }

    public boolean Imprimir() { }

    // El spool no debe alterar las posiciones de los reportes.
    public void EstadoActual() { }
}

Spool spool = new Spool();
```

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`Spool.java`](Spool.java) | Clase `Registro` (reporte) y el spool sobre una `Cola`. |
| [`AplSpool.java`](AplSpool.java) | Aplicación que realiza las actividades aleatorias. |
