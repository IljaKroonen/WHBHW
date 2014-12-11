
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

                <div class="contentSetup">
                    <h2><g:link action="show" id="${setupInstance.id}">${fieldValue(bean: setupInstance, field: "name")}</g:link></h2>
                    <h4>Propriétaire</h4>${fieldValue(bean: setupInstance.user, field: "username")}
                    <h4>Description</h4>
                    <i>${fieldValue(bean: setupInstance, field: "description")}</i>
                    <h4>Composants </h4>
                    <g:each in="${setupInstance.components.sort{it.id}}" var="component">
                        ${fieldValue(bean: component, field: "name")}<br/>
                    </g:each>
                    <g:if test="${setupInstance.evaluations!=null}">
                        <g:each in="${setupInstance.evaluations}" var="evaluation">

                            <div class="gradePos">
                                <b>${fieldValue(bean: evaluation, field: "grade")}</b>
                            </div>
                            ${fieldValue(bean: applicationContext.springSecurityService.getCurrentUser(), field: "username")} :
                            ${fieldValue(bean: evaluation, field: "comment")}<br/>
                            <g:if test="${(evaluation.getUser().id).equals(applicationContext.springSecurityService.getCurrentUser().id)}">
                                <g:form url="[resource:evaluation, action:'delete']" method="DELETE">
                                    <fieldset class="buttons">
                                        <g:actionSubmit class="delete btn btn-danger glyphicon-trash" style="width: 150px; float: right; margin-right: 20px;"
                                                        action="delete" value="${message(code: 'Effacer', default: 'Effacer')}"
                                                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                        <g:link class="edit btn btn-info" style="width: 150px; float: right; margin-right: 20px;" action="edit"   resource="${evaluation}">
                                            <span class="glyphicon glyphicon-pencil" style="margin-right: 10px;" />      Editer</g:link>
                                    </fieldset>
                                </g:form>
                            </g:if>
                        </g:each>

                    </g:if>
                </div>

                <g:if test="${(!(setupInstance.getEvaluations()*.getUser().id).contains(applicationContext.springSecurityService.getCurrentUser()?.id) && applicationContext.springSecurityService.getCurrentUser()!=null)}">
                <g:form action="save" controller="Evaluation" >
                    <div class="addEvaluation">
                        <input type="hidden" name="setup.id" value="${setupInstance.id}">
                        <input type="hidden" name="user.id" value="${applicationContext.springSecurityService.getCurrentUser().id}">
                        <input id="comment" name="comment" maxlength="1600" type="text" class="form-control" id="texte" placeholder="">
                        <g:select name="grade" from="${1..5}" value="${grade}"/>
                        <g:submitButton type="submit" name="save" class="save" value="Add Evaluation"/> <br/>
                    </div>
                </g:form>
                </g:if>
            </g:each>

           <hr/>

			<div class="pagination">
				<g:paginate total="${setupInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
