<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.ag5.Personnel" %>
<%@ page import="com.mycompany.ag5.PersonnelUtils" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Personel Listesi</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Personel Listesi</h1>
        <table class="table table-striped mt-4">
            <thead class="thead-dark">
                <tr>
                    <th>Adı</th>
                    <th>Soyadı</th>
                    <th>Sicil Numarası</th>
                    <th>Departman</th>
                    <th>Telefon</th>
                    <th>İşe Giriş Tarihi</th>
                    <th>Maaş Tutarı</th>
                    <th>Aktiflik Durumu</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${personnelList}" var="personnel">
                    <tr>
                        <td>${personnel.name}</td>
                        <td>${personnel.surname}</td>
                        <td>${personnel.employeeId}</td>
                        <td>${personnel.department}</td>
                        <td>${personnel.phone}</td>
                        <td>${personnel.startDate}</td>
                        <td>${personnel.salary}</td>
                        <td>
                            <c:choose>
                                <c:when test="${personnel.active}">Aktif</c:when>
                                <c:otherwise>Pasif</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="mt-4">
            <p><strong>Toplam Personel Sayısı:</strong> ${totalPersonnel}</p>
            <p><strong>Tüm Personelin Toplam Maaş Tutarı:</strong> ${totalSalary}</p>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
