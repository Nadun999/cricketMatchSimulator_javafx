package Helpers;

import Models.Team_Array;

import java.util.*;

public class Helper {

    Team_Array team_to_bat;
    Team_Array team_to_bowl;

    public ArrayList<Team_Array> get_random_match(Team_Array[] Group_A, Team_Array[] Group_B){

        /** converting team array into lists **/
        List<Team_Array> Group_A_list = Arrays.asList(Group_A);
        List<Team_Array> Group_B_list = Arrays.asList(Group_B);

        /** shufflling the teams inside a group **/
        Collections.shuffle(Arrays.asList(Group_A));
        Collections.shuffle(Arrays.asList(Group_B));

        ArrayList<Team_Array> match_between_A = new ArrayList<>();
        ArrayList<Team_Array> match_between_B = new ArrayList<>();

        /** selecting two teams from each group **/
        match_between_A.add(Group_A_list.get(0));
        match_between_A.add(Group_A_list.get(1));

        match_between_B.add(Group_B_list.get(0));
        match_between_B.add(Group_B_list.get(1));

        /** inserting the two genarated matches into chosen match variable **/
        List<ArrayList<Team_Array>> chosen_match = Arrays.asList(match_between_A,match_between_B);

        /** picking a random match from the two genarated matches **/
        Random r=new Random();
        return chosen_match.get(r.nextInt(chosen_match.size()));
    }

    public List<Team_Array> toss_coin(ArrayList<Team_Array> the_match){

        String[] toss_outcome = new String[2];

        Team_Array visiting_team = the_match.get(0);
        Team_Array home_team = the_match.get(1);

        List<String> coin = Arrays.asList("heads", "tails");
        List<String> selection = Arrays.asList("heads", "tails");
        List<String> options = Arrays.asList("bowl", "bat");

        Collections.shuffle(coin);
        Collections.shuffle(selection);
        Collections.shuffle(options);

        if(selection.get(0).equals(coin.get(0))){
            toss_outcome[0] = visiting_team.getTeamName();
            toss_outcome[1] = options.get(0);
            System.out.println(toss_outcome[0]+"-- visiting team won the toss and choose to "+options.get(0));
            if (toss_outcome[1].equals("bat")){
                team_to_bat = visiting_team;
                team_to_bowl = home_team;
            }
            else {
                team_to_bat = home_team;
                team_to_bowl = visiting_team;
            }

        }
        else {
            toss_outcome[0] = home_team.getTeamName();
            toss_outcome[1] = options.get(1);
            System.out.println(toss_outcome[0]+"-- home team won the toss and choose to "+options.get(1));
            if (toss_outcome[1].equals("bat")){
                team_to_bat = home_team;
                team_to_bowl = visiting_team;
            }
            else {
                team_to_bat = visiting_team;
                team_to_bowl = home_team;
            }
        }
        return get_team_to_bat_and_bowl();
    }

    public List<Team_Array> get_team_to_bat_and_bowl(){
        List<Team_Array> battingBowlingTeams = Arrays.asList(team_to_bat,team_to_bowl);
        return battingBowlingTeams;
    }

    public String methodOfDismissal(){
        List<String> methodOfDismissal = Arrays.asList("Bowled", "Caught", "LBW");
        Collections.shuffle(methodOfDismissal);
        return methodOfDismissal.get(0);
    }

    public int genarateBatterScore(){
        List<Integer> batterScore = Arrays.asList(0,1,2,3,4,5,6);
        Collections.shuffle(batterScore);
        return batterScore.get(0);
    }

    public int genarateBowlerScore(){
        List<Integer> bowlerScore = Arrays.asList(1,2,3,4,5,6);
        Collections.shuffle(bowlerScore);
        return bowlerScore.get(0);
    }
}
