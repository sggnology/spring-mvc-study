package com.springmvcstudy.springmvcstudy.frontcontroller.v2

import com.springmvcstudy.springmvcstudy.frontcontroller.v2.controller.MemberFormControllerV2
import org.springframework.http.HttpStatus
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV2", urlPatterns = ["/font-controller/v2/*"])
class FrontControllerV2: HttpServlet() {
    lateinit var controllerMap: Map<String, ControllerV2>

    init {
        controllerMap = mapOf(Pair("/front-controller/v2/members/new-form", MemberFormControllerV2()))
    }

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val requestURI = req?.requestURI
        val controller = controllerMap[requestURI]

        controller?.process(req,resp)?.render(req, resp)
    }
}