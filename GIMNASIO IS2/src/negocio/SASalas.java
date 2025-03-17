package negocio;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1cd220e2-1716-4fe5-b2a9-03a6478a500d")
public interface SASalas {
    @objid ("605c0124-7ee4-444f-9c60-20617d39c44d")
    int altaSala(final tSala sala);

    @objid ("a3cdf8d0-0862-4ba4-822c-8f7c2e332aa1")
    tSala leerSala();

    @objid ("27416893-2654-4eda-90f3-2a26c98b808a")
    int actualizarSala(final tSala sala);

    @objid ("12ed4f33-9610-444d-96cf-047122910b77")
    int borrarSala(final int id);

    @objid ("65730f62-ebc6-432d-aaf2-468b41bf7576")
    List<tSala> leerTodasSalas();

}
