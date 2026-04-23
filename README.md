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

## Pendiente:
- Seguridad (Spring Security + JWT)  
- Integración con frontend (Angular)  
- Reportes  
- Validaciones avanzadas  
