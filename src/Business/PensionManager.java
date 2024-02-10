package Business;

import Dao.PensionDao;
import Entity.Pension;
import Entity.Pension.PensionType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PensionManager {
    private final PensionDao pensionDao = new PensionDao();

    public ArrayList<Pension> findAllPensions() {
        return pensionDao.findAll();
    }

    public Pension findPensionById(int pensionId) {
        return pensionDao.getById(pensionId);
    }

    public boolean savePension(Pension pension) {
        if (pension.getPension_id() > 0) {
            return pensionDao.update(pension);
        } else {
            return pensionDao.save(pension);
        }
    }

    public boolean deletePension(int pensionId) {
        return pensionDao.delete(pensionId);
    }


    public ArrayList<Pension> findPensionsByHotelId(int hotelId) {
        ArrayList<Pension> allPensions = pensionDao.findAll();
        return allPensions.stream()
                .filter(pension -> pension.getHotel_id() == hotelId)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public boolean updatePensionType(int pensionId, PensionType newType) {
        Pension pension = findPensionById(pensionId);
        if (pension != null) {
            pension.setType(newType);
            return pensionDao.update(pension);
        }
        return false;
    }
}
