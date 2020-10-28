<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${aviso.id == 0 }">Nuevo</c:if>
            <c:if test="${aviso.id != 0 }">Editar</c:if>
                aviso
            </h1>
            <form action="inicio" method="post">
                <input type="hidden" name="id" value="${aviso.id}"/>
            <table>
                <tr>
                    <td>Producto:</td>
                    <td><input type="text" name="producto" value="${aviso.producto}"/></td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input type="text" name="precio" value="${aviso.precio}"/></td>
                </tr>   
                <tr>
                    <td>cantidad:</td>
                    <td><input type="text" name="cantidad" value="${aviso.cantidad}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"/></td>
                </tr>
            </table>
        </form>
</html>
