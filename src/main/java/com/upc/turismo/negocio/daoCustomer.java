package com.upc.turismo.negocio;

import com.upc.turismo.entidades.TblCustomer;
import com.upc.turismo.interfaces.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class daoCustomer {
    // Gestionar  = C R U D
    @Autowired
    private ICustomer Clientes;

    //  C -> Registrando
    public TblCustomer RegistrarClientes(TblCustomer Cliente){
        return Clientes.save(Cliente);
    }

    //  R-> Listando Todos
    public List<TblCustomer> TodosClientes(){
        return Clientes.findAll();
    }
    //   -> Listando Especifico
    public TblCustomer ObtenerCliente(Integer Codigo){
        return Clientes.findById(Codigo).get();
    }

    //  U -> Actualizando Especifico
    public TblCustomer ModificarCliente(TblCustomer Cliente){
        return Clientes.save(Cliente);
    }

    //  D -> Eliminando
    public TblCustomer EliminarCliente(Integer Codigo){
        TblCustomer Cliente;
        Cliente = Clientes.findById(Codigo).get();
        Clientes.delete(Cliente);
        return Cliente;
    }

}
