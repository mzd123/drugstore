package com.mzd.drugstore.bean.generator;

import java.util.ArrayList;
import java.util.List;

public class StoremessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoremessageExample() {
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

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreLocationIsNull() {
            addCriterion("store_location is null");
            return (Criteria) this;
        }

        public Criteria andStoreLocationIsNotNull() {
            addCriterion("store_location is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLocationEqualTo(String value) {
            addCriterion("store_location =", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotEqualTo(String value) {
            addCriterion("store_location <>", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationGreaterThan(String value) {
            addCriterion("store_location >", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationGreaterThanOrEqualTo(String value) {
            addCriterion("store_location >=", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationLessThan(String value) {
            addCriterion("store_location <", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationLessThanOrEqualTo(String value) {
            addCriterion("store_location <=", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationLike(String value) {
            addCriterion("store_location like", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotLike(String value) {
            addCriterion("store_location not like", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationIn(List<String> values) {
            addCriterion("store_location in", values, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotIn(List<String> values) {
            addCriterion("store_location not in", values, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationBetween(String value1, String value2) {
            addCriterion("store_location between", value1, value2, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotBetween(String value1, String value2) {
            addCriterion("store_location not between", value1, value2, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreImgIsNull() {
            addCriterion("store_img is null");
            return (Criteria) this;
        }

        public Criteria andStoreImgIsNotNull() {
            addCriterion("store_img is not null");
            return (Criteria) this;
        }

        public Criteria andStoreImgEqualTo(String value) {
            addCriterion("store_img =", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgNotEqualTo(String value) {
            addCriterion("store_img <>", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgGreaterThan(String value) {
            addCriterion("store_img >", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgGreaterThanOrEqualTo(String value) {
            addCriterion("store_img >=", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgLessThan(String value) {
            addCriterion("store_img <", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgLessThanOrEqualTo(String value) {
            addCriterion("store_img <=", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgLike(String value) {
            addCriterion("store_img like", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgNotLike(String value) {
            addCriterion("store_img not like", value, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgIn(List<String> values) {
            addCriterion("store_img in", values, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgNotIn(List<String> values) {
            addCriterion("store_img not in", values, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgBetween(String value1, String value2) {
            addCriterion("store_img between", value1, value2, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreImgNotBetween(String value1, String value2) {
            addCriterion("store_img not between", value1, value2, "storeImg");
            return (Criteria) this;
        }

        public Criteria andStoreTelIsNull() {
            addCriterion("store_tel is null");
            return (Criteria) this;
        }

        public Criteria andStoreTelIsNotNull() {
            addCriterion("store_tel is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTelEqualTo(String value) {
            addCriterion("store_tel =", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotEqualTo(String value) {
            addCriterion("store_tel <>", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelGreaterThan(String value) {
            addCriterion("store_tel >", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelGreaterThanOrEqualTo(String value) {
            addCriterion("store_tel >=", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLessThan(String value) {
            addCriterion("store_tel <", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLessThanOrEqualTo(String value) {
            addCriterion("store_tel <=", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLike(String value) {
            addCriterion("store_tel like", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotLike(String value) {
            addCriterion("store_tel not like", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelIn(List<String> values) {
            addCriterion("store_tel in", values, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotIn(List<String> values) {
            addCriterion("store_tel not in", values, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelBetween(String value1, String value2) {
            addCriterion("store_tel between", value1, value2, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotBetween(String value1, String value2) {
            addCriterion("store_tel not between", value1, value2, "storeTel");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNull() {
            addCriterion("boss_name is null");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNotNull() {
            addCriterion("boss_name is not null");
            return (Criteria) this;
        }

        public Criteria andBossNameEqualTo(String value) {
            addCriterion("boss_name =", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotEqualTo(String value) {
            addCriterion("boss_name <>", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThan(String value) {
            addCriterion("boss_name >", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThanOrEqualTo(String value) {
            addCriterion("boss_name >=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThan(String value) {
            addCriterion("boss_name <", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThanOrEqualTo(String value) {
            addCriterion("boss_name <=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLike(String value) {
            addCriterion("boss_name like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotLike(String value) {
            addCriterion("boss_name not like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameIn(List<String> values) {
            addCriterion("boss_name in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotIn(List<String> values) {
            addCriterion("boss_name not in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameBetween(String value1, String value2) {
            addCriterion("boss_name between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotBetween(String value1, String value2) {
            addCriterion("boss_name not between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossTelIsNull() {
            addCriterion("boss_tel is null");
            return (Criteria) this;
        }

        public Criteria andBossTelIsNotNull() {
            addCriterion("boss_tel is not null");
            return (Criteria) this;
        }

        public Criteria andBossTelEqualTo(String value) {
            addCriterion("boss_tel =", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelNotEqualTo(String value) {
            addCriterion("boss_tel <>", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelGreaterThan(String value) {
            addCriterion("boss_tel >", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelGreaterThanOrEqualTo(String value) {
            addCriterion("boss_tel >=", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelLessThan(String value) {
            addCriterion("boss_tel <", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelLessThanOrEqualTo(String value) {
            addCriterion("boss_tel <=", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelLike(String value) {
            addCriterion("boss_tel like", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelNotLike(String value) {
            addCriterion("boss_tel not like", value, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelIn(List<String> values) {
            addCriterion("boss_tel in", values, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelNotIn(List<String> values) {
            addCriterion("boss_tel not in", values, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelBetween(String value1, String value2) {
            addCriterion("boss_tel between", value1, value2, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossTelNotBetween(String value1, String value2) {
            addCriterion("boss_tel not between", value1, value2, "bossTel");
            return (Criteria) this;
        }

        public Criteria andBossIdcardIsNull() {
            addCriterion("boss_idcard is null");
            return (Criteria) this;
        }

        public Criteria andBossIdcardIsNotNull() {
            addCriterion("boss_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andBossIdcardEqualTo(String value) {
            addCriterion("boss_idcard =", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardNotEqualTo(String value) {
            addCriterion("boss_idcard <>", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardGreaterThan(String value) {
            addCriterion("boss_idcard >", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("boss_idcard >=", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardLessThan(String value) {
            addCriterion("boss_idcard <", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardLessThanOrEqualTo(String value) {
            addCriterion("boss_idcard <=", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardLike(String value) {
            addCriterion("boss_idcard like", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardNotLike(String value) {
            addCriterion("boss_idcard not like", value, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardIn(List<String> values) {
            addCriterion("boss_idcard in", values, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardNotIn(List<String> values) {
            addCriterion("boss_idcard not in", values, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardBetween(String value1, String value2) {
            addCriterion("boss_idcard between", value1, value2, "bossIdcard");
            return (Criteria) this;
        }

        public Criteria andBossIdcardNotBetween(String value1, String value2) {
            addCriterion("boss_idcard not between", value1, value2, "bossIdcard");
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