package integracion;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.tSala;

@objid ("65d42062-016b-4930-88c4-97f840773c84")
public interface DAOSalas {
    @objid ("da1cb44b-3264-4b3d-8a1b-20691cb500aa")
    int altaSala(tSala Sala);

    @objid ("c8ef7fae-f1b9-4be6-9388-a49621ca3a1a")
    tSala leerSala();

    @objid ("0733f5c5-45fd-4c61-8c6b-d8ff0289f14f")
    int actualizarSala(final tSala sala);

    @objid ("e2f7deaa-4424-43c1-bb61-bd22f3bfe592")
    int borrarSala(final int id);

    @objid ("7b0cd8bd-0f71-400c-8354-db16a0ec7fec")
    List<tSala> leerTodasSalas();

}
