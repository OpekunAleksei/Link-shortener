package com.opekun.linkshortener.dao;

import com.opekun.linkshortener.api.dao.IUserDao;
import com.opekun.linkshortener.model.User;
import com.opekun.linkshortener.model.User_;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements IUserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserByLogin(String login) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.equal(root.get(User_.login), login));
        TypedQuery<User> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }
}
