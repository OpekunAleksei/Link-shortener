package com.opekun.linkshortener.dao;

import com.opekun.linkshortener.api.dao.ITagDao;
import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import com.opekun.linkshortener.model.Tag_;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TagDaoImpl extends AbstractDao<Tag> implements ITagDao {

    public TagDaoImpl() {
        super(Tag.class);
    }

    @Override
    public List<Link> getLinksByTag(Tag tag) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Link> criteriaQuery = builder.createQuery(Link.class);
        Root<Tag> root = criteriaQuery.from(Tag.class);
        criteriaQuery.where(builder.equal(root.get(Tag_.id), tag.getId()));
        TypedQuery<Link> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
