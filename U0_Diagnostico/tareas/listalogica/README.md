# Proyecto 01 · Lista lógica de clientes

> **Unidad 0 · Diagnóstico** — Ordenamiento lógico de un arreglo de objetos a partir de un archivo CSV.

## Planteamiento

La oficina donde usted trabaja recibió recientemente el archivo de texto **`CLIENTES.CSV`** (organización secuencial), con el siguiente registro lógico:

| CLIENTES.CSV |
|--------------|
| `NoCliente`  |
| `Nombre`     |
| `IdEstado`   |

Se desea que desarrolle las clases Java necesarias para crear un **arreglo unidimensional de objetos** de la clase `Cliente` que se muestra a continuación:

```java
class Clientes {
    private String nomCliente;
    private String nomEstado;
    private int Siguiente;
}
```

## Restricciones del arreglo de objetos

1. Debe contener tantos elementos como el `NoCliente` mayor contenido en el CSV.
2. Cada cliente del archivo CSV debe asignarse en el elemento que representa su `NoCliente`.
3. La información del arreglo debe quedar ordenada de **forma lógica** (mediante el atributo `Siguiente`) por **nombre de estado** y **nombre del cliente**.

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`Cliente.java`](Cliente.java) | Clase del registro con el enlace lógico `siguiente`. |
| [`ListaLogica.java`](ListaLogica.java) | Arreglo de clientes con inserción ordenada lógicamente. |
| [`AplLista.java`](AplLista.java) | Aplicación: lee el CSV, llena la lista e imprime el recorrido. |
| [`CLIENTES.CSV`](CLIENTES.CSV) | Archivo de datos de entrada (1000 registros). |
