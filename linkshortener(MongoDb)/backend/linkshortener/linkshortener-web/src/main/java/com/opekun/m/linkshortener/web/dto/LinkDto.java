package com.opekun.m.linkshortener.web.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class LinkDto {

    @Getter
    @Setter
    String userId;
    @Getter
    @Setter
    private List<String> tags;
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
    @Getter
    @Setter
    private String id;

}
