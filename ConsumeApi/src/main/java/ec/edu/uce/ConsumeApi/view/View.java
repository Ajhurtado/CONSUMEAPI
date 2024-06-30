package ec.edu.uce.ConsumeApi.view;

import ec.edu.uce.ConsumeApi.model.Rover;
import ec.edu.uce.ConsumeApi.service.MarsRoverPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Component
public class View extends JPanel {

    private final MarsRoverPhotosService photosService;

    @Autowired
    public View(MarsRoverPhotosService photosService) {
        this.photosService = photosService;
    }

    public void createAndShowGui() {
        JFrame frame = new JFrame("Mars Rover Photos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new GridLayout(0, 1)); // Panel para mostrar las URLs

        // Obtener datos de la API
        List<Rover> rovers = photosService.getPhotos("2023-01-01", "FHAZ", 1000, 1);

        // Mostrar las URLs en etiquetas clickeables
        for (Rover rover : rovers) {
            JLabel label = new JLabel(rover.getImgSrc());
            label.setForeground(Color.BLUE); // Cambiar color para indicar que es clickeable
            label.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor al pasar por encima

            // Agregar listener de clic
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        // Abrir la URL en el navegador predeterminado
                        Desktop.getDesktop().browse(new URI(rover.getImgSrc()));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            panel.add(label);
        }

        frame.add(new JScrollPane(panel)); // Agregar panel con scroll
        frame.setVisible(true);
    }
}