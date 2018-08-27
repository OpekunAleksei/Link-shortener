package com.opekun.linkshortener.dao;

import com.opekun.linkshortener.api.dao.ILinkDao;
import com.opekun.linkshortener.model.Link;
import com.opekun.linkshortener.model.Link_;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class LinkDaoImpl extends AbstractDao<Link> implements ILinkDao {

    public LinkDaoImpl() {
        super(Link.class);
    }

    @Override
    public Link getLinkByFullUrl(String fullUrl) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Link> criteriaQuery = builder.createQuery(Link.class);
        Root<Link> root = criteriaQuery.from(Link.class);
        criteriaQuery.where(builder.equal(root.get(Link_.fullUrl), fullUrl));
        TypedQuery<Link> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public Link getLinkByCutUrl(String cutUrl) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Link> criteriaQuery = builder.createQuery(Link.class);
        Root<Link> root = criteriaQuery.from(Link.class);
        criteriaQuery.where(builder.equal(root.get(Link_.cutUrl), cutUrl));
        TypedQuery<Link> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }
}
