package Business;

import Dao.SeasonDao;
import Entity.Season;

import java.util.ArrayList;

public class SeasonManager {
    private final SeasonDao seasonDao = new SeasonDao();

    public ArrayList<Season> findAllSeasons() {
        return seasonDao.findAll();
    }

    public ArrayList<Object[]> getForTable(ArrayList<Season> seasonList) {
        ArrayList<Object[]> seasonObjList = new ArrayList<>();
        for (Season season : seasonList) {
            seasonObjList.add(new Object[]{
                    season.getSeason_id(),
                    season.getHotel_id(),
                    season.getStart_date(),
                    season.getEnd_date()
            });
        }
        return seasonObjList;
    }

    public Season findSeasonById(int seasonId) {
        return seasonDao.getById(seasonId);
    }

    public boolean saveSeason(Season season) {
        if (season.getSeason_id() > 0) {
            return seasonDao.update(season);
        } else {
            return seasonDao.save(season);
        }
    }

    public boolean deleteSeason(int seasonId) {
        return seasonDao.delete(seasonId);
    }
}
