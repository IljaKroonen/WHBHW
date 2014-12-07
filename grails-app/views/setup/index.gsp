
<%@ page import="whbhw.Setup" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'setup.label', default: 'Setup')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <style type="text/css" media="screen">

        .contentSetup{
            text-align: center;
        }
        .gradePos{
            color: green;
            font-size: 200%;
        }

        </style>
	</head>
	<body>
		<a href="#list-setup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>

			</ul>
		</div>
        <div class="search">
            <fieldset class="form">
                <g:form action="index" method="GET">
                        <label for="query">Search :</label>
                        <g:textField name="query" value="${params.query}"/>
                        <label for="checkBoxSetup">Setup :</label>
                        <g:checkBox name="checkBoxSetup" value="${false}" />
                        <label for="checkBoxPseudo">Pseudo :</label>
                        <g:checkBox name="checkBoxPseudo" value="${false}" />
                        <label for="checkBoxComponent">Component :</label>
                        <g:checkBox name="checkBoxComponent" value="${false}" />
                </g:form>
            </fieldset>
        </div>

		<div id="list-setup" class="content scaffold-list" role="main">
			<!--<h1><g:message code="default.list.label" args="[entityName]" /></h1> -->
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

            <g:each in="${setupInstanceList}" status="i" var="setupInstance">
                <h2>Pseudo:</h2> <g:link action="show" id="${setupInstance.id}">${fieldValue(bean: setupInstance.user, field: "username")}</g:link>

                <div class="contentSetup">
                    <h2>${fieldValue(bean: setupInstance, field: "name")}:</h2>
                    <i>${fieldValue(bean: setupInstance, field: "description")}</i>
                    <h2>Components: </h2>
                    <g:each in="${setupInstance.components}" var="component">
                        ${fieldValue(bean: component, field: "name")}<br/>
                    </g:each>
                    <g:actionSubmit value="Show Evaluation"/> <br/>
                    <g:if test="${setupInstance.evaluations!=null}">
                        <g:each in="${setupInstance.evaluations}" var="evaluation">

                            <div class="gradePos">
                                <b>${fieldValue(bean: evaluation, field: "grade")}</b>
                            </div>
                            ${fieldValue(bean: evaluation.user, field: "username")} :
                            ${fieldValue(bean: evaluation, field: "comment")}<br/>
                        </g:each>

                    </g:if>
                </div>

            </g:each>

           <hr/>

			<div class="pagination">
				<g:paginate total="${setupInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
