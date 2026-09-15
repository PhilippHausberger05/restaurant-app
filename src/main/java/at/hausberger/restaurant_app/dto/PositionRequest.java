package at.hausberger.restaurant_app.dto;

public class PositionRequest {
    private Long gerichtId;
    private int menge;

    public Long getGerichtId() {
        return gerichtId;
    }
    public void setGerichtId(Long gerichtId) {
        this.gerichtId = gerichtId;
    }
    public int getMenge() {
        return menge;
    }
    public void setMenge(int menge) {
        this.menge = menge;
    }
}