package com.cursospring.geekepedia.controllers;


import com.cursospring.geekepedia.dominio.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    private List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(
            new Cliente("Rodrigo", "Rodri adm", "123", 23),
            new Cliente("Juan", "juajo23", "keee321", 33),
            new Cliente("Virginia", "virgiLaOne", "laOne23", 22)
    ));

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return listaClientes;
    }

    @GetMapping("/clientes/{nombre}")
    public Cliente getCliente(@PathVariable String nombre) {
        for (Cliente c : listaClientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping("/agregar-cliente")
    public Cliente postCliente(@RequestBody Cliente cliente){
        listaClientes.add(cliente);
        return cliente;
    }

    @PutMapping("/editar-cliente")
    public Cliente putCliente(@RequestBody Cliente cliente){
        for (Cliente c : listaClientes){
            if (c.getId() == cliente.getId()){
                c.setNombre(cliente.getNombre());
                c.setNombreUsuario(cliente.getNombreUsuario());
                c.setContrasena(cliente.getContrasena());

                return cliente;
            }
        }
        return cliente;
    }

    @DeleteMapping("/eliminar-cliente/{id}")
    public Cliente deleteCliente (@PathVariable int id){
        for (Cliente c : listaClientes){
            if (c.getId() == id){
                listaClientes.remove(c);

                return c;
            }
        }
        return null;
    }
}
































