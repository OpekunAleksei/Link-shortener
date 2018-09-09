package com.opekun.m.linkshortener.model;

import com.opekun.m.linkshortener.model.generic.Model;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Document(collection = "users")
public class User extends Model {

    private static final long serialVersionUID = 5854422556239724109L;

    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;
    @Id
    private String id;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

}
