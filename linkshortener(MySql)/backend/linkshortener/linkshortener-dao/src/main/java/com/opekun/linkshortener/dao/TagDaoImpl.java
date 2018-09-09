package com.opekun.linkshortener.dao;

import com.opekun.linkshortener.api.dao.ITagDao;
import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Tag;
import com.opekun.linkshortener.model.Tag_;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class TagDaoImpl extends AbstractDao<Tag> implements ITagDao {

    public TagDaoImpl() {
        super(Tag.class);
    }

    @Override
    public List<Link> getLinksByTag(Long id) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaQuery = builder.createQuery(Tag.class);
        Root<Tag> root = criteriaQuery.from(Tag.class);
        root.fetch(Tag_.links, JoinType.INNER);
        criteriaQuery.where(builder.equal(root.get(Tag_.id), id));
        TypedQuery<Tag> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList().get(0).getLinks();
    }

    @Override
    public Tag getTagByTitle(String title) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaQuery = builder.createQuery(Tag.class);
        Root<Tag> root = criteriaQuery.from(Tag.class);
        criteriaQuery.where(builder.equal(root.get(Tag_.title), title));
        TypedQuery<Tag> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        if (getLinksByTag(id).isEmpty()) {
            super.delete(id);
        }
    }

}
