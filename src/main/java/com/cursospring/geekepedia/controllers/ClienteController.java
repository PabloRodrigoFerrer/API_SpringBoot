package com.cursospring.geekepedia.controllers;


import com.cursospring.geekepedia.dominio.Cliente;
import jakarta.servlet.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(
            new Cliente("Rodrigo", "Rodri adm", "123", 23),
            new Cliente("Juan", "juajo23", "keee321", 33),
            new Cliente("Virginia", "virgiLaOne", "laOne23", 22)
    ));

    @RequestMapping (method = RequestMethod.GET)
    //@GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(listaClientes);
    }

    @RequestMapping( value = "{nombre}", method = RequestMethod.GET)
    //@GetMapping("/{nombre}")
    public ResponseEntity<?> getCliente(@PathVariable String nombre) {
        for (Cliente c : listaClientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontró ningún usuario con el nombre: " + nombre);
    }

    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Cliente cliente){
        listaClientes.add(cliente);

        URI locacion = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{nombre}")
                .buildAndExpand(cliente.getNombre()).toUri();

        return ResponseEntity.created(locacion).build();
    }

    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Cliente cliente){
        for (Cliente c : listaClientes){
            if (c.getId() == cliente.getId()){
                c.setNombre(cliente.getNombre());
                c.setNombreUsuario(cliente.getNombreUsuario());
                c.setContrasena(cliente.getContrasena());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente (@PathVariable int id){
        for (Cliente c : listaClientes){
            if (c.getId() == id){
                listaClientes.remove(c);

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el ID: " + id);
    }

    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Cliente cliente){
        for (Cliente c : listaClientes){
            if (c.getId() == cliente.getId()){

                if (cliente.getNombre() != null){
                    c.setNombre(cliente.getNombre());
                }
                if (cliente.getNombreUsuario() != null){
                    c.setNombreUsuario(cliente.getNombreUsuario());
                }
                if (cliente.getContrasena() != null){
                    c.setContrasena(cliente.getContrasena());
                }

                return ResponseEntity.ok("Id cliente: " + cliente.getId() + " modificado exitosamente.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID de cliente no encontrada: " + cliente.getId());
    }
}
































