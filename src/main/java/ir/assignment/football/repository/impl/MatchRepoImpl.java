package ir.assignment.football.repository.impl;

import ir.assignment.football.model.Match;
import ir.assignment.football.repository.MatchRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MatchRepoImpl implements MatchRepo {

    private JdbcTemplate jdbcTemplate;
    private static int predictionCount = 0;

    public MatchRepoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Match match) {
        predictionCount = 5 + (int) (Math.random() * ((1000 - 5) + 1));
        if (match.getId() > 0) {
            // update
            String sql = "UPDATE matches SET homeTeamName=?,awayTeamName=?"
                    +" ,homeTeamGoal=?,awayTeamGoal=?"
                    +" ,homeTeamPreGoal=?,awayTeamPreGoal=?"
                    +" ,score=?,status=?"
                    + " WHERE matchId=?";
            jdbcTemplate.update(sql, match.getHomeTeam(), match.getAwayTeam()
                    , match.getHomeTeamGoal(), match.getAwayTeamGoal()
                    , match.getHomeTeamPreGoal(), match.getAwayTeamPreGoal()
                    , match.getScore(), match.getStatus()
                    , match.getId());
        } else {
            // insert
            String sql = "INSERT INTO matches (matchId,homeTeamName,awayTeamName,homeTeamGoal,awayTeamGoal,homeTeamPreGoal,awayTeamPreGoal,score,status)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, predictionCount, match.getHomeTeam(), match.getAwayTeam(), match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                    match.getHomeTeamPreGoal(), match.getAwayTeamPreGoal(), match.getScore(), match.getStatus());
        }

    }

    @Override
    public void delete(int matchId) {
        String sql = "DELETE FROM matches WHERE matchId=?";
        jdbcTemplate.update(sql, matchId);
    }

    @Override
    public List<Match> list() {
        String sql = "SELECT * FROM matches";
        List<Match> matches = jdbcTemplate.query(sql, new RowMapper<Match>() {

            @Override
            public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
                Match match = new Match();

                match.setId(rs.getInt("matchId"));
                match.setHomeTeam(rs.getInt("homeTeamName"));
                match.setAwayTeam(rs.getInt("awayTeamName"));
                match.setHomeTeamGoal(rs.getInt("homeTeamGoal"));
                match.setAwayTeamGoal(rs.getInt("awayTeamGoal"));
                match.setHomeTeamPreGoal(rs.getInt("homeTeamPreGoal"));
                match.setAwayTeamPreGoal(rs.getInt("awayTeamPreGoal"));
                match.setScore(rs.getInt("score"));
                match.setStatus(rs.getInt("status"));

                return match;
            }

        });

        return matches;
    }

    @Override
    public Match get(int matchId) {
        String sql = "SELECT * FROM matches WHERE matchId=" + matchId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Match>() {

            @Override
            public Match extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Match match = new Match();

                    match.setId(rs.getInt("matchId"));
                    match.setHomeTeam(rs.getInt("homeTeamName"));
                    match.setAwayTeam(rs.getInt("awayTeamName"));
                    match.setHomeTeamGoal(rs.getInt("homeTeamGoal"));
                    match.setAwayTeamGoal(rs.getInt("awayTeamGoal"));
                    match.setHomeTeamPreGoal(rs.getInt("homeTeamPreGoal"));
                    match.setAwayTeamPreGoal(rs.getInt("awayTeamPreGoal"));
                    match.setScore(rs.getInt("score"));
                    match.setStatus(rs.getInt("status"));

                    return match;
                }

                return null;
            }

        });
    }
}
