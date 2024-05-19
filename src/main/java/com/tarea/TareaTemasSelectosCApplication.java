package com.tarea;

import com.tarea.entity.Producto;
import com.tarea.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareaTemasSelectosCApplication implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TareaTemasSelectosCApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Agregar datos de ejemplo
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100.0);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200.0);

        productoRepository.save(producto1);
        productoRepository.save(producto2);
    }
}

