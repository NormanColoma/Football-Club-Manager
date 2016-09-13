package models;

import play.*;
import play.mvc.*;
import play.db.jpa.*;
import play.db.jpa.Transactional;
import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

public class TeamDAOImpl implements TeamDAO {

  public List<Team> getTeams(){
    List<Team> teams = JPA.em().createQuery("select t from Team t", Team.class).getResultList();
    return teams;
  }

  public Team createTeam(Team team){
      JPA.em().persist(team);
      return team;
  }

  public boolean deleteTeam(Integer id){
    Team team = JPA.em().find(Team.class, id);
    if(team != null){
      JPA.em().remove(team);
      return true;
    }
    return false;
  }

  public boolean updateTeam(Team team,Integer id){
    Team t = JPA.em().find(Team.class, id);
    if(t != null){
      t.setName(team.name);
      t.setAbout(team.about);
      return true;
    }
    return false;
  }
}
