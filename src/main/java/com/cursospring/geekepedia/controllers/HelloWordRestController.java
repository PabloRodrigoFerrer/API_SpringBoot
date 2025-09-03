package com.cursospring.geekepedia.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordRestController {

    @GetMapping({"/saludar","/hola"})
    public String helloWord(){
        System.out.println("solicitud enviada");
        return "Hola mundo";
    }
}
