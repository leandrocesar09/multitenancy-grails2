
<%@ page import="multitenancy.EntityTest" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'entityTest.label', default: 'EntityTest')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-entityTest" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-entityTest" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list entityTest">
			
				<g:if test="${entityTestInstance?.dateRegister}">
				<li class="fieldcontain">
					<span id="dateRegister-label" class="property-label"><g:message code="entityTest.dateRegister.label" default="Date Register" /></span>
					
						<span class="property-value" aria-labelledby="dateRegister-label"><g:formatDate date="${entityTestInstance?.dateRegister}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${entityTestInstance?.idTenant}">
				<li class="fieldcontain">
					<span id="idTenant-label" class="property-label"><g:message code="entityTest.idTenant.label" default="Id Tenant" /></span>
					
						<span class="property-value" aria-labelledby="idTenant-label"><g:fieldValue bean="${entityTestInstance}" field="idTenant"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${entityTestInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="entityTest.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${entityTestInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:entityTestInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${entityTestInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
