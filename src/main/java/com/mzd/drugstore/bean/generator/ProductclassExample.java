package com.mzd.drugstore.bean.generator;

import java.util.ArrayList;
import java.util.List;

public class ProductclassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductclassExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProductclassIdIsNull() {
            addCriterion("productclass_id is null");
            return (Criteria) this;
        }

        public Criteria andProductclassIdIsNotNull() {
            addCriterion("productclass_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductclassIdEqualTo(String value) {
            addCriterion("productclass_id =", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdNotEqualTo(String value) {
            addCriterion("productclass_id <>", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdGreaterThan(String value) {
            addCriterion("productclass_id >", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdGreaterThanOrEqualTo(String value) {
            addCriterion("productclass_id >=", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdLessThan(String value) {
            addCriterion("productclass_id <", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdLessThanOrEqualTo(String value) {
            addCriterion("productclass_id <=", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdLike(String value) {
            addCriterion("productclass_id like", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdNotLike(String value) {
            addCriterion("productclass_id not like", value, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdIn(List<String> values) {
            addCriterion("productclass_id in", values, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdNotIn(List<String> values) {
            addCriterion("productclass_id not in", values, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdBetween(String value1, String value2) {
            addCriterion("productclass_id between", value1, value2, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassIdNotBetween(String value1, String value2) {
            addCriterion("productclass_id not between", value1, value2, "productclassId");
            return (Criteria) this;
        }

        public Criteria andProductclassNameIsNull() {
            addCriterion("productclass_name is null");
            return (Criteria) this;
        }

        public Criteria andProductclassNameIsNotNull() {
            addCriterion("productclass_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductclassNameEqualTo(String value) {
            addCriterion("productclass_name =", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameNotEqualTo(String value) {
            addCriterion("productclass_name <>", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameGreaterThan(String value) {
            addCriterion("productclass_name >", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameGreaterThanOrEqualTo(String value) {
            addCriterion("productclass_name >=", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameLessThan(String value) {
            addCriterion("productclass_name <", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameLessThanOrEqualTo(String value) {
            addCriterion("productclass_name <=", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameLike(String value) {
            addCriterion("productclass_name like", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameNotLike(String value) {
            addCriterion("productclass_name not like", value, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameIn(List<String> values) {
            addCriterion("productclass_name in", values, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameNotIn(List<String> values) {
            addCriterion("productclass_name not in", values, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameBetween(String value1, String value2) {
            addCriterion("productclass_name between", value1, value2, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassNameNotBetween(String value1, String value2) {
            addCriterion("productclass_name not between", value1, value2, "productclassName");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusIsNull() {
            addCriterion("productclass_status is null");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusIsNotNull() {
            addCriterion("productclass_status is not null");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusEqualTo(String value) {
            addCriterion("productclass_status =", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusNotEqualTo(String value) {
            addCriterion("productclass_status <>", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusGreaterThan(String value) {
            addCriterion("productclass_status >", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusGreaterThanOrEqualTo(String value) {
            addCriterion("productclass_status >=", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusLessThan(String value) {
            addCriterion("productclass_status <", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusLessThanOrEqualTo(String value) {
            addCriterion("productclass_status <=", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusLike(String value) {
            addCriterion("productclass_status like", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusNotLike(String value) {
            addCriterion("productclass_status not like", value, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusIn(List<String> values) {
            addCriterion("productclass_status in", values, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusNotIn(List<String> values) {
            addCriterion("productclass_status not in", values, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusBetween(String value1, String value2) {
            addCriterion("productclass_status between", value1, value2, "productclassStatus");
            return (Criteria) this;
        }

        public Criteria andProductclassStatusNotBetween(String value1, String value2) {
            addCriterion("productclass_status not between", value1, value2, "productclassStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}