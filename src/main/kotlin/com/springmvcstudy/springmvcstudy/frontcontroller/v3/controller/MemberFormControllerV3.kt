package com.springmvcstudy.springmvcstudy.frontcontroller.v3.controller

import com.springmvcstudy.springmvcstudy.frontcontroller.ModelView
import com.springmvcstudy.springmvcstudy.frontcontroller.v3.ControllerV3

class MemberFormControllerV3: ControllerV3 {
    override fun process(paramMap: Map<String, String>): ModelView {
        return ModelView(viewName = "new-form")
    }
}