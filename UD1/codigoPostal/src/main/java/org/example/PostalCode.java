package org.example;

import java.util.List;

public class PostalCode {
    private String postalCode;
    private String country;
    private String countryAbbreviation;
    private List<Place> places;

    public PostalCode() {
    }

    public PostalCode(String postalCode, String country, String countryAbbreviation, List<Place> places) {
        this.postalCode = postalCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.places = places;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    // Método que devole a lista de lugares en HTML
    public String getPlacesAsHtml() {
        StringBuilder stringBuilder = new StringBuilder("<html><body>");
        places.forEach(place -> {
            stringBuilder.append(place.toHtml()).append("<br/>");
        });
        stringBuilder.append("</body></html>");
        return stringBuilder.toString();
    }

    // Método que o devolve en HTML como tabla
    public String getPlacesAsHtml(boolean asTable) {
        StringBuilder sb = new StringBuilder("<html><body>");
        if (asTable) {
            sb.append("<table border=\"1\">");
            sb.append("<tr style=\"background-color: #cccccc\">");
            sb.append("<th>Lugar</th>");
            sb.append("<th>Longitud</th>");
            sb.append("<th>Latitud</th>");
            sb.append("<th>Comunidad</th>");
            sb.append("<th>Abreviatura Comunidad</th>");
            sb.append("</tr>");
            places.forEach(place -> {
                sb.append(place.toHtml(true));
            });
            sb.append("</table>");
        } else {
            places.forEach(place -> {
                sb.append(place.toHtml()).append("<br>");
            });
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("Código Postal: '"
                + postalCode + System.lineSeparator()
                + "Pais: '" + country + System.lineSeparator()
                + "AbreviaturaPais: " + countryAbbreviation + System.lineSeparator());
        places.forEach(place -> {
            sb.append(place).append(System.lineSeparator());
        });
        return sb.toString();
    }

}
