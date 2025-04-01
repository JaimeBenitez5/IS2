package presentacion;

import java.awt.*;
import javax.swing.*;

public class VistaEmpleados {

    public VistaEmpleados() {
        // ------------------------------------
        // Diseño de la vista
        JFrame menuPrincipal = new JFrame("Menú CRUD Empleados");
        menuPrincipal.setSize(1280, 720);
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con margen y disposición en cuadrícula
        JPanel panel = new JPanel(new GridLayout(3, 2, 20, 20));
        panel.setBackground(new Color(88, 161, 164));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Crear botones
        JButton botonAlta = crearBoton("Alta Empleado");
        JButton botonReadAll = crearBoton("Mostrar Empleados");
        JButton botonRead = crearBoton("Mostrar Empleado");
        JButton botonUnroll = crearBoton("Eliminar Empleado");
        JButton botonModClient = crearBoton("Modificar Empleado");

        // Botón de regreso al menú principal con icono
        JButton botonMainMenu = new JButton(new ImageIcon("icons/main_menu.png"));
        botonMainMenu.setBorderPainted(false);
        botonMainMenu.setContentAreaFilled(false);
        botonMainMenu.setActionCommand("Ir a Menú Principal");

        // Agregar elementos al panel
        panel.add(botonAlta);
        panel.add(botonReadAll);
        panel.add(botonRead);
        panel.add(botonUnroll);
        panel.add(botonModClient);

        // Agregar el panel y el botón del menú principal
        menuPrincipal.add(panel, BorderLayout.CENTER);
        menuPrincipal.add(botonMainMenu, BorderLayout.SOUTH);
        menuPrincipal.setVisible(true);

        // ------------------------------------
        // Listeners
        botonAlta.addActionListener(e -> {
            menuPrincipal.setVisible(false);
            Controlador.accion(Evento.ALTA_CLIENTE, null);
        });

        botonReadAll.addActionListener(e -> {
            Controlador.accion(Evento.MOSTRAR_CLIENTES, null);
        });

        botonUnroll.addActionListener(e -> {
            menuPrincipal.setVisible(false);
            Controlador.accion(Evento.ELIMINAR_CLIENTE, null);
        });

        botonMainMenu.addActionListener(e -> {
            menuPrincipal.setVisible(false);
            new VistaMenuPrincipal();
        });
    }

    // Método para crear botones con formato uniforme
    private static JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(48, 86, 119));
        return boton;
    }

    public static void actualizar(int evento, Object datos) {
        if (evento == Evento.RES_MOSTRAR_CLIENTES_OK) {
            JTextArea textArea = new JTextArea(datos.toString());
            textArea.setLineWrap(true);
            textArea.setEditable(false);
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 200));
            JOptionPane.showMessageDialog(null, scrollPane, "EMPLEADOS", JOptionPane.DEFAULT_OPTION);
        } else if (evento == Evento.RES_MOSTRAR_CLIENTES_KO) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar ningún empleado");
        }
    }
}
