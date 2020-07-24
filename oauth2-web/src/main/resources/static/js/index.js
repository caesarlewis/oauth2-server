/**
 * Created by YL on 2017/6/27.
 */

var title = document.getElementById("loginTitle");
var vfc = document.getElementById("vfcLi");
var useridLi = document.getElementById("useridLi");
var userLogin = document.getElementById("useridLogin");
var userLogin = document.getElementById("login_container");
var m=0;

$("#vfcLi").click(function(){
    $("#useridLi").addClass("li-active").css("background","#5c7594").css("color","#fff");
    $(this).removeClass("li-active").css("color","#5c7594");
    $("#useridLogin").css("display","none");
    $("#login_container").css("display","block");
    $("#login").css("background","#fff");
});

$("#useridLi").click(function(){
    $("#vfcLi").addClass("li-active");
    $(this).removeClass("li-active").css("background","");
    $("#login_container").css("display","none");
    $("#useridLogin").css("display","block");
    $("#login").removeAttr("style");
});


$("#useridLi").mouseenter(function(){
    $(this).css("color","#ea5404");
});
$("#useridLi").mouseout(function(){
    $(this).css("color","#fff");
});

$("#vfcLi").mouseenter(function(){
    $(this).css("color","#ea5404");
});
$("#vfcLi").mouseout(function(){
    $(this).css("color","#5c7594");
});