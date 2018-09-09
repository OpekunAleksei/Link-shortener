package com.opekun.m.linkshortener.service;

import com.opekun.m.linkshortener.api.dao.ILinkDao;
import com.opekun.m.linkshortener.api.service.ILinkService;
import com.opekun.m.linkshortener.model.Link;
import com.opekun.m.linkshortener.model.exceptions.GetLinkException;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private ILinkDao linkDao;

    @Override
    public Link getLinkByShortLink(String shortLink) throws GetLinkException {
        Link link = this.linkDao.getLinkByShortLink(shortLink);
        if (link != null) {
            link.increaseViews();
            return this.linkDao.saveUpdate(link);
        } else {
            throw new GetLinkException();
        }
    }

    @Override
    public List<Link> getAllLinks() {
        return this.linkDao.getAll();
    }

    @Override
    public void deleteLink(String id) {
        this.linkDao.delete(id);
    }

    @Override
    public Link saveUpdateLink(Link link) {
        if (link.getShortLink() != null) {
            return this.linkDao.saveUpdate(link);
        } else {
            link.setShortLink(this.getShortLink());
            return this.linkDao.saveUpdate(link);
        }
    }

    @Override
    public Link getLinkByUrl(String url) {
        return this.linkDao.getLinkByUrl(url);
    }

    @Override
    public List<Link> getUserLinks(String userId) {
        return this.linkDao.getUserLinks(userId);
    }

    @Override
    public List<Link> getLinksByTag(String tag) {
        return this.linkDao.getLinksByTag(tag);
    }

    private String getShortLink() {
        String cutUrl;
        do {
            cutUrl = RandomStringUtils.randomAlphanumeric(10);
        } while (this.linkDao.getLinkByShortLink(cutUrl) != null);
        return cutUrl;
    }

}
