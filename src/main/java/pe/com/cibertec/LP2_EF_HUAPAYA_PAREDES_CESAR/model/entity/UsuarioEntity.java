package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name="tb_usuario")

@AllArgsConstructor
@NoArgsConstructor

public class UsuarioEntity {

	@Id
	@Column(name ="correo", nullable = false, length=60)
	private String correo;
	
	@Column(name ="contrasenia", nullable = false)
	private String contrasenia;
	
	@Column(name ="nombre", nullable = false, length=100)
	private String nombre;
	
	@Column(name ="apellido", nullable = false,length=100)
	private String apellido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fechaNacimiento", nullable = false)
	private Date fechaNacimiento;
	
	@Column(name ="url_imagen")
	private String urlImagen;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
	
	
}
