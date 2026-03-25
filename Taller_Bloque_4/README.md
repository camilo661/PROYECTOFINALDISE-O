# TTALLER BLOQUE 4

---

## 📦 Clases y Objetos

### Ejercicio 1 — Clase `Cuenta`

Crea una clase llamada `Cuenta` con los siguientes atributos:

- `titular` — obligatorio
- `cantidad` — opcional (puede tener decimales)

#### Constructores
Crea **dos constructores** que cumplan lo anterior.

#### Métodos básicos
- `get`
- `set`
- `toString`

#### Métodos especiales

- **`ingresar(double cantidad)`** — Se ingresa una cantidad a la cuenta.
  Si la cantidad introducida es negativa, no se hará nada.

- **`retirar(double cantidad)`** — Se retira una cantidad de la cuenta.
  Si al restar la cantidad actual a la que nos pasan el resultado es negativo,
  la cantidad de la cuenta pasa a ser `0`.

> 📌
![Diagrama de clases](/Taller_Bloque_4/diagramas/image%20copy.png)

> 📎 [Ver diagrama de clases](https://drive.google.com/file/d/1jSqZjkhfDBgqEoBom5n67CGb4554_sh3/view?usp=sharing)


---

## 👤 Clases y Objetos

### Ejercicio 2 — Clase `Persona`

Crea una clase llamada `Persona` que siga las siguientes condiciones:

#### Atributos
> ⚠️ No se debe acceder directamente a ellos.
> Piensa qué modificador de acceso es el más adecuado, también su tipo.

| Atributo | Tipo | Valor por defecto |
|---|---|---|
| `nombre` | `String` | `""` |
| `edad` | `int` | `0` |
| `DNI` | `String` | *(generado automáticamente)* |
| `sexo` | `char` (`H` hombre / `M` mujer) | `H` *(constante)* |
| `peso` | `double` | `0.0` |
| `altura` | `double` | `0.0` |

> 💡 Si deseas añadir algún atributo adicional, puedes hacerlo.
> Por defecto, todos los atributos menos el DNI tendrán el valor por defecto
> según su tipo (`0` para números, cadena vacía para `String`, etc.).
> El sexo será **hombre** por defecto; usa una **constante** para ello.

---

#### Constructores

Se implementarán varios constructores:

1. **Constructor por defecto** — todos los atributos con sus valores por defecto.
2. **Constructor con** `nombre`, `edad` y `sexo` — el resto por defecto.
3. **Constructor completo** — todos los atributos como parámetros.

> 📌
![Diagrama de clases](/Taller_Bloque_4/diagramas/image.png)

> 📎 [Ver diagrama de clases](https://drive.google.com/file/d/1jSqZjkhfDBgqEoBom5n67CGb4554_sh3/view?usp=sharing)

---

#### Métodos

- **`calcularIMC()`** — Calcula si la persona está en su peso ideal
  usando la fórmula: `peso (kg) / altura² (m)`.

  | Resultado de la fórmula | Retorna | Significado |
  |---|---|---|
  | Menor que `20` | `-1` | Por debajo del peso ideal |
  | Entre `20` y `25` (inclusive) | `0` | Peso ideal |
  | Mayor que `25` | `1` | Sobrepeso |

  > 💡 Se recomienda usar **constantes** para los valores de retorno.

- **`esMayorDeEdad()`** — Indica si la persona es mayor de edad.
  Devuelve un `boolean`.

- **`comprobarSexo(char sexo)`** — Comprueba que el sexo introducido sea correcto.
  Si no lo es, se asigna `H` por defecto.
  > 🔒 Este método **no será visible al exterior**.

- **`toString()`** — Devuelve toda la información del objeto.

- **`generaDNI()`** — Genera un número aleatorio de 8 cifras y, a partir de él,
  su letra correspondiente. Este método es invocado al construir el objeto.
  Puedes dividirlo en submétodos para facilitar su implementación.
  > 🔒 Este método **no será visible al exterior**.

- **Métodos `set`** de cada atributo, **excepto** de `DNI`.

---

### Ejercicio 3 — Clase Ejecutable

Crea una clase ejecutable que realice lo siguiente:

#### Entrada por teclado
Pide al usuario:
- Nombre
- Edad
- Sexo
- Peso
- Altura

#### Creación de objetos
Crea **3 objetos** de la clase `Persona`:

| Objeto | Datos de inicialización |
|---|---|
| **Objeto 1** | Todos los datos ingresados por teclado |
| **Objeto 2** | Todos los datos anteriores, excepto `peso` y `altura` |
| **Objeto 3** | Constructor por defecto; usar métodos `set` para asignar valores |

#### Acciones por cada objeto

1. Comprobar si está en su **peso ideal**, tiene **sobrepeso** o está
   **por debajo de su peso ideal**, mostrando un mensaje descriptivo.
2. Indicar si el objeto es **mayor de edad**.
3. Mostrar toda la **información del objeto** usando `toString()`.


