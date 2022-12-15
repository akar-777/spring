package ir.assignment.football.repository.impl;

import ir.assignment.football.repository.TeamRepo;
import ir.assignment.football.model.Team;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeamRepoImpl implements TeamRepo {

    private JdbcTemplate jdbcTemplate;
    private static int count = 0;

    public TeamRepoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Team team) {
        count = 5 + (int) (Math.random() * ((1000 - 5) + 1));
        if (team.getId() > 0) {
            // update
            String sql = "UPDATE teams SET name=?,city=?,shortName=? "
                    + "WHERE teamId=?";
            jdbcTemplate.update(sql, team.getName(),team.getCity(),team.getShortName(), team.getId());
        } else {
            // insert
            String sql = "INSERT INTO teams (teamId, name,city,shortName)"
                    + " VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, count, team.getName(),team.getCity(),team.getShortName());
        }

    }

    @Override
    public void delete(int teamId) {
        String sql = "DELETE FROM teams WHERE teamId=?";
        jdbcTemplate.update(sql, teamId);
    }

    @Override
    public List<Team> list() {
        String sql = "SELECT * FROM teams";
        List<Team> teams = jdbcTemplate.query(sql, new RowMapper<Team>() {

            @Override
            public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
                Team team = new Team();

                team.setId(rs.getInt("teamId"));
                team.setName(rs.getString("name"));
                team.setCity(rs.getString("city"));
                team.setShortName(rs.getString("shortName"));

                return team;
            }

        });

        return teams;
    }

    @Override
    public Team get(int teamId) {
        String sql = "SELECT * FROM teams WHERE teamId=" + teamId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Team>() {

            @Override
            public Team extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Team team = new Team();
                    team.setId(rs.getInt("teamId"));
                    team.setName(rs.getString("name"));
                    team.setCity(rs.getString("city"));
                    team.setShortName(rs.getString("shortName"));
                    return team;
                }

                return null;
            }

        });
    }

}
