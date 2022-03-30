package Models;

import java.io.File;

public class Team_Array {
    private String BasePath = "E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/coursework/team_data/";
    private String _name;
    private File File_Path;
    private String Team_File_Path;

    public Team_Array(String TeamName){
        _name = TeamName;
    }

    public Team_Array() {
    }

    public String getTeamName(){
        return _name;
    }

    public File getTeamPath(){
        Team_File_Path = BasePath + _name+"/"+ _name +".xlsx";
        File_Path = new File((Team_File_Path));
        return File_Path;
    }
}
