package com.cursospring.geekepedia.Servicios;

import com.cursospring.geekepedia.dominio.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ProductoServicioJSONImpl implements ProductoServicio {

    List<Producto> listaProductos;

    @Override
    public List<Producto> getListaProductos() {

        try {
            listaProductos = new ObjectMapper()
                    .readValue(this.getClass().getResource("/productos.json"),
                            new TypeReference<List<Producto>>() {
                            });

            return listaProductos;

        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
}
