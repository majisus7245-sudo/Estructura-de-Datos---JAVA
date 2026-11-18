# Spool circular con prioridad y límite

> **Estructuras Lineales** — Variante del [Spool de impresión](../spool/) usando una **cola circular**.

> ℹ️ Esta tarea no contaba con un documento de instrucciones; la descripción se obtuvo del código entregado.

## Descripción

Extiende el proyecto del spool con las siguientes reglas:

- El spool es una **cola circular** (`ColaCir`) con capacidad de **40 – 60 secciones**.
- Cada reporte tiene `NoComputadora`, total de hojas y `formato`.
- **Límite:** un reporte se divide en **secciones de máximo 50 hojas**; cada sección ocupa un lugar en el spool. Si no hay espacio suficiente para todas sus secciones, el reporte se rechaza.
- **Prioridad:** los reportes se acomodan en la cola según su **formato**, de modo que los de menor formato se imprimen primero.
- Para verificar espacio y mostrar el estado actual se trabaja sobre una **copia profunda** de la cola (clonación por serialización), sin alterar el spool original.

## Archivos

| Archivo | Descripción |
|---------|-------------|
| [`SpoolCircular.java`](SpoolCircular.java) | Versión entregada: clase `Registro` y el spool circular. |
| [`AplSpoolCircular.java`](AplSpoolCircular.java) | Aplicación que realiza las actividades aleatorias. |
| [`revisado/SpoolCircular.java`](revisado/SpoolCircular.java) | Misma versión con los **comentarios de revisión del profesor**. |
