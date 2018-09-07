package junit;

import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.service.SessionService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class TestSessionService {

    private SessionService sessionService;
    private Session session;
    private Film film;

    @Before
    public void setUp(){
        sessionService = new SessionService();
    }

    @Test
    public void testGetSessions(){
        session = new Session();
        film = new Film();
        film.setFilmId(20L);
        film.setFilmName("Небоскрёб");
        film.setAgeRestriction("PG-13");
        film.setDirector("Роусон Маршалл Тёрбер");
        film.setDuration("01:42:00");
        session.setSessionId(4L);
        session.setFilm(film);
        session.setDate(Date.valueOf("2018-09-07"));
        session.setTime("09:00");
        List<Session> sessionList = sessionService.getSessions();
        Assert.assertEquals(21,sessionList.size());
        Assert.assertEquals(session,sessionList.get(0));
        return;
    }

    @Test
    public void testGetSessionById(){
        session = new Session();
        session.setSessionId(4L);
        session.setFilm(new Film(20L));
        session.setDate(Date.valueOf("2018-09-07"));
        session.setTime("09:00");
        Assert.assertEquals(session,sessionService.getSessionById(4L));
        return;
    }

    @After
    public void tearDown(){
        sessionService = null;
    }

}
