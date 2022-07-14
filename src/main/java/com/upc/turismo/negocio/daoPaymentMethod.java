package com.upc.turismo.negocio;

import com.upc.turismo.entidades.TblPaymentMethod;
import com.upc.turismo.interfaces.IPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class daoPaymentMethod {
    // Gestionar  = C R U D
    @Autowired
    private IPaymentMethod TipoPago;

    //  C -> Registrando
    public TblPaymentMethod RegistrarTipoPago(TblPaymentMethod Tipo){
        return TipoPago.save(Tipo);
    }

    //  R-> Listando Todos
    public List<TblPaymentMethod> TodosTipoPagos(){
        return TipoPago.findAll();
    }
    //   -> Listando Especifico
    public TblPaymentMethod ObtenerTipoPago(Integer Codigo){
        return TipoPago.findById(Codigo).get();
    }

    //  U -> Actualizando Especifico
    public TblPaymentMethod ModficarTipoPago(TblPaymentMethod Tipo){
        return TipoPago.save(Tipo);
    }

    //  D -> Eliminando
    public TblPaymentMethod EliminarTipoPago(Integer Codigo){
        TblPaymentMethod Tipo;
        Tipo = TipoPago.findById(Codigo).get();
        TipoPago.delete(Tipo);
        return Tipo;
    }
}
