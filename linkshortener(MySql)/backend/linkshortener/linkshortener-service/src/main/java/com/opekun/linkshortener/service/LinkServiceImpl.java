package com.opekun.linkshortener.service;

import com.opekun.linkshortener.api.dao.ILinkDao;
import com.opekun.linkshortener.api.dao.ITagDao;
import com.opekun.linkshortener.api.dao.IUserDao;
import com.opekun.linkshortener.api.service.ILinkService;
import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import com.opekun.linkshortener.model.exceptions.GetLinkException;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private ILinkDao linkDao;
    @Autowired
    private ITagDao tagDao;
    @Autowired
    private IUserDao userDao;

    @Override
    public Link saveLink(String url, Long userId) {
        Link link = new Link(this.userDao.getById(userId), url, this.getShortLink(), 0);
        return this.linkDao.save(link);
    }

    @Override
    public Link getLinkByShortLink(String shortLink) throws GetLinkException {
        Link link = this.linkDao.getLinkByShortLink(shortLink);
        if (link != null) {
            link.increaseViews();
            return this.linkDao.update(link);
        } else {
            throw new GetLinkException();
        }
    }

    @Override
    public List<Link> getAllLinks() {
        return this.linkDao.getAll();
    }

    @Override
    public Link updateLink(Link link) {
        return this.linkDao.update(link);
    }

    @Override
    public void deleteLink(Long id) {
        List<Tag> tags = this.linkDao.getById(id).getTags();
        this.linkDao.delete(id);
        tags.forEach((tag) -> {
            this.tagDao.delete(tag.getId());
        });
    }

    @Override
    public Link getLinkByUrl(String fullUrl) {
        return this.linkDao.getLinkByUrl(fullUrl);
    }

    @Override
    public List<Link> getUserLinks(Long userId) {
        return this.linkDao.getUserLinks(this.userDao.getById(userId));
    }

    private String getShortLink() {
        String cutUrl;
        do {
            cutUrl = RandomStringUtils.randomAlphanumeric(10);
        } while (this.linkDao.getLinkByShortLink(cutUrl) != null);
        return cutUrl;
    }
}
