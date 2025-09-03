package com.cursospring.geekepedia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BienvenidaRestController {

    @GetMapping({"/saludo/{nombre}","/hola/{nombre}"})
    public String saludar(@PathVariable String nombre){

        return "Hola bienvenido, " + nombre ;
    }
}
