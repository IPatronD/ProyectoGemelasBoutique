# SaaS de Gestión de Ventas e Inventario – Gemelas Boutique

## 1. Definición del problema
La empresa Gemelas Boutique realiza el registro de ventas, clientes e inventario de manera manual mediante cuadernos físicos. Este proceso ocasiona pérdida de información, errores en los registros, dificultad para conocer el stock disponible y falta de reportes para la toma de decisiones. Además, no existe control de usuarios ni seguridad en el acceso a la información. Se requiere desarrollar una solución SaaS que permita centralizar la gestión de ventas, clientes y productos mediante una aplicación web.

## 2. Alcance del proyecto
El sistema será una aplicación web SaaS multiusuario que permitirá gestionar clientes, productos, ventas e inventario. La solución contará con backend desarrollado en Spring Boot, API REST, base de datos relacional y autenticación con roles. El frontend se integrará posteriormente con Angular. El sistema permitirá acceso por roles (Administrador y Vendedor) y registro completo de operaciones comerciales.

## 3. Actores del sistema
- **Administrador:** Gestiona usuarios, productos, reportes y supervisa las ventas.
- **Vendedor:** Registra clientes, realiza ventas y consulta productos.
- **Cliente:** Usuario final que compra productos (actor externo).

## 4. Módulos del sistema
- Módulo de autenticación y usuarios  
- Módulo de gestión de clientes  
- Módulo de gestión de productos  
- Módulo de ventas  
- Módulo de inventario  
- Módulo de reportes  

## 5. Modelo inicial de entidades
- Usuario(id, username, password, rol, estado)  
- Empleado(id, nombres, apellidos, dni, correo)  
- Cliente(id, tipo, nombres, documento, telefono)  
- Producto(id, nombre, categoria, precio, stock)  
- Venta(id, fecha, total, cliente, usuario)  
- DetalleVenta(id, venta, producto, cantidad, precio)  
- Categoria(id, nombre)  
- MetodoPago(id, nombre)  

## 6. Estructura del proyecto Spring Boot
El proyecto sigue una arquitectura por capas:

- **controller:** Controladores REST  
- **service:** Lógica de negocio  
- **repository:** Acceso a datos  
- **model:** Entidades JPA  
- **config:** Configuración de seguridad (pendiente)

## 7. Estructura actual del proyecto

```
ProyectoGemelasBoutique-main
│
├── .mvn
├── src
│   ├── main
│   │   ├── java/com/example/demo
│   │   │   ├── controllers
│   │   │   │   ├── CategoriaController.java
│   │   │   │   ├── ClienteController.java
│   │   │   │   ├── DetalleVentaController.java
│   │   │   │   ├── EmpleadoController.java
│   │   │   │   ├── MetodoPagoController.java
│   │   │   │   ├── ProductoController.java
│   │   │   │   ├── UsuarioController.java
│   │   │   │   └── VentaController.java
│   │   │   │
│   │   │   ├── models
│   │   │   │   ├── Categoria.java
│   │   │   │   ├── Cliente.java
│   │   │   │   ├── DetalleVenta.java
│   │   │   │   ├── Empleado.java
│   │   │   │   ├── MetodoPago.java
│   │   │   │   ├── Producto.java
│   │   │   │   ├── Usuario.java
│   │   │   │   └── Venta.java
│   │   │   │
│   │   │   ├── repository
│   │   │   │   ├── CategoriaRepository.java
│   │   │   │   ├── ClienteRepository.java
│   │   │   │   ├── DetalleVentaRepository.java
│   │   │   │   ├── EmpleadoRepository.java
│   │   │   │   ├── MetodoPagoRepository.java
│   │   │   │   ├── ProductoRepository.java
│   │   │   │   ├── UsuarioRepository.java
│   │   │   │   └── VentaRepository.java
│   │   │   │
│   │   │   ├── service
│   │   │   │   ├── CategoriaService.java
│   │   │   │   ├── ClienteService.java
│   │   │   │   ├── DetalleVentaService.java
│   │   │   │   ├── EmpleadoService.java
│   │   │   │   ├── MetodoPagoService.java
│   │   │   │   ├── ProductoService.java
│   │   │   │   ├── UsuarioService.java
│   │   │   │   ├── VentaService.java
│   │   │   │   └── impl
│   │   │   │       ├── DetalleVentaServiceImpl.java
│   │   │   │       └── MetodoPagoServiceImpl.java
│   │   │   │
│   │   │   └── DemoApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── target
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 8. Endpoints REST iniciales

### Usuarios
- GET /api/usuarios  
- POST /api/usuarios  
- PUT /api/usuarios/{id}  
- DELETE /api/usuarios/{id}  

### Clientes
- GET /api/clientes  
- POST /api/clientes  
- PUT /api/clientes/{id}  
- DELETE /api/clientes/{id}  

### Productos
- GET /api/productos  
- POST /api/productos  
- PUT /api/productos/{id}  
- DELETE /api/productos/{id}  

### Ventas
- GET /api/ventas  
- POST /api/ventas  
- GET /api/ventas/{id}  

## 9. Inyección de dependencias
Se utiliza `@Autowired` y también inyección por constructor para desacoplar los controladores de los servicios. Los servicios utilizan repositorios JPA para acceder a la base de datos.

## 10. Pruebas iniciales de API
Las pruebas se realizan con Postman utilizando métodos HTTP:
- GET
- POST
- PUT
- DELETE  

Se verifica:
- Creación de registros  
- Consulta de datos  
- Actualización  
- Eliminación  

## 11. Funcionamiento general
El backend inicial permite registrar usuarios, clientes y productos. Los endpoints REST están operativos y responden en formato JSON. La arquitectura es escalable, permitiendo integrar en el futuro:
- Seguridad con JWT  
- Frontend con Angular  
- Reportes avanzados  
- Control de inventario automatizado  

## 12. Estado del proyecto (Primera entrega)
✔ Estructura base del proyecto Spring Boot  
✔ Entidades modeladas con JPA  
✔ Repositorios implementados  
✔ Servicios definidos  
✔ Controladores REST funcionales  
✔ Endpoints probados con Postman  

---

# 13. Segunda entrega del proyecto

## Mejoras implementadas

Durante la segunda fase del proyecto se realizaron mejoras importantes en la arquitectura, seguridad y funcionamiento general del sistema SaaS de Gemelas Boutique.

Se completó la implementación de relaciones entre entidades, validaciones, consultas personalizadas con JPQL y seguridad mediante Spring Security.

---

# 14. Seguridad implementada (Spring Security)

Se integró Spring Security para proteger los endpoints REST de la aplicación.

## Características implementadas

- Autenticación HTTP Basic
- Control de acceso por roles
- Encriptación de contraseñas con BCrypt
- Restricción de endpoints por permisos
- Usuarios autenticados para acceder a la API

## Roles del sistema

### ROLE_ADMIN
Tiene acceso completo al sistema:
- Gestión de usuarios
- Eliminación de registros
- Acceso total a ventas y productos

### ROLE_VENDEDOR
Puede:
- Registrar ventas
- Consultar productos
- Registrar clientes

---

# 15. Configuración de seguridad

Se creó el paquete:

```text
com.example.demo.security
```

Dentro de este paquete se implementó:

- SecurityConfig.java

La configuración incluye:
- BCryptPasswordEncoder
- SecurityFilterChain
- Restricción de rutas por roles

---

# 16. Validaciones implementadas

Se implementaron validaciones usando Jakarta Validation a nivel de entidades para evitar registros inválidos en la base de datos:

- `@NotBlank` (Nombre, username, documento, etc.)
- `@NotNull` (Fechas y relaciones obligatorias)
- `@Email` (Formato de correo electrónico)
- `@Pattern` (Formatos numéricos de DNI y teléfono)
- `@Size` (Límites de caracteres mínimos y máximos)
- `@Positive` y `@PositiveOrZero` (Precios, cantidades y stock)

Adicionalmente, se configuró un **Manejador de Excepciones Global (`@RestControllerAdvice`)** para capturar automáticamente estos errores de validación (`MethodArgumentNotValidException`) y retornar al cliente un código **HTTP 400 Bad Request** junto con un JSON estructurado que detalla exactamente qué campos no cumplen con las reglas.

---

# 17. Relaciones entre entidades

Se completaron las relaciones JPA entre las entidades del sistema:

- Cliente → Ventas
- Usuario → Ventas
- Venta → DetalleVenta
- Producto → Categoria
- MetodoPago → Ventas
- Empleado → Usuario

Relaciones utilizadas:
- @OneToMany
- @ManyToOne
- @OneToOne

---

# 18. Consultas JPQL implementadas

Se implementaron consultas personalizadas en los repositorios.

## UsuarioRepository
- Buscar por username
- Buscar por rol
- Listar usuarios activos

## ProductoRepository
- Buscar productos por nombre
- Buscar productos por categoría
- Buscar productos con stock bajo
- Buscar productos por rango de precios

## VentaRepository
- Buscar ventas por cliente
- Buscar ventas por usuario
- Buscar ventas entre fechas

## ClienteRepository
- Buscar cliente por documento
- Buscar clientes por tipo
- Buscar clientes por nombres

---

# 19. Base de datos

La base de datos fue implementada en MySQL Workbench.

Tablas utilizadas:
- usuarios
- empleados
- clientes
- categorias
- productos
- ventas
- detalle_venta
- metodo_pago

También se agregaron:
- claves foráneas
- relaciones entre tablas
- datos de prueba

---

# 20. Pruebas realizadas

Las pruebas fueron realizadas con Postman utilizando:

- GET
- POST
- PUT
- DELETE

Se probaron:
- Registro de usuarios
- Registro de clientes
- Registro de ventas
- Seguridad con Spring Security
- Acceso por roles
- CRUD completos

---

# 21. Estado actual del proyecto

## Implementado
✔ Arquitectura por capas  
✔ CRUD completos  
✔ Relaciones JPA  
✔ Consultas JPQL  
✔ Spring Security  
✔ BCrypt  
✔ Validaciones  
✔ Manejo de excepciones global  
✔ Base de datos MySQL  
✔ Endpoints REST funcionales  
✔ Pruebas con Postman  

---

# 22. Manejo global de excepciones

Se implementó un controlador de consejos global (`@RestControllerAdvice`) para capturar excepciones a nivel de aplicación y retornar respuestas estructuradas en formato JSON:

- **Excepciones de Negocio (`RuntimeException`):** Captura de forma dinámica errores específicos. Si el mensaje contiene *"no encontrado"*, responde con un código **HTTP 404 Not Found**. Si el mensaje contiene *"ya existe"* o *"ya registrado"*, responde con **HTTP 400 Bad Request**.
- **Errores de Validaciones (`MethodArgumentNotValidException`):** Captura automáticamente las fallas de campos anotados con validaciones de Jakarta (como `@NotBlank`, `@Email`, etc.) y retorna un mapa detallado (`validationErrors`) con los campos incorrectos y sus razones bajo un código **HTTP 400 Bad Request**.
- **Errores de Argumentos e Invalideces (`IllegalArgumentException`):** Retorna un código **HTTP 400 Bad Request**.
- **Excepciones Generales (`Exception`):** Atrapa cualquier otro error no controlado y devuelve un HTTP **500 Internal Server Error** con estructura controlada para no filtrar trazas internas del servidor.

---

# 23. Estructura del proyecto del segundo avance

```

PROYECTOGEMELASBOUTIQUE-MAIN
│
├── .github
├── .mvn
├── .vscode
│
├── src
│   └── main
│       ├── java/com/example/demo
│       │
│       │   ├── controllers
│       │   │   ├── CategoriaController.java
│       │   │   ├── ClienteController.java
│       │   │   ├── DetalleVentaController.java
│       │   │   ├── EmpleadoController.java
│       │   │   ├── GlobalExceptionHandler.java
│       │   │   ├── MetodoPagoController.java
│       │   │   ├── ProductoController.java
│       │   │   ├── UsuarioController.java
│       │   │   └── VentaController.java
│       │
│       │   ├── models
│       │   │   ├── Categoria.java
│       │   │   ├── Cliente.java
│       │   │   ├── DetalleVenta.java
│       │   │   ├── Empleado.java
│       │   │   ├── MetodoPago.java
│       │   │   ├── Producto.java
│       │   │   ├── Usuario.java
│       │   │   └── Venta.java
│       │
│       │   ├── repository
│       │   │   ├── CategoriaRepository.java
│       │   │   ├── ClienteRepository.java
│       │   │   ├── DetalleVentaRepository.java
│       │   │   ├── EmpleadoRepository.java
│       │   │   ├── MetodoPagoRepository.java
│       │   │   ├── ProductoRepository.java
│       │   │   ├── UsuarioRepository.java
│       │   │   └── VentaRepository.java
│       │
│       │   ├── security
│       │   │   ├── CustomUserDetailsService.java
│       │   │   └── SecurityConfig.java
│       │
│       │   ├── service
│       │   │   ├── impl
│       │   │   │   ├── CategoriaServiceImpl.java
│       │   │   │   ├── ClienteServiceImpl.java
│       │   │   │   ├── DetalleVentaServiceImpl.java
│       │   │   │   ├── EmpleadoServiceImpl.java
│       │   │   │   ├── MetodoPagoServiceImpl.java
│       │   │   │   ├── ProductoServiceImpl.java
│       │   │   │   ├── UsuarioServiceImpl.java
│       │   │   │   └── VentaServiceImpl.java
│       │   │
│       │   │   ├── CategoriaService.java
│       │   │   ├── ClienteService.java
│       │   │   ├── DetalleVentaService.java
│       │   │   ├── EmpleadoService.java
│       │   │   ├── MetodoPagoService.java
│       │   │   ├── ProductoService.java
│       │   │   ├── UsuarioService.java
│       │   │   └── VentaService.java
│       │
│       │   └── DemoApplication.java
│       │
│       └── resources
│           └── application.properties
│
├── test
│   └── java/com/example/demo
│       │
│       ├── controllers
│       │   ├── CategoriaControllerTest.java
│       │   ├── ClienteControllerTest.java
│       │   ├── DetalleVentaControllerTest.java
│       │   ├── EmpleadoControllerTest.java
│       │   ├── MetodoPagoControllerTest.java
│       │   ├── ProductoControllerTest.java
│       │   ├── UsuarioControllerTest.java
│       │   └── VentaControllerTest.java
│       │
│       ├── service
│       │   └── impl
│       │       ├── CategoriaServiceImplTest.java
│       │       ├── ClienteServiceImplTest.java
│       │       ├── DetalleVentaServiceImplTest.java
│       │       ├── EmpleadoServiceImplTest.java
│       │       ├── MetodoPagoServiceImplTest.java
│       │       ├── ProductoServiceImplTest.java
│       │       ├── UsuarioServiceImplTest.java
│       │       └── VentaServiceImplTest.java
│       │
│       └── DemoApplicationTests.java
├── target
│
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```
---

# Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Maven
- MySQL
- Postman

---

## Pendiente
- Integración con Angular
- JWT Authentication
- Dashboard administrativo
