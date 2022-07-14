package com.upc.turismo.interfaces;

import com.upc.turismo.entidades.TblCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

// C R U D
public interface ICustomer extends JpaRepository<TblCustomer, Integer> {
}
