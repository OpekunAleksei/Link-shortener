package com.opekun.linkshortener.service;

import com.opekun.linkshortener.api.dao.ILinkDao;
import com.opekun.linkshortener.api.service.ILinkService;
import com.opekun.linkshortener.model.Link;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class LinkServiceImpl implements ILinkService {

    public final static String URL = "http://localhost:8080/";
    @Autowired
    private ILinkDao linkDao;

    @Override
    public Link createShortLink(Link link) {
        link.setCutUrl(this.createCutUrl());
        return this.linkDao.save(link);
    }

    @Override
    public Link getFullUrlByCutLink(String cutLink) {
        Link link = this.linkDao.getLinkByCutUrl(cutLink);
        link.increaseViews();
        return this.linkDao.update(link);
    }

    private String createCutUrl() {
        String cutUrl;
        do {
            cutUrl = RandomStringUtils.randomAlphanumeric(10);
        } while (this.linkDao.getLinkByCutUrl(cutUrl) != null);

        return URL + cutUrl;
    }
}
