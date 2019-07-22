<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Employees List</h1>
        <form method="POST" action="/save">
            <table class="table table-striped">
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"</td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="text" name="age"/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><input type="text" name="gender"/></td>
                </tr>
                <tr >
                    <td><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
