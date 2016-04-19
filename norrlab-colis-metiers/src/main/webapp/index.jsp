<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="com.norrlab.colis.dao.entity.Gender"%>
<%@page import="java.util.Date"%>
<%@page import="com.norrlab.colis.dao.entity.Client"%>
<%@page import="com.norrlab.colis.service.interfaces.ClientService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<html>

<head>
  <title>NorrLab Business</title>
<!--     <meta charset="utf-8"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<% WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
 	ClientService clService = ctx.getBean(ClientService.class);
 	Collection<Client>clients = clService.getAllCleints();
 	Client cl = clService.getById(3L);
 	
 	request.setAttribute("cl",cl);
 	request.setAttribute("clients",clients);
%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active">
			<a href="#">
          		<span class="glyphicon glyphicon-home"></span>
        	</a>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span>  ${cl.lastname}</a></li>
        <li>
		<!--         <a href="#"><span class="glyphicon glyphicon-log-in"></span> s'inscrire</a> -->
        <a href="#">
          <span class="glyphicon glyphicon-plus-sign"> s'inscrire</span>
        </a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<h2>Hello World! tresor bbb</h2>
	<div>
		<h1 style="background: red">le client</h1>
		<p>${cl.id}</p>
		<p>${cl.country}</p>
		<p>${cl.lastname}</p>
	<div>
	<div class="colm-md-6">
		sgbfhnjygjymgkhJLMKYLMJK?L
		gnblgjnlkmj,tnklt
		nbljgtljh,
	</div>
			 
		</div>
		<table border="1" style="text-align: center ">
				<tr>
					<th>NOM</th>
					<th>PRENOM</th>
					 <th>SEX</th>
					 <th>EMAIL</th>
					 <th>VILLE</th>
					 <th>PAYS</th>
				</tr>
				 
			<c:forEach items="${clients}" var="client">
				<tr>
					<td>${client.firstname}</td>
					<td>${client.lastname}</td>
					<td>${client.sex}</td>
					<td>${client.email}</td>
					<td>${client.city}</td>
					<td>${client.country}</td>
				</tr>
			</c:forEach>
		
		</table>
	</div> 
</body>
</html>
