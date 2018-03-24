<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%-- 用于显示班级状态信息 --%>
<s:set value="new java.util.Date()" var="nowDate"></s:set>
<%--1 现在  小于 开始 --%>
<s:if test="#nowDate.getTime() < beginTime.getTime()">未开班</s:if>
<s:elseif test="endTime.getTime() < #nowDate.getTime()">已结束</s:elseif>
<s:else>已开班</s:else>
