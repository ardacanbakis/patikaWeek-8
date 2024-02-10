package Entity;

public class Pension {
    private int pension_id;
    private int hotel_id;
    private PensionType type; // Use the PensionType enum

    public Pension() {
    }

    public Pension(int pension_id, int hotel_id, PensionType type) {
        this.pension_id = pension_id;
        this.hotel_id = hotel_id;
        this.type = type;
    }

    // To be selected with in the GUI
    public enum PensionType {
        ULTRA_ALL_INCLUSIVE,
        ALL_INCLUSIVE,
        FULL_CREDIT_EXCLUDING_ALCOHOL,
        ROOM_BREAKFAST,
        FULL_PENSION,
        HALF_BOARD,
        BED_ONLY
    }

    // Getters and Setters
    public int getPension_id() { return pension_id; }
    public void setPension_id(int pension_id) { this.pension_id = pension_id; }

    public int getHotel_id() { return hotel_id; }
    public void setHotel_id(int hotel_id) { this.hotel_id = hotel_id; }

    public PensionType getType() { return type; }
    public void setType(PensionType type) { this.type = type; }


}
