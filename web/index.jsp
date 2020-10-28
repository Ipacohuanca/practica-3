<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRODUCTOS</h1>
        <p> <a href="inicio?action=add"> Nuevo</a> </p>
        <table>
            <tr>
                <th>Id</th>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${avisos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item}.producto</td>
                    <td>${item}.precio</td>
                    <td>${item}.cantidad</td>
                    <td><a href="inicio?action=edit&id=${item.id}">EDITAR</a></td>
                    <td><a href="inicio?action=edit&id=${item.id}" onclick="return(confirm('ESTA SEGURO..!'))">ELIMINAR</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
