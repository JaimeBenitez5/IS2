package integracion;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.DTOtCliente;

@objid ("c9382fff-a686-44ed-a6bd-9880fa6e65b9")
public interface DAOCliente {
    @objid ("0701464f-42e9-4833-b355-cb4c0019bae9")
    int createCliente(DTOtCliente cliente);

    @objid ("280c8e5f-0170-4cf8-b3c4-53cd5f34890d")
    DTOtCliente readCliente();

    @objid ("ea12b096-42dc-4a10-a277-0793e07af8a1")
    int updateCliente(final DTOtCliente cliente);

    @objid ("8ba5b0b9-8b5a-408f-ac50-2e633ebee280")
    int deleteCliente(final String dni);

    @objid ("5be71561-e293-481f-9810-a046fa1c0ddc")
    List<DTOtCliente> readAllClientes();

}
