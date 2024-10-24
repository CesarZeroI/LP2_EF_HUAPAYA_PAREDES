package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.multipart.MultipartFile;

public class Utilitario {
	public static String guardarImagen(MultipartFile foto) {
		
		try {
			byte[] fotoBytes= foto.getBytes();
			Path pathImagen= Paths.get("src/main/resources/static/usuario_foto/" + 
					foto.getOriginalFilename());
			Files.write(pathImagen, fotoBytes);
			return foto.getOriginalFilename();
			
		} catch (IOException e) {
			System.out.print("Ocurrio un error:   " + e.getMessage() );
			return null;
		}
	}
	
	public static String extraerHash (String contrasenia) {
		
		return BCrypt.hashpw(contrasenia, BCrypt.gensalt());
	}	
	
	public static boolean checkPassword(String contraseniaInput, String hashcontrasenia) {
		return BCrypt.checkpw(contraseniaInput, hashcontrasenia);
	}
	
}
