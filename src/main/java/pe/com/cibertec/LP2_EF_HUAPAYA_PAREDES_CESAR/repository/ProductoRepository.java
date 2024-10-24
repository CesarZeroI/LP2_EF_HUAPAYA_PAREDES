package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.ProductoEntity;



@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer>{

}
