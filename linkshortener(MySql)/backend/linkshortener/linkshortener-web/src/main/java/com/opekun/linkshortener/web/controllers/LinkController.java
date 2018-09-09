package com.opekun.linkshortener.web.controllers;

import com.opekun.linkshortener.api.service.ILinkService;
import com.opekun.linkshortener.api.utils.IResponseBuilder;
import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.exceptions.GetLinkException;
import com.opekun.linkshortener.web.dto.LinkDto;
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
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;
    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private DozerBeanMapper mapper;

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    Map<String, Object> createLink(@PathVariable(value = "id") Long userId, @RequestBody String url) {
        Link link = this.linkService.getLinkByUrl(url);
        if (link != null) {
            LinkDto responseLink = mapper.map(link, LinkDto.class);
            return responseBuilder.createResponse(Boolean.FALSE, null, responseLink);
        } else {
            Link createLink = linkService.saveLink(url, userId);
            LinkDto responseLink = mapper.map(createLink, LinkDto.class);
            return responseBuilder.createResponse(Boolean.TRUE, null, responseLink);
        }
    }

    @RequestMapping(path = "all", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAllLinks() {
        List<LinkDto> links = new ArrayList<>();
        this.linkService.getAllLinks().forEach((link) -> {
            links.add(mapper.map(link, LinkDto.class));
        });
        return responseBuilder.createResponse(Boolean.TRUE, null, links);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> updateLink(@RequestBody Link link) {
        Link createLink = linkService.updateLink(link);
        LinkDto responseLink = mapper.map(createLink, LinkDto.class);
        return responseBuilder.createResponse(Boolean.TRUE, null, responseLink);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Map<String, Object> deleteLink(@PathVariable(value = "id") Long linkId) {
        this.linkService.deleteLink(linkId);
        return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "userLinks", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getUserLinks(@RequestBody Long userId) {
        List<LinkDto> links = new ArrayList<>();
        this.linkService.getUserLinks(userId).
                forEach((link) -> {
                    links.add(mapper.map(link, LinkDto.class));
                });
        return responseBuilder.createResponse(Boolean.TRUE, null, links);
    }

    @RequestMapping(path = "/{shortlink}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getLinkByShotrLink(@PathVariable(value = "shortlink") String shortlink) throws GetLinkException {
        Link link = this.linkService.getLinkByShortLink(shortlink);
        LinkDto responseLink = mapper.map(link, LinkDto.class);
        return responseBuilder.createResponse(Boolean.TRUE, null, responseLink);
    }

}
