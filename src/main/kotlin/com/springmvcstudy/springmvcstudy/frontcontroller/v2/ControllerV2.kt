package com.springmvcstudy.springmvcstudy.frontcontroller.v2

import com.springmvcstudy.springmvcstudy.frontcontroller.MyView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface ControllerV2 {
    fun process(req: HttpServletRequest?, res: HttpServletResponse?): MyView
}