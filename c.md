## Curso de C 

### Índice

1. [Historia y características](#historia)
2. [El ciclo de compilación](#compilacion)
3. [Tipos básicos y `sizeof`](#tipos)
4. [Variables y alcance](#variables)
5. [Operadores](#operadores)
6. [Estructuras de control](#control)
7. [Lógica de programación y algoritmos](#logica)
8. [Funciones y prototipos](#funciones)
9. [Funciones y prototipos](#funciones)
10. [Arreglos, punteros y `const`](#arreglos)
11. [Estructuras, uniones y encapsulación](#estructuras)
12. [Memoria dinámica segura](#dinamica)
13. [Preprocesador y macros seguros](#preprocesador)
14. [Buenas prácticas y recursos](#practicas)
15. [Vulnerabilidades comunes y mitigaciones](#vulnerabilidades)

---

## 1. Historia y características {#historia}(#historia)

2. [El ciclo de compilación](#compilacion)
3. [Tipos básicos y `sizeof`](#tipos)
4. [Variables y alcance](#variables)
5. [Operadores](#operadores)
6. [Estructuras de control](#control)
7. [Funciones y prototipos](#funciones)
8. [Arreglos, punteros y `const`](#arreglos)
9. [Estructuras, uniones y encapsulación](#estructuras)
10. [Memoria dinámica segura](#dinamica)
11. [Preprocesador y macros seguros](#preprocesador)
12. [Buenas prácticas y recursos](#practicas)

---

## 1. Historia y características {#historia}

* C nació en los 70 para reescribir Unix. Es eficiente, cercano al hardware y base de muchos sistemas.
* Sigue evolucionando: C99, C11, C17 con mejoras de seguridad y concurrencia.

## 2. El ciclo de compilación {#compilacion}

```bash
gcc -Wall -Wextra -std=c11 programa.c -o programa
```

* `-Wall -Wextra`: activa todas las advertencias.
* `-std=c11`: usa el estándar C11.
* `-O2`: optimiza rendimiento.

## 3. Tipos básicos y `sizeof` {#tipos}

|     Tipo | Tamaño mínimo | Uso típico                      |
| -------: | :-----------: | :------------------------------ |
|   `char` |     1 byte    | caracteres, datos crudos        |
|  `short` |    2 bytes    | enteros pequeños                |
|    `int` |   2-4 bytes   | enteros principales             |
|   `long` |   4-8 bytes   | enteros grandes                 |
|  `float` |    4 bytes    | punto flotante sencillo         |
| `double` |    8 bytes    | punto flotante doble            |
|   `void` |       —       | sin valor (funciones genéricas) |

```c
printf("int ocupa %zu bytes\n", sizeof(int));
```

## 4. Variables y alcance {#variables}

* **Locales**: viven dentro de `{}`.
* **Globales**: durante toda la ejecución.
* **`static`** en función: persiste entre llamadas.
* **`extern`**: declara variable de otro fichero.

## 5. Operadores {#operadores}

* Aritméticos: `+ - * / % ++ --`
* Relacionales: `== != < > <= >=`
* Lógicos: `&& || !`
* Bit a bit: `& | ^ ~ << >>`

## 6. Estructuras de control {#control}

* `if/else`, `switch`, bucles `for`, `while`, `do…while`.
* Usa `break`/`continue` con moderación.

## 7. Lógica de programación y algoritmos {#logica}

La base de cualquier programa está en la **lógica** que define su comportamiento:

* **Algoritmo**: conjunto de pasos ordenados para resolver un problema.

  * Debe ser finito, claro, y producir el resultado correcto.
* **Pseudocódigo**: descripción estructurada de un algoritmo, cercana al lenguaje humano:

```plaintext
Inicio
  Leer n
  Si n es impar entonces
    Imprimir "Impar"
  Sino
    Imprimir "Par"
  FinSi
Fin
```

* **Diagramas de flujo**: representan gráficamente procesos con símbolos (óvalos para inicio/fin, rectángulos para acciones, rombos para decisiones).
* **Descomposición**: divide problemas grandes en subproblemas (funciones).
* **Estructuras básicas**:

  * Secuencia: pasos uno tras otro.
  * Selección: `if/else`, `switch`.
  * Iteración: bucles `for`, `while`.

**Ejemplo: búsqueda lineal**

```c
int buscar(int arr[], int n, int clave) {
    for (int i = 0; i < n; ++i) {
        if (arr[i] == clave) {
            return i; // encontrado
        }
    }
    return -1; // no encontrado
}
```

## 8. Funciones y prototipos {#funciones} y prototipos {#funciones}

* Prototipos en `.h`, definiciones en `.c`.
* Paso por valor siempre, `const` para argumentos de solo lectura.

```c
// util.h
int max(int a, int b);

// util.c
int max(int a, int b) { return a>b? a: b; }
```

## 8. Arreglos, punteros y `const` {#arreglos}

* `T a[N]`: contiguidad garantizada.
* `T *p`: puntero.
* Usa `const` para proteger datos:

```c
void f(const char *s) { /* no modifica s */ }
```

## 9. Estructuras, uniones y encapsulación {#estructuras}

* `struct` agrupa datos.
* `union` comparte espacio.
* Oculta campos con `static` en el fichero.

## 10. Memoria dinámica segura {#dinamica}

* Usa `malloc`/`calloc`, comprueba `NULL`:

```c
int *arr = malloc(n * sizeof *arr);
if (!arr) { perror("malloc"); exit(1); }
```

* Prefiere `calloc` para cero-inicializar.
* Libera con `free` y establece punteros a `NULL`.

## 11. Preprocesador y macros seguros {#preprocesador}

* Evita macros complejas.
* Usa `static inline` en C11:

```c
static inline int min(int a, int b) { return a<b? a: b; }
```

## 12. Buenas prácticas y recursos {#practicas}

* **Guías de estilo**:

  * [Linux Kernel Coding Style](https://www.kernel.org/doc/html/latest/process/coding-style.html)
  * [C Standard Library Conventions](https://en.cppreference.com/w/c)
* **Memoria y seguridad**:

  * [Valgrind](https://valgrind.org/), [AddressSanitizer](https://clang.llvm.org/docs/AddressSanitizer.html)
  * Prefiere `snprintf`, `fgets`, valida funciones de E/S.
* **Documentación**:

  * [Doxygen](https://www.doxygen.nl/manual/index.html)
* **Lecturas**:

  * "The C Programming Language" de Kernighan & Ritchie
  * ISO C11 Standard (en cppreference)
* **Comunidades**:

  * [Stack Overflow/C](https://stackoverflow.com/questions/tagged/c)
  * [r/C\_Programming](https://www.reddit.com/r/C_Programming/)

---

## 13. Vulnerabilidades comunes y mitigaciones {#vulnerabilidades}

### 13.1 Desbordamientos de búfer

* **Riesgo**: escribir fuera de un array puede corromper memoria.
* **Prevención**: usa funciones limitadas como `snprintf`, `strncpy` (con cuidado del nulo), o mejor, contenedores seguros en C.

```c
char buf[16];
snprintf(buf, sizeof buf, "%s", input);
```

### 13.2 Vulnerabilidades de formato de cadena

* **Riesgo**: `printf(user_input)` sin formato fijo permite lectura/escritura arbitraria.
* **Prevención**: siempre usar un literal de formato:

```c
printf("%s", user_input);
```

### 13.3 Desbordamientos de enteros

* **Riesgo**: suma/resta que excede el rango invierte signo.
* **Prevención**: usa chequeos de rangos manuales o funciones sicias:

```c
if (a > INT_MAX - b) { /* error */ }
```

### 13.4 Uso después de liberar (Use-After-Free)

* **Riesgo**: acceder a memoria liberada.
* **Prevención**: pon puntero a `NULL` tras `free` y comprueba antes:

```c
free(p);
p = NULL;
if (p) *p = 5; // seguro
```

### 13.5 Condiciones de carrera y concurrencia

* **Riesgo**: múltiples hilos acceden simultáneamente a datos sin sincronización.
* **Prevención**: usa mutexes (`pthread_mutex_t`), variables atómicas (`<stdatomic.h>` en C11).

```c
#include <stdatomic.h>
atomic_int counter = 0;
atomic_fetch_add(&counter, 1);
```
