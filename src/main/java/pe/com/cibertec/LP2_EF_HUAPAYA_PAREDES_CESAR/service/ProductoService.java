package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service;

import java.util.List;

import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.ProductoEntity;

public interface ProductoService {

	List<ProductoEntity> listarProductos();
	ProductoEntity buscarPorId(Integer ID_Producto);
	boolean crearProducto(ProductoEntity Nuevo_Producto);
	boolean actualizarProducto(ProductoEntity Actualizar_Producto);
	boolean eliminarProducto(Integer ID_Producto);
	
}
