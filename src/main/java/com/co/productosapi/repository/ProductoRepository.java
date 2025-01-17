package com.co.productosapi.repository;

import com.co.productosapi.dto.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoDTO, Integer> {

}
