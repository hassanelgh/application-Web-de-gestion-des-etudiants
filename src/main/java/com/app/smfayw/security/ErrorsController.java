package com.app.smfayw.security;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorsController implements ErrorController {
    @GetMapping("/error")
    public String error(Model model,HttpServletRequest httpRequest){
        String errorMsg = "";
        int httpErrorCode = (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
        switch (httpErrorCode) {
            case 400: {errorMsg = "Http Error Code: 400. Bad Request";break;}
            case 401: {errorMsg = "Http Error Code: 401. Unauthorized";break;}
            case 403: {errorMsg = "Http Error Code: 403. Forbidden";break;}
            case 404: {errorMsg = "Http Error Code: 404. Resource not found";break;}
            case 405: {errorMsg = "Http Error Code: 405. Method Not Allowed";break;}
            case 500: {errorMsg = "Http Error Code: 500. Internal Server Error";break;}
        }
        model.addAttribute("errorMsg",errorMsg);
        model.addAttribute("status",httpErrorCode);
        return "ErrorPage";
    }

}
