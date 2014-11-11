
<%@ page import="whbhw.Setup" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'setup.label', default: 'Setup')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-setup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-setup" class="content scaffold-list" role="main">
			<!--<h1><g:message code="default.list.label" args="[entityName]" /></h1> -->
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

            <g:each in="${setupInstanceList}" status="i" var="setupInstance">
                <h2>Pseudo:</h2> <g:link action="show" id="${setupInstance.id}">${fieldValue(bean: setupInstance.user, field: "username")}</g:link>
                <h2>Setup: ${fieldValue(bean: setupInstance, field: "name")}</h2>
                ${fieldValue(bean: setupInstance, field: "description")}
                <h2>Components: </h2>
                <g:each in="${setupInstance.components}" var="component">
                    ${fieldValue(bean: component, field: "name")}<br/>
                </g:each>
            </g:each>

           <!-- <g:actionSubmit value="Add Evaluation" action="addEvaluation"/> <br/>-->


            ---------------------------------------------------------------------------------------<br/>


        <!--
			<table>
			<thead>
					<tr>
					
						<th><g:message code="setup.user.label" default="User" /></th>
					
						<g:sortableColumn property="name" title="${message(code: 'setup.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'setup.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
                <g:each in="${setupInstanceList}" status="i" var="setupInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${setupInstance.id}">${fieldValue(bean: setupInstance.user, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: setupInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: setupInstance, field: "description")}</td>

                        <g:each in="${setupInstance.components}" var="component">
                            <td>${fieldValue(bean: component, field: "name")}</td>
                        </g:each>
					
					</tr>
				</g:each>
				</tbody>
			</table> -->
			<div class="pagination">
				<g:paginate total="${setupInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
