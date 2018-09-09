package com.opekun.linkshortener.web.controllers;

import com.opekun.linkshortener.api.service.ITagService;
import com.opekun.linkshortener.api.utils.IResponseBuilder;
import com.opekun.linkshortener.model.Tag;
import com.opekun.linkshortener.web.dto.LinkDto;
import com.opekun.linkshortener.web.dto.TagDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private ITagService tagService;
    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private DozerBeanMapper mapper;

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    Map<String, Object> createTag(@RequestBody Tag tag) {
        Tag createTag = tagService.getTagByTitle(tag);
        TagDto responserTag = mapper.map(createTag, TagDto.class);
        return responseBuilder.createResponse(Boolean.TRUE, null, responserTag);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Map<String, Object> deleteTag(@PathVariable(value = "id") Long tagId) {
        this.tagService.deleteTag(tagId);
        return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "links/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getLinksByTag(@PathVariable(value = "id") Long tagId) {
        List<LinkDto> links = new ArrayList<>();
        this.tagService.getLinksByTag(tagId).
                forEach((link) -> {
                    links.add(mapper.map(link, LinkDto.class));
                });
        return responseBuilder.createResponse(Boolean.TRUE, null, links);
    }
}
