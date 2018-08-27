package com.opekun.linkshortener.api.dao;

import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import java.util.List;

public interface ITagDao extends IGenericDao<Tag> {

    public List<Link> getLinksByTag(Tag tag);
}
