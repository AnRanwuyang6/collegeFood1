package com.college.food.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForumTopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForumTopicExample() {
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

        public Criteria andTopicNameIsNull() {
            addCriterion("topic_name is null");
            return (Criteria) this;
        }

        public Criteria andTopicNameIsNotNull() {
            addCriterion("topic_name is not null");
            return (Criteria) this;
        }

        public Criteria andTopicNameEqualTo(String value) {
            addCriterion("topic_name =", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotEqualTo(String value) {
            addCriterion("topic_name <>", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameGreaterThan(String value) {
            addCriterion("topic_name >", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameGreaterThanOrEqualTo(String value) {
            addCriterion("topic_name >=", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLessThan(String value) {
            addCriterion("topic_name <", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLessThanOrEqualTo(String value) {
            addCriterion("topic_name <=", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLike(String value) {
            addCriterion("topic_name like", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotLike(String value) {
            addCriterion("topic_name not like", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameIn(List<String> values) {
            addCriterion("topic_name in", values, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotIn(List<String> values) {
            addCriterion("topic_name not in", values, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameBetween(String value1, String value2) {
            addCriterion("topic_name between", value1, value2, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotBetween(String value1, String value2) {
            addCriterion("topic_name not between", value1, value2, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicImgIsNull() {
            addCriterion("topic_img is null");
            return (Criteria) this;
        }

        public Criteria andTopicImgIsNotNull() {
            addCriterion("topic_img is not null");
            return (Criteria) this;
        }

        public Criteria andTopicImgEqualTo(String value) {
            addCriterion("topic_img =", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotEqualTo(String value) {
            addCriterion("topic_img <>", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgGreaterThan(String value) {
            addCriterion("topic_img >", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgGreaterThanOrEqualTo(String value) {
            addCriterion("topic_img >=", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLessThan(String value) {
            addCriterion("topic_img <", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLessThanOrEqualTo(String value) {
            addCriterion("topic_img <=", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLike(String value) {
            addCriterion("topic_img like", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotLike(String value) {
            addCriterion("topic_img not like", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgIn(List<String> values) {
            addCriterion("topic_img in", values, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotIn(List<String> values) {
            addCriterion("topic_img not in", values, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgBetween(String value1, String value2) {
            addCriterion("topic_img between", value1, value2, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotBetween(String value1, String value2) {
            addCriterion("topic_img not between", value1, value2, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicStatusIsNull() {
            addCriterion("topic_status is null");
            return (Criteria) this;
        }

        public Criteria andTopicStatusIsNotNull() {
            addCriterion("topic_status is not null");
            return (Criteria) this;
        }

        public Criteria andTopicStatusEqualTo(String value) {
            addCriterion("topic_status =", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotEqualTo(String value) {
            addCriterion("topic_status <>", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusGreaterThan(String value) {
            addCriterion("topic_status >", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusGreaterThanOrEqualTo(String value) {
            addCriterion("topic_status >=", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusLessThan(String value) {
            addCriterion("topic_status <", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusLessThanOrEqualTo(String value) {
            addCriterion("topic_status <=", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusLike(String value) {
            addCriterion("topic_status like", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotLike(String value) {
            addCriterion("topic_status not like", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusIn(List<String> values) {
            addCriterion("topic_status in", values, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotIn(List<String> values) {
            addCriterion("topic_status not in", values, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusBetween(String value1, String value2) {
            addCriterion("topic_status between", value1, value2, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotBetween(String value1, String value2) {
            addCriterion("topic_status not between", value1, value2, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andArticleCountIsNull() {
            addCriterion("article_count is null");
            return (Criteria) this;
        }

        public Criteria andArticleCountIsNotNull() {
            addCriterion("article_count is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCountEqualTo(Integer value) {
            addCriterion("article_count =", value, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountNotEqualTo(Integer value) {
            addCriterion("article_count <>", value, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountGreaterThan(Integer value) {
            addCriterion("article_count >", value, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_count >=", value, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountLessThan(Integer value) {
            addCriterion("article_count <", value, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountLessThanOrEqualTo(Integer value) {
            addCriterion("article_count <=", value, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountIn(List<Integer> values) {
            addCriterion("article_count in", values, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountNotIn(List<Integer> values) {
            addCriterion("article_count not in", values, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountBetween(Integer value1, Integer value2) {
            addCriterion("article_count between", value1, value2, "articleCount");
            return (Criteria) this;
        }

        public Criteria andArticleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("article_count not between", value1, value2, "articleCount");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeIsNull() {
            addCriterion("topic_describe is null");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeIsNotNull() {
            addCriterion("topic_describe is not null");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeEqualTo(String value) {
            addCriterion("topic_describe =", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeNotEqualTo(String value) {
            addCriterion("topic_describe <>", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeGreaterThan(String value) {
            addCriterion("topic_describe >", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("topic_describe >=", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeLessThan(String value) {
            addCriterion("topic_describe <", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeLessThanOrEqualTo(String value) {
            addCriterion("topic_describe <=", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeLike(String value) {
            addCriterion("topic_describe like", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeNotLike(String value) {
            addCriterion("topic_describe not like", value, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeIn(List<String> values) {
            addCriterion("topic_describe in", values, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeNotIn(List<String> values) {
            addCriterion("topic_describe not in", values, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeBetween(String value1, String value2) {
            addCriterion("topic_describe between", value1, value2, "topicDescribe");
            return (Criteria) this;
        }

        public Criteria andTopicDescribeNotBetween(String value1, String value2) {
            addCriterion("topic_describe not between", value1, value2, "topicDescribe");
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