package com.opekun.linkshortener.api.service;

import com.opekun.linkshortener.model.Link;

public interface ILinkService {

    public Link createShortLink(Link link);

    public Link getFullUrlByCutLink(String cutLink);
}
