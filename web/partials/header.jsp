
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${!empty username}">
Hello ${username} !
</c:if>

<a href="/supcommerce/listProducts">List products</a> | 
<a href="/supcommerce/auth/addProduct">Add product</a> | 
<a href="/supcommerce/auth/addCategory">Add category</a> | 
<a href="/supcommerce/logout">Logout</a>
