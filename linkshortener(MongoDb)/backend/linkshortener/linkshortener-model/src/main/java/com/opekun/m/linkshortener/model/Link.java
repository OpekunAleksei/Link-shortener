package com.opekun.m.linkshortener.model;

import com.opekun.m.linkshortener.model.generic.Model;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Document(collection = "links")
public class Link extends Model {

    private static final long serialVersionUID = 5854482556239724109L;
    @Getter
    @Setter
    private List<String> tags;
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private String shortLink;
    @Getter
    @Setter
    private Integer views;
    @Id
    private String id;

    public Link() {
    }

    public Link(String userId, String url, String shortLink, Integer views) {
        this.userId = userId;
        this.url = url;
        this.shortLink = shortLink;
        this.views = views;
    }

    public void increaseViews() {
        this.views++;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Link other = (Link) obj;
        return Objects.equals(this.id, other.id);
    }

}
