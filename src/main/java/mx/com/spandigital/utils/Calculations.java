package mx.com.spandigital.utils;

import java.util.Map;

import mx.com.spandigital.constants.MatchConstants;
import mx.com.spandigital.dto.Team;
import mx.com.spandigital.interfaces.CalculationsInterface;

public class Calculations implements CalculationsInterface{

	public void computePointsPerMatch(Team team1, Team team2){
		if(team1.getScore() > team2.getScore()) {
			team1.setPoints(MatchConstants.WIN);
			team2.setPoints(MatchConstants.LOSE);
		}else if(team1.getScore() < team2.getScore()) {
			team1.setPoints(MatchConstants.LOSE);
			team2.setPoints(MatchConstants.WIN);
		}else {
			team1.setPoints(MatchConstants.TIE);
			team2.setPoints(MatchConstants.TIE);
		}
	}
	
	public void countPointsPerTeam(Team team, Map<String, Integer> pointsPerTeam) {
		if(!pointsPerTeam.containsKey(team.getName())) {
			pointsPerTeam.put(team.getName(), team.getPoints());
		}else {
			pointsPerTeam.put(team.getName(), pointsPerTeam.get(team.getName())+ team.getPoints());
		}
	}
}
