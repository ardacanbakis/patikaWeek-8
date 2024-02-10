package Business;

import Dao.SeasonDao;
import Entity.Season;

import java.util.ArrayList;

public class SeasonManager {
    private final SeasonDao seasonDao = new SeasonDao();

    public ArrayList<Season> findAllSeasons() {
        return seasonDao.findAll();
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
