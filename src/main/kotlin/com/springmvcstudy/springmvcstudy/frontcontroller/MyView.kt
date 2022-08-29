package com.springmvcstudy.springmvcstudy.frontcontroller

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class MyView(private var viewPath: String) {
    fun render(req: HttpServletRequest?, res: HttpServletResponse?){
        val dispatcher = req?.getRequestDispatcher(viewPath)
        dispatcher?.forward(req, res)
    }

    fun render(model: Map<String, Any>, req: HttpServletRequest?, res: HttpServletResponse?){
        modelToRequestAttribute(model, req)
        render(req, res)
    }

    private fun modelToRequestAttribute(model: Map<String, Any>, req: HttpServletRequest?){
        model.forEach(req!!::setAttribute)
    }
}