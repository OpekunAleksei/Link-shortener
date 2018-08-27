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

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class TagServiceImpl implements ITagService {

    @Autowired
    private ITagDao tagDao;

    @Override
    public List<Link> getLinksByTag(Tag tag) {
        return this.tagDao.getLinksByTag(tag);
    }

}
