## Curso de C++ 

### Índice

1. [Historia y paradigmas](#historia_cpp)
2. [Compilación y estándares](#compilacion_cpp)
3. [Tipos y `auto`](#tipos_cpp)
4. [Variables, alcance y duración](#variables_cpp)
5. [Operadores y sobrecarga](#operadores_cpp)
6. [Control de flujo moderno](#control_cpp)
7. [Funciones y `constexpr`](#funciones_cpp)
8. [C-strings vs `std::string`](#strings_cpp)
9. [POO: Clases, encapsulación y RAII](#poo_cpp)
10. [Herencia y polimorfismo](#herencia_cpp)
11. [Plantillas y genéricos](#templates_cpp)
12. [Excepciones y manejo de errores](#excepciones_cpp)
13. [Smart pointers y STL](#stl_cpp)
14. [Seguridad y prevención de vulnerabilidades](#seguridad_cpp)
15. [Buenas prácticas y recursos](#practicas_cpp)

---

## 1. Historia y paradigmas {#historia\_cpp}

* C++ nació en los 80 para añadir **clases** a C. Hoy abarca múltiples paradigmas: imperativo, OOP, genérico y funcional.
* Desde C++98 hasta C++20 y C++23, cada estándar suma características para escribir código más seguro y expresivo.

## 2. Compilación y estándares {#compilacion\_cpp}

```bash
g++ -Wall -Wextra -std=c++20 main.cpp -o prog
```

* `-std=c++20` activa el estándar C++20.
* `-O2` optimiza, `-g` añade símbolos de debug.

## 3. Tipos y `auto` {#tipos\_cpp}

* Tipos iguales a C, más `bool`, `wchar_t`, `char8_t`, `char16_t`, `char32_t`.
* **`auto`** deduce el tipo:

```cpp
auto x = 42;        // int
auto s = "hola";  // const char*
```

## 4. Variables, alcance y duración {#variables\_cpp}

* Igual que C, con:

  * **`constexpr`**: valor compilado.
  * **`thread_local`**.
  * Objetos globales inicializan antes de `main`.

```cpp
static int contador = 0;           // persiste
constexpr double PI = 3.14159;     // constante en tiempo de compilación
```

## 5. Operadores y sobrecarga {#operadores\_cpp}

* Mismos operadores de C.
* Puedes **sobrecargar**:

```cpp
struct Punto { double x,y; };
Punto operator+(Punto a, Punto b) { return {a.x+b.x, a.y+b.y}; }
```

## 6. Control de flujo moderno {#control\_cpp}

* `if` con inicializador:

  ```cpp
  if (auto it = m.find(key); it != m.end()) { /*...*/ }
  ```
* `switch` con `std::string` (C++23).
* Rango-based `for`:

  ```cpp
  for (auto &v : vec) cout<<v;
  ```

## 7. Funciones y `constexpr` {#funciones\_cpp}

* Soporte de funciones `inline`, `constexpr`, lambdas:

```cpp
auto f = [](int x){ return x*x; };
constexpr int sq(int x) { return x*x; }
```

## 8. C-strings vs `std::string` {#strings\_cpp}

* Mejor usar `std::string`:

```cpp
std::string nombre = "Ana";
nombre += " Pérez";
```

* Evita `char buf[100]` a menos que necesites interoperabilidad.

## 9. POO: Clases, encapsulación y RAII {#poo\_cpp}

* **Clases** con miembros y métodos:

```cpp
class Cuenta {
    double saldo;
public:
    Cuenta(double s): saldo(s) {}
    void depositar(double x) { saldo += x; }
    double obtener() const { return saldo; }
};
```

* **RAII**: recursos gestionados por objetos.

## 10. Herencia y polimorfismo {#herencia\_cpp}

* Herencia simple/múltiple:

```cpp
class Animal { public: virtual void habla() = 0; };
class Perro : public Animal { void habla() override { cout<<"Guau"; }};
```

## 11. Plantillas y genéricos {#templates\_cpp}

* **Templates** de funciones y clases:

```cpp
template<typename T>
T maximo(T a, T b) { return a>b ? a : b; }
```

* Usa `typename` o `class` indistintamente.

## 12. Excepciones y manejo de errores {#excepciones\_cpp}

```cpp
try {
    throw runtime_error("Algo falló");
} catch (const exception &e) {
    cerr<<e.what();
}
```

* Prefiere retornar `std::optional` o `std::expected` en vez de excepciones en código crítico.

## 13. Smart pointers y STL {#stl\_cpp}

* **Smart pointers**:

  * `std::unique_ptr<T>`: dueño único.
  * `std::shared_ptr<T>`: recuento de referencias.
* **STL**: `vector`, `map`, `unordered_map`, algoritmos en `<algorithm>`.

```cpp
auto p = make_unique<int>(5);
vector<string> vs{"a","b","c"};
sort(vs.begin(), vs.end());
```

## 14. Seguridad y prevención de vulnerabilidades {#seguridad\_cpp}

* **Validación de entradas**: nunca confíes en datos externos; comprueba rangos y formatos.
* **Evita desbordamientos**: usa funciones con límite (`std::string::substr`, `std::copy_n`) y contenedores STL en lugar de punteros crudos.
* **Control de acceso**: marca métodos y datos privados o protegidos.
* **Desinfección de datos**: limpia buffers sensibles tras uso.
* **Uso de smart pointers**: previene fugas y uso tras liberación.
* **Evita excepciones en destructores**: asegura que siempre limpian sin lanzar.
* **Política de privilegios mínimos**: ejecuta componentes con los permisos estrictamente necesarios.
* **Análisis estático y dinámico**: aprovecha herramientas (Valgrind, AddressSanitizer, clang-tidy) para detectar fugas y errores.

## 15. Buenas prácticas y recursos {#practicas\_cpp}

* **Guías de estilo**:

  * [Google C++ Style Guide](https://google.github.io/styleguide/cppguide.html): normas de codificación de Google.
  * [C++ Core Guidelines](https://isocpp.github.io/CppCoreGuidelines/CppCoreGuidelines): recomendaciones de la comunidad ISO.
* **Gestión de recursos (RAII)** y evita `new`/`delete` directos; usa **smart pointers**:

  * `std::unique_ptr`, `std::shared_ptr`, `std::weak_ptr`.
* **Documentación**:

  * [Doxygen](https://www.doxygen.nl/): genera documentación automática desde comentarios.
  * Usa etiquetas como `rief`, `@param`, `@return`.
* **Biblioteca estándar y referencias**:

  * [cppreference.com](https://en.cppreference.com/w/): documentación completa de STL y lenguaje.
  * [ISO C++ Standard](https://isocpp.org/std/the-standard): últimas ediciones del estándar.
* **Lecturas recomendadas**:

  * "Effective Modern C++" de Scott Meyers (C++11/C++14).
  * "C++ Primer" de Lippman, Lajoie y Moo.
  * "Clean Code" de Robert C. Martin (aplicable a C++).
* **Comunidades y aprendizaje continuo**:

  * [Stack Overflow](https://stackoverflow.com/questions/tagged/c%2b%2b)
  * [r/cpp](https://www.reddit.com/r/cpp/)
  * [ISO C++](https://isocpp.org/)

