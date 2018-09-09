package com.opekun.linkshortener.web.dto;

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
    UserDto user;
    @Getter
    @Setter
    private List<TagDto> tags;
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
    private Long id;

}
