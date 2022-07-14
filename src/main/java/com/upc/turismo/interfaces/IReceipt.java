package com.upc.turismo.interfaces;

import com.upc.turismo.entidades.TblReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

// C R U D
public interface IReceipt extends JpaRepository<TblReceipt, Integer> {
}
