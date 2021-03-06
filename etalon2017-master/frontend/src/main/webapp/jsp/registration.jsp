<%--
  Created by IntelliJ IDEA.
  User: anpi0316
  Date: 06.10.2017
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="/jsp/blocks/header.jsp"/>

<div class="container">
    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Registration page"/>
    </jsp:include>
</div>

<div class="container">
    <div id="loginbox" style="margin-top:50px;margin-left: 25%;"
         class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="card card.text-white.bg-info">
            <div class="card-header">
                <div class="card-title">Registration</div>
            </div>
            <div style="padding-top:30px" class="panel-body">

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form id="loginform" class="form-horizontal" role="form">
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="fa " aria-hidden="true"></i></span>
                        <select>
                            <option value="1">Head Of Practice</option>
                            <option value="2">Student</option>
                        </select>
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                        <input  id="login-username" type="text" class="form-control" name="username" value=""
                                placeholder="Email">
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                        <input id="login-password" type="password" class="form-control" name="password"
                               placeholder="Password">
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                        <input id="rep-password" type="password" class="form-control" name="password"
                               placeholder="Confirm Password">
                    </div>

                    <div style="margin-top:10px" class="form-group">
                        <!-- Button -->

                        <div class="col-sm-12 controls">
                            <%--<a id="btn-fblogin" href="#" class="btn btn-primary"--%>
                            <%--onclick="window.location='systemStudentPanelView.jsp'">Login</a>--%>

                            <a id="btn-fblogin" href="/students/showAll" class="btn btn-primary">Submit</a>
                            <%--<a id="btn-fblogin" href="/faculty/createSpecialtyModal" class="btn btn-primary">Registration</a>--%>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>

