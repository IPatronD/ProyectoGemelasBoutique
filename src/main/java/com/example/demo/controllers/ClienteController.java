package com.example.demo.controllers;
import com.example.demo.models.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Indica que es un controlador REST que responde con datos (JSON)
@RequestMapping("/api/clientes") // Ruta base para todos los endpoints
public class ClienteController {

    @Autowired // Inyección automática del servicio
    private ClienteService clienteService;

    @GetMapping // Endpoint GET -> listar todos los clientes
    public List<Cliente> listar() {
        return clienteService.listar(); // Llama al servicio para obtener la lista
    }

    @PostMapping // Endpoint POST -> guardar un nuevo cliente
    public Cliente guardar(@RequestBody Cliente cliente) {
        // @RequestBody convierte el JSON en objeto Cliente
        return clienteService.guardar(cliente); // Guarda el cliente
    }

    @GetMapping("/{id}") // Endpoint GET -> buscar cliente por ID
    public Cliente buscar(@PathVariable Long id) {
        // @PathVariable obtiene el ID desde la URL
        return clienteService.buscarPorId(id); // Busca el cliente
    }

    @DeleteMapping("/{id}") // Endpoint DELETE -> eliminar cliente por ID
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id); // Elimina el cliente
    }
}