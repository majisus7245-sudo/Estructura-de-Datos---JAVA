# Manejo de Archivos y Excepciones

Manejo de excepciones, archivos secuenciales de texto, archivos binarios de **acceso directo**, archivos **indexados** y **encadenados**, y persistencia de objetos.

> ▶️ Estos programas crean y leen archivos (`AMIGOS.DAT`, `AUTOS.DAT`, `*.CVS`…) en el **directorio de trabajo**. Algunos dependen de que otro programa haya generado el archivo antes (por ejemplo, `CrearArchivoDirecto` → `ActualizarAmigos`).

## 📂 Contenido — [`ejercicios/`](ejercicios/)

### ⚠️ Excepciones

| Archivo | Tema |
|---------|------|
| [`AplErrores.java`](ejercicios/AplErrores.java) · [`AplErroresV2.java`](ejercicios/AplErroresV2.java) | `try` / `catch` / `finally` y propagación de errores entre métodos. |
| [`MiExcepcion.java`](ejercicios/MiExcepcion.java) · [`Excepciones.java`](ejercicios/Excepciones.java) · [`AplLanzoExcepcion.java`](ejercicios/AplLanzoExcepcion.java) | Excepciones propias, `throw` y `throws`. |
| [`EstacionGasolina.java`](ejercicios/EstacionGasolina.java) · [`AplEstacionBombas.java`](ejercicios/AplEstacionBombas.java) | Carga de usuarios/contraseñas de bombas desde `BOMBAS.DAT`; si el archivo falla, la excepción marca la estación como no creada. |
| [`Sleep.java`](ejercicios/Sleep.java) | Pausas con `Thread.sleep`. |

### 📄 Archivos secuenciales (texto)

| Archivo | Tema |
|---------|------|
| [`AplFAO.java`](ejercicios/AplFAO.java) | Lectura byte a byte con `FileInputStream` *(usa una ruta absoluta del equipo del profesor)*. |
| [`ArchivoSecuencialCrearAmigos.java`](ejercicios/ArchivoSecuencialCrearAmigos.java) · [`ArchivoSecuencialLeerAmigos.java`](ejercicios/ArchivoSecuencialLeerAmigos.java) | Creación y lectura de un archivo de texto. |
| [`ArchivoSecuencialContarAmigos.java`](ejercicios/ArchivoSecuencialContarAmigos.java) · [`ArchivoSecuencialFrecuenciaAmigos.java`](ejercicios/ArchivoSecuencialFrecuenciaAmigos.java) | Conteo y frecuencias sobre un archivo secuencial. |
| [`ArchivoSecuencialCVS.java`](ejercicios/ArchivoSecuencialCVS.java) · [`ArchivoSecuencialLerrCVS.java`](ejercicios/ArchivoSecuencialLerrCVS.java) · [`ArchivoSecuencialCVSctualizar.java`](ejercicios/ArchivoSecuencialCVSctualizar.java) | Creación, lectura y actualización de archivos CSV (archivo de trabajo + renombrado). |
| [`CrearArchivoVentas2023.java`](ejercicios/CrearArchivoVentas2023.java) · [`ArchivoSecuencialVentas.java`](ejercicios/ArchivoSecuencialVentas.java) | Archivo de ventas y su procesamiento. |

### 💾 Archivos de acceso directo (binarios)

| Archivo | Tema |
|---------|------|
| [`CrearArchivoDirecto.java`](ejercicios/CrearArchivoDirecto.java) | Creación de `AMIGOS.DAT` con registros de longitud fija (69 bytes). |
| [`ActualizarAmigos.java`](ejercicios/ActualizarAmigos.java) · [`BaJaAmigosDat.java`](ejercicios/BaJaAmigosDat.java) | Modificación y baja lógica de registros con `seek`. |
| [`AutosPlaca.java`](ejercicios/AutosPlaca.java) · [`IdxContenido.java`](ejercicios/IdxContenido.java) | Simulación de un **archivo indexado** (`AUTOS.DAT` + índice por placa). |
| [`ArchivosParaEncadenar.java`](ejercicios/ArchivosParaEncadenar.java) · [`ArchivosParaEncadenarPri.java`](ejercicios/ArchivosParaEncadenarPri.java) | Archivos **encadenados** (folios → movimientos ligados por posición). |

### 📦 Persistencia de objetos

| Archivo | Tema |
|---------|------|
| [`GrabarObjetos.java`](ejercicios/GrabarObjetos.java) · [`LeerObjetosPersistentes.java`](ejercicios/LeerObjetosPersistentes.java) | Serialización de objetos con `ObjectOutputStream` / `ObjectInputStream`. |
| [`Contacto.java`](ejercicios/Contacto.java) · [`AplContactos.java`](ejercicios/AplContactos.java) | Agenda de contactos persistente. |
