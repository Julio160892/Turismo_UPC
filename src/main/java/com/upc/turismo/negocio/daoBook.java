package com.upc.turismo.negocio;

import com.upc.turismo.entidades.TblBook;
import com.upc.turismo.interfaces.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class daoBook {
    // Gestionar  = C R U D
    @Autowired
    private IBook Cuaderno;

    //  C -> Registrando
    public TblBook RegistrarCuaderno(TblBook CuadernoR){
        return Cuaderno.save(CuadernoR);
    }

    //  R-> Listando Todos
    public List<TblBook> TodosRegistros(){
        return Cuaderno.findAll();
    }
    //   -> Listando Especifico
    public TblBook ObtenerRegistro(Integer Codigo){
        return Cuaderno.findById(Codigo).get();
    }

    //  U -> Actualizando Especifico
    public TblBook ModificarCuaderno(TblBook CuadernoR){
        return Cuaderno.save(CuadernoR);
    }

    //  D -> Eliminando
    public boolean EliminarCuaderno(Integer CodigoID){
//        TblBook CuadernoE;
//        CuadernoE = Cuaderno.findById(CodigoID).get();
        Cuaderno.deleteById(CodigoID);
        return true;
    }
}
