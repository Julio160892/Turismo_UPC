package com.upc.turismo.interfaces;

import com.upc.turismo.entidades.TblPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

// C R U D
public interface IPaymentMethod extends JpaRepository<TblPaymentMethod, Integer> {
}
