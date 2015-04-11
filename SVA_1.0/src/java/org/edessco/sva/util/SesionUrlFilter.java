package org.edessco.sva.util;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package org.edessco.sva.util;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author JorgeLuis
// */
//@WebFilter("*.xhtml")
//public class SesionUrlFilter implements Filter{
//    FilterConfig filterConfig;
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig=filterConfig;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest)request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        HttpSession session = req.getSession(true);
//        
//        String requestUrl = req.getRequestURI().toString();
//        
//        //Url permitidas segun rol
//        String [] urlsAdmin = new String[]{
//            "faces/page/administrarCriterio.xhtml",
//            "faces/page/administrarDimension.xhtml",
//            "faces/page/administrarEstandar.xhtml",
//            "faces/page/administrarFactor.xhtml",
//            "faces/page/administrarUniversidad.xhtml",
//            "faces/page/administrarFacultad.xhtml",
//            "faces/page/administrarUnidadAcademica.xhtml",
//        };
//        
//        if(session.getAttribute("nombreUsuario")==null && !requestUrl.contains("login.xhtml")){
//            res.sendRedirect(req.getContextPath()+"/faces/login.xhtml");
//        }else{
//            chain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        
//    }
//    
//}
