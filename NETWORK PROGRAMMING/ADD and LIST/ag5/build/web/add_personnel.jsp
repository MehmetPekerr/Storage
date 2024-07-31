<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Personel Ekle</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Personel Ekle</h1>
        <form action="personnel" method="post" class="mt-4">
            <div class="form-group">
                <label for="name">Adı:</label>
                <input type="text" id="name" name="name" class="form-control" required/>
            </div>
            <div class="form-group">
                <label for="surname">Soyadı:</label>
                <input type="text" id="surname" name="surname" class="form-control" required/>
            </div>
            <div class="form-group">
                <label for="employeeId">Sicil Numarası:</label>
                <input type="text" id="employeeId" name="employeeId" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="department">Departmanı:</label>
                <select id="department" name="department" class="form-control" multiple>
                    <option value="IT">IT</option>
                    <option value="HR">HR</option>
                    <option value="Finance">Finance</option>
                    <option value="Marketing">Marketing</option>
                </select>
            </div>
            <div class="form-group">
                <label for="phone">Telefon:</label>
                <input type="text" id="phone" name="phone" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="startDate">İşe Giriş Tarihi:</label>
                <input type="date" id="startDate" name="startDate" class="form-control" required/>
            </div>
            <div class="form-group">
                <label for="salary">Maaş Tutarı:</label>
                <input type="number" id="salary" name="salary" class="form-control" required/>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" id="active" name="active" class="form-check-input"/>
                <label for="active" class="form-check-label">Aktiflik</label>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Personel Ekle</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
