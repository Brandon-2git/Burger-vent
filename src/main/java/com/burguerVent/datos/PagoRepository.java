package com.burguerVent.datos;

import com.burguerVent.modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Pago.
 * Proporciona métodos para acceder y manipular los datos de pagos en la base de datos.
 * Extiende JpaRepository para obtener funcionalidad CRUD básica.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Los métodos básicos de CRUD son proporcionados automáticamente por JpaRepository
    // Se pueden agregar métodos personalizados según sea necesario
} 