package presentacion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import negocio.DTOtCliente;

@objid ("69cff9f9-fddd-46c9-b01f-2aa13f2b2c28")
public class VistaAltaCliente {
    @objid ("73d83efe-4a43-4c20-8afc-0a59bd859fef")
    private String _dni;

    @objid ("08d33ec6-61ad-418c-bbc2-fa562a211f8f")
    private String _nombre;

    @objid ("5cc10efb-fd15-4cf6-aefa-32bc0ddae10b")
    public DTOtCliente tCliente;

    @objid ("3175bc60-dc4e-4d25-8fbe-2b50c79d9d60")
    public VistaAltaCliente(final String dni, final String nombre) {
    	
    }

}
