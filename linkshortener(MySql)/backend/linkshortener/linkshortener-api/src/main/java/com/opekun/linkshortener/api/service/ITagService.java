package com.opekun.linkshortener.api.service;

import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ITagService {

    public List<Link> getLinksByTag(Long id);

    public Tag getTagByTitle(Tag tag);

    public void deleteTag(Long id);
}
