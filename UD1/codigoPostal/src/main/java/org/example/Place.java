package org.example;

public class Place {
    private String placeName;
    private double latitude;
    private double longitude;
    private String state;
    private String stateAbbreviation;

    public Place() {
    }

    public Place(String placeName, double latitude, double longitude, String state, String stateAbbreviation) {
        this.placeName = placeName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    // Método que devolve os datos en formato HTML
    public String toHtml() {
        return "<h1>" + placeName + "<h1>"
                + "Latitude: " + latitude + "<br/>"
                + "Lonxitude: " + longitude + "<br/>"
                + "Comunidad: " + state + "<br/>"
                + "Abreviatura: " + stateAbbreviation;
    }

    // Método que devolve os datos en formato fila si un booleano é true
    public String toHtml(boolean row) {
        return (row) ? "<tr style=\"background-color: #cccccc\">"
                + "<td>" + placeName + "</td>"
                + "<td>" + latitude + "</td>"
                + "<td>" + longitude + "</td>"
                + "<td>" + state + "</td>"
                + "<td>" + stateAbbreviation + "</td>"
                + "</tr>"
                : "<h1>" + placeName + "</h1>"
                + "Longitud: " + latitude + "<br/>"
                + "Latitud: " + longitude + "<br/>"
                + "Comunidad: " + state + "<br/>"
                + "Abreviatura Comunidad: " + stateAbbreviation + "<br/>";
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "placeName='" + placeName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", state='" + state + '\'' +
                ", stateAbbreviation='" + stateAbbreviation + '\'' +
                '}';
    }
}
