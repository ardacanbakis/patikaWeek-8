package Business;

import Dao.RoomDao;
import Entity.Room;

import java.util.ArrayList;

public class RoomManager {
    private final RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }

    public ArrayList<Object[]> getForTable(ArrayList<Room> roomList) {
        ArrayList<Object[]> roomObjList = new ArrayList<>();
        for (Room room : roomList) {
            roomObjList.add(new Object[]{
                    room.getRoom_id(),
                    room.getHotel_id(),
                    room.getType(),
                    room.getStock(),
                    room.getAdult_price(),
                    room.getChild_price(),
                    room.getBed_capacity(),
                    room.getSquare_meter(),
                    room.isTelevision(),
                    room.isMinibar(),
                    room.isGame_console(),
                    room.isSafe(),
                    room.isProjection()
            });
        }
        return roomObjList;
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
