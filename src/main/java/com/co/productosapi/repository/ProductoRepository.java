package com.co.productosapi.repository;

import com.co.productosapi.dto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
