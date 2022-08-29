package com.springmvcstudy.springmvcstudy.frontcontroller.v2.controller

import com.springmvcstudy.springmvcstudy.frontcontroller.MyView
import com.springmvcstudy.springmvcstudy.frontcontroller.v2.ControllerV2
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV2: ControllerV2 {
    override fun process(req: HttpServletRequest?, res: HttpServletResponse?): MyView {
        return MyView("/WEB-INF/views/new-form.jsp")
    }
}