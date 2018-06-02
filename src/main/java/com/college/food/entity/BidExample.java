package com.college.food.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BidExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BidExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTendersIdIsNull() {
            addCriterion("tenders_id is null");
            return (Criteria) this;
        }

        public Criteria andTendersIdIsNotNull() {
            addCriterion("tenders_id is not null");
            return (Criteria) this;
        }

        public Criteria andTendersIdEqualTo(String value) {
            addCriterion("tenders_id =", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdNotEqualTo(String value) {
            addCriterion("tenders_id <>", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdGreaterThan(String value) {
            addCriterion("tenders_id >", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenders_id >=", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdLessThan(String value) {
            addCriterion("tenders_id <", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdLessThanOrEqualTo(String value) {
            addCriterion("tenders_id <=", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdLike(String value) {
            addCriterion("tenders_id like", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdNotLike(String value) {
            addCriterion("tenders_id not like", value, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdIn(List<String> values) {
            addCriterion("tenders_id in", values, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdNotIn(List<String> values) {
            addCriterion("tenders_id not in", values, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdBetween(String value1, String value2) {
            addCriterion("tenders_id between", value1, value2, "tendersId");
            return (Criteria) this;
        }

        public Criteria andTendersIdNotBetween(String value1, String value2) {
            addCriterion("tenders_id not between", value1, value2, "tendersId");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStr1IsNull() {
            addCriterion("str1 is null");
            return (Criteria) this;
        }

        public Criteria andStr1IsNotNull() {
            addCriterion("str1 is not null");
            return (Criteria) this;
        }

        public Criteria andStr1EqualTo(String value) {
            addCriterion("str1 =", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotEqualTo(String value) {
            addCriterion("str1 <>", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1GreaterThan(String value) {
            addCriterion("str1 >", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1GreaterThanOrEqualTo(String value) {
            addCriterion("str1 >=", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1LessThan(String value) {
            addCriterion("str1 <", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1LessThanOrEqualTo(String value) {
            addCriterion("str1 <=", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1Like(String value) {
            addCriterion("str1 like", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotLike(String value) {
            addCriterion("str1 not like", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1In(List<String> values) {
            addCriterion("str1 in", values, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotIn(List<String> values) {
            addCriterion("str1 not in", values, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1Between(String value1, String value2) {
            addCriterion("str1 between", value1, value2, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotBetween(String value1, String value2) {
            addCriterion("str1 not between", value1, value2, "str1");
            return (Criteria) this;
        }

        public Criteria andStr2IsNull() {
            addCriterion("str2 is null");
            return (Criteria) this;
        }

        public Criteria andStr2IsNotNull() {
            addCriterion("str2 is not null");
            return (Criteria) this;
        }

        public Criteria andStr2EqualTo(String value) {
            addCriterion("str2 =", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotEqualTo(String value) {
            addCriterion("str2 <>", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2GreaterThan(String value) {
            addCriterion("str2 >", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2GreaterThanOrEqualTo(String value) {
            addCriterion("str2 >=", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2LessThan(String value) {
            addCriterion("str2 <", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2LessThanOrEqualTo(String value) {
            addCriterion("str2 <=", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2Like(String value) {
            addCriterion("str2 like", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotLike(String value) {
            addCriterion("str2 not like", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2In(List<String> values) {
            addCriterion("str2 in", values, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotIn(List<String> values) {
            addCriterion("str2 not in", values, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2Between(String value1, String value2) {
            addCriterion("str2 between", value1, value2, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotBetween(String value1, String value2) {
            addCriterion("str2 not between", value1, value2, "str2");
            return (Criteria) this;
        }

        public Criteria andStr3IsNull() {
            addCriterion("str3 is null");
            return (Criteria) this;
        }

        public Criteria andStr3IsNotNull() {
            addCriterion("str3 is not null");
            return (Criteria) this;
        }

        public Criteria andStr3EqualTo(String value) {
            addCriterion("str3 =", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotEqualTo(String value) {
            addCriterion("str3 <>", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3GreaterThan(String value) {
            addCriterion("str3 >", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3GreaterThanOrEqualTo(String value) {
            addCriterion("str3 >=", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3LessThan(String value) {
            addCriterion("str3 <", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3LessThanOrEqualTo(String value) {
            addCriterion("str3 <=", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3Like(String value) {
            addCriterion("str3 like", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotLike(String value) {
            addCriterion("str3 not like", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3In(List<String> values) {
            addCriterion("str3 in", values, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotIn(List<String> values) {
            addCriterion("str3 not in", values, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3Between(String value1, String value2) {
            addCriterion("str3 between", value1, value2, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotBetween(String value1, String value2) {
            addCriterion("str3 not between", value1, value2, "str3");
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