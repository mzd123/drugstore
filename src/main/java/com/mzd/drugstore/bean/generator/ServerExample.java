package com.mzd.drugstore.bean.generator;

import java.util.ArrayList;
import java.util.List;

public class ServerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServerExample() {
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

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(String value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(String value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(String value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(String value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(String value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLike(String value) {
            addCriterion("server_id like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotLike(String value) {
            addCriterion("server_id not like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<String> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<String> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(String value1, String value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(String value1, String value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerContentIsNull() {
            addCriterion("server_content is null");
            return (Criteria) this;
        }

        public Criteria andServerContentIsNotNull() {
            addCriterion("server_content is not null");
            return (Criteria) this;
        }

        public Criteria andServerContentEqualTo(String value) {
            addCriterion("server_content =", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentNotEqualTo(String value) {
            addCriterion("server_content <>", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentGreaterThan(String value) {
            addCriterion("server_content >", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentGreaterThanOrEqualTo(String value) {
            addCriterion("server_content >=", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentLessThan(String value) {
            addCriterion("server_content <", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentLessThanOrEqualTo(String value) {
            addCriterion("server_content <=", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentLike(String value) {
            addCriterion("server_content like", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentNotLike(String value) {
            addCriterion("server_content not like", value, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentIn(List<String> values) {
            addCriterion("server_content in", values, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentNotIn(List<String> values) {
            addCriterion("server_content not in", values, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentBetween(String value1, String value2) {
            addCriterion("server_content between", value1, value2, "serverContent");
            return (Criteria) this;
        }

        public Criteria andServerContentNotBetween(String value1, String value2) {
            addCriterion("server_content not between", value1, value2, "serverContent");
            return (Criteria) this;
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

        public Criteria andAfterserverIdIsNull() {
            addCriterion("afterserver_id is null");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdIsNotNull() {
            addCriterion("afterserver_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdEqualTo(String value) {
            addCriterion("afterserver_id =", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdNotEqualTo(String value) {
            addCriterion("afterserver_id <>", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdGreaterThan(String value) {
            addCriterion("afterserver_id >", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdGreaterThanOrEqualTo(String value) {
            addCriterion("afterserver_id >=", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdLessThan(String value) {
            addCriterion("afterserver_id <", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdLessThanOrEqualTo(String value) {
            addCriterion("afterserver_id <=", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdLike(String value) {
            addCriterion("afterserver_id like", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdNotLike(String value) {
            addCriterion("afterserver_id not like", value, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdIn(List<String> values) {
            addCriterion("afterserver_id in", values, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdNotIn(List<String> values) {
            addCriterion("afterserver_id not in", values, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdBetween(String value1, String value2) {
            addCriterion("afterserver_id between", value1, value2, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andAfterserverIdNotBetween(String value1, String value2) {
            addCriterion("afterserver_id not between", value1, value2, "afterserverId");
            return (Criteria) this;
        }

        public Criteria andServerUseridIsNull() {
            addCriterion("server_userid is null");
            return (Criteria) this;
        }

        public Criteria andServerUseridIsNotNull() {
            addCriterion("server_userid is not null");
            return (Criteria) this;
        }

        public Criteria andServerUseridEqualTo(String value) {
            addCriterion("server_userid =", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridNotEqualTo(String value) {
            addCriterion("server_userid <>", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridGreaterThan(String value) {
            addCriterion("server_userid >", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridGreaterThanOrEqualTo(String value) {
            addCriterion("server_userid >=", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridLessThan(String value) {
            addCriterion("server_userid <", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridLessThanOrEqualTo(String value) {
            addCriterion("server_userid <=", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridLike(String value) {
            addCriterion("server_userid like", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridNotLike(String value) {
            addCriterion("server_userid not like", value, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridIn(List<String> values) {
            addCriterion("server_userid in", values, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridNotIn(List<String> values) {
            addCriterion("server_userid not in", values, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridBetween(String value1, String value2) {
            addCriterion("server_userid between", value1, value2, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerUseridNotBetween(String value1, String value2) {
            addCriterion("server_userid not between", value1, value2, "serverUserid");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeIsNull() {
            addCriterion("server_starttime is null");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeIsNotNull() {
            addCriterion("server_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeEqualTo(String value) {
            addCriterion("server_starttime =", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeNotEqualTo(String value) {
            addCriterion("server_starttime <>", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeGreaterThan(String value) {
            addCriterion("server_starttime >", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("server_starttime >=", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeLessThan(String value) {
            addCriterion("server_starttime <", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeLessThanOrEqualTo(String value) {
            addCriterion("server_starttime <=", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeLike(String value) {
            addCriterion("server_starttime like", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeNotLike(String value) {
            addCriterion("server_starttime not like", value, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeIn(List<String> values) {
            addCriterion("server_starttime in", values, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeNotIn(List<String> values) {
            addCriterion("server_starttime not in", values, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeBetween(String value1, String value2) {
            addCriterion("server_starttime between", value1, value2, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerStarttimeNotBetween(String value1, String value2) {
            addCriterion("server_starttime not between", value1, value2, "serverStarttime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeIsNull() {
            addCriterion("server_endtime is null");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeIsNotNull() {
            addCriterion("server_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeEqualTo(String value) {
            addCriterion("server_endtime =", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeNotEqualTo(String value) {
            addCriterion("server_endtime <>", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeGreaterThan(String value) {
            addCriterion("server_endtime >", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("server_endtime >=", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeLessThan(String value) {
            addCriterion("server_endtime <", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeLessThanOrEqualTo(String value) {
            addCriterion("server_endtime <=", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeLike(String value) {
            addCriterion("server_endtime like", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeNotLike(String value) {
            addCriterion("server_endtime not like", value, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeIn(List<String> values) {
            addCriterion("server_endtime in", values, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeNotIn(List<String> values) {
            addCriterion("server_endtime not in", values, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeBetween(String value1, String value2) {
            addCriterion("server_endtime between", value1, value2, "serverEndtime");
            return (Criteria) this;
        }

        public Criteria andServerEndtimeNotBetween(String value1, String value2) {
            addCriterion("server_endtime not between", value1, value2, "serverEndtime");
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