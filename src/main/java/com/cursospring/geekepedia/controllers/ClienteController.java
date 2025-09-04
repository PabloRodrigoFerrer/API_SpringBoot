package com.cursospring.geekepedia.controllers;


import com.cursospring.geekepedia.dominio.Cliente;
import org.springframework.web.bind.annotation.*;

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
    public List<Cliente> getClientes() {
        return listaClientes;
    }

    @RequestMapping( value = "{nombre}", method = RequestMethod.GET)
    //@GetMapping("/{nombre}")
    public Cliente getCliente(@PathVariable String nombre) {
        for (Cliente c : listaClientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping
    public Cliente postCliente(@RequestBody Cliente cliente){
        listaClientes.add(cliente);
        return cliente;
    }

    @PutMapping
    public Cliente putCliente(@RequestBody Cliente cliente){
        for (Cliente c : listaClientes){
            if (c.getId() == cliente.getId()){
                c.setNombre(cliente.getNombre());
                c.setNombreUsuario(cliente.getNombreUsuario());
                c.setContrasena(cliente.getContrasena());

                return c;
            }
        }
        return cliente;
    }

    @DeleteMapping("/{id}")
    public Cliente deleteCliente (@PathVariable int id){
        for (Cliente c : listaClientes){
            if (c.getId() == id){
                listaClientes.remove(c);

                return c;
            }
        }
        return null;
    }

    @PatchMapping
    public Cliente patchCliente(@RequestBody Cliente cliente){
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

                return c;
            }
        }
        return null;
    }
}
































