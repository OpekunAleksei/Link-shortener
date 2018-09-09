package com.opekun.linkshortener.api.dao;

import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ITagDao extends IGenericDao<Tag> {

    public List<Link> getLinksByTag(Long id);

    public Tag getTagByTitle(String title);

}
