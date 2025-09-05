package com.cursospring.geekepedia.Servicios;

import com.cursospring.geekepedia.dominio.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private List<Producto> listaProductos = new ArrayList<>(Arrays.asList(
        new Producto(1,"Laptop", 1255.5, 10),
        new Producto(2,"Celular", 553.80, 12),
        new Producto(3,"Televisor", 280.5, 5),
        new Producto(4,"Smartwatch", 90.99, 30)
    ));

    @Override
    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
