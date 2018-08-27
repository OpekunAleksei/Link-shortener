package com.opekun.linkshortener.model;

import com.opekun.linkshortener.model.generic.Model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User extends Model {

    private static final long serialVersionUID = 5854422586239724109L;
    @Getter
    @Setter
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    private List<Link> links;
    @Getter
    @Setter
    @Column(name = "login", unique = true, nullable = false, updatable = false)
    private String login;
    @Getter
    @Setter
    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;
    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public User() {
    }

    public User(List<Link> links, String login, String nickname, String password) {
        this.links = links;
        this.login = login;
        this.nickname = nickname;
        this.password = password;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
