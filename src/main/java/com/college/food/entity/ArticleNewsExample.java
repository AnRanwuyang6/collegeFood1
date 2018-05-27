package com.college.food.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleNewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleNewsExample() {
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

        public Criteria andTArticleTitleIsNull() {
            addCriterion("t_article_title is null");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleIsNotNull() {
            addCriterion("t_article_title is not null");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleEqualTo(String value) {
            addCriterion("t_article_title =", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleNotEqualTo(String value) {
            addCriterion("t_article_title <>", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleGreaterThan(String value) {
            addCriterion("t_article_title >", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("t_article_title >=", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleLessThan(String value) {
            addCriterion("t_article_title <", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("t_article_title <=", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleLike(String value) {
            addCriterion("t_article_title like", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleNotLike(String value) {
            addCriterion("t_article_title not like", value, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleIn(List<String> values) {
            addCriterion("t_article_title in", values, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleNotIn(List<String> values) {
            addCriterion("t_article_title not in", values, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleBetween(String value1, String value2) {
            addCriterion("t_article_title between", value1, value2, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleTitleNotBetween(String value1, String value2) {
            addCriterion("t_article_title not between", value1, value2, "tArticleTitle");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsIsNull() {
            addCriterion("t_article_keywords is null");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsIsNotNull() {
            addCriterion("t_article_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsEqualTo(String value) {
            addCriterion("t_article_keywords =", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsNotEqualTo(String value) {
            addCriterion("t_article_keywords <>", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsGreaterThan(String value) {
            addCriterion("t_article_keywords >", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("t_article_keywords >=", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsLessThan(String value) {
            addCriterion("t_article_keywords <", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsLessThanOrEqualTo(String value) {
            addCriterion("t_article_keywords <=", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsLike(String value) {
            addCriterion("t_article_keywords like", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsNotLike(String value) {
            addCriterion("t_article_keywords not like", value, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsIn(List<String> values) {
            addCriterion("t_article_keywords in", values, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsNotIn(List<String> values) {
            addCriterion("t_article_keywords not in", values, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsBetween(String value1, String value2) {
            addCriterion("t_article_keywords between", value1, value2, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleKeywordsNotBetween(String value1, String value2) {
            addCriterion("t_article_keywords not between", value1, value2, "tArticleKeywords");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagIsNull() {
            addCriterion("t_article_flag is null");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagIsNotNull() {
            addCriterion("t_article_flag is not null");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagEqualTo(String value) {
            addCriterion("t_article_flag =", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagNotEqualTo(String value) {
            addCriterion("t_article_flag <>", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagGreaterThan(String value) {
            addCriterion("t_article_flag >", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagGreaterThanOrEqualTo(String value) {
            addCriterion("t_article_flag >=", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagLessThan(String value) {
            addCriterion("t_article_flag <", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagLessThanOrEqualTo(String value) {
            addCriterion("t_article_flag <=", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagLike(String value) {
            addCriterion("t_article_flag like", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagNotLike(String value) {
            addCriterion("t_article_flag not like", value, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagIn(List<String> values) {
            addCriterion("t_article_flag in", values, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagNotIn(List<String> values) {
            addCriterion("t_article_flag not in", values, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagBetween(String value1, String value2) {
            addCriterion("t_article_flag between", value1, value2, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleFlagNotBetween(String value1, String value2) {
            addCriterion("t_article_flag not between", value1, value2, "tArticleFlag");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeIsNull() {
            addCriterion("t_article_type is null");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeIsNotNull() {
            addCriterion("t_article_type is not null");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeEqualTo(String value) {
            addCriterion("t_article_type =", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeNotEqualTo(String value) {
            addCriterion("t_article_type <>", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeGreaterThan(String value) {
            addCriterion("t_article_type >", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("t_article_type >=", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeLessThan(String value) {
            addCriterion("t_article_type <", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeLessThanOrEqualTo(String value) {
            addCriterion("t_article_type <=", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeLike(String value) {
            addCriterion("t_article_type like", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeNotLike(String value) {
            addCriterion("t_article_type not like", value, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeIn(List<String> values) {
            addCriterion("t_article_type in", values, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeNotIn(List<String> values) {
            addCriterion("t_article_type not in", values, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeBetween(String value1, String value2) {
            addCriterion("t_article_type between", value1, value2, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTArticleTypeNotBetween(String value1, String value2) {
            addCriterion("t_article_type not between", value1, value2, "tArticleType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeIsNull() {
            addCriterion("t_announcement_type is null");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeIsNotNull() {
            addCriterion("t_announcement_type is not null");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeEqualTo(String value) {
            addCriterion("t_announcement_type =", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeNotEqualTo(String value) {
            addCriterion("t_announcement_type <>", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeGreaterThan(String value) {
            addCriterion("t_announcement_type >", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("t_announcement_type >=", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeLessThan(String value) {
            addCriterion("t_announcement_type <", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeLessThanOrEqualTo(String value) {
            addCriterion("t_announcement_type <=", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeLike(String value) {
            addCriterion("t_announcement_type like", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeNotLike(String value) {
            addCriterion("t_announcement_type not like", value, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeIn(List<String> values) {
            addCriterion("t_announcement_type in", values, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeNotIn(List<String> values) {
            addCriterion("t_announcement_type not in", values, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeBetween(String value1, String value2) {
            addCriterion("t_announcement_type between", value1, value2, "tAnnouncementType");
            return (Criteria) this;
        }

        public Criteria andTAnnouncementTypeNotBetween(String value1, String value2) {
            addCriterion("t_announcement_type not between", value1, value2, "tAnnouncementType");
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

        public Criteria andCrateTimeIsNull() {
            addCriterion("crate_time is null");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIsNotNull() {
            addCriterion("crate_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrateTimeEqualTo(Date value) {
            addCriterion("crate_time =", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotEqualTo(Date value) {
            addCriterion("crate_time <>", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeGreaterThan(Date value) {
            addCriterion("crate_time >", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("crate_time >=", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeLessThan(Date value) {
            addCriterion("crate_time <", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeLessThanOrEqualTo(Date value) {
            addCriterion("crate_time <=", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIn(List<Date> values) {
            addCriterion("crate_time in", values, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotIn(List<Date> values) {
            addCriterion("crate_time not in", values, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeBetween(Date value1, Date value2) {
            addCriterion("crate_time between", value1, value2, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotBetween(Date value1, Date value2) {
            addCriterion("crate_time not between", value1, value2, "crateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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