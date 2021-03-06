package edu.yale.its.tp.cas.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import edu.yale.its.tp.cas.ticket.*;

/**
 * Lets users explicitly log out from the Central Authentication Servlet.
 */
public class Logout extends HttpServlet {

  //*********************************************************************
  // Constants

  private static final String TGC_ID = "CASTGC";


  //*********************************************************************
  // Private state

  private ServletContext app;
  private GrantorCache tgcCache;
  private String logoutPage;

  //*********************************************************************
  // Initialization 

  public void init(ServletConfig config) throws ServletException {
    // retrieve the context and the caches
    app = config.getServletContext();
    tgcCache = (GrantorCache) app.getAttribute("tgcCache");

    // retrieve a relative URL for the login form
    logoutPage = app.getInitParameter("edu.yale.its.tp.cas.logoutPage");
    if (logoutPage == null)
      throw new ServletException("need edu.yale.its.tp.cas.logoutPage");
  }


  //*********************************************************************
  // Request handling

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // avoid caching (in the stupidly numerous ways we must)
    response.setHeader("pragma", "no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setDateHeader("Expires", 0);

    // see if the user sent us a valid TGC
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals(TGC_ID)) {
          TicketGrantingTicket t =
            (TicketGrantingTicket) tgcCache.getTicket(cookies[i].getValue());
          if (t == null)
            continue;

	  // ticket found!
          tgcCache.deleteTicket(cookies[i].getValue());
          destroyTgc(response);
        }
      }
    }

    // forward to the UI to reassure the user
    app.getRequestDispatcher(logoutPage).forward(request, response);
  }

  /** Destroys the browser's TGC. */
  private void destroyTgc(HttpServletResponse response) {
    Cookie tgcOverwrite = new Cookie(TGC_ID, "destroyed");
    tgcOverwrite.setMaxAge(0);
    response.addCookie(tgcOverwrite);
  }

}
