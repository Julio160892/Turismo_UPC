package com.upc.turismo.negocio;

import com.upc.turismo.entidades.TblRoom;
import com.upc.turismo.interfaces.IRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class daoRoom {

    // Gestionar Cuartos = C R U D
    @Autowired
    private IRoom Cuartos;

    // C -> Registrando Cuartos
    public TblRoom RegistrarCuarto(TblRoom cuarto){
        return Cuartos.save(cuarto);
    }

    //  R-> Listando Todos los Cuartos
    public List<TblRoom> TodosCuartos(){
        return Cuartos.findAll();
    }
    //   -> Listando Cuarto Especifico
    public TblRoom ObtenerCuarto(Integer Codigo){
        return Cuartos.findById(Codigo).get();
    }

    // U -> Actualizando Cuarto Especifico
    public TblRoom ModificarCuarto(TblRoom cuarto){
        return Cuartos.save(cuarto);
    }

    // D -> Eliminando Cuarto
    public TblRoom EliminarCuarto(Integer Codigo){
        TblRoom Cuarto;
        Cuarto = Cuartos.findById(Codigo).get();
        Cuartos.delete(Cuarto);
        return Cuarto;
    }
}
