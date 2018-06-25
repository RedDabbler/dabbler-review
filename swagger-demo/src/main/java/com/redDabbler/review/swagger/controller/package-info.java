package com.redDabbler.review.swagger.controller;

/**
 *
 * http://localhost:8080/swagger-ui.html#/
 *
 * when
 * @RequestMapping("/")
 * public class HelloController {}
 *
 * then return  type=Method Not Allowed, status=405
 *
 * when
 * @RestController
 * @RequestMapping("/test")
 * public class HelloController {
 *
 *  then normal
 *
 *  so the Controller class requestMapping has some root path
 *
 *
 */