package ir.assignment.football.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ir.assignment.football.repository.TeamRepo;
import ir.assignment.football.model.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {

	@Autowired
	private TeamRepo teamRepo;
	
	@RequestMapping(value="/listTeam")
	public ModelAndView listTeam(ModelAndView model) throws IOException{
		List<Team> teams = teamRepo.list();
		model.addObject("teams", teams);
		model.setViewName("listTeam");
		
		return model;
	}
	
	@RequestMapping(value = "/newTeam", method = RequestMethod.GET)
	public ModelAndView newTeam(ModelAndView model) {
		Team team = new Team();
		model.addObject("team", team);
		model.setViewName("TeamForm");
		return model;
	}
	
	@RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
	public ModelAndView saveTeam(@ModelAttribute Team team) {
		teamRepo.saveOrUpdate(team);
		return new ModelAndView("redirect:/listTeam");
	}
	
	@RequestMapping(value = "/deleteTeam", method = RequestMethod.GET)
	public ModelAndView deleteTeam(HttpServletRequest request) {
		int teamId = Integer.parseInt(request.getParameter("id"));
		teamRepo.delete(teamId);
		return new ModelAndView("redirect:/listTeam");
	}
	
	@RequestMapping(value = "/editTeam", method = RequestMethod.GET)
	public ModelAndView editTeam(HttpServletRequest request) {
		int teamId = Integer.parseInt(request.getParameter("id"));
		Team team = teamRepo.get(teamId);
		ModelAndView model = new ModelAndView("TeamForm");
		model.addObject("team", team);
		
		return model;
	}
}
