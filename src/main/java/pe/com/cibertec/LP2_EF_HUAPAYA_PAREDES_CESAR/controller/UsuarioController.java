package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.UsuarioEntity;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("registrar_usuario")
    public String mostrarRegistrarUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "registrar_usuario";
    }
    @PostMapping("/registrar_usuario")
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioEntity usuarioFormulario,
    		Model model, @RequestParam("foto") MultipartFile foto) {
        //TODO: process POST request
        usuarioService.crearUsuario(usuarioFormulario, foto);
        return "registrar_usuario";
        
        
        
    }
    
    
    @GetMapping("/")
    public String mostrarLogin(Model model) {
    	model.addAttribute("usuario", new UsuarioEntity());
    	return "login";
    }
    
    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String correo, @RequestParam String contrasenia, Model model) {
        boolean resultadoLogin = usuarioService.validarUsuario(correo, contrasenia);
        if (!resultadoLogin) {
            model.addAttribute("error", "Credenciales incorrectas. Inténtelo de nuevo.");
            return "home";  
        }
        return "login";  
    }

    
   
}


	
	

