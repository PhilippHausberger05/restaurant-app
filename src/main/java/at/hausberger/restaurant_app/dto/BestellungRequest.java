package at.hausberger.restaurant_app.dto;

import java.util.List;

public class BestellungRequest {
    private Long kundeId;
    private List<PositionRequest> positionen;

    public Long getKundeId() {
        return kundeId;
    }
    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }
    public List<PositionRequest> getPositionen() {
        return positionen;
    }
    public void setPositionen(List<PositionRequest> positionen) {
        this.positionen = positionen;
    }
}