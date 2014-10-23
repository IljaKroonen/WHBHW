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

<div class="fieldcontain ${hasErrors(bean: componentInstance, field: 'setups', 'error')} ">
	<label for="setups">
		<g:message code="component.setups.label" default="Setups" />
		
	</label>
	<g:select name="setups" from="${whbhw.Setup.list()}" multiple="multiple" optionKey="id" size="5" value="${componentInstance?.setups*.id}" class="many-to-many"/>

</div>

