package ec.edu.uce.ConsumeApi.service;

import ec.edu.uce.ConsumeApi.model.Rover;
import java.util.List;

public interface MarsRoverPhotosService {
    List<Rover> getPhotos(String date, String cameraName, int roverId, int page);
}