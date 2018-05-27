package com.college.food.common.utils;


import org.springframework.data.domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yangzy on 2017/6/30.
 */
public class JpaUtils {
    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 10;

    /***
     *
     * @param oriPage
     *     页数
     * @param oriSize
     *     每页条数
     * @param orderBy
     *     排序字段
     * @param desc
     *     升降序
     * @return
     *     Pageable
     */
    public static Pageable getPageAble(Integer oriPage, Integer oriSize, String orderBy, String desc){
        Integer page = getPage(oriPage);
        Integer size = getSize(oriSize);
        Sort.Direction direction = Sort.Direction.ASC;
        if(desc.equalsIgnoreCase("desc"))
            direction = Sort.Direction.DESC;
        Sort sort = new Sort(direction, orderBy);
        return new PageRequest(page, size, sort);
    }

    public static Pageable getPageAble(Integer oriPage, Integer oriSize, List<String> orderBy, String desc){
        Integer page = getPage(oriPage);
        Integer size = getSize(oriSize);
        Sort.Direction direction = Sort.Direction.ASC;
        if(desc.equalsIgnoreCase("desc"))
            direction = Sort.Direction.DESC;
        Sort sort = new Sort(direction, orderBy);
        return new PageRequest(page, size, sort);
    }

    /***
     *
     * @param oriPage
     *     页数
     * @param oriSize
     *     每页条数
     * @return
     *     Pageable
     */
    public static Pageable getPageAble(Integer oriPage, Integer oriSize){
        Integer page = getPage(oriPage);
        Integer size = getSize(oriSize);
        return new PageRequest(page, size);
    }

    /***
     *
     * @param t
     *     entity
     * @param <T>
     *     type
     * @return
     *     Example<T>
     */
    public static <T> Example<T> createExample(T t){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        return Example.of(t, exampleMatcher);
    }

    public static Date toDate(String oriDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = getFormat();
        return simpleDateFormat.parse(oriDate);
    }

    public static Date toDate(String oriDate, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = getFormat(format);
        return simpleDateFormat.parse(oriDate);
    }

    public static String dateToString(Date oriDate){
        SimpleDateFormat simpleDateFormat = getFormat();
        return simpleDateFormat.format(oriDate);
    }

    public static String dateToString(Date oriDate, String format){
        SimpleDateFormat simpleDateFormat = getFormat(format);
        return simpleDateFormat.format(oriDate);
    }

    public static SimpleDateFormat getFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static SimpleDateFormat getFormat(String format){
        return new SimpleDateFormat(format);
    }

    private static Integer getPage(Integer oriPage){
        return oriPage==null?DEFAULT_PAGE:oriPage-1;
    }

    private static Integer getSize(Integer oriSize){
        return oriSize==null?DEFAULT_SIZE:oriSize;
    }
}
