package com.upc.turismo.interfaces;

import com.upc.turismo.entidades.TblEmployees;
import org.springframework.data.jpa.repository.JpaRepository;

// C R U D
public interface IEmployees extends JpaRepository<TblEmployees, Integer> {
}
