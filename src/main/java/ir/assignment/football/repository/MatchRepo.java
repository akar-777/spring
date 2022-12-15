package ir.assignment.football.repository;

import ir.assignment.football.model.Match;

import java.util.List;

public interface MatchRepo {

    public void saveOrUpdate(Match match);

    public void delete(int matchId);

    public Match get(int matchId);

    public List<Match> list();
}
