<%@ page import="multitenancy.EntityTest" %>



<div class="fieldcontain ${hasErrors(bean: entityTestInstance, field: 'dateRegister', 'error')} required">
	<label for="dateRegister">
		<g:message code="entityTest.dateRegister.label" default="Date Register" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateRegister" precision="day"  value="${entityTestInstance?.dateRegister}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: entityTestInstance, field: 'idTenant', 'error')} required">
	<label for="idTenant">
		<g:message code="entityTest.idTenant.label" default="Id Tenant" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="idTenant" type="number" value="${entityTestInstance.idTenant}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: entityTestInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="entityTest.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${entityTestInstance?.name}"/>

</div>

