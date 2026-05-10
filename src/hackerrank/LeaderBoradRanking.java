package hackerrank;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

import utils.CommonUtils;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

public class LeaderBoradRanking {

	public static void main(String[] args) {
		// Score of 7 existing players, these scores will not change
		int scores[] = {100, 100, 50, 40, 40, 20, 10};  // Ranks => 1, 1, 2, 3, 3, 4, 5
		// Alice a new player (8th) starts playing, below are her scores after each round
		// Find out her rank after each round, players with the same scores will have same rank
		// Her ranks will change as: 6 => 5 => 4 => 2 => 1
		int alice[] = {5, 25, 50, 120};
		
		CommonUtils.printArray(climbingLeaderboard(scores, alice));
		CommonUtils.printArray(climbingLeaderboard2(scores, alice));
		CommonUtils.printArray(viren(scores, alice));
	}
	
    // Submitted
    static int[] viren(int[] scores, int[] alice) {
    	int[] distinctScores = IntStream.of(scores).distinct().toArray();
    	int[] ranking = new int[alice.length];
    	
    	if (scores.length == 0) {
    		for (int i = 0; i < alice.length; i++) {
    			ranking[i] = 1;
    		}
    		return ranking;
    	}
    	
    	//for (int score: alice) {
    	for (int i = 0; i < alice.length; i++) {
    		ranking[i] = distinctScores.length + 1;
    		for (int j = 0; j < distinctScores.length; j++) {
    			if (alice[i] >= distinctScores[j]) {
    				// found the position
    				//ranking[i] = (alice[i] > distinctScores[j]) ? (j + 1) : j;
    				ranking[i] = j + 1;
    				break;
    			}
    		}
    	}
    	
    	return ranking;
    }
	
    // Submitted
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	int[] distinctScores = IntStream.of(scores).distinct().toArray();
    	int rankIndex = distinctScores.length;  // start with lowest
    	int ranking[] = new int[alice.length];
    	
    	//for (int score: alice) {
    	for (int i = 0; i < alice.length; i++) {
    		while (rankIndex >= 1) {
    			if (alice[i] >= distinctScores[rankIndex - 1]) {
    				rankIndex--;
    			} else {
    				//System.out.println(pos + 2);
    				ranking[i] = rankIndex + 1;
    				break;
    			}
    		}
    		
    		if (rankIndex < 1) {
    			//There were no scores higher than hers
    			ranking[i] = 1;
    		}
    	}
    	
    	return ranking;
    }
    
    static int[] climbingLeaderboard2(int[] scores, int[] alice) {
        SortedSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int[] rankings = new int[alice.length];
        
        for (int i = 0; i < scores.length; i++) {
            set.add(scores[i]);
        }
        
        boolean doesExist;
        for (int j = 0; j < alice.length; j++) {
            doesExist = false;
            if (set.contains(alice[j])) {
                doesExist = true;
            }
            set.add(alice[j]);
            rankings[j] = set.headSet(alice[j]).size() + 1;
            
            if (doesExist == false) {
                set.remove(alice[j]);
            }
        }
        
        return rankings;
    }
}
