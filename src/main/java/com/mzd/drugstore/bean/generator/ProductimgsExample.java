package com.mzd.drugstore.bean.generator;

import java.util.ArrayList;
import java.util.List;

public class ProductimgsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductimgsExample() {
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

        public Criteria andImgidIsNull() {
            addCriterion("imgid is null");
            return (Criteria) this;
        }

        public Criteria andImgidIsNotNull() {
            addCriterion("imgid is not null");
            return (Criteria) this;
        }

        public Criteria andImgidEqualTo(String value) {
            addCriterion("imgid =", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotEqualTo(String value) {
            addCriterion("imgid <>", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidGreaterThan(String value) {
            addCriterion("imgid >", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidGreaterThanOrEqualTo(String value) {
            addCriterion("imgid >=", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLessThan(String value) {
            addCriterion("imgid <", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLessThanOrEqualTo(String value) {
            addCriterion("imgid <=", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidLike(String value) {
            addCriterion("imgid like", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotLike(String value) {
            addCriterion("imgid not like", value, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidIn(List<String> values) {
            addCriterion("imgid in", values, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotIn(List<String> values) {
            addCriterion("imgid not in", values, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidBetween(String value1, String value2) {
            addCriterion("imgid between", value1, value2, "imgid");
            return (Criteria) this;
        }

        public Criteria andImgidNotBetween(String value1, String value2) {
            addCriterion("imgid not between", value1, value2, "imgid");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productid is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productid is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(String value) {
            addCriterion("productid =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(String value) {
            addCriterion("productid <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(String value) {
            addCriterion("productid >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(String value) {
            addCriterion("productid >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(String value) {
            addCriterion("productid <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(String value) {
            addCriterion("productid <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLike(String value) {
            addCriterion("productid like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotLike(String value) {
            addCriterion("productid not like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<String> values) {
            addCriterion("productid in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<String> values) {
            addCriterion("productid not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(String value1, String value2) {
            addCriterion("productid between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(String value1, String value2) {
            addCriterion("productid not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgStatusIsNull() {
            addCriterion("img_status is null");
            return (Criteria) this;
        }

        public Criteria andImgStatusIsNotNull() {
            addCriterion("img_status is not null");
            return (Criteria) this;
        }

        public Criteria andImgStatusEqualTo(String value) {
            addCriterion("img_status =", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusNotEqualTo(String value) {
            addCriterion("img_status <>", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusGreaterThan(String value) {
            addCriterion("img_status >", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("img_status >=", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusLessThan(String value) {
            addCriterion("img_status <", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusLessThanOrEqualTo(String value) {
            addCriterion("img_status <=", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusLike(String value) {
            addCriterion("img_status like", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusNotLike(String value) {
            addCriterion("img_status not like", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusIn(List<String> values) {
            addCriterion("img_status in", values, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusNotIn(List<String> values) {
            addCriterion("img_status not in", values, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusBetween(String value1, String value2) {
            addCriterion("img_status between", value1, value2, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusNotBetween(String value1, String value2) {
            addCriterion("img_status not between", value1, value2, "imgStatus");
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