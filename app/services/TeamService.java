package services;

import play.*;
import play.mvc.*;
import models.*;
import java.util.List;

public class TeamService{

  private TeamDAOImpl teamDAO;

  public TeamService(){
    this.teamDAO = new TeamDAOImpl();
  }

  public List<Team> getAll(){
    return teamDAO.getTeams();
  }
  public Team addTeam(Team t){
    return teamDAO.createTeam(t);
  }

  public boolean deleteTeam(Integer id){
    return teamDAO.deleteTeam(id);
  }

  public boolean updateTeam(Team t,Integer id){
    return teamDAO.updateTeam(t,id);
  }
}
