package com.example.testthu.servlet;


import com.example.testthu.model.KhachHang;
import com.example.testthu.service.KhachHangService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/hien-thi",
        "/khach-hang/detail",
        "/khach-hang/add",
        "/khach-hang/delete",
        "/khach-hang/view-update",
        "/khach-hang/update",})
public class KhachHangServlet extends HttpServlet {
    public KhachHangService khachHangService = new KhachHangService();
    public List<KhachHang> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")){
            this.getAll(request,response);
        } else if (uri.contains("detail")) {
            this.detail(request,response);
        } else if (uri.contains("delete")) {
            this.delete(request,response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request,response);
        }else {
            this.getAll(request,response);
        }

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(id);
        request.setAttribute("kh",kh);
        request.getRequestDispatcher("/view/viewUpdate-KhachHang.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(id);
        khachHangService.delete(kh);
        this.getAll(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(id);
        request.setAttribute("kh",kh);
        this.getAll(request,response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = khachHangService.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/view/khach-hang-hien-thi.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            this.add(request,response);
        }else {
            this.update(request,response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        KhachHang kh = new KhachHang();
        String id = request.getParameter("id");
        kh.setId(id);
        BeanUtils.populate(kh,request.getParameterMap());
        khachHangService.update(kh);
        this.getAll(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        KhachHang kh = new KhachHang();
        BeanUtils.populate(kh,request.getParameterMap());
        khachHangService.add(kh);
        this.getAll(request,response);
    }

}
