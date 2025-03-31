package com.burguerVent.datos;

import com.burguerVent.negocio.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Puedes agregar métodos personalizados si los necesitas
}
