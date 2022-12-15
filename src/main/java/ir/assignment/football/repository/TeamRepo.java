package ir.assignment.football.repository;

import ir.assignment.football.model.Team;

import java.util.List;

public interface TeamRepo {
	
	public void saveOrUpdate(Team team);
	
	public void delete(int teamId);
	
	public Team get(int teamId);
	
	public List<Team> list();
}
