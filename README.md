<div align="center">

# 🗂️ Estructura de Datos

**Ejercicios en clase, tareas, exámenes y recuperaciones de la materia de Estructura de Datos, implementados en Java.**

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Eclipse](https://img.shields.io/badge/IDE-Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white)
![Periodo](https://img.shields.io/badge/Periodo-Ago--Dic%202024-1f6feb?style=for-the-badge)

</div>

---

## 📖 Acerca del repositorio

Este repositorio reúne todo el trabajo realizado durante el curso de **Estructura de Datos**: desde el diagnóstico inicial hasta el manejo de archivos. Cada estructura se implementa **desde cero** con clases genéricas (`Pila<T>`, `Cola<T>`, `Lista<T>`, `ArbolBB<T>`, `Grafo`…) y después se aplica a problemas concretos como simulaciones, juegos y procesamiento de archivos.

El contenido está organizado **por unidad**, y dentro de cada una se separa en:

| Carpeta | Contenido |
|---------|-----------|
| 🧪 `ejercicios/` | Código desarrollado en clase junto con el profesor. |
| 📝 `tareas/` | Proyectos individuales, cada uno con un `README.md` con las instrucciones originales. |
| 📋 `examen/` | Exámenes de unidad (algunos con comentarios de revisión del profesor). |
| 🔁 `recuperacion/` | Exámenes de segunda oportunidad. |

---

## 📚 Unidades

| Unidad | Temas | Tareas y evaluaciones |
|:------:|-------|-----------------------|
| [**0 · Diagnóstico y Fundamentos**](U0_Diagnostico/) | POO, arreglos de objetos, clonación profunda por serialización, utilerías (`Rutinas`) | [Lista lógica de clientes](U0_Diagnostico/tareas/listalogica/) |
| [**Recursividad**](U1_Recursividad/) | Caso base, recursividad directa e indirecta, *backtracking* (8 reinas) | [Métodos recursivos](U1_Recursividad/tareas/proyecto02/) |
| [**Estructuras Lineales**](U2_EstructurasLineales/) | Pilas, colas, colas circulares, bicolas, colas de prioridad, notación posfija; listas simples, dobles y circulares | [Amortiguador](U2_EstructurasLineales/tareas/amortiguador/) · [Spool](U2_EstructurasLineales/tareas/spool/) · [Spool circular](U2_EstructurasLineales/tareas/spoolcircular/) · [Serpientes y Escaleras](U2_EstructurasLineales/tareas/serpientesyescaleras/) · [Examen](U2_EstructurasLineales/examen/) · [Recuperación](U2_EstructurasLineales/recuperacion/) |
| [**Estructuras No Lineales**](U3_EstructurasNoLineales/) | Árboles binarios de búsqueda, grafos ponderados, algoritmo de Dijkstra | [Árbol de cuentas contables](U3_EstructurasNoLineales/tareas/proyectoabb/) · [Examen](U3_EstructurasNoLineales/examen/) |
| [**Métodos de Ordenamiento**](U4_MetodosDeOrdenamiento/) | Burbuja, intercambio, inserción, QuickSort, MergeSort; ordenamiento externo | [QuickSort en memoria externa](U4_MetodosDeOrdenamiento/tareas/quicksortexterno/) |
| [**Métodos de Búsqueda**](U5_MetodosDeBusqueda/) | Búsqueda secuencial, `Hashtable`, `HashMap` vs `TreeMap` | — |
| [**Manejo de Archivos y Excepciones**](U6_ArchivosYExcepciones/) | Excepciones propias, archivos secuenciales, de acceso directo, indexados y encadenados; persistencia de objetos | — |

📎 Las presentaciones del curso están en [`materiales/`](materiales/).

---

## 🗺️ Estructura del proyecto

```text
Estructura de Datos/
├── U0_Diagnostico/
│   ├── utilerias/            → Rutinas (usada en todo el repositorio)
│   ├── ejercicios/clonacion/
│   └── tareas/listalogica/
├── U1_Recursividad/
│   ├── ejercicios/
│   └── tareas/proyecto02/
├── U2_EstructurasLineales/
│   ├── ejercicios/
│   │   ├── estaticas/        → Pila, Cola, ColaCir, Bicola, ColaOrdenada…
│   │   └── dinamicas/        → Lista, ListaDbl, ListaCircular…
│   ├── tareas/
│   │   ├── amortiguador/
│   │   ├── spool/
│   │   ├── spoolcircular/
│   │   └── serpientesyescaleras/
│   ├── examen/
│   └── recuperacion/
├── U3_EstructurasNoLineales/
│   ├── ejercicios/           → ArbolBB, Grafo (Dijkstra)
│   ├── tareas/proyectoabb/
│   └── examen/
├── U4_MetodosDeOrdenamiento/
│   ├── ejercicios/
│   └── tareas/quicksortexterno/
├── U5_MetodosDeBusqueda/
│   └── ejercicios/
├── U6_ArchivosYExcepciones/
│   └── ejercicios/
└── materiales/               → Presentaciones del curso (.ppt)
```

> 💡 Los nombres de carpeta son identificadores válidos de Java, por lo que **cada carpeta corresponde a un paquete**
> (por ejemplo, `U2_EstructurasLineales/tareas/spool/` → `package U2_EstructurasLineales.tareas.spool;`).
> Las tareas reutilizan las estructuras de los ejercicios en clase mediante `import`.

---

## ▶️ Cómo compilar y ejecutar

**Requisitos:** JDK 17 o superior.

### Con Eclipse / IntelliJ IDEA

1. Crea un proyecto Java nuevo y usa la **raíz del repositorio** como carpeta de código fuente (`src`).
2. Ejecuta cualquier clase que tenga un método `main` (normalmente las que empiezan con `Apl…`).

### Desde la terminal

Desde la raíz del repositorio:

```bash
# Compilar todo
javac -encoding UTF-8 -d out $(find . -name "*.java")

# Ejecutar un programa (nombre completo del paquete + clase)
java -cp out U2_EstructurasLineales.tareas.serpientesyescaleras.SerpientesYEscaleras
```

En **Windows (PowerShell)**:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java).FullName
java -cp out U1_Recursividad.ejercicios.OchoReinas
```

> 📁 Los programas que trabajan con archivos (`AMIGOS.DAT`, `CLIENTES.CSV`, etc.) los buscan en el **directorio de trabajo**. Ejecútalos desde la carpeta donde está el archivo de datos, o cópialo al directorio desde donde ejecutas.

---

## 👤 Autor

| | |
|---|---|
| **Alumno** | Manuel de Jesús Inzunza Lara |
| **Materia** | Estructura de Datos |
| **Profesor** | Dr. Gerardo Clemente García |
| **Periodo** | Agosto – Diciembre 2024 |

<div align="center">

*Repositorio con fines académicos.*

</div>
