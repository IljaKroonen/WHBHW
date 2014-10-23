<%@ page import="whbhw.Setup" %>



<div class="fieldcontain ${hasErrors(bean: setupInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="setup.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${whbhw.User.list()}" optionKey="id" required="" value="${setupInstance?.user?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: setupInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="setup.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${setupInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: setupInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="setup.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${setupInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: setupInstance, field: 'components', 'error')} ">
	<label for="components">
		<g:message code="setup.components.label" default="Components" />
		
	</label>
	

</div>

