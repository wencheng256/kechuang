<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String url=(String)session.getAttribute("url");
response.sendRedirect(url);
%>
