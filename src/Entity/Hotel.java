package Entity;

public class Hotel {

    private int hotel_id;
    private String hotel_name;
    private String hotel_address;
    private String hotel_city;
    private String hotel_email;
    private String hotel_phone;
    private int hotel_star_rating;
    private boolean free_parking;
    private boolean free_wifi;
    private boolean hotel_concierge;
    private boolean room_service_24_7;
    private boolean fitness_center;
    private boolean spa;
    private boolean swimming_pool;

    public Hotel() {

    }

    public Hotel(int hotel_id, String hotel_name, String hotel_address, String hotel_city,
                 String hotel_email, String hotel_phone, int hotel_star_rating, boolean free_parking,
                 boolean free_wifi, boolean hotel_concierge, boolean room_service_24_7,
                 boolean fitness_center, boolean spa, boolean swimming_pool) {

        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_email = hotel_email;
        this.hotel_phone = hotel_phone;
        this.hotel_star_rating = hotel_star_rating;
        this.free_parking = free_parking;
        this.free_wifi = free_wifi;
        this.hotel_concierge = hotel_concierge;
        this.room_service_24_7 = room_service_24_7;
        this.fitness_center = fitness_center;
        this.spa = spa;
        this.swimming_pool = swimming_pool;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getHotel_email() {
        return hotel_email;
    }

    public void setHotel_email(String hotel_email) {
        this.hotel_email = hotel_email;
    }

    public String getHotel_phone() {
        return hotel_phone;
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone;
    }

    public int getHotel_star_rating() {
        return hotel_star_rating;
    }

    public void setHotel_star_rating(int hotel_star_rating) {
        this.hotel_star_rating = hotel_star_rating;
    }

    public boolean isFree_parking() {
        return free_parking;
    }

    public void setFree_parking(boolean free_parking) {
        this.free_parking = free_parking;
    }

    public boolean isFree_wifi() {
        return free_wifi;
    }

    public void setFree_wifi(boolean free_wifi) {
        this.free_wifi = free_wifi;
    }

    public boolean isHotel_concierge() {
        return hotel_concierge;
    }

    public void setHotel_concierge(boolean hotel_concierge) {
        this.hotel_concierge = hotel_concierge;
    }

    public boolean isRoom_service_24_7() {
        return room_service_24_7;
    }

    public void setRoom_service_24_7(boolean room_service_24_7) {
        this.room_service_24_7 = room_service_24_7;
    }

    public boolean isFitness_center() {
        return fitness_center;
    }

    public void setFitness_center(boolean fitness_center) {
        this.fitness_center = fitness_center;
    }

    public boolean isSpa() {
        return spa;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public boolean isSwimming_pool() {
        return swimming_pool;
    }

    public void setSwimming_pool(boolean swimming_pool) {
        this.swimming_pool = swimming_pool;
    }
}


