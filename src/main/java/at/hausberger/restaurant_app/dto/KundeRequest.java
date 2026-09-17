package at.hausberger.restaurant_app.dto;

public class KundeRequest {
    private String name;
    private String email;
    private String passwort;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswort() { return passwort; }
    public void setPasswort(String passwort) { this.passwort = passwort; }
}