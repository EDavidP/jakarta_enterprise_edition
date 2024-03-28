package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.IEJBPublications;
import beans.IEJBResearchers;
import book.Publication;
import book.Researcher;


@WebServlet("/webaccess")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IEJBPublications managePublications;
    @EJB
    private IEJBResearchers manageResearchers;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<String> field1List = managePublications.getInfotmationAboutPublications().stream().map(Publication::getTitle).collect(Collectors.toList());
        List<String> field2List = manageResearchers.getInfotmationAboutResearchers().stream().map(Researcher::getName).collect(Collectors.toList());
        
        request.setAttribute("publications", field1List);
        request.setAttribute("researchers", field2List);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}