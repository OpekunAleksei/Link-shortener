package com.opekun.m.linkshortener.api.service;

import com.opekun.m.linkshortener.model.Link;
import com.opekun.m.linkshortener.model.exceptions.GetLinkException;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ILinkService {

    public Link getLinkByShortLink(String shortLink) throws GetLinkException;

    public Link getLinkByUrl(String url);

    public List<Link> getAllLinks();

    public List<Link> getLinksByTag(String tag);

    public void deleteLink(String id);

    public Link saveUpdateLink(Link link);

    public List<Link> getUserLinks(String userId);

}
