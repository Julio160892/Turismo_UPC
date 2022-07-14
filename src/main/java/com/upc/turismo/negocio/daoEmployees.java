package com.upc.turismo.negocio;

import com.upc.turismo.entidades.TblEmployees;
import com.upc.turismo.interfaces.IEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class daoEmployees {
    // Gestionar  = C R U D
    @Autowired
    private IEmployees Empleados;

    //  C -> Registrando
    public TblEmployees RegistrarEmpleados(TblEmployees Empleado){
        return Empleados.save(Empleado);
    }

    //  R-> Listando Todos
    public List<TblEmployees> TodosEmpleados(){
        return Empleados.findAll();
    }
    //   -> Listando Especifico
    public TblEmployees ObtenerEmpleado(Integer CodigoID){
        return Empleados.findById(CodigoID).get();
    }

    //  U -> Actualizando Especifico
    public TblEmployees ModificarEmpleado(TblEmployees Empleado){
        return Empleados.save(Empleado);
    }

    //  D -> Eliminando
    public TblEmployees EliminarEmpleado(Integer CodigoID){
        TblEmployees Empleado;
        Empleado = Empleados.findById(CodigoID).get();
        Empleados.delete(Empleado);
        return Empleado;
    }
}
