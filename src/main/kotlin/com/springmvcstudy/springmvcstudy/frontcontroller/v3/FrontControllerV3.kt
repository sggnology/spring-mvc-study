package com.springmvcstudy.springmvcstudy.frontcontroller.v3

import com.springmvcstudy.springmvcstudy.frontcontroller.MyView
import com.springmvcstudy.springmvcstudy.frontcontroller.v3.controller.MemberFormControllerV3
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV3", urlPatterns = ["/front-controller/v3/*"])
class FrontControllerV3: HttpServlet() {
    lateinit var controllerMap: Map<String, ControllerV3>

    init {
        controllerMap = mapOf(Pair("/front-controller/v3/members/new-form", MemberFormControllerV3()))
    }

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val uri = req?.requestURI
        val controller = controllerMap[uri]

        val paramMap = createParamMap(req)
        val mv = controller?.process(paramMap)

        val viewName = mv?.viewName
        val myView = viewResolver(viewName!!)

        myView.render(mv.model,req, resp)
    }

    private fun viewResolver(viewName: String): MyView {
        return MyView("/WEB-INF/views/${viewName}.jsp")
    }

    private fun createParamMap(req: HttpServletRequest?): HashMap<String, String>{
        val paramMap: HashMap<String, String> = hashMapOf()

        req?.parameterNames?.iterator()?.forEachRemaining { paramName->
            paramMap[paramName] = req.getParameter(paramName)
        }

        return paramMap

    }
}