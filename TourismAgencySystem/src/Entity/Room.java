package Entity;

public class Room {
    private int room_id;
    private int hotel_id; // Link to a specific hotel
    private String type;
    private int stock;
    private double adult_price;
    private double child_price;
    private int bed_capacity;
    private int square_meter;
    private boolean television;
    private boolean minibar;
    private boolean game_console;
    private boolean safe;
    private boolean projection;

    public Room(int room_id, int hotel_id, String type, int stock, double adult_price, double child_price,
                int bed_capacity, int square_meter, boolean television, boolean minibar,
                boolean game_console, boolean safe, boolean projection) {
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.type = type;
        this.stock = stock;
        this.adult_price = adult_price;
        this.child_price = child_price;
        this.bed_capacity = bed_capacity;
        this.square_meter = square_meter;
        this.television = television;
        this.minibar = minibar;
        this.game_console = game_console;
        this.safe = safe;
        this.projection = projection;

    }

    // Getters and setters
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getAdult_price() {
        return adult_price;
    }

    public void setAdult_price(double adult_price) {
        this.adult_price = adult_price;
    }

    public double getChild_price() {
        return child_price;
    }

    public void setChild_price(double child_price) {
        this.child_price = child_price;
    }

    public int getBed_capacity() {
        return bed_capacity;
    }

    public void setBed_capacity(int bed_capacity) {
        this.bed_capacity = bed_capacity;
    }

    public int getSquare_meter() {
        return square_meter;
    }

    public void setSquare_meter(int square_meter) {
        this.square_meter = square_meter;
    }

    public boolean isTelevision() {
        return television;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isGame_console() {
        return game_console;
    }

    public void setGame_console(boolean game_console) {
        this.game_console = game_console;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public boolean isProjection() {
        return projection;
    }

    public void setProjection(boolean projection) {
        this.projection = projection;
    }

}
