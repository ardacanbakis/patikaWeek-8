package Entity;

import java.time.LocalDate;

public class Reservation {
    private int reservation_id;
    private int room_id;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private double total_price;
    private int guest_count;
    private String guest_name;
    private int guest_citizen_id;
    private String guest_mail;
    private String guest_phone;

    public Reservation() {
    }

    public Reservation(int reservation_id, int room_id, LocalDate check_in_date, LocalDate check_out_date,
                       double total_price, int guest_count, String guest_name, int guest_citizen_id,
                       String guest_mail, String guest_phone) {
        this.reservation_id = reservation_id;
        this.room_id = room_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.total_price = total_price;
        this.guest_count = guest_count;
        this.guest_name = guest_name;
        this.guest_citizen_id = guest_citizen_id;
        this.guest_mail = guest_mail;
        this.guest_phone = guest_phone;
    }

    // Getters
    public int getReservation_id() {
        return reservation_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public LocalDate getCheck_in_date() {
        return check_in_date;
    }

    public LocalDate getCheck_out_date() {
        return check_out_date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public int getGuest_count() {
        return guest_count;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public int getGuest_citizen_id() {
        return guest_citizen_id;
    }

    public String getGuest_mail() {
        return guest_mail;
    }

    public String getGuest_phone() {
        return guest_phone;
    }

    // Setters
    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setCheck_in_date(LocalDate check_in_date) {
        this.check_in_date = check_in_date;
    }

    public void setCheck_out_date(LocalDate check_out_date) {
        this.check_out_date = check_out_date;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public void setGuest_count(int guest_count) {
        this.guest_count = guest_count;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public void setGuest_citizen_id(int guest_citizen_id) {
        this.guest_citizen_id = guest_citizen_id;
    }

    public void setGuest_mail(String guest_mail) {
        this.guest_mail = guest_mail;
    }

    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }
}
