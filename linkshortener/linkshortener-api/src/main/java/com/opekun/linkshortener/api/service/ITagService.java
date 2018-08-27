package com.opekun.linkshortener.api.service;

import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import java.util.List;

public interface ITagService {

    public List<Link> getLinksByTag(Tag tag);
}
