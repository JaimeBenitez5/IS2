package negocio;

import java.util.Collection;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("9e011476-3f7e-4cb4-adec-5fb2b9ca2b77")
public interface SACliente {
    @objid ("94dc1f0b-a91d-43aa-b952-ec72d7096f3d")
    int altaCliente(final DTOtCliente cliente);

    @objid ("ef47e726-6daa-402a-b807-b83681b7be9f")
    DTOtCliente leerCliente();

    @objid ("e9d51efa-64a0-4945-ae98-28ed826bc6f0")
    int actualizarCliente(final DTOtCliente cliente);

    @objid ("9ead1079-1cf0-429d-9471-b44e8503cf18")
    int borrarCliente(final String dni);

    @objid ("56937062-b7ac-4f11-97d6-c9e1cd03e24d")
    List<DTOtCliente> leerTodosClientes();

}
