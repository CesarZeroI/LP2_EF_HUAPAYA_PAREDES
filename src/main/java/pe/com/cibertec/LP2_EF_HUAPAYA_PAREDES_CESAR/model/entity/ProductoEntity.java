package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_producto")
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Producto", nullable = false)
	private Integer idProducto;
	
	@Column(name = "nombre_prod", nullable = false)
	private String nombre;
	
	@Column(name = "stock_prod", nullable = false)
	private Integer stock;
	
	@Column(name = "fk_categoria", nullable = false)
    private Integer id_Categoria;

	@ManyToOne
    @JoinColumn(name = "fk_categoria", referencedColumnName = "ID_Categoria", insertable = false, updatable = false)
	private CategoriaEntity categoriaEntity;

	public Integer getIdProducto() {
		return idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public Integer getIdCategoria() {
		return id_Categoria;
	}

	public CategoriaEntity getCategoriaEntity() {
		return categoriaEntity;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setIdCategoria(Integer id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
		this.categoriaEntity = categoriaEntity;
	}
	
	
}
