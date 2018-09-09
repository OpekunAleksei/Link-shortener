package com.opekun.m.linkshortener.dao;

import com.opekun.m.linkshortener.api.dao.ILinkDao;
import com.opekun.m.linkshortener.model.Link;
import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class LinkDaoImpl extends AbstractDao<Link> implements ILinkDao {

    private static final String SHORT_LINK = "shortLink";
    private static final String URL = "url";
    private static final String USER_ID = "userId";
    private static final String TAGS = "tags";
    private static final String LINKS = "links";

    public LinkDaoImpl() {
        super(Link.class);
    }

    @Override
    public Link getLinkByShortLink(String shortLink) {
        MongoOperations mongoOperations = super.getMongoOperations();
        Link link = mongoOperations.findOne(Query.query(Criteria.where(SHORT_LINK).is(shortLink)), Link.class);
        return link;
    }

    @Override
    public Link getLinkByUrl(String url) {
        MongoOperations mongoOperations = super.getMongoOperations();
        return mongoOperations.findOne(Query.query(Criteria.where(URL).is(url)), Link.class);
    }

    @Override
    public List<Link> getUserLinks(String userId) {
        MongoOperations mongoOperations = super.getMongoOperations();
        return mongoOperations.find(Query.query(Criteria.where(USER_ID).is(userId)), Link.class, LINKS);
    }

    @Override
    public List<Link> getLinksByTag(String tag) {
        MongoOperations mongoOperations = super.getMongoOperations();
        return mongoOperations.find(Query.query(Criteria.where(TAGS).is(tag)), Link.class, LINKS);
    }

}
