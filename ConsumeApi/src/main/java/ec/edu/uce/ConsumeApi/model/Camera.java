package ec.edu.uce.ConsumeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Camera {
    private int id;
    private String name;
    private int roverId;
    private String fullName;

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

    public int getRoverId() {
        return roverId;
    }

    @JsonProperty("rover_id")
    public void setRoverId(int roverId) {
        this.roverId = roverId;
    }

    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}