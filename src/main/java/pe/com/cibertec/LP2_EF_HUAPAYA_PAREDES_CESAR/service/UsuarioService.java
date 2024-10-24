package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.UsuarioEntity;

public interface UsuarioService {
	void crearUsuario (UsuarioEntity usuarioEntity, MultipartFile foto);
	boolean validarUsuario(String correo, String contrasenia);
	
}
