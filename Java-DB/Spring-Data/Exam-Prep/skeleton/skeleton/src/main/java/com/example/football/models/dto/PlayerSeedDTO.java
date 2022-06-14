package com.example.football.models.dto;

import com.example.football.models.entity.Position;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDTO {
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "position")
    private Position position;
    @XmlElement(name = "town")
    private TownNameDTO townName;
    @XmlElement(name = "team")
    private TeamNameDTO teamNameDTO;
    @XmlElement(name = "stat")
    private StatIdDTO statIdDTO;

    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownNameDTO getTownName() {
        return townName;
    }

    public void setTownName(TownNameDTO townName) {
        this.townName = townName;
    }

    public TeamNameDTO getTeamNameDTO() {
        return teamNameDTO;
    }

    public void setTeamNameDTO(TeamNameDTO teamNameDTO) {
        this.teamNameDTO = teamNameDTO;
    }

    public StatIdDTO getStatIdDTO() {
        return statIdDTO;
    }

    public void setStatIdDTO(StatIdDTO statIdDTO) {
        this.statIdDTO = statIdDTO;
    }
}
