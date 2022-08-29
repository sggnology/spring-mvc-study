package com.springmvcstudy.springmvcstudy.frontcontroller.v3

import com.springmvcstudy.springmvcstudy.frontcontroller.ModelView

interface ControllerV3 {
    fun process(paramMap :Map<String, String>): ModelView
}