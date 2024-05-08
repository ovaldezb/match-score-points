package mx.com.spandigital.interfaces;

import java.util.Map;

import mx.com.spandigital.dto.Team;

public interface CalculationsInterface {

	void computePointsPerMatch(Team team1, Team team2);
	void countPointsPerTeam(Team team, Map<String, Integer> pointsPerTeam);
}
