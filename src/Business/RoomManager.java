package Business;

import Dao.RoomDao;
import Entity.Room;

import java.util.ArrayList;

public class RoomManager {
    private final RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }


    public ArrayList<Room> findAllRooms() {
        return roomDao.findAll();
    }


    public Room findRoomById(int roomId) {
        return roomDao.getById(roomId);
    }


    public boolean saveRoom(Room room) {
        if (room.getRoom_id() > 0) {

            return roomDao.updateRoom(room);
        } else {

            return roomDao.save(room);
        }
    }

    public boolean deleteRoom(int roomId) {
        return roomDao.deleteRoom(roomId);
    }


    public ArrayList<Room> findRoomsByHotel(int hotelId) {
        String query = "SELECT * FROM rooms WHERE hotel_id = " + hotelId;
        return roomDao.selectByQuery(query);
    }
}
