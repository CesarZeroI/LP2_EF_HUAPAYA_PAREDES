package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.UsuarioEntity;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.repository.UsuarioRepository;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.UsuarioService;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.utils.Utilitario;

@Service

public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto) {
		// fotoguardado
		String nombreFoto = Utilitario.guardarImagen(foto);
		
		usuarioEntity.setUrlImagen(nombreFoto);
		//contrasenia
		String contraseniaHash = Utilitario.extraerHash(usuarioEntity.getContrasenia());
		
		usuarioEntity.setContrasenia(contraseniaHash);
		
		//guardar en la bd
		
		usuarioRepository.save(usuarioEntity);
		
	}

	@Override
	public boolean validarUsuario(String correo, String contrasenia) {
	    UsuarioEntity usuario = usuarioRepository.findById(correo).orElse(null);
	    if (usuario == null || Utilitario.checkPassword(contrasenia, usuario.getContrasenia())) {
	        
	        return false;
	    }

	
	    return true;
	}


}
