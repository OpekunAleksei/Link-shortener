/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "links")
public class Link extends Model {

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "link_tags", joinColumns = {
        @JoinColumn(name = "link_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tag_id")})
    private List<Tag> tags;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, nullable = false)
    private User user;
    @Getter
    @Setter
    @Column(name = "information", nullable = false)
    private String information;
    @Getter
    @Setter
    @Column(name = "fullUrl", nullable = false)
    private String fullUrl;
    @Getter
    @Setter
    @Column(name = "cutUrl", nullable = false)
    private String cutUrl;
    @Getter
    @Setter
    @Column(name = "views", nullable = false)
    private Integer views;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Link() {
    }

    public Link(User user, String information, String fullUrl, String cutUrl, Integer views, List<Tag> tags) {
        this.user = user;
        this.information = information;
        this.fullUrl = fullUrl;
        this.cutUrl = cutUrl;
        this.views = views;
        this.tags = tags;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void increaseViews() {
        this.views++;
    }
}
