package com.springmvcstudy.springmvcstudy.frontcontroller.v1

import com.springmvcstudy.springmvcstudy.frontcontroller.v1.controller.MemberFormControllerV1
import java.security.InvalidKeyException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV1", urlPatterns = ["/front-controller/v1/*"])
class FrontControllerV1 : HttpServlet() {
    lateinit var controllerMap: Map<String, ControllerV1>

    init {
        this.controllerMap = mapOf<String, ControllerV1>(Pair("/front-controller/v1/members/new-form", MemberFormControllerV1()))
    }

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val requestURI = req?.requestURI
        val controller = controllerMap[requestURI]

        controller?.process(req, resp)
    }
}