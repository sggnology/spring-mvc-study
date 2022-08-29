package com.springmvcstudy.springmvcstudy.frontcontroller

data class ModelView(
    var viewName: String,
    var model: HashMap<String, Any> = hashMapOf()
){

}
