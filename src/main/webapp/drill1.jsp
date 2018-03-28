<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/28/18
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
String username = request.getParameter("username");

    if(username == null){
    username = "user";
    }

%>
<html>
<head>
    <title>drill1</title>
</head>
<body>
<div class="login-box">
    <div class="login-logo">
        <a href="http://www.gygproductions.com/"><img src="resources/img/DJ-Gonzo-Logo_website.png"></a>
    </div><!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        <form action="/name" method="post" accept-charset="utf-8">
            <div class="form-group has-feedback">
                <input type="text" name="username" value="" placeholder="Username" class="form-control" id="login" maxlength="80" size="30">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                <span><font color="red"></font></span>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <div class="icheckbox_square-blue" aria-checked="false" aria-disabled="false" style="position: relative;">
                                <input type="checkbox" name="remember" value="" id="remember" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"
                                ><ins class="iCheck-helper" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
                            </div> <label for="remember" class="">Remember me</label>
                        </label>
                    </div>
                </div><!-- /.col -->
                <div class="col-xs-4">
                    <input type="submit" name="submit" value="Sign In" id="submit" class="btn btn-primary btn-block btn-flat">            </div><!-- /.col -->
            </div>
        </form>        <a href="http://myadcubes.com/user/auth/forgot_password">I forgot my password</a><br>
        <a href="http://myadcubes.com/user/auth/register/" class="text-center">Register a new membership</a>
    </div><!-- /.login-box-body -->
</div>

</body>
</html>
