package mx.com.spandigital.main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import mx.com.spandigital.constants.MatchConstants;
import mx.com.spandigital.dto.Team;
import mx.com.spandigital.interfaces.CalculationsInterface;
import mx.com.spandigital.utils.Calculations;

public class Main {

	public static void main(String[] args) {
		Map<String, Integer> pointsPerTeam = new HashMap<String, Integer>();
		String matchScore = null;
		Team team1 = null;
		Team team2 = null;
		String[] teamsData;
		CalculationsInterface calculation = new Calculations();
		try (Scanner matchResult = new Scanner(System.in)) {
			do {
				matchScore = matchResult.nextLine();
				//The cycle will end when the user hits enter with EMPTY String
				if(MatchConstants.EMPTY.equals(matchScore)) break;
				teamsData = matchScore.split(",");	
				team1 = new Team(teamsData[0].strip().substring(0,teamsData[0].lastIndexOf(" ")) ,0,Integer.parseInt(teamsData[0].substring(teamsData[0].lastIndexOf(" "),teamsData[0].length()).strip()));
				team2 = new Team(teamsData[1].strip().substring(0,teamsData[1].lastIndexOf(" ")) ,0,Integer.parseInt(teamsData[1].substring(teamsData[1].lastIndexOf(" "),teamsData[1].length()).strip()));
				calculation.computePointsPerMatch(team1, team2);
				calculation.countPointsPerTeam(team1, pointsPerTeam);
				calculation.countPointsPerTeam(team2, pointsPerTeam);
			}while(true);
			List<Team> listResults = pointsPerTeam.entrySet()
										.stream()
										.map(t-> new Team(t.getKey(),t.getValue(),0)).collect(Collectors.toList());
			Collections.sort(listResults);
			int numberPosition = 0;
			for(Team t: listResults) {
				System.out.println(++numberPosition+". "+t.getName()+", "+t.getPoints()+" pt"+ (t.getPoints()!=1 ? "s":""));
			}
		}
		

	}

}
