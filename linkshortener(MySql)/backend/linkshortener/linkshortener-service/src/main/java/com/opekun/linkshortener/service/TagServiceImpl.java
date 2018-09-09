package com.opekun.linkshortener.service;

import com.opekun.linkshortener.api.dao.ITagDao;
import com.opekun.linkshortener.api.service.ITagService;
import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import java.util.List;
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
public class TagServiceImpl implements ITagService {

    @Autowired
    private ITagDao tagDao;

    @Override
    public List<Link> getLinksByTag(Long id) {
        return this.tagDao.getLinksByTag(id);
    }

    @Override
    public Tag getTagByTitle(Tag tag) {
        Tag persistentTag = this.tagDao.getTagByTitle(tag.getTitle());
        if (persistentTag == null) {
            persistentTag = this.tagDao.save(tag);
        }
        return persistentTag;
    }

    @Override
    public void deleteTag(Long id) {
        this.tagDao.delete(id);
    }
}
