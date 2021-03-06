package com.mzd.drugstore.bean.generator;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(String value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(String value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(String value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(String value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(String value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(String value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLike(String value) {
            addCriterion("address_id like", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotLike(String value) {
            addCriterion("address_id not like", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<String> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<String> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(String value1, String value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(String value1, String value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressLocationIsNull() {
            addCriterion("address_location is null");
            return (Criteria) this;
        }

        public Criteria andAddressLocationIsNotNull() {
            addCriterion("address_location is not null");
            return (Criteria) this;
        }

        public Criteria andAddressLocationEqualTo(String value) {
            addCriterion("address_location =", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotEqualTo(String value) {
            addCriterion("address_location <>", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationGreaterThan(String value) {
            addCriterion("address_location >", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationGreaterThanOrEqualTo(String value) {
            addCriterion("address_location >=", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationLessThan(String value) {
            addCriterion("address_location <", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationLessThanOrEqualTo(String value) {
            addCriterion("address_location <=", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationLike(String value) {
            addCriterion("address_location like", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotLike(String value) {
            addCriterion("address_location not like", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationIn(List<String> values) {
            addCriterion("address_location in", values, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotIn(List<String> values) {
            addCriterion("address_location not in", values, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationBetween(String value1, String value2) {
            addCriterion("address_location between", value1, value2, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotBetween(String value1, String value2) {
            addCriterion("address_location not between", value1, value2, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeIsNull() {
            addCriterion("address_createtime is null");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeIsNotNull() {
            addCriterion("address_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeEqualTo(String value) {
            addCriterion("address_createtime =", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeNotEqualTo(String value) {
            addCriterion("address_createtime <>", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeGreaterThan(String value) {
            addCriterion("address_createtime >", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("address_createtime >=", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeLessThan(String value) {
            addCriterion("address_createtime <", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("address_createtime <=", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeLike(String value) {
            addCriterion("address_createtime like", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeNotLike(String value) {
            addCriterion("address_createtime not like", value, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeIn(List<String> values) {
            addCriterion("address_createtime in", values, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeNotIn(List<String> values) {
            addCriterion("address_createtime not in", values, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeBetween(String value1, String value2) {
            addCriterion("address_createtime between", value1, value2, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressCreatetimeNotBetween(String value1, String value2) {
            addCriterion("address_createtime not between", value1, value2, "addressCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddressStatusIsNull() {
            addCriterion("address_status is null");
            return (Criteria) this;
        }

        public Criteria andAddressStatusIsNotNull() {
            addCriterion("address_status is not null");
            return (Criteria) this;
        }

        public Criteria andAddressStatusEqualTo(String value) {
            addCriterion("address_status =", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotEqualTo(String value) {
            addCriterion("address_status <>", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusGreaterThan(String value) {
            addCriterion("address_status >", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusGreaterThanOrEqualTo(String value) {
            addCriterion("address_status >=", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusLessThan(String value) {
            addCriterion("address_status <", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusLessThanOrEqualTo(String value) {
            addCriterion("address_status <=", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusLike(String value) {
            addCriterion("address_status like", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotLike(String value) {
            addCriterion("address_status not like", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusIn(List<String> values) {
            addCriterion("address_status in", values, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotIn(List<String> values) {
            addCriterion("address_status not in", values, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusBetween(String value1, String value2) {
            addCriterion("address_status between", value1, value2, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotBetween(String value1, String value2) {
            addCriterion("address_status not between", value1, value2, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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