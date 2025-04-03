package presentacion.salas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("9fac9e50-fd83-46b5-81b9-55e898639586")
public class VistaAltaSalas {
    private JTextField idSalaTF;
    private JTextField aforoTF;

    public VistaAltaSalas() {
        JFrame ventana = new JFrame("Alta Sala");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(new FlowLayout());
        ventana.getContentPane().setBackground(new Color(88, 161, 164));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(88, 161, 164));
        ventana.add(panelPrincipal);

        JLabel titulo = new JLabel("Añadir Sala");
        titulo.setOpaque(true);
        titulo.setBackground(new Color(88, 161, 164));
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(88, 161, 164));
        panelTitulo.add(titulo);
        panelPrincipal.add(panelTitulo);

        JPanel panelId = new JPanel(new GridLayout(1, 2));
        panelId.setBackground(new Color(88, 161, 164));
        panelId.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        JLabel idLabel = new JLabel("ID Sala:");
        idSalaTF = new JTextField(30);
        panelId.add(idLabel);
        panelId.add(idSalaTF);
        panelPrincipal.add(panelId);

        JPanel panelAforo = new JPanel(new GridLayout(1, 2));
        panelAforo.setBackground(new Color(88, 161, 164));
        panelAforo.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        JLabel aforoLabel = new JLabel("Aforo:");
        aforoTF = new JTextField(30);
        panelAforo.add(aforoLabel);
        panelAforo.add(aforoTF);
        panelPrincipal.add(panelAforo);

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 3));
        botones.setBackground(new Color(88, 161, 164));

        JButton descartar = new JButton("Descartar");
        descartar.setForeground(Color.WHITE);
        descartar.setBackground(new Color(48, 86, 119));

        JButton guardar = new JButton("Guardar");
        guardar.setForeground(Color.WHITE);
        guardar.setBackground(new Color(48, 86, 119));

        JButton volver = new JButton(new ImageIcon("icons/back.png"));
        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);

        botones.add(volver);
        botones.add(descartar);
        botones.add(guardar);
        panelPrincipal.add(botones);

        ventana.setResizable(false);
        ventana.pack();
        ventana.setVisible(true);

        descartar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                idSalaTF.setText("");
                aforoTF.setText("");
            }
        });

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idSala = idSalaTF.getText();
                String aforo = aforoTF.getText();
                System.out.println("Guardando sala: ID=" + idSala + ", Aforo=" + aforo);
            }
        });

        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(false);
            }
        });
    }
}
