import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
public class cookie_demo extends HttpServlet
{
    public void doGet(HttpServletRequest req ,HttpServletResponse res) throws ServletException , IOException
    {
        res.setContentType("text/html");
       
        String name=req.getParameter("tf1");
        String value=req.getParameter("tf2");
        Cookie ck =new Cookie(name, value);
        res.addCookie(ck);
         PrintWriter pw=res.getWriter();
        pw.print("<html>");
        pw.print("<body>");
        pw.print("<h1><i>cookie created successfully</i></h1>");
        pw.print("</body>");
        pw.print("</html>");
        pw.close();
    }
}