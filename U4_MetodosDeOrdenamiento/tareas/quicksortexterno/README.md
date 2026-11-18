# Proyecto · QuickSort en memoria externa

> **Métodos de Ordenamiento** — Ordenamiento **físico** de un archivo binario de acceso directo.

## Planteamiento

Usted acaba de recibir el archivo **`AMIGOS.DAT`** de organización de **acceso directo** (binario). El registro lógico se describe en la siguiente tabla:

| Campo | Tipo | Bytes |
|-------|------|------:|
| `Nombre` | String 40 + 2 | 42 |
| `Edad` | int | 4 |
| `Estatura` | int | 4 |
| `Color` | String 15 + 2 | 17 |
| `Vig` | char | 2 |
| | **Longitud del registro** | **69** |

Se desea que desarrolle las clases Java necesarias para implementar el método de ordenamiento **QuickSort** para ordenar **de forma física** el archivo `AMIGOS.DAT` por los atributos **color** y **nombre**.

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`OrdenamientoExterno.java`](OrdenamientoExterno.java) | QuickSort que lee y sobrescribe registros directamente en el archivo con `RandomAccessFile`. |
| [`AMIGOS.DAT`](AMIGOS.DAT) | Archivo de datos (10 000 registros de 69 bytes). |
| [`referencia/CrearArchivoDirecto.java`](referencia/CrearArchivoDirecto.java) | Programa de referencia proporcionado para generar `AMIGOS.DAT`. |

## Programa de referencia: `CrearArchivoDirecto`

Programa proporcionado en clase que genera el archivo `AMIGOS.DAT` con la estructura descrita arriba. Sigue el patrón **Abrir → Crear → Imprimir → Cerrar**:

| Método | Qué hace |
|--------|----------|
| `Abrir()` | Abre `AMIGOS.DAT` con `RandomAccessFile` en modo `"rw"`. |
| `Crear()` | Se posiciona al final del archivo y agrega **10 000 registros** aleatorios usando `Rutinas` (nombre, color, edad 18 – 65 y estatura 170 – 199). Los textos se ajustan a longitud fija con `PonBlancos` para que cada registro mida exactamente 69 bytes. |
| `Imprimir()` | Calcula el número de registros (`length() / 69`) y los muestra en forma tabular. |
| `Cerrar()` | Cierra el archivo. |

Fragmento clave — escritura de un registro de longitud fija:

```java
nombre = Rutinas.PonBlancos(nombre, 40);   // 40 + 2 bytes (writeUTF)
color  = Rutinas.PonBlancos(color, 15);    // 15 + 2 bytes (writeUTF)

arch.writeUTF(nombre);    // 42
arch.writeInt(edad);      //  4
arch.writeInt(estatura);  //  4
arch.writeUTF(color);     // 17
arch.writeChar(vig);      //  2  → 69 bytes por registro
```

Gracias a la longitud fija, el registro `i` se localiza directamente con `arch.seek(i * 69)`, que es lo que permite aplicar QuickSort sobre el archivo sin cargarlo completo en memoria.

> ▶️ Los programas leen y escriben `AMIGOS.DAT` en el **directorio de trabajo**; ejecútelos desde esta carpeta o copie ahí el archivo.
