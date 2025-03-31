package com.burguerVent.datos;


import com.burguerVent.negocio.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Puedes agregar métodos personalizados si los necesitas
	
	}
