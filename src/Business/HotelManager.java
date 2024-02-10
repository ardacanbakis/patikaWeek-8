package Business;

import Dao.HotelDao;
import Entity.Hotel;

import java.util.ArrayList;

public class HotelManager {
    private final HotelDao hotelDao = new HotelDao();

    public ArrayList<Object[]> getForTable(ArrayList<Hotel> hotelList) {
        ArrayList<Object[]> hotelObjList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            hotelObjList.add(new Object[]{
                    hotel.getHotel_id(),
                    hotel.getHotel_name(),
                    hotel.getHotel_address(),
                    hotel.getHotel_city(),
                    hotel.getHotel_email(),
                    hotel.getHotel_phone(),
                    hotel.getHotel_star_rating(),
                    hotel.isFree_parking(),
                    hotel.isFree_wifi(),
                    hotel.isHotel_concierge(),
                    hotel.isRoom_service_24_7(),
                    hotel.isFitness_center(),
                    hotel.isSpa(),
                    hotel.isSwimming_pool()
            });
        }
        return hotelObjList;
    }
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
}
