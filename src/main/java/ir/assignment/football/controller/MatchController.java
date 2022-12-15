package ir.assignment.football.controller;

import ir.assignment.football.repository.MatchRepo;
import ir.assignment.football.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class MatchController {

	@Autowired
	private MatchRepo matchRepo;
	
	@RequestMapping(value="/listMatch")
	public ModelAndView listPrediction(ModelAndView model) throws IOException{
		List<Match> matches = matchRepo.list();
		model.addObject("matches", matches);
		model.setViewName("listMatch");
		
		return model;
	}
	
	@RequestMapping(value = "/newMatch", method = RequestMethod.GET)
	public ModelAndView newMatch(ModelAndView model) {
		Match match = new Match();
		model.addObject("match", match);
		model.setViewName("MatchForm");
		return model;
	}
	
	@RequestMapping(value = "/saveMatch", method = RequestMethod.POST)
	public ModelAndView saveMatch(@ModelAttribute Match match) {
		matchRepo.saveOrUpdate(match);
		return new ModelAndView("redirect:/listMatch");
	}

	@RequestMapping(value = "/newPrediction", method = RequestMethod.GET)
	public ModelAndView newPrediction(HttpServletRequest request) throws Exception {
		int matchId = Integer.parseInt(request.getParameter("id"));
		Match match = matchRepo.get(matchId);
		if (match.getStatus()==1)
			throw new Exception("Match is finished!!!");
		ModelAndView model = new ModelAndView("PredictionForm");
		model.addObject("prediction", match);

		return model;
	}
	@RequestMapping(value = "/savePrediction", method = RequestMethod.POST)
	public ModelAndView savePrediction(@ModelAttribute Match match) {
		Match matchInfo = matchRepo.get(match.getId());
		matchInfo.setHomeTeamPreGoal(match.getHomeTeamPreGoal());
		matchInfo.setAwayTeamPreGoal(match.getAwayTeamPreGoal());
		matchRepo.saveOrUpdate(matchInfo);
		return new ModelAndView("redirect:/listMatch");
	}
	@RequestMapping(value = "/Completion", method = RequestMethod.GET)
	public ModelAndView completion(HttpServletRequest request) throws Exception {
		int matchId = Integer.parseInt(request.getParameter("id"));
		Match match = matchRepo.get(matchId);
		if (match.getStatus() == 1)
			throw new Exception("Match is finished!!!");
		ModelAndView model = new ModelAndView("MatchCompletionForm");
		model.addObject("completion", match);

		return model;
	}
	@RequestMapping(value = "/saveCompletion", method = RequestMethod.POST)
	public ModelAndView saveCompletion(@ModelAttribute Match match) {
		Match matchInfo = matchRepo.get(match.getId());
		matchInfo.setHomeTeamGoal(match.getHomeTeamGoal());
		matchInfo.setAwayTeamGoal(match.getAwayTeamGoal());
		matchInfo.setStatus(1);
		matchRepo.saveOrUpdate(matchInfo);
		return new ModelAndView("redirect:/listMatch");
	}
	
	@RequestMapping(value = "/deleteMatch", method = RequestMethod.GET)
	public ModelAndView deleteMatch(HttpServletRequest request) {
		int predictionId = Integer.parseInt(request.getParameter("id"));
		matchRepo.delete(predictionId);
		return new ModelAndView("redirect:/listMatch");
	}
	@RequestMapping(value = "/doPrediction", method = RequestMethod.GET)
	public ModelAndView doPrediction(HttpServletRequest request) {
		List<Match> matches = matchRepo.list();
		int score = 0;
		for (Match match : matches){
			if (match.getStatus()==1){
				String matchResult = match.getHomeTeamGoal()+"-"+match.getAwayTeamGoal();
				String matchPreResult = match.getHomeTeamPreGoal() + "-" + match.getAwayTeamPreGoal();
				if (matchResult.equals(matchPreResult))
					score=3;
				else if (match.getHomeTeamGoal()==match.getHomeTeamPreGoal())
					score+=1;
				else if (match.getAwayTeamGoal()==match.getAwayTeamPreGoal())
					score+=1;
				match.setScore(score);
				matchRepo.saveOrUpdate(match);
			}
		}
		return new ModelAndView("redirect:/listMatch");
	}
}
