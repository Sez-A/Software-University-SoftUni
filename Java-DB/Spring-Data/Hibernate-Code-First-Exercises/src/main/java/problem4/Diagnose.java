package problem4;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Diagnose extends BaseEntity {
    private String name;
    private String comments;

    @Column
    public String getName() {
        return name;
    }

    public Diagnose setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public Diagnose setComments(String comments) {
        this.comments = comments;
        return this;
    }
}
