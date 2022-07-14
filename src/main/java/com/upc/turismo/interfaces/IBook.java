package com.upc.turismo.interfaces;

import com.upc.turismo.entidades.TblBook;
import org.springframework.data.jpa.repository.JpaRepository;

// C R U D
public interface IBook extends JpaRepository<TblBook, Integer> {
}
