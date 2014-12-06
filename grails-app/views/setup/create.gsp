<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'setup.label', default: 'Setup')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-setup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-setup" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${setupInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${setupInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:setupInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
                Carte mère:<g:select name="carteMere" from="${whbhw.Component.findAllByType('CARTE_MERE').name}" />
                <br />
                Processeur:<g:select name="processeur" from="${whbhw.Component.findAllByType('PROCESSEUR').name}" keys="${whbhw.Component.findAllByType('PROCESSEUR').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
                Carte graphique:<g:select name="carteGraphique" from="${whbhw.Component.findAllByType('CARTE_GRAPHIQUE').name}" keys="${whbhw.Component.findAllByType('CARTE_GRAPHIQUE').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
                Ventilateur:<g:select name="ventilateur" from="${whbhw.Component.findAllByType('VENTILATEUR').name}" keys="${whbhw.Component.findAllByType('VENTILATEUR').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
                RAM:<g:select name="ram" from="${whbhw.Component.findAllByType('RAM').name}" keys="${whbhw.Component.findAllByType('RAM').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
                Boitier:<g:select name="boitier" from="${whbhw.Component.findAllByType('BOITIER').name}" keys="${whbhw.Component.findAllByType('BOITIER').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
                Alimentation:<g:select name="alimentation" from="${whbhw.Component.findAllByType('ALIMENTATION').name}" keys="${whbhw.Component.findAllByType('ALIMENTATION').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
                Disque dur:<g:select name="disqueDur" from="${whbhw.Component.findAllByType('DISQUE_DUR').name}" keys="${whbhw.Component.findAllByType('DISQUE_DUR').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
                SSD:<g:select name="ssd" from="${whbhw.Component.findAllByType('SSD').name}" keys="${whbhw.Component.findAllByType('SSD').name}" required="" value="${setupInstance?.components?.name()}" />
                <br />
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
    </body>
</html>
