<%--
  Created by IntelliJ IDEA.
  User: gavin
  Date: 16-11-2
  Time: 下午1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- header section start-->
<div id="indexHeader" class="header-section">
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    <!--toggle button start-->
    <a class="toggle-btn"><i class="fa fa-bars"></i></a>
    <!--toggle button end-->

    <!--search start-->
    <%--<form class="searchform" action="${pageContext.request.contextPath}/WEB-INF/pages/index.jsp" method="post">--%>
    <%--<input type="text" class="form-control" name="keyword" placeholder="Search here..." />--%>
    <%--</form>--%>
    <!--search end-->

    <!--notification menu start -->
    <div class="menu-right">
        <ul class="notification-menu">
            <%--<li>--%>
            <%--<a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">--%>
            <%--<i class="fa fa-tasks"></i>--%>
            <%--<span class="badge">8</span>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-head pull-right">--%>
            <%--<h5 class="title">You have 8 pending task</h5>--%>
            <%--<ul class="dropdown-list user-list">--%>
            <%--<li class="new">--%>
            <%--<a href="#">--%>
            <%--<div class="task-info">--%>
            <%--<div>Database update</div>--%>
            <%--</div>--%>
            <%--<div class="progress progress-striped">--%>
            <%--<div style="width: 40%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-warning">--%>
            <%--<span class="">40%</span>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li class="new">--%>
            <%--<a href="#">--%>
            <%--<div class="task-info">--%>
            <%--<div>Dashboard done</div>--%>
            <%--</div>--%>
            <%--<div class="progress progress-striped">--%>
            <%--<div style="width: 90%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="90" role="progressbar" class="progress-bar progress-bar-success">--%>
            <%--<span class="">90%</span>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="#">--%>
            <%--<div class="task-info">--%>
            <%--<div>Web Development</div>--%>
            <%--</div>--%>
            <%--<div class="progress progress-striped">--%>
            <%--<div style="width: 66%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="66" role="progressbar" class="progress-bar progress-bar-info">--%>
            <%--<span class="">66% </span>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="#">--%>
            <%--<div class="task-info">--%>
            <%--<div>Mobile App</div>--%>
            <%--</div>--%>
            <%--<div class="progress progress-striped">--%>
            <%--<div style="width: 33%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="33" role="progressbar" class="progress-bar progress-bar-danger">--%>
            <%--<span class="">33% </span>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="#">--%>
            <%--<div class="task-info">--%>
            <%--<div>Issues fixed</div>--%>
            <%--</div>--%>
            <%--<div class="progress progress-striped">--%>
            <%--<div style="width: 80%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="80" role="progressbar" class="progress-bar">--%>
            <%--<span class="">80% </span>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li class="new"><a href="">See All Pending Task</a></li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">--%>
            <%--<i class="fa fa-envelope-o"></i>--%>
            <%--<span class="badge">5</span>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-head pull-right">--%>
            <%--<h5 class="title">You have 5 Mails </h5>--%>
            <%--<ul class="dropdown-list normal-list">--%>
            <%--<li class="new">--%>
            <%--<a href="">--%>
            <%--<span class="thumb"><img src="${pageContext.request.contextPath}/frame/images/photos/user1.png" alt="" /></span>--%>
            <%--<span class="desc">--%>
            <%--<span class="name">John Doe <span class="badge badge-success">new</span></span>--%>
            <%--<span class="msg">Lorem ipsum dolor sit amet...</span>--%>
            <%--</span>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="">--%>
            <%--<span class="thumb"><img src="${pageContext.request.contextPath}/frame/images/photos/user2.png" alt="" /></span>--%>
            <%--<span class="desc">--%>
            <%--<span class="name">Jonathan Smith</span>--%>
            <%--<span class="msg">Lorem ipsum dolor sit amet...</span>--%>
            <%--</span>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="">--%>
            <%--<span class="thumb"><img src="${pageContext.request.contextPath}/frame/images/photos/user3.png" alt="" /></span>--%>
            <%--<span class="desc">--%>
            <%--<span class="name">Jane Doe</span>--%>
            <%--<span class="msg">Lorem ipsum dolor sit amet...</span>--%>
            <%--</span>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="">--%>
            <%--<span class="thumb"><img src="${pageContext.request.contextPath}/frame/images/photos/user4.png" alt="" /></span>--%>
            <%--<span class="desc">--%>
            <%--<span class="name">Mark Henry</span>--%>
            <%--<span class="msg">Lorem ipsum dolor sit amet...</span>--%>
            <%--</span>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="">--%>
            <%--<span class="thumb"><img src="${pageContext.request.contextPath}/frame/images/photos/user5.png" alt="" /></span>--%>
            <%--<span class="desc">--%>
            <%--<span class="name">Jim Doe</span>--%>
            <%--<span class="msg">Lorem ipsum dolor sit amet...</span>--%>
            <%--</span>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li class="new"><a href="">Read All Mails</a></li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">--%>
            <%--<i class="fa fa-bell-o"></i>--%>
            <%--<span class="badge">4</span>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-head pull-right">--%>
            <%--<h5 class="title">Notifications</h5>--%>
            <%--<ul class="dropdown-list normal-list">--%>
            <%--<li class="new">--%>
            <%--<a href="">--%>
            <%--<span class="label label-danger"><i class="fa fa-bolt"></i></span>--%>
            <%--<span class="name">Server #1 overloaded.  </span>--%>
            <%--<em class="small">34 mins</em>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li class="new">--%>
            <%--<a href="">--%>
            <%--<span class="label label-danger"><i class="fa fa-bolt"></i></span>--%>
            <%--<span class="name">Server #3 overloaded.  </span>--%>
            <%--<em class="small">1 hrs</em>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li class="new">--%>
            <%--<a href="">--%>
            <%--<span class="label label-danger"><i class="fa fa-bolt"></i></span>--%>
            <%--<span class="name">Server #5 overloaded.  </span>--%>
            <%--<em class="small">4 hrs</em>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li class="new">--%>
            <%--<a href="">--%>
            <%--<span class="label label-danger"><i class="fa fa-bolt"></i></span>--%>
            <%--<span class="name">Server #31 overloaded.  </span>--%>
            <%--<em class="small">4 hrs</em>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--<li class="new"><a href="">See All Notifications</a></li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <%--</li>--%>
            <li>
                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <img src="${pageContext.request.contextPath}/frame/images/photos/user-avatar.png" alt=""/>
                    <shiro:user>
                        <shiro:principal property="username"></shiro:principal>，
                    </shiro:user>
                    您好！
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                    <li><a data-toggle="modal" data-target="#ownModal"><i class="fa fa-cog"></i>修改密码</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout.do"><i class="fa fa-sign-out"></i>退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!--notification menu end -->
</div>
<!-- header section end-->
<%--
<form id="myPwForm" class="form-signin validateForm" action="${pageContext.request.contextPath}/sys/updPw.do" method="post">
--%>
<div aria-hidden="true" aria-labelledby="ownModalLabel" role="dialog" tabindex="-1" id="ownModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div style="background: #424f63; width: 100%;height: 100%;margin: 0px;padding: 0px;">
                <div class="login-wrap form-signin">
                    <h4 class="lead text-center">修改密码</h4>
                    <input id="oldPw" type="password" name="password" placeholder="原密码" class="form-control" value=""
                           onblur="confirmOPw()" required>
                    <input id="new_pw" type="password" name="new_pw" placeholder="新密码" class="form-control" required>
                    <input id="re_pw" type="password" name="re_pw" placeholder="确认密码" class="form-control" required>

                    <button onclick="checkInfo()" type="button" class="btn btn-lg btn-login btn-block">
                        <i class="fa fa-check"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<%--</form>--%>