package com.crtf.ssm.core.controller;

import com.crtf.ssm.core.model.User;
import com.crtf.ssm.core.service.UserService;
import com.crtf.ssm.util.constant.ConstantQuantity;
import com.crtf.ssm.util.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.Map;

/**
 * @author crtf
 * @version V1.0
 * @className UserController
 * @description
 * @date 21.6.9 16:54
 */
@Controller
@RequestMapping(value = "/user")
@SessionAttributes(value = "s_user")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(User user, HttpSession session, ModelAndView modelAndView) {
        User result = userService.signUp(user);
        if (result != null) {
            session.setAttribute(ConstantQuantity.SESSION_USER, result);
            session.setAttribute("user", result);
            modelAndView.addObject("user", user);
            return "home";
        } else {
            return "sign_up";
        }
    }

    @RequestMapping(value = "/exit")
    public String exit(HttpSession session) {
        session.removeAttribute(ConstantQuantity.SESSION_USER);
        session.removeAttribute("user");
        session.invalidate();
        return "sign_in";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(User user, HttpSession session) {
        User result = userService.signIn(user);
        if (result != null) {
            if (!result.getName().startsWith("crtf")){
                throw new UserNotFoundException();
            }
            session.setAttribute(ConstantQuantity.SESSION_USER, result);
            return "home";
        } else {
            return "sign_in";
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
//    @ResponseStatus(reason = "我错了！",code = HttpStatus.NOT_EXTENDED)
    public String update(@Valid User user, BindingResult result, HttpSession session, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            return "update";
        }
        User sessionUser = (User) session.getAttribute(ConstantQuantity.SESSION_USER);
        user.setId(sessionUser.getId());
        User update = userService.update(user);
        if (update != null) {
            session.setAttribute(ConstantQuantity.SESSION_USER, update);
            return "home";
        }
        return "update";
    }

    @ModelAttribute
    public void addAttribute(ModelAndView modelAndView, Map<String, Object> map) {
        map.put("addAttribute", "addAttribute");
    }

}

