package com.opekun.linkshortener.api.dao;

import com.opekun.linkshortener.model.Link;

public interface ILinkDao extends IGenericDao<Link> {

    public Link getLinkByCutUrl(String cutUrl);

    public Link getLinkByFullUrl(String fullUrl);
}
