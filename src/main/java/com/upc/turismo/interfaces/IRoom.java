package com.upc.turismo.interfaces;

import com.upc.turismo.entidades.TblRoom;
import org.springframework.data.jpa.repository.JpaRepository;

// C R U D
public interface IRoom extends JpaRepository<TblRoom, Integer> {
}
