package com.mzd.drugstore.bean.generator;

import java.util.ArrayList;
import java.util.List;

public class AfterserverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AfterserverExample() {
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

        public Criteria andAfterserverClassIsNull() {
            addCriterion("afterserver_class is null");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassIsNotNull() {
            addCriterion("afterserver_class is not null");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassEqualTo(String value) {
            addCriterion("afterserver_class =", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassNotEqualTo(String value) {
            addCriterion("afterserver_class <>", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassGreaterThan(String value) {
            addCriterion("afterserver_class >", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassGreaterThanOrEqualTo(String value) {
            addCriterion("afterserver_class >=", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassLessThan(String value) {
            addCriterion("afterserver_class <", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassLessThanOrEqualTo(String value) {
            addCriterion("afterserver_class <=", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassLike(String value) {
            addCriterion("afterserver_class like", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassNotLike(String value) {
            addCriterion("afterserver_class not like", value, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassIn(List<String> values) {
            addCriterion("afterserver_class in", values, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassNotIn(List<String> values) {
            addCriterion("afterserver_class not in", values, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassBetween(String value1, String value2) {
            addCriterion("afterserver_class between", value1, value2, "afterserverClass");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassNotBetween(String value1, String value2) {
            addCriterion("afterserver_class not between", value1, value2, "afterserverClass");
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

        public Criteria andAfterserverCreatetimeIsNull() {
            addCriterion("afterserver_createtime is null");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeIsNotNull() {
            addCriterion("afterserver_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeEqualTo(String value) {
            addCriterion("afterserver_createtime =", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeNotEqualTo(String value) {
            addCriterion("afterserver_createtime <>", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeGreaterThan(String value) {
            addCriterion("afterserver_createtime >", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("afterserver_createtime >=", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeLessThan(String value) {
            addCriterion("afterserver_createtime <", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("afterserver_createtime <=", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeLike(String value) {
            addCriterion("afterserver_createtime like", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeNotLike(String value) {
            addCriterion("afterserver_createtime not like", value, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeIn(List<String> values) {
            addCriterion("afterserver_createtime in", values, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeNotIn(List<String> values) {
            addCriterion("afterserver_createtime not in", values, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeBetween(String value1, String value2) {
            addCriterion("afterserver_createtime between", value1, value2, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverCreatetimeNotBetween(String value1, String value2) {
            addCriterion("afterserver_createtime not between", value1, value2, "afterserverCreatetime");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageIsNull() {
            addCriterion("afterserver_stage is null");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageIsNotNull() {
            addCriterion("afterserver_stage is not null");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageEqualTo(String value) {
            addCriterion("afterserver_stage =", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageNotEqualTo(String value) {
            addCriterion("afterserver_stage <>", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageGreaterThan(String value) {
            addCriterion("afterserver_stage >", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageGreaterThanOrEqualTo(String value) {
            addCriterion("afterserver_stage >=", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageLessThan(String value) {
            addCriterion("afterserver_stage <", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageLessThanOrEqualTo(String value) {
            addCriterion("afterserver_stage <=", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageLike(String value) {
            addCriterion("afterserver_stage like", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageNotLike(String value) {
            addCriterion("afterserver_stage not like", value, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageIn(List<String> values) {
            addCriterion("afterserver_stage in", values, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageNotIn(List<String> values) {
            addCriterion("afterserver_stage not in", values, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageBetween(String value1, String value2) {
            addCriterion("afterserver_stage between", value1, value2, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverStageNotBetween(String value1, String value2) {
            addCriterion("afterserver_stage not between", value1, value2, "afterserverStage");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgIsNull() {
            addCriterion("afterserver_img is null");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgIsNotNull() {
            addCriterion("afterserver_img is not null");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgEqualTo(String value) {
            addCriterion("afterserver_img =", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgNotEqualTo(String value) {
            addCriterion("afterserver_img <>", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgGreaterThan(String value) {
            addCriterion("afterserver_img >", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgGreaterThanOrEqualTo(String value) {
            addCriterion("afterserver_img >=", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgLessThan(String value) {
            addCriterion("afterserver_img <", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgLessThanOrEqualTo(String value) {
            addCriterion("afterserver_img <=", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgLike(String value) {
            addCriterion("afterserver_img like", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgNotLike(String value) {
            addCriterion("afterserver_img not like", value, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgIn(List<String> values) {
            addCriterion("afterserver_img in", values, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgNotIn(List<String> values) {
            addCriterion("afterserver_img not in", values, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgBetween(String value1, String value2) {
            addCriterion("afterserver_img between", value1, value2, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverImgNotBetween(String value1, String value2) {
            addCriterion("afterserver_img not between", value1, value2, "afterserverImg");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesIsNull() {
            addCriterion("afterserver_classes is null");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesIsNotNull() {
            addCriterion("afterserver_classes is not null");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesEqualTo(String value) {
            addCriterion("afterserver_classes =", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesNotEqualTo(String value) {
            addCriterion("afterserver_classes <>", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesGreaterThan(String value) {
            addCriterion("afterserver_classes >", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesGreaterThanOrEqualTo(String value) {
            addCriterion("afterserver_classes >=", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesLessThan(String value) {
            addCriterion("afterserver_classes <", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesLessThanOrEqualTo(String value) {
            addCriterion("afterserver_classes <=", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesLike(String value) {
            addCriterion("afterserver_classes like", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesNotLike(String value) {
            addCriterion("afterserver_classes not like", value, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesIn(List<String> values) {
            addCriterion("afterserver_classes in", values, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesNotIn(List<String> values) {
            addCriterion("afterserver_classes not in", values, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesBetween(String value1, String value2) {
            addCriterion("afterserver_classes between", value1, value2, "afterserverClasses");
            return (Criteria) this;
        }

        public Criteria andAfterserverClassesNotBetween(String value1, String value2) {
            addCriterion("afterserver_classes not between", value1, value2, "afterserverClasses");
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