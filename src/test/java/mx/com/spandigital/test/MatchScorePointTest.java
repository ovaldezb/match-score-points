package mx.com.spandigital.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import mx.com.spandigital.constants.MatchConstants;
import mx.com.spandigital.dto.Team;
import mx.com.spandigital.interfaces.CalculationsInterface;
import mx.com.spandigital.utils.Calculations;

public class MatchScorePointTest {
	CalculationsInterface calc = new Calculations();
	Map<String, Integer> points = new HashMap<>();
	@Test
	public void computePointsTie() {
		
		Team team1 = new Team("Lions", 0, 3);
		Team team2 = new Team("Snakes", 0, 3);
		calc.computePointsPerMatch(team1, team2);
		assertTrue(team1.getPoints()==MatchConstants.TIE);
		assertTrue(team2.getPoints()==MatchConstants.TIE);
	}
	
	@Test
	public void computePointsWinLose() {
		Team team1 = new Team("Tarantulas", 0, 1);
		Team team2 = new Team("FC Awesome", 0, 0);
		calc.computePointsPerMatch(team1, team2);
		assertTrue(team1.getPoints()==MatchConstants.WIN);
		assertTrue(team2.getPoints()==MatchConstants.LOSE);
	}
	
	@Test
	public void computePointsLoseWin() {
		Team team1 = new Team("Tarantulas", 0, 0);
		Team team2 = new Team("FC Awesome", 0, 3);
		calc.computePointsPerMatch(team1, team2);
		assertTrue(team1.getPoints()==MatchConstants.LOSE);
		assertTrue(team2.getPoints()==MatchConstants.WIN);
	}
	
	@Test
	public void computeAccomulatedPoints() {
		Team team1 = new Team("Tarantulas", 0, 1);
		Team team2 = new Team("FC Awesome", 0, 0);
		calc.computePointsPerMatch(team1, team2);
		calc.countPointsPerTeam(team1, points);
		calc.countPointsPerTeam(team2, points);
		assertTrue(points.get("Tarantulas").intValue()==3);
		assertTrue(points.get("FC Awesome").intValue()==0);
	}
	
	@Test
	public void computeAccomulatedPointsMultiple() {
		Team team1 = new Team("Tarantulas", 0, 1);
		Team team2 = new Team("FC Awesome", 0, 0);
		calc.computePointsPerMatch(team1, team2);
		calc.countPointsPerTeam(team1, points);
		calc.countPointsPerTeam(team2, points);
		team1 = new Team("Tarantulas", 0, 3);
		team2 = new Team("Snakes", 0, 1);
		calc.computePointsPerMatch(team1, team2);
		calc.countPointsPerTeam(team1, points);
		calc.countPointsPerTeam(team2, points);
		assertTrue(points.get("Tarantulas").intValue()==6);
		assertTrue(points.get("FC Awesome").intValue()==0);
		assertTrue(points.get("Snakes").intValue()==0);
	}

}
