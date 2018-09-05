package junit;

import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.service.FilmService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestFilmService {

    private FilmService filmService;
    private Film film;

    @Before
    public void setUp(){
        filmService = new FilmService();
        film = new Film();
        film.setAgeRestriction("PG-13");
        film.setDirector("Taika Waititi");
        film.setDuration("02:10:00");
        film.setFilmId(1L);
        film.setFilmName("Thor: Ragnarok");
        film.setPoster("G:\\Ambidekstr\\EPAM\\Cinema\\Posters");
        film.setTrailerPath("G:\\Ambidekstr\\EPAM\\Cinema\\Posters");
    }

    @Test
    public void testGetAllFilms(){
        List<Film> filmList = filmService.getAllFilms();
        Assert.assertEquals(30,filmList.size());
        Assert.assertEquals(film,filmList.get(0));
        return;
    }

    @After
    public void tearDown(){
        filmService = null;
        film = null;
    }
}
