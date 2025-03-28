package com.vti.TestingSystem6.specification;

import com.vti.TestingSystem6.entity.Account;
import com.vti.TestingSystem6.form.AccountFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {
    private static final String SEARCH = "SEARCH";
    public static Specification<Account> buildWhere(AccountFilterForm form){
        Specification<Account> whereUserName = new SpecificatioImpl(SEARCH, form.getSearch());
        return Specification.where(whereUserName);
    }
    private static class SpecificatioImpl implements Specification<Account>{

        private String key;
        private Object value;

        public SpecificatioImpl(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Specification<Account> and(Specification<Account> other) {
            return Specification.super.and(other);
        }

        @Override
        public Specification<Account> or(Specification<Account> other) {
            return Specification.super.or(other);
        }

        @Override
        public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if(value == null){
                return null;
            }
            switch (key){
                case SEARCH:
                    return criteriaBuilder.like(root.get("username"), "%" + value + "%");
            }
            return null;
        }
    }
}
