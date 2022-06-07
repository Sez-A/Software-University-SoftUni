package problem4;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Visitation extends BaseEntity {
    private LocalDate date;
    private String comments;

    @Column
    public LocalDate getDate() {
        return date;
    }

    public Visitation setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public Visitation setComments(String comments) {
        this.comments = comments;
        return this;
    }
}
