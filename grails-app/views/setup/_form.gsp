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

<div class="fieldcontain required">
    <label for="carteMere">Carte mère</label>
    <g:select name="carteMere" from="${whbhw.Component.findAllByType('CARTE_MERE').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.CARTE_MERE})?.name}"/>
</div>

<div class="fieldcontain required">
    <label for="processeur">Processeur</label>
    <g:select name="processeur" from="${whbhw.Component.findAllByType('PROCESSEUR').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.PROCESSEUR})?.name}" />
</div>

<div class="fieldcontain required">
    <label for="carteGraphique">Carte graphique</label>
    <g:select name="carteGraphique" from="${whbhw.Component.findAllByType('CARTE_GRAPHIQUE').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.CARTE_GRAPHIQUE})?.name}" />
</div>

<div class="fieldcontain required">
    <label for="ventilateur">Ventilateur</label>
    <g:select name="ventilateur" from="${whbhw.Component.findAllByType('VENTILATEUR').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.VENTILATEUR})?.name}"/>
</div>

<div class="fieldcontain required">
    <label for="ram">Mémoire vive</label>
    <g:select name="ram" from="${whbhw.Component.findAllByType('RAM').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.RAM})?.name}"/>
</div>

<div class="fieldcontain required">
    <label for="boitier">Boîtier</label>
    <g:select name="boitier" from="${whbhw.Component.findAllByType('BOITIER').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.BOITIER})?.name}"/>
</div>

<div class="fieldcontain required">
    <label for="alimentation">Alimentation</label>
    <g:select name="alimentation" from="${whbhw.Component.findAllByType('ALIMENTATION').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.ALIMENTATION})?.name}"/>
</div>

<div class="fieldcontain required">
    <label for="disqueDur">Disque dur</label>
    <g:select name="disqueDur" from="${whbhw.Component.findAllByType('DISQUE_DUR').name}"  value="${setupInstance.components.find({e -> e.type == whbhw.Type.DISQUE_DUR})?.name}"/>
</div>

<div class="fieldcontain required">
    <label for="ssd">SSD</label>
    <g:select name="ssd" from="${whbhw.Component.findAllByType('SSD').name}" value="${setupInstance.components.find({e -> e.type == whbhw.Type.SSD})?.name}"/>
</div>