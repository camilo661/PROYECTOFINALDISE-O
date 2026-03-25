# TALLER BLOQUE 2

## 🏫 Caso
**Diseñar un sistema para:** *Gestión de pedidos en una cafetería universitaria digital*

El sistema debe permitir:
- Ver menú
- Realizar pedido
- Pagar
- Notificar preparación
- Entregar pedido

---

## Actividad 1 — Abstracción

Definir:
1. Objetivo del sistema
2. Actores
3. Funciones principales
4. Límites del sistema

**Entregable:**
> 📌 Diagrama de contexto
![Diagrama de contexto](/Taller_Bloque_2/Diagramas/diagrama_de_contexto.png)

---

## Actividad 2 — Modularidad

Dividir en módulos:
- Usuarios
- Pedidos
- Pagos
- Cocina
- Notificaciones

**Entregable:**
> 📌 Diagrama de módulos
![Diagrama de módulos](/Taller_Bloque_2/Diagramas/diagrama_de_modulos.png)

---

## Actividad 3 — Refinamiento

Elegir módulo **"Pedidos"** y descomponerlo a bajo nivel.

**Entregable:**
> 📌 Diagrama de casos de uso
![Diagrama detallado - Módulo Pedidos](/Taller_Bloque_2/Diagramas/diagrama_de_casos_de_uso.png)


> 📌 Diagrama de clases
![Diagrama detallado - Módulo Pedidos](/Taller_Bloque_2/Diagramas/diagrama_de_clases.png)
---

## Actividad 4 — Aplicación de Principios

### 🔄 Flexibilidad del diseño
El diseño es flexible cuando puede adaptarse a cambios sin necesidad de reescribir grandes porciones del sistema. Esto se logra aplicando principios como **Open/Closed** (el código se extiende sin modificarse) y **Dependency Inversion** (los módulos dependen de abstracciones, no de implementaciones concretas). Por ejemplo, si el sistema usa una interfaz `IRepositorio`, se puede cambiar la base de datos subyacente sin tocar la lógica de negocio.

### 🧪 Facilidad para pruebas
Un buen diseño hace que el software sea naturalmente testeable. Cuando los componentes tienen responsabilidades únicas y bien definidas (principio **SRP**), es posible probar cada uno de forma aislada.

La **inyección de dependencias** permite sustituir componentes reales por *mocks* o *stubs* durante las pruebas, sin modificar el código fuente. Así, por ejemplo, se puede probar la lógica de negocio sin necesidad de conectarse a una base de datos real. Esto reduce el costo y el tiempo de las pruebas unitarias e de integración, y aumenta la confianza en el sistema.

### ♻️ Reutilización de componentes
La reutilización parte del principio **DRY**: la lógica común se encapsula en módulos, servicios o librerías que múltiples partes del sistema pueden consumir. Por ejemplo, un módulo de autenticación, un componente de envío de correos o una utilidad de validación de datos pueden ser utilizados desde distintos flujos sin duplicar código. Esto reduce errores, acelera el desarrollo y centraliza el mantenimiento: si hay un cambio en la lógica compartida, se actualiza en un solo lugar y todos los consumidores se benefician automáticamente.

### 🏢 Escalabilidad a varias sedes
Si el sistema crece para operar en múltiples sedes, un diseño bien estructurado lo soporta sin traumatismos mayores. La separación de capas (presentación, lógica de negocio, datos) permite escalar cada nivel de forma independiente. Si las sedes requieren datos propios, se pueden agregar nuevos esquemas o instancias de base de datos sin alterar la lógica central. Si se necesita mayor capacidad de procesamiento, los módulos desacoplados pueden desplegarse como servicios independientes o microservicios distribuidos. Sin este diseño, el crecimiento implicaría reescribir el sistema desde cero, con altos costos y riesgos; con él, escalar es una evolución natural y controlada.

---

## Actividad 5 — Arquitectura

Diseñar la arquitectura del sistema, incluyendo:
- 🖥️ Cliente web / móvil
- ⚙️ Backend
- 🗄️ Base de datos
- 💳 Pasarela de pago

**Entregable:**
> 📌 Diagrama de arquitectura

![Diagrama de arquitectura](/Taller_Bloque_2/Diagramas/arquitectura.png)