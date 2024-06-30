package ec.edu.uce.ConsumeApi.main;

/**
 *
 *
 *  @author:Hurtado Alexis
 *  Titulo: ConsumirApi
 */

import ec.edu.uce.ConsumeApi.ConsumeApiApplication;
import ec.edu.uce.ConsumeApi.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.swing.*;

public class AppPhotos {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Iniciar la aplicación
            ApplicationContext context = new AnnotationConfigApplicationContext(ConsumeApiApplication.class);
            View gui = context.getBean(View.class);
            gui.createAndShowGui(); // Método para mostrar la GUI
        });
    }
}