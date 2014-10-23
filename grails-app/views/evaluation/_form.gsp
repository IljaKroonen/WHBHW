<%@ page import="whbhw.Evaluation" %>



<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'grade', 'error')} required">
	<label for="grade">
		<g:message code="evaluation.grade.label" default="Grade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="grade" type="number" value="${evaluationInstance.grade}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'comment', 'error')} ">
	<label for="comment">
		<g:message code="evaluation.comment.label" default="Comment" />
		
	</label>
	<g:textField name="comment" value="${evaluationInstance?.comment}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'setup', 'error')} ">
	<label for="setup">
		<g:message code="evaluation.setup.label" default="Setup" />
		
	</label>
	<g:select id="setup" name="setup.id" from="${whbhw.Setup.list()}" optionKey="id" value="${evaluationInstance?.setup?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

