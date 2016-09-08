package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

@Entity
public class Team{
    @Id
    @SequenceGenerator(name="team_id_seq1",
                       sequenceName="team_id_seq1",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="team_id_seq1")
    public Integer id;

    public String name;

    public String about;
}
