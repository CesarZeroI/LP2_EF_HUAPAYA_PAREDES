package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.CategoriaEntity;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.ProductoEntity;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.repository.CategoriaRepository;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.repository.ProductoRepository;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.CategoriaService;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.ProductoService;
@Service

public class ProductoServiceImpl implements ProductoService, CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public ProductoEntity buscarPorId(Integer idProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idProducto).get();
	}
	
	@Override
	public List<ProductoEntity> listarProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crearProducto(ProductoEntity newProducto) {
		// TODO Auto-generated method stub
		try {
			productoRepository.save(newProducto);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean actualizarProducto(ProductoEntity updatedProducto) {
		// TODO Auto-generated method stub
		ProductoEntity producto = buscarPorId(updatedProducto.getIdProducto());
		if(producto != null) {
			productoRepository.save(updatedProducto);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarProducto(Integer idProducto) {
		// TODO Auto-generated method stub
		ProductoEntity producto = buscarPorId(idProducto);
		if(producto != null) {
			productoRepository.delete(producto);
			return true;
		}
		return false;
	}

	@Override
	public List<CategoriaEntity> listarCategoria() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public CategoriaEntity buscarCategoriaPorId(Integer categoria_ID) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(categoria_ID).get();
	}

	

}
