package com.mzd.drugstore.bean.generator;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyIsNull() {
            addCriterion("order_summoney is null");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyIsNotNull() {
            addCriterion("order_summoney is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyEqualTo(String value) {
            addCriterion("order_summoney =", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyNotEqualTo(String value) {
            addCriterion("order_summoney <>", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyGreaterThan(String value) {
            addCriterion("order_summoney >", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyGreaterThanOrEqualTo(String value) {
            addCriterion("order_summoney >=", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyLessThan(String value) {
            addCriterion("order_summoney <", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyLessThanOrEqualTo(String value) {
            addCriterion("order_summoney <=", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyLike(String value) {
            addCriterion("order_summoney like", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyNotLike(String value) {
            addCriterion("order_summoney not like", value, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyIn(List<String> values) {
            addCriterion("order_summoney in", values, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyNotIn(List<String> values) {
            addCriterion("order_summoney not in", values, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyBetween(String value1, String value2) {
            addCriterion("order_summoney between", value1, value2, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderSummoneyNotBetween(String value1, String value2) {
            addCriterion("order_summoney not between", value1, value2, "orderSummoney");
            return (Criteria) this;
        }

        public Criteria andOrderStageIsNull() {
            addCriterion("order_stage is null");
            return (Criteria) this;
        }

        public Criteria andOrderStageIsNotNull() {
            addCriterion("order_stage is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStageEqualTo(String value) {
            addCriterion("order_stage =", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageNotEqualTo(String value) {
            addCriterion("order_stage <>", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageGreaterThan(String value) {
            addCriterion("order_stage >", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageGreaterThanOrEqualTo(String value) {
            addCriterion("order_stage >=", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageLessThan(String value) {
            addCriterion("order_stage <", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageLessThanOrEqualTo(String value) {
            addCriterion("order_stage <=", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageLike(String value) {
            addCriterion("order_stage like", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageNotLike(String value) {
            addCriterion("order_stage not like", value, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageIn(List<String> values) {
            addCriterion("order_stage in", values, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageNotIn(List<String> values) {
            addCriterion("order_stage not in", values, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageBetween(String value1, String value2) {
            addCriterion("order_stage between", value1, value2, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderStageNotBetween(String value1, String value2) {
            addCriterion("order_stage not between", value1, value2, "orderStage");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeIsNull() {
            addCriterion("order_createtime is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeIsNotNull() {
            addCriterion("order_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeEqualTo(String value) {
            addCriterion("order_createtime =", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotEqualTo(String value) {
            addCriterion("order_createtime <>", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeGreaterThan(String value) {
            addCriterion("order_createtime >", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_createtime >=", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeLessThan(String value) {
            addCriterion("order_createtime <", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("order_createtime <=", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeLike(String value) {
            addCriterion("order_createtime like", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotLike(String value) {
            addCriterion("order_createtime not like", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeIn(List<String> values) {
            addCriterion("order_createtime in", values, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotIn(List<String> values) {
            addCriterion("order_createtime not in", values, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeBetween(String value1, String value2) {
            addCriterion("order_createtime between", value1, value2, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotBetween(String value1, String value2) {
            addCriterion("order_createtime not between", value1, value2, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderOriginIsNull() {
            addCriterion("order_origin is null");
            return (Criteria) this;
        }

        public Criteria andOrderOriginIsNotNull() {
            addCriterion("order_origin is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOriginEqualTo(String value) {
            addCriterion("order_origin =", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginNotEqualTo(String value) {
            addCriterion("order_origin <>", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginGreaterThan(String value) {
            addCriterion("order_origin >", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginGreaterThanOrEqualTo(String value) {
            addCriterion("order_origin >=", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginLessThan(String value) {
            addCriterion("order_origin <", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginLessThanOrEqualTo(String value) {
            addCriterion("order_origin <=", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginLike(String value) {
            addCriterion("order_origin like", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginNotLike(String value) {
            addCriterion("order_origin not like", value, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginIn(List<String> values) {
            addCriterion("order_origin in", values, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginNotIn(List<String> values) {
            addCriterion("order_origin not in", values, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginBetween(String value1, String value2) {
            addCriterion("order_origin between", value1, value2, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andOrderOriginNotBetween(String value1, String value2) {
            addCriterion("order_origin not between", value1, value2, "orderOrigin");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
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

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
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