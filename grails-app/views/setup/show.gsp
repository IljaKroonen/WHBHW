
<%@ page import="whbhw.Setup" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'setup.label', default: 'Setup')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-setup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-setup" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list setup">
			
				<g:if test="${setupInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="setup.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${setupInstance?.user?.id}">${setupInstance?.user?.username}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${setupInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="setup.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${setupInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setupInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="setup.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${setupInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setupInstance?.components}">
				<li class="fieldcontain">
					<span id="components-label" class="property-label"><g:message code="setup.components.label" default="Components" /></span>

						<g:each in="${setupInstance.components.sort{it.id}}" var="c">
						<span class="property-value" aria-labelledby="components-label"><g:link controller="component" action="show" id="${c.id}">${c?.name}</g:link></span>
						</g:each>
					
				</li>
				</g:if>

			</ol>
			<g:form url="[resource:setupInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${setupInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
