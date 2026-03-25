# TALLER BLOQUE 3
## Taller para Trabajo en Casa

### 🎯 Objetivo
Aplicar diseño orientado a objetos a un sistema real mediante identificación de 
> - clases,
> - atributos
> - métodos y
> - relaciones.

---

## 📋 Caso Práctico
**Diseñar un sistema orientado a objetos para:** *Plataforma digital de gestión de cursos universitarios*

> 💡 El sistema debe permitir:
> - Registro de estudiantes
> - Gestión de cursos
> - Inscripción
> - Pagos
> - Calificaciones

---

## Actividad 1 — Identificación de Objetos
**Programación Orientada a Objetos (POO)**

### 1. ¿Qué objetos existen en el sistema?


> - Estudiante
> - Profesor
> - Administrador
> - Rol
> - Curso
> - Materia
> - Facultad
> - Semestre
> - Notas 
> - Pago 
> - Calificaciones
> - Contenido
> - Documento.

---

### 2. ¿Cuáles son principales?


> | Objeto | Rol en el sistema |
> |---|---|
> | **Estudiante** | Actor central; todo gira en torno a su aprendizaje |
> | **Docente** | Crea y gestiona el contenido académico |
> | **Curso** | La unidad académica fundamental del sistema |
> | **Inscripción** | El vínculo que une al estudiante con el curso |
> | **Pago** | Habilita la inscripción; sin él no hay acceso |
> | **Calificación** | El resultado final del proceso académico |

---

### 3. ¿Cuáles apoyan el sistema?


> | Objeto | Qué apoya |
> |---|---|
> | **Administrador** | Gestiona usuarios, períodos y verifica pagos |
> | **PeriodoAcademico** | Organiza los cursos en el tiempo |
> | **Modulo** | Estructura interna del Curso |
> | **Contenido** | Material del que se compone cada Módulo |
> | **Evaluacion / Tarea / Examen** | Mecanismos para generar Calificaciones |
> | **PagoReferenciaBancaria** | Implementación concreta del proceso de pago |
> | **ReporteNotas** | Consolida y exporta información académica |
> | **Notificacion** | Comunicación interna del sistema hacia los usuarios |
> | **Enumeraciones** *(RolUsuario, EstadoCurso, EstadoInscripcion, etc.)* | Controlan los estados válidos de cada objeto |

---

## Actividad 2 — Diseño de Clases

Seleccionar mínimo **6 clases**. Para cada clase definir:
- Nombre
- Atributos
- Métodos

**Entregable:** tabla o diagrama de clases simple.

> 📌 Diagrama de clases
![Diagrama de clases](/Taller_Bloque_3/diagramas/diagrama_de_clases.png)

> 📎 [Ver diagrama de clases](https://drive.google.com/file/d/1xnWOROU3uoFEMClcIQsFn-T8JD3uFgN6/view?usp=sharing)

---

## Actividad 3 — Aplicación de POO

Explicar en máximo **1 página**:

**1.	Cómo aplicó encapsulamiento**
Haciendo que los datos internos del objeto solo se modifiquen a travez de sus propios metodos, se sabe que en los atributos el signo (-) hace referencia a un atributo privado

**2.	Ejemplo de herencia**
 Se crea una clase abstracta llamada Usuario, que contiene los atributos y métodos comunes a todos los usuarios del sistema, como nombre, correo electrónico, contraseña, y métodos para autenticarse o recuperar la contraseña. A partir de esta clase base se derivan tres subclases que son Estudiante, Profesor, Administrador que tambien contienen atributos y metodos propios

**3.	Ejemplo de abstracción**
 Ejemplo con la clase Pago, no puede instanciarse directamente si no que esta clase define la estructura y los métodos que todos los tipos de pago deben tener, como el monto, la fecha, el estado, y la obligación de procesar el pago y generar un comprobante. 
A partir de esta clase abstracta, se crea la clase concreta PagoTransferencia, que implementa los métodos específicos para procesar pagos realizados mediante transferencia bancaria, incluyendo la validación del número de referencia y la generación de facturas electrónicas.
De esta manera, cualquier nuevo método de pago que se quiera agregar en el futuro solo debe heredar de la clase Pago e implementar sus métodos específicos, sin modificar la estructura existente.

**4.	Ejemplo de polimorfismo**
 Cuando se invoca el método "getRol" desde un objeto de tipo Usuario, cada clase hija responde de manera diferente. Si el usuario es un administrador, el método retorna "ADMINISTRADOR"; si es un profesor, retorna "PROFESOR"; y si es un estudiante, retorna "ESTUDIANTE". El sistema no necesita saber qué tipo específico de usuario es, simplemente llama al método y cada objeto sabe cómo responder.



---

## Actividad 4 — Relaciones entre Clases

Definir:
- **Asociación**
- **Herencia**
- **Dependencias**

> 📝 No obligatorio UML formal, puede ser diagrama libre.

> 📌 Asociación Unidireccional
![Asociación Unidireccional](/Taller_Bloque_3/diagramas/Asociación_Unidireccional.png)
El profesor conoce los cursos que dicta, pero los cursos no necesitan conocer a todos los  profesores de la universidad

> 📌 Asociación Bidireccional
![Asociación Bidireccional](/Taller_Bloque_3/diagramas/Asociación_Bidireccional.png)
Un estudiante conoce sus inscripciones, y cada inscripción conoce al estudiante al que  pertenece.

> 📌 Asociación con  Multiplicidad
![Asociación con Multiplicidad](/Taller_Bloque_3/diagramas/Multiplicidad.png)
·	Un estudiante puede tener muchas inscripciones (1 a *)
·	Un curso puede tener muchos estudiantes inscritos (1 a *)
·	Un profesor puede dictar muchos cursos (1 a *)
·	Una inscripción pertenece a un solo estudiante (* a 1)


> 📌 Herencia 
![Herencia](/Taller_Bloque_3/diagramas/herencia.png)

> 📌 Dependencia
![Dependencia](/Taller_Bloque_3/diagramas/dependencia.png)
 




---

## Actividad 5 — Análisis de Diseño

Responder:
**1. ¿Qué clase es más importante?**
La clase Inscripción porque es el eje del sistema, sin esta clase no exisitiria un pago, no hubiera relacion entre el estudiante y el curso.

**2. ¿Cuál cambiaría más si el sistema crece?**
La clase Curso ya que si empieza a crecer el sistema llegarian nuevas reglas de negocio y esta clase es la que tendria mayor impacto

**3. ¿Qué parte podría reutilizarse en otra app?**
La parte de Pago


---

## ⭐ Reto Opcional *(Nota Alta)*

> 💡 Mejorar el diseño:
> - Identificar errores
> - Proponer refactorización
> - Justificar mejora

---

## 📤 Formato de Entrega

Documento **PDF o Word** con:
> - Diagramas
> - Explicaciones
> - Portada con integrantes

---

## 📊 Criterios de Evaluación


> | Criterio | Descripción |
> |---|---|
> | ✅ Identificación de objetos | Correcta identificación de objetos del sistema |
> | ✅ Coherencia de clases | Las clases reflejan el dominio del problema |
> | ✅ Aplicación de POO | Uso correcto de encapsulamiento, herencia, abstracción y polimorfismo |
> | ✅ Claridad del diseño | Diagramas y explicaciones comprensibles |
> | ✅ Argumentación técnica | Justificación sólida de las decisiones de diseño |
> | ✅ Orden y presentación | Documento bien estructurado y presentado |