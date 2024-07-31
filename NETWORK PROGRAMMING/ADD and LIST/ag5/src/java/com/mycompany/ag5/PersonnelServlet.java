package com.mycompany.ag5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/personnel")
public class PersonnelServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private List<Personnel> personnelList;

    @Override
    public void init() throws ServletException {
        personnelList = new ArrayList<>();
        personnelList.add(new Personnel("Ali", "Veli", "123", "IT", "555-1234", "2020-01-01", 5000, true));
        personnelList.add(new Personnel("Ayşe", "Yılmaz", "124", "HR", "555-5678", "2019-02-15", 4500, false));
    }

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Personnel> personnelList = PersonnelUtils.getPersonnelList();
    request.setAttribute("personnelList", personnelList);

    int totalPersonnel = PersonnelUtils.getTotalPersonnel();
    double totalSalary = PersonnelUtils.getTotalSalary();
    request.setAttribute("totalPersonnel", totalPersonnel);
    request.setAttribute("totalSalary", totalSalary);

    request.getRequestDispatcher("/list_personnel.jsp").forward(request, response);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String employeeId = request.getParameter("employeeId");
        String department = request.getParameter("department");
        String phone = request.getParameter("phone");
        String startDate = request.getParameter("startDate");
        int salary = Integer.parseInt(request.getParameter("salary"));
        boolean active = request.getParameter("active") != null;

        Personnel personnel = new Personnel(name, surname, employeeId, department, phone, startDate, salary, active);
        PersonnelUtils.addPersonnel(personnel);

        response.sendRedirect("personnel");
    }
}
