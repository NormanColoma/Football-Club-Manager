package models;

import java.util.List;

public interface TeamDAO{

  public List<Team> getTeams();
  public Team createTeam(Team team);
  public boolean deleteTeam(Integer id);
  public boolean updateTeam(Team team, Integer id);

}
