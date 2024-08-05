package com.example.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    public static class Ticket {
        public int id;
        public String ticketNo;
        public String categoryName;
        public String title;
        public String raisedBy;
        public String date;
        public String status;
        public String description;

        public Ticket(int id, String ticketNo, String categoryName, String title, String raisedBy, String date, String status, String description) {
            this.id = id;
            this.ticketNo = ticketNo;
            this.categoryName = categoryName;
            this.title = title;
            this.raisedBy = raisedBy;
            this.date = date;
            this.status = status;
            this.description = description;
        }
    }

    private List<Ticket> tickets;

    @Override
    public void init() throws ServletException {
        tickets = new ArrayList<>();
        tickets.add(new Ticket(1, "10001002", "Carter Cooper", "fgfhfghgf", "Leilani Rivas", "2022-04-02", "Pending", "gfhfh"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tickets", tickets);
        request.getRequestDispatcher("/tickets.jsp").forward(request, response);
    }
}
