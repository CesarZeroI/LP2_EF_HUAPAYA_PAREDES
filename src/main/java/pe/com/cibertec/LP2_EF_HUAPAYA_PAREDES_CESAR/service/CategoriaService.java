package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service;

import java.util.List;

import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.CategoriaEntity;

public interface CategoriaService {

	List<CategoriaEntity> listarCategoria();
	CategoriaEntity buscarCategoriaPorId(Integer categoria_ID);
}
