<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Function tags</title>
</head>
<body>
<%-- <c:set var="s" value="payalrathee"/>
<c:if test="${fn:contains(s,'rathee')}">
contains
</c:if> --%>

<%-- <c:set var="s" value="payalrathee"/>
<c:if test="${fn:containsIgnoreCase(s,'RAT')}">
contains
</c:if> --%>

<%-- <c:set var="s" value="payalrathee"/>
<c:if test="${fn:endsWith(s,'rathee')}">
ends
</c:if> --%>

<%-- <c:set var="s" value="It is <xyz>second String.</xyz>"/>
${fn:escapeXml(s) } 
${s } --%>

<!-- ${fn:indexOf("abcd","cd")} -->

<%-- <c:set var="s" value="payalrathee"/>
${fn:contains(s,'rathee')} --%>

<%-- ${fn:trim("  abdc  a                ncd") }  --%>

<%-- <c:set var="xxx" value="payal-rathee-3-abcd"/>
<c:set var="yyy" value="${fn:split(xxx,'-') }"/>
<c:set var="zzz" value="${fn:join(yyy,' ') }"/>
${zzz }
<c:forEach var="i" items="${yyy }">
<c:out value="${i }"/>
<c:out value="${i.length() }"/>
</c:forEach> --%>

${fn:replace("payal","a","x") }


























</body>
</html>