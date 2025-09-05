package com.cursospring.geekepedia.controllers;


import com.cursospring.geekepedia.Servicios.ProductoServicio;
import com.cursospring.geekepedia.Servicios.ProductoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<?> getProductos(){

        return ResponseEntity.ok(productoServicio.getListaProductos());
    }
}
