package com.opekun.linkshortener.api.dao;

import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.User;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ILinkDao extends IGenericDao<Link> {

    public Link getLinkByShortLink(String shortLink);

    public Link getLinkByUrl(String fullUrl);

    public List<Link> getUserLinks(User user);

}
