package Business;

import Dao.HotelDao;
import Entity.Hotel;

import java.util.ArrayList;

public class HotelManager {
    private final HotelDao hotelDao = new HotelDao();

    public ArrayList<Hotel> findAllHotels() {
        return hotelDao.findAll();
    }

    public Hotel findHotelById(int hotelId) {
        return hotelDao.getById(hotelId);
    }

    public boolean saveHotel(Hotel hotel) {
        if (hotel.getHotel_id() > 0) {
            return hotelDao.update(hotel);
        } else {
            return hotelDao.save(hotel);
        }
    }

    public boolean deleteHotel(int hotelId) {
        return hotelDao.delete(hotelId);
    }

    // Additional methods for business logic as needed
    // Example: filtering hotels by city, star rating, or available amenities
}
