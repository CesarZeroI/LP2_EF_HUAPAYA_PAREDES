package pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.CategoriaEntity;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.ProductoEntity;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.model.entity.UsuarioEntity;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.CategoriaService;
import pe.com.cibertec.LP2_EF_HUAPAYA_PAREDES_CESAR.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listaProd")
    public String listarProductos(Model model) {
    	model.addAttribute("lista_Productos", productoService.listarProductos());
        return "listaProd";
    }
    
	@GetMapping("/crearProd")
    public String crearProducto(Model model) {
    	model.addAttribute("Nuevo_Producto", new ProductoEntity());
		model.addAttribute("lista_Categoria", categoriaService.listarCategoria());
        return "crearProd";
    }
	
	@PostMapping("/crearProd")
	public String registrarProducto(@RequestParam Integer categoria_ID,
			@ModelAttribute("Nuevo_Producto") ProductoEntity Nuevo_Producto) {
		if (categoria_ID != null) {
			CategoriaEntity categoria = categoriaService.buscarCategoriaPorId(categoria_ID);
			Nuevo_Producto.setCategoriaEntity(categoria);
			productoService.crearProducto(Nuevo_Producto);
		} else {
			System.out.println("No se seleccionó un área.");
		}
		return "listaProd";
	}
    
    @GetMapping("/actualizarProducto/{prodId}")
	public String buscarProducto(@PathVariable Integer ID_Producto, Model model) {
		ProductoEntity producto = productoService.buscarPorId(ID_Producto);
		List<CategoriaEntity> categorias = categoriaService.listarCategoria();
		model.addAttribute("producto", producto);
		model.addAttribute("lista_Categorias", categorias);
		return "actualizarProducto";
	}

    @PostMapping("/actualizarProducto/{prodId}")
	public String actualizarProducto(@PathVariable Integer ID_Producto, @RequestParam Integer categoria_ID,
			@ModelAttribute("producto") ProductoEntity producto) {
		producto.setIdCategoria(categoria_ID);
		productoService.actualizarProducto(producto);
		return "listaProductos";
	}

	@GetMapping("/eliminar/{prodId}")
	public String eliminarProducto(@PathVariable Integer categoria_ID) {
		productoService.eliminarProducto(categoria_ID);
		return "listaProd";
	}
}
