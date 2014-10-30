<%@ page import="whbhw.Component" %>



<div class="fieldcontain ${hasErrors(bean: componentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="component.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${componentInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: componentInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="component.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${componentInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: componentInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="component.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="type" required="" value="${componentInstance?.type}"/>

</div>

