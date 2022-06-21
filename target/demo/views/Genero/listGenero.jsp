<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <head>
 </head>

 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="assets/css/styles.css">
 <link rel="stylesheet" href="assets/css/stylesMenu..css">
 <link rel="stylesheet" href="assets/css/Estilo.css">
 <link rel="stylesheet" href="assets/css/Diseños.css">
 <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
 <script src="assets/js/jquery-3.6.0.min.js"></script>

 <title>DISQUERA</title>
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
<div class="container">
    <a class="navbar-brand js-scroll-trigger">DISQUERA</a>
    
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="genero?accion=index">INICIO</a></li>

               </ul>
            </div>
         </div>
      </nav>

<div id="menu-container">
 <div id="menu-wrapper">
    <div id="hamburger-menu"><span></span><span></span><span></span></div>
    <!-- hamburger-menu -->
 </div>
  <!-- menu-wrapper -->
  <ul class="menu-list accordion">
   <li id="nav1" class="toggle accordion-toggle"> 
      <span class="icon-plus"></span>
      <a class="menu-link" href="#">Canción</a>
   </li>
   <!-- accordion-toggle -->
   <ul class="menu-submenu accordion-content">
      <li><a class="head" href="cancion?accion=añadirCancion">Añadir Canción</a></li>
      <li><a class="head" href="cancion?accion=editarCancion">Editar Canción</a></li>
      <li><a class="head" href="cancion?accion=consultarCancion">Consultar Canción</a></li>
   </ul>

      <!-- menu-submenu accordon-content-->
      <li id="nav3" class="toggle accordion-toggle"> 
       <span class="icon-plus"></span>
       <a class="menu-link" href="#">Género</a>
    </li>
    <!-- accordion-toggle -->
    <ul class="menu-submenu accordion-content">
       <li><a class="head" href="genero?accion=añadirGenero">Añadir Género</a></li>
       <li><a class="head" href="genero?accion=editarGenero">Editar Género</a></li>
       <li><a class="head" href="genero?accion=consultarGenero">Consultar Género</a></li>
   </ul>


   <!-- menu-submenu accordon-content-->
   <li id="nav2" class="toggle accordion-toggle"> 
      <span class="icon-plus"></span>
      <a class="menu-link" href="#">Álbum</a>
   </li>
   <!-- accordion-toggle -->
   <ul class="menu-submenu accordion-content">
      <li><a class="head" href="album?accion=añadirAlbum">Añadir Álbum</a></li>
      <li><a class="head" href="album?accion=editarAlbum">Editar Álbum</a></li>
      <li><a class="head" href="album?accion=consultarAlbum">Consultar Álbum</a></li>
   </ul>
  
<!-- menu-submenu accordon-content-->
</ul>
<!-- menu-list accordion-->
</div>
<!-- menu-container -->
<center>
<table>
   <thead>
      <tr>
         <th>Id</th>
         <th>Nombre</th>
         <th>Estado</th>
         <th>Cambiar Estado</th>
         <th>Acción</th>
     </tr>
 </thead>
 <tbody>
     <c:forEach var="generoList" items="${listar}">
     <tr>
         <td>${generoList.getIdGenero()}</td>
         <td>${generoList.getNombreGenero()}</td>

         <td>
         <c:if test="${generoList.getEstadoGenero() == true}">
         <span>Activo</span>
         </c:if>
         <c:if test="${generoList.getEstadoGenero() == false}">
             <span>Inactivo</span>
         </c:if>
         </td>
         <td>
             <c:if test="${generoList.getEstadoGenero() == false}">
             <a href="genero?accion=estado&idGenero=${generoList.getIdGenero()}&estadoGenero=true"><button class="btn btn-primary" ><span>Activar</span></button></a>
         </c:if>
             <c:if test="${generoList.getEstadoGenero() == true}">
             <a href="genero?accion=estado&idGenero=${generoList.getIdGenero()}&estadoGenero=false"><button class="btn btn-danger"><span>Inactivar</span></button></a>
         </c:if>
         </td>
         <td>
            <div>
               <a href="genero?accion=eliminarGenero&idGenero=${generoList.getIdGenero()}"><img src="assets/img/eliminar.png" style="width: 25px;"></a>
               <a href="genero?accion=editarGenero&idGenero=${generoList.getIdGenero()}"><button type="button" class="btn btn-info">Editar</button></a>
              
            </div>
           </td>
       </tr>
   </c:forEach>
   </tbody>
</table>
<div>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
<a href="genero?accion=añadirGenero"><button class="btn btn-dark">Agregar Género</button></a>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</div>
</div>
</div>
</div>
</main>
     <!-- Copyright Section-->
     <div class="copyright py-4 text-center text-white">
      <h4>
      <div class="container"><small>Disquera  &copy; 2022 Todos los derechos reservados.</small></div>
     </div>
     <script src="assets/js/scriptMenu.js"></script>
   </body>
</html>