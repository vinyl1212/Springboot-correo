package com.tarea.controller;

import com.tarea.entity.Usuario;
import com.tarea.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import java.io.IOException;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/registrar")
    public String registrarUsuario(@RequestBody Usuario usuario) {
        // Configurar los datos del correo electrónico
        Context context = new Context();
        context.setVariable("name", usuario.getNombre());

        try {
            emailService.sendEmail(usuario.getEmail(), "Bienvenido a nuestra aplicación", "email-template.html", context);
            return "Registro exitoso y correo enviado";
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            return "Error al enviar el correo electrónico";
        }
    }
}


