package com.example.taskmanagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = XMLUtils.readTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/index.html").forward(request, response);
    }
}
