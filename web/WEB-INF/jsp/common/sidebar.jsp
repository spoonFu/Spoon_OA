<%@ page contentType="text/html;charset=utf-8" %>
<div class="sidebar">
    <ul class="sidemenu">
        <c:forEach items="${MenuResource}" var="li" varStatus="vs">
            <c:if test="${li.children!=null||li.url!=null}">
                <li class="<c:if test="${fn:startsWith(currentMenu.code,li.code)}">active </c:if><c:if test="${li.children!=null}">haschild</c:if>">
                    <a <c:if test="${!empty li.url}">href="${rootUrl}${li.url}"</c:if>>${li.name}
                        <c:if test="${li.children!=null}"><span class="fa fa-arrow-left"></span></c:if>
                    </a>
                    <c:if test="${li.children!=null}">
                        <ul class="submenu">
                            <c:forEach items="${li.children}" var="li1">
                                <li <c:if test="${fn:startsWith(currentMenu.code,li1.code)}">class="active"</c:if>><a href="${rootUrl}${li1.url}">${li1.name}</a></li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </li>
            </c:if>
        </c:forEach>
    </ul>
</div>