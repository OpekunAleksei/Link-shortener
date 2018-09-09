package com.opekun.m.linkshortener.api.dao;

import com.opekun.m.linkshortener.model.Link;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ILinkDao extends IGenericDao<Link> {

    public Link getLinkByShortLink(String shortLink);

    public Link getLinkByUrl(String url);

    public List<Link> getUserLinks(String userId);

    public List<Link> getLinksByTag(String tag);
}
