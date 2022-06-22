package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoGroup;
import dao.DaoShop;
import model.ModelGroup;
import model.ModelShop;

public class ControllerShop extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		String uri = getUri(req);
		
		switch (uri) {
			case "/add":
				try {
					req.setAttribute("grouplist", DaoGroup.getList());
				} catch (Exception e) {
					e.printStackTrace();
				}
				dispatcher = req.getRequestDispatcher("/Shop/add.jsp");
				break;			
			default:
				dispatcher = req.getRequestDispatcher("/Shop/index.jsp");
				break;				
		}

        dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		String uri = getUri(req);

		switch (uri) {
			case "/add":
				try {
					
					
					ModelShop shop = new ModelShop(req.getParameter("name"));

					System.out.println(req.getParameter("groupcheck"));


					if (req.getParameter("groupcheck").equals("checked")) {
						System.out.println(req.getParameter("groupselect"));
						
						shop.setGroupId(req.getParameter("groupselect"));
						if (shop.getGroupId().equals("create")) {
							shop.setGroupId(UUID.randomUUID().toString());
						}
						
						ModelGroup group = new ModelGroup(shop);
						DaoGroup.add(group);
					}

					DaoShop.add(shop);
					
					resp.sendRedirect("../shop");
					return;
				} catch (Exception e) {
					e.printStackTrace();
					
					try{
						req.setAttribute("grouplist", DaoGroup.getList());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					dispatcher = req.getRequestDispatcher("/Shop/add.jsp");
				}

				break;			
			default:
				dispatcher = req.getRequestDispatcher("/Shop/index.jsp");
				break;				
		}

        dispatcher.forward(req, resp);
	}
	
	private String getUri(HttpServletRequest req) {
		return req.getRequestURI().replaceAll("/CreateSchedule/shop", "");
	}
}
