package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Categoria", nullable = false)
	private Integer id_Categoria;
	
	@Column(name = "nombre_Categoria", nullable = false)
	private String nombre_categoria;
}
