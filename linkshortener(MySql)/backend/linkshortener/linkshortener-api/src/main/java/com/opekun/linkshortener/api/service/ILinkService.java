package com.opekun.linkshortener.api.service;

import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.exceptions.GetLinkException;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ILinkService {

    public Link saveLink(String url, Long userId);

    public Link getLinkByShortLink(String shortLink) throws GetLinkException;

    public Link getLinkByUrl(String fullUrl);

    public List<Link> getAllLinks();

    public Link updateLink(Link link);

    public void deleteLink(Long id);

    public List<Link> getUserLinks(Long userId);

}
