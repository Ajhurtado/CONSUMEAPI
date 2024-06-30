package ec.edu.uce.ConsumeApi.controller;

import ec.edu.uce.ConsumeApi.model.Rover;
import ec.edu.uce.ConsumeApi.service.MarsRoverPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarsRoverPhotosController {

    private final MarsRoverPhotosService photosService;

    @Autowired
    public MarsRoverPhotosController(MarsRoverPhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/photos")
    public List<Rover> getPhotos(
            @RequestParam String date,
            @RequestParam String camera,
            @RequestParam int sol,
            @RequestParam int page
    ) {
        return photosService.getPhotos(date, camera, sol, page);
    }
}