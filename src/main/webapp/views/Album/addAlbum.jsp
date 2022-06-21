<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
 <head>
 </head>

 </body>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="assets/css/styles.css">
 <link rel="stylesheet" href="assets/css/stylesMenu..css">
 <link rel="stylesheet" href="assets/css/Estilo.css">
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
                  <section class="form-login">
                   <h5>AÑADIR ÁLBUM</h5>
                  <form  action="album" method="POST">
                     <input type="text" class="controls" placeholder="Nombre Álbum" name="nombreAlbum" id="nombreAlbum" >
                     <input type="number" class="controls" placeholder="Año Publicado" name="anioPublicacion" id="anioPublicacion" >

                  <select class="controls">

                     <option value="true">Activo</option>
                     <option value="false">Inactivo</option>
                  </select>
                  </div>
            </div>
            <br>
                  </select>
                  <button type="submit" class="buttons" name="accion" value="add">Agregar</button>
            
                  </a></p>
              </form>
                 </div>
             </div>
         </div>
     </section>
     <br>
     <br>
     <br>
     <br>
     <br>
     <br>
     <br>
     <br>
  
     
     <!-- Copyright Section-->
     <div class="copyright py-4 text-center text-white">
      <h4>
      <div class="container"><small>Disquera &copy; 2022 Todos los derechos reservados.</small></div>
      </div>
      <script src="assets/js/scriptMenu.js"></script>
   </body>
</html>