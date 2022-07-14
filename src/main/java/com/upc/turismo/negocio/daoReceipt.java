package com.upc.turismo.negocio;

import com.upc.turismo.entidades.TblReceipt;
import com.upc.turismo.interfaces.IReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class daoReceipt {
    // Gestionar  = C R U D
    @Autowired
    private IReceipt Recibos;

    //  C -> Registrando
    public TblReceipt RegistarRecibo(TblReceipt Recibo){
        return Recibos.save(Recibo);
    }

    //  R-> Listando Todos
    public List<TblReceipt> TodosRecibos(){
        return Recibos.findAll();
    }
    //   -> Listando Especifico
    public TblReceipt ObtenerRecibo(Integer Codigo){
        return Recibos.findById(Codigo).get();
    }

    //  U -> Actualizando Especifico
    public TblReceipt ModificarRecibo(TblReceipt Recibo){
        return Recibos.save(Recibo);
    }
    //  D -> Eliminando
    public TblReceipt EliminarRecibo(Integer Codigo){
        TblReceipt Recibo;
        Recibo = Recibos.findById(Codigo).get();
        Recibos.delete(Recibo);
        return Recibo;
    }

}
