package com.college.food.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodInformationExample() {
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

        public Criteria andFoodNameIsNull() {
            addCriterion("food_name is null");
            return (Criteria) this;
        }

        public Criteria andFoodNameIsNotNull() {
            addCriterion("food_name is not null");
            return (Criteria) this;
        }

        public Criteria andFoodNameEqualTo(String value) {
            addCriterion("food_name =", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotEqualTo(String value) {
            addCriterion("food_name <>", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThan(String value) {
            addCriterion("food_name >", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("food_name >=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThan(String value) {
            addCriterion("food_name <", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThanOrEqualTo(String value) {
            addCriterion("food_name <=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLike(String value) {
            addCriterion("food_name like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotLike(String value) {
            addCriterion("food_name not like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameIn(List<String> values) {
            addCriterion("food_name in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotIn(List<String> values) {
            addCriterion("food_name not in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameBetween(String value1, String value2) {
            addCriterion("food_name between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotBetween(String value1, String value2) {
            addCriterion("food_name not between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIsNull() {
            addCriterion("food_price is null");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIsNotNull() {
            addCriterion("food_price is not null");
            return (Criteria) this;
        }

        public Criteria andFoodPriceEqualTo(Double value) {
            addCriterion("food_price =", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotEqualTo(Double value) {
            addCriterion("food_price <>", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceGreaterThan(Double value) {
            addCriterion("food_price >", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("food_price >=", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceLessThan(Double value) {
            addCriterion("food_price <", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceLessThanOrEqualTo(Double value) {
            addCriterion("food_price <=", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIn(List<Double> values) {
            addCriterion("food_price in", values, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotIn(List<Double> values) {
            addCriterion("food_price not in", values, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceBetween(Double value1, Double value2) {
            addCriterion("food_price between", value1, value2, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotBetween(Double value1, Double value2) {
            addCriterion("food_price not between", value1, value2, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdIsNull() {
            addCriterion("food_type_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdIsNotNull() {
            addCriterion("food_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdEqualTo(String value) {
            addCriterion("food_type_id =", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdNotEqualTo(String value) {
            addCriterion("food_type_id <>", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdGreaterThan(String value) {
            addCriterion("food_type_id >", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("food_type_id >=", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdLessThan(String value) {
            addCriterion("food_type_id <", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdLessThanOrEqualTo(String value) {
            addCriterion("food_type_id <=", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdLike(String value) {
            addCriterion("food_type_id like", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdNotLike(String value) {
            addCriterion("food_type_id not like", value, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdIn(List<String> values) {
            addCriterion("food_type_id in", values, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdNotIn(List<String> values) {
            addCriterion("food_type_id not in", values, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdBetween(String value1, String value2) {
            addCriterion("food_type_id between", value1, value2, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeIdNotBetween(String value1, String value2) {
            addCriterion("food_type_id not between", value1, value2, "foodTypeId");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameIsNull() {
            addCriterion("food_type_name is null");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameIsNotNull() {
            addCriterion("food_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameEqualTo(String value) {
            addCriterion("food_type_name =", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameNotEqualTo(String value) {
            addCriterion("food_type_name <>", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameGreaterThan(String value) {
            addCriterion("food_type_name >", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("food_type_name >=", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameLessThan(String value) {
            addCriterion("food_type_name <", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameLessThanOrEqualTo(String value) {
            addCriterion("food_type_name <=", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameLike(String value) {
            addCriterion("food_type_name like", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameNotLike(String value) {
            addCriterion("food_type_name not like", value, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameIn(List<String> values) {
            addCriterion("food_type_name in", values, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameNotIn(List<String> values) {
            addCriterion("food_type_name not in", values, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameBetween(String value1, String value2) {
            addCriterion("food_type_name between", value1, value2, "foodTypeName");
            return (Criteria) this;
        }

        public Criteria andFoodTypeNameNotBetween(String value1, String value2) {
            addCriterion("food_type_name not between", value1, value2, "foodTypeName");
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

        public Criteria andFoodUrlIsNull() {
            addCriterion("food_url is null");
            return (Criteria) this;
        }

        public Criteria andFoodUrlIsNotNull() {
            addCriterion("food_url is not null");
            return (Criteria) this;
        }

        public Criteria andFoodUrlEqualTo(String value) {
            addCriterion("food_url =", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlNotEqualTo(String value) {
            addCriterion("food_url <>", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlGreaterThan(String value) {
            addCriterion("food_url >", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlGreaterThanOrEqualTo(String value) {
            addCriterion("food_url >=", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlLessThan(String value) {
            addCriterion("food_url <", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlLessThanOrEqualTo(String value) {
            addCriterion("food_url <=", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlLike(String value) {
            addCriterion("food_url like", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlNotLike(String value) {
            addCriterion("food_url not like", value, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlIn(List<String> values) {
            addCriterion("food_url in", values, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlNotIn(List<String> values) {
            addCriterion("food_url not in", values, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlBetween(String value1, String value2) {
            addCriterion("food_url between", value1, value2, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodUrlNotBetween(String value1, String value2) {
            addCriterion("food_url not between", value1, value2, "foodUrl");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeIsNull() {
            addCriterion("food_describe is null");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeIsNotNull() {
            addCriterion("food_describe is not null");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeEqualTo(String value) {
            addCriterion("food_describe =", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeNotEqualTo(String value) {
            addCriterion("food_describe <>", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeGreaterThan(String value) {
            addCriterion("food_describe >", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("food_describe >=", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeLessThan(String value) {
            addCriterion("food_describe <", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeLessThanOrEqualTo(String value) {
            addCriterion("food_describe <=", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeLike(String value) {
            addCriterion("food_describe like", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeNotLike(String value) {
            addCriterion("food_describe not like", value, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeIn(List<String> values) {
            addCriterion("food_describe in", values, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeNotIn(List<String> values) {
            addCriterion("food_describe not in", values, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeBetween(String value1, String value2) {
            addCriterion("food_describe between", value1, value2, "foodDescribe");
            return (Criteria) this;
        }

        public Criteria andFoodDescribeNotBetween(String value1, String value2) {
            addCriterion("food_describe not between", value1, value2, "foodDescribe");
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