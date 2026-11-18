# Estructuras Lineales

Implementación genérica de pilas, colas y listas, tanto **estáticas** (arreglos) como **dinámicas** (nodos enlazados), y sus aplicaciones.

## 📂 Contenido

### 🧪 Ejercicios en clase

#### Estructuras estáticas — [`ejercicios/estaticas/`](ejercicios/estaticas/)

| Archivo | Tema |
|---------|------|
| [`Pila.java`](ejercicios/estaticas/Pila.java) · [`AplPila.java`](ejercicios/estaticas/AplPila.java) | Pila genérica sobre arreglo. |
| [`Cola.java`](ejercicios/estaticas/Cola.java) | Cola lineal genérica. |
| [`ColaCir.java`](ejercicios/estaticas/ColaCir.java) | Cola circular. |
| [`Bicola.java`](ejercicios/estaticas/Bicola.java) | Bicola (retiro por ambos extremos). |
| [`ColaOrdenada.java`](ejercicios/estaticas/ColaOrdenada.java) · [`AplColaOrdenada.java`](ejercicios/estaticas/AplColaOrdenada.java) | Cola con prioridad (inserción ordenada). |
| [`Posfija.java`](ejercicios/estaticas/Posfija.java) · [`AplPosfija.java`](ejercicios/estaticas/AplPosfija.java) | Evaluación de expresiones en notación **posfija** con pila. |
| [`VeridicarParentesis.java`](ejercicios/estaticas/VeridicarParentesis.java) · [`AplVeridicarParentesis.java`](ejercicios/estaticas/AplVeridicarParentesis.java) | Verificación de paréntesis balanceados. |
| [`Persona.java`](ejercicios/estaticas/Persona.java) | Clase de datos para los ejemplos. |

#### Estructuras dinámicas — [`ejercicios/dinamicas/`](ejercicios/dinamicas/)

| Archivo | Tema |
|---------|------|
| [`Nodo.java`](ejercicios/dinamicas/Nodo.java) · [`Lista.java`](ejercicios/dinamicas/Lista.java) · [`AplLista.java`](ejercicios/dinamicas/AplLista.java) | Lista simplemente ligada (inserción al frente, final y ordenada; borrado y búsqueda). |
| [`NodoDbl.java`](ejercicios/dinamicas/NodoDbl.java) · [`ListaDbl.java`](ejercicios/dinamicas/ListaDbl.java) · [`AplListaDbl.java`](ejercicios/dinamicas/AplListaDbl.java) | Lista doblemente ligada. |
| [`ListaCircular.java`](ejercicios/dinamicas/ListaCircular.java) · [`AplListaCircular.java`](ejercicios/dinamicas/AplListaCircular.java) | Lista circular. |
| [`Polinomios.java`](ejercicios/dinamicas/Polinomios.java) · [`AplPolinomio.java`](ejercicios/dinamicas/AplPolinomio.java) | Suma de polinomios representados con listas. |

### 📝 Tareas

| Proyecto | Estructura | Tema |
|----------|-----------|------|
| [Amortiguador](tareas/amortiguador/) | Pila estática | Simulación del desgaste de los discos de un amortiguador. |
| [Spool de impresión](tareas/spool/) | Cola estática | Envío, impresión y estado actual de reportes. |
| [Spool circular con prioridad y límite](tareas/spoolcircular/) | Cola circular | Reportes divididos en secciones y ordenados por formato. |
| [Serpientes y Escaleras](tareas/serpientesyescaleras/) | Lista doble | Tablero y simulación del juego con 2 – 5 jugadores. |

### 📋 Examen — [`examen/`](examen/)

**Examen Unidad · ED lineales estáticas y dinámicas.** Generación de 10 000 – 20 000 préstamos (año, estado, importe) en una lista ordenada; cálculo de acumulados por año/estado, obtención de los mayores en una cola y eliminación de esos préstamos de la lista original.

| Archivo | Descripción |
|---------|-------------|
| [`Prestamo.java`](examen/Prestamo.java) | Préstamo con año, estado e importe. |
| [`EDPrestamos.java`](examen/EDPrestamos.java) | Solución (incluye los comentarios de revisión del profesor). |
| [`MyInterface.java`](examen/MyInterface.java) | Interfaz implementada por `EDPrestamos`. |

### 🔁 Recuperación

| Proyecto | Tema |
|----------|------|
| [Parcial #3 · Segunda oportunidad](recuperacion/) | Eliminación de nombres de una pila según las posiciones guardadas en otra pila. |
