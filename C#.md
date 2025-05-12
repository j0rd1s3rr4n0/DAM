## Curso de C# 

### Índice

1. [Introducción a C# y .NET](#introduccion)
2. [Configuración del entorno y proyectos](#entorno)
3. [Tipos, variables y null safety](#tipos)
4. [Control de flujo y expresiones](#control)
5. [Métodos, delegados y expresiones lambda](#metodos)
6. [Clases, structs, interfaces y herencia](#poo)
7. [Propiedades, indexadores y eventos](#propiedades)
8. [Colecciones, LINQ y consultas](#linq)
9. [Asincronía con async/await y tareas](#async)
10. [Patrones de diseño comunes](#patrones)
11. [Unit testing y TDD](#testing)
12. [ASP.NET Core: Web APIs y MVC](#aspnet)
13. [Inyección de dependencias y middleware](#di)
14. [Seguridad y mitigación de vulnerabilidades](#seguridad)
15. [Optimización y rendimiento](#rendimiento)
16. [Buenas prácticas y recursos](#practicas)

---

## 1. Introducción a C# y .NET {#introduccion}

* C# es un lenguaje de alto nivel, fuertemente tipado, creado en 2000 para la plataforma .NET.
* .NET Core y .NET 5/6/7 unifican runtimes para Windows, Linux y macOS.
* Características clave: recolección de basura, LINQ, async/await, seguridad de tipos.

## 2. Configuración del entorno y proyectos {#entorno}

* Instala [.NET SDK](https://dotnet.microsoft.com/download).
* IDE: Visual Studio, VS Code + C# extension.
* Crea tu primer proyecto:

  ```bash
  dotnet new console -o MiApp
  cd MiApp
  dotnet run
  ```
* Soluciones y proyectos: `.sln`, `.csproj`, gestión con `dotnet sln`.

## 3. Tipos, variables y null safety {#tipos}

* Tipos primitivos: `int`, `long`, `float`, `double`, `decimal`, `bool`, `char`, `string`.
* Null safety (C# 8.0+): habilita `nullable` en `.csproj` para diferenciar `string` vs `string?`.
* Variables implicitas con `var`, constantes con `const` y `readonly`.

```csharp
int x = 10;
string? nombre = null;
var lista = new List<string>();
```

## 4. Control de flujo y expresiones {#control}

* Condicionales: `if`, `switch` expresión, `switch` statement.
* Bucles: `for`, `while`, `do...while`, `foreach`.
* Expresiones condicionales y nulas:

  ```csharp
  var mensaje = edad >= 18 ? "Adulto" : "Menor";
  string texto = nombre ?? "Invitado";
  ```

## 5. Métodos, delegados y expresiones lambda {#metodos}

* Métodos estáticos e instancias, parámetros `ref`, `out`, `in`.
* Delegados: tipo seguro para referencias a métodos.
* Lambdas y Func/Action:

  ```csharp
  Func<int,int,int> sumar = (a,b) => a + b;
  int res = sumar(3,4);
  ```
* Eventos basados en delegados:

  ```csharp
  public event EventHandler Evento;
  ```

## 6. Clases, structs, interfaces y herencia {#poo}

* Classes vs Structs (valor vs referencia).
* Interfaces y herencia múltiple de interfaces:

  ```csharp
  interface IAnimal { void Hablar(); }
  class Perro : IAnimal { public void Hablar() => Console.WriteLine("Guau"); }
  ```
* Constructores, destructores (`IDisposable`) y bloques `using`.

```csharp
using(var recurso = new MiRecurso()) { ... }
```

## 7. Propiedades, indexadores y eventos {#propiedades}

* Propiedades automáticas y con lógica:

  ```csharp
  public int Edad { get; private set; }
  ```
* Indexadores en colecciones propias:

  ```csharp
  public string this[int index] { get {...} set {...} }
  ```
* Eventos y patrones `EventArgs`.

## 8. Colecciones, LINQ y consultas {#linq}

* Listas, Diccionarios, Conjuntos, Colas, Pilas.
* LINQ to Objects/Entities:

  ```csharp
  var pares = nums.Where(n => n % 2 == 0).OrderBy(n => n).ToList();
  ```
* Métodos de extensión y expresiones diferidas.

## 9. Asincronía con async/await y tareas {#async}

* `async Task`, `async Task<T>`, `async void` (eventos).
* Cancelling con `CancellationToken`.
* Ejecución paralela: `Task.WhenAll`, `Parallel.ForEach`.

```csharp
async Task<int> FetchAsync(string url) {
    var client = new HttpClient();
    return await client.GetStringAsync(url).Length;
}
```

## 10. Patrones de diseño comunes {#patrones}

* **Singleton**: único objeto global.
* **Factory Method**: crea objetos sin especificar clase.
* **Repository**: abstracción de acceso a datos.
* **Dependency Injection**: desacopla dependencias.

```csharp
services.AddScoped<IMiRepo, MiRepo>();
```

## 11. Unit testing y TDD {#testing}

* Frameworks: **xUnit**, **NUnit**, **MSTest**.
* Estructura AAA (Arrange-Act-Assert).
* Mocking con **Moq**.

```csharp
[Fact]
public void Suma_DosNumeros_RetornaSuma() {
    Assert.Equal(5, Calculadora.Sumar(2,3));
}
```

## 12. ASP.NET Core: Web APIs y MVC {#aspnet}

* Crea proyecto:

  ```bash
  ```

dotnet new webapi -o MiApi

````
- Controladores con `[ApiController]` y rutas.
- Middlewares, pipeline de solicitudes.
- Validación de modelos con Data Annotations.

## 13. Inyección de dependencias y middleware {#di}

- DI built-in en ASP.NET Core con `IServiceCollection`.
- Registros: `AddSingleton`, `AddScoped`, `AddTransient`.
- Crea middleware personalizado:

```csharp
app.Use(async (ctx, next) => {
    // antes
    await next();
    // después
});
````

## 14. Seguridad y mitigación de vulnerabilidades {#seguridad}

* **Validación de entrada**: usa `TryParse`, Data Annotations.
* **Protección contra inyección**:

  * SQL: `FromSqlRaw` con parámetros.
  * No uses concatenación de strings.
* **Autenticación/Autorización**: JWT, IdentityServer.
* **XSS/CSRF**: protección automática en Razor, antiforgery tokens.
* **Análisis estático**: Roslyn Analyzers, Sonar.

## 15. Optimización y rendimiento {#rendimiento}

* Usa **Span<T>** y **Memory<T>** para buffers sin allocations.
* Pools de objetos con `ArrayPool<T>`, `ObjectPool<T>`.
* Evita boxing/unboxing en genéricos.
* Perfilado con **dotnet-trace**, **BenchmarkDotNet**.

## 16. Buenas prácticas y recursos {#practicas}

* **Guías de estilo**:

  * [Microsoft C# Coding Conventions](https://learn.microsoft.com/dotnet/csharp/fundamentals/coding-style/coding-conventions)
* **Documentación**:

  * [Microsoft Docs - C# Guide](https://learn.microsoft.com/dotnet/csharp/)
  * [API Browser](https://api.dotnet.microsoft.com/)
* **Lecturas**:

  * "C# in Depth" de Jon Skeet
  * "Pro ASP.NET Core" de Adam Freeman
* **Herramientas**:

  * ReSharper, Rider
  * VS Code + C# extension


---



## 17. Ejercicios prácticos {#ejercicios}

1. **Pseudobanco simple**: Crea una consola que permita crear cuentas, depositar, retirar y mostrar saldo. Usa clases, excepciones y validación de entrada.
2. **API REST básica**: Con ASP.NET Core, define un controlador `ProductosController` para CRUD de productos en memoria. Aplica DI para el repositorio y validación de modelos.
3. **LINQ avanzado**: Dado un array de clientes con propiedades `Nombre`, `Edad` y `Saldo`, genera:

   * Lista de los 5 mayores de edad con saldo > 1000, ordenada por saldo descendente.
   * Diccionario agrupado por decena de edad.
4. **Async File Reader**: Implementa un método `ReadLinesAsync(string path)` que lea un archivo línea a línea de forma asíncrona y cuente las apariciones de una palabra.
5. **Middleware de logging**: En ASP.NET Core, crea un middleware que registre método, ruta y tiempo de ejecución en un archivo de registro.
6. **Unit tests**: Para la clase calculadora con métodos `Sumar`, `Restar`, `Multiplicar`, `Dividir`, escribe pruebas con xUnit y Moq para simular división por cero.
7. **Patrón Repository**: Implementa un repositorio genérico `IRepository<T>` con métodos `Add`, `Get`, `GetAll` y su implementación en memoria.
8. **Optimización con Span<T>**: Escribe una función que reciba un array de bytes y convierta a mayúsculas todas las letras ASCII usando `Span<byte>`.
9. **Data Annotations**: Define un modelo `Usuario` con propiedades `Email`, `Password`, `BirthDate`. Aplica atributos de validación (`[EmailAddress]`, `[StringLength]`, `[DataType]`) y valida en un controlador MVC.
10. **Análisis de vulnerabilidades**: Usa Roslyn Analyzer para crear una regla que detecte concatenaciones de SQL en strings.

