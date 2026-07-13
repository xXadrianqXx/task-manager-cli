# 📋 Task Manager CLI

> Una aplicación de gestión de tareas desarrollada en Kotlin para la terminal.  
> Practica de lógica de programación, manejo de archivos JSON y .txt y flujos de menú interactivo.

---

## 🚀 Características

- ✅ Agregar tareas con título y prioridad
- 📋 Listar tareas ordenadas por prioridad
- 🔍 Buscar tareas por ID o nombre
- ✏️ Editar tareas existentes (Incompleto)
- ✅ Marcar tareas como completadas (Incompleto)
- 🗑️ Eliminar tareas(Incompleto)
- 💾 Guardar y cargar tareas en JSON(Incompleto)

---

## 🛠️ Tecnologías usadas

- **Kotlin** - Lenguaje principal
- **Terminal** - Interfaz de usuario
- **Termux** - Entorno de desarrollo (Android)
- **Git** - Control de versiones


---

## 📦 Instalación

```bash
# 1. Clona el repositorio
git clone https://github.com/xXadrianqXx/task-manager-cli

# 2. Entra al directorio
cd task-manager-cli

# 3. Compila el Script(Solo la primera vez) 
kotlinc Task.kt -runtime-include -d Task.jar

# 4. Ejecuta
kotlin Task.jar
```
**Requisito:** Tener instalado Java y Kotlin.
---
**Actualización**

```
#Tambien puede usar java -jar [ejecutableName]
java -jar Tarea.jar
```

---

🎯 Uso

Al ejecutar la app, verás un menú principal como este:

```bash
  GESTOR DE TAREAS
1.  Agregar tarea
2.  Listar tareas
3.  Buscar tarea
4.  Marcar completada
5.  Editar tarea
6.  Eliminar tarea
7.  Guardar tareas
8.  Salir
```

Selecciona una opción escribiendo el número correspondiente y sigue las instrucciones en pantalla.

---

📁 Estructura del proyecto

```
task-manager-cli/
├── Task.kt               # Código fuente principal
├── tareas.json/.txt           # Archivo de datos (se genera automáticamente)
├── README.md             # Este archivo
└── .gitignore            # Archivos ignorados por Git
```

---

📝 Ejemplo de uso

```bash
# Agregar una tarea
➜ Ingrese el título de la tarea: Aprender Kotlin
✅ Tarea agregada con ID: 1

# Listar tareas
➜ [⬜] 1. Aprender Kotlin [PRIORIDAD: Alta]

# Buscar por nombre
➜ Ingrese el nombre a buscar: Kotlin
✅ Tarea encontrada: 1. Aprender Kotlin [PRIORIDAD: Alta]

# Marcar como completada
➜ Ingrese el ID de la tarea a completar: 1
✅ Tarea marcada como completada

# Listar nuevamente
➜ [✅] 1. Aprender Kotlin [PRIORIDAD: Alta]
```

---

¿Qué se práctico?

· Manejo de colecciones en Kotlin (list, filter, map, sortedBy)
· Persistencia de datos con JSON
· Entrada y salida por consola
· Control de flujo con when y bucles
· Organización de código en funciones
· Uso de Git y GitHub para control de versiones
· Creación de ejecutables .jar para distribución

---

Contribuciones

Este es un proyecto personal para practicar Kotlin.
Si tienes sugerencias, mejoras o encuentras algún error, ¡son bienvenidas!
Puedes abrir un Issue o un Pull Request.

---

📄 Licencia

Este proyecto está bajo la licencia MIT.
Puedes usarlo, modificarlo y distribuirlo libremente.

---

👨‍💻 Autor

Adrian

· GitHub: @xXadrianqXx
· Proyecto creado para practicar lógica de programación y Kotlin.

---

Si te fue útil, ¡dale una ⭐ al repositorio!

---

Nota: Este proyecto fue desarrollado y probado en Termux (Android), pero funciona en cualquier sistema con Java/Kotlin instalado.


