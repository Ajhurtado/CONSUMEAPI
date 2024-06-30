package ec.edu.uce.ConsumeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rover {
    private int id;
    private String name;
    private String landingDate;
    private String launchDate;
    private String status;
    private int maxSol;
    private String maxDate;
    private int totalPhotos;
    private String imgSrc;
    private Camera camera;  // Agregar referencia a la clase Camera

    // Getters y setters para todos los campos

    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("landing_date")
    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    @JsonProperty("launch_date")
    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("max_sol")
    public void setMaxSol(int maxSol) {
        this.maxSol = maxSol;
    }

    @JsonProperty("max_date")
    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    @JsonProperty("total_photos")
    public void setTotalPhotos(int totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    @JsonProperty("img_src")
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @JsonProperty("camera")
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public String getStatus() {
        return status;
    }

    public int getMaxSol() {
        return maxSol;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public int getTotalPhotos() {
        return totalPhotos;
    }

    public String getImgSrc() {
        return imgSrc;
    }
}