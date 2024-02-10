package Business;

import Dao.RoomDao;
import Entity.Room;

import java.util.ArrayList;

public class RoomManager {
    private final RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }

    //Retrieves all rooms from the database
    public ArrayList<Room> findAllRooms() {
        return roomDao.findAll();
    }

    //Retrieves a single room by its ID
    public Room findRoomById(int roomId) {
        return roomDao.getById(roomId);
    }

    //Saves a new room to the database or updates an existing one
    public boolean saveRoom(Room room) {
        if (room.getRoom_id() > 0) {
            // If room_id is present, it's an existing room, so update it
            return roomDao.updateRoom(room);
        } else {
            // If room_id is absent, it's a new room, so insert it
            return roomDao.save(room);
        }
    }

    //Deletes a room from the database
    public boolean deleteRoom(int roomId) {
        return roomDao.deleteRoom(roomId);
    }


    //Find rooms by hotel
    public ArrayList<Room> findRoomsByHotel(int hotelId) {
        String query = "SELECT * FROM rooms WHERE hotel_id = " + hotelId;
        return roomDao.selectByQuery(query);
        // Note: Directly concatenating the query might expose SQL injection risks.
        // Consider enhancing the selectByQuery method or creating a new method in RoomDao to safely handle parameters.
    }
}
