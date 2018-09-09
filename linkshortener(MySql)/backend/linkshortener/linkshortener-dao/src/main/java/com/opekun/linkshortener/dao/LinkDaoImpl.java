package com.opekun.linkshortener.dao;

import com.opekun.linkshortener.api.dao.ILinkDao;
import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Link_;
import com.opekun.linkshortener.model.User;
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
public class LinkDaoImpl extends AbstractDao<Link> implements ILinkDao {

    public LinkDaoImpl() {
        super(Link.class);
    }

    @Override
    public Link getLinkByUrl(String url) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Link> criteriaQuery = builder.createQuery(Link.class);
        Root<Link> root = criteriaQuery.from(Link.class);
        criteriaQuery.where(builder.equal(root.get(Link_.url), url));
        TypedQuery<Link> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public Link getLinkByShortLink(String shortLink) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Link> criteriaQuery = builder.createQuery(Link.class);
        Root<Link> root = criteriaQuery.from(Link.class);
        criteriaQuery.where(builder.equal(root.get(Link_.shortLink), shortLink));
        TypedQuery<Link> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Link> getUserLinks(User user) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Link> criteriaQuery = builder.createQuery(Link.class);
        Root<Link> root = criteriaQuery.from(Link.class);
        root.fetch(Link_.user, JoinType.INNER);
        criteriaQuery.where(builder.equal(root.get(Link_.user), user));
        TypedQuery<Link> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

}
