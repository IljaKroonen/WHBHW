<%@ page import="whbhw.Setup" %>

<div class="fieldcontain ${hasErrors(bean: setupInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="setup.name.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${setupInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: setupInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="setup.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" required="" value="${setupInstance?.description}"/>

</div>