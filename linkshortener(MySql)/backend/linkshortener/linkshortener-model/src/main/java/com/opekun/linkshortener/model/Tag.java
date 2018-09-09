package com.opekun.linkshortener.model;

import com.opekun.linkshortener.model.generic.Model;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Entity
@Table(name = "tags")
public class Tag extends Model {

    @Getter
    @Setter
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private List<Link> links;
    @Getter
    @Setter
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Tag() {
    }

    public Tag(String title) {
        this.title = title;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tag other = (Tag) obj;
        return Objects.equals(this.id, other.id);
    }

}
