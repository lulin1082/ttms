<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
				<span class="sr-only">切换导航</span> <span class="icon-bar"></span> 
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img src="images/logo.png"height="100%" /></a>
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a class="icon-bar" href="#">旅游管理系统</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">产品管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li role="separator" class="divider"></li>
						<li><a id="load-project-id">项目信息</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-team-id">团信息</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-type-id">产品分类</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-attachement-id">产品信息</a></li>
					</ul></li>
				<li><a href="#">分销管理</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">系统管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li role="separator" class="divider"></li>
						<li><a id="load-org-id">组织管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-role-id">角色管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-function-id">权限管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-user-id">用户管理</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a  id="tipslogin"  href="toLogin.do?="+Maht.random(1000) >请登录</a></li>
				<li><a  id="welcome">欢迎您,${currentUser.usrname}</a></li>
				<li><a href="/logout.do?t="+Maht.random(1000) >安全退出</a></li>
			</ul>
		</div>
	</div>
</div>




<script type="text/javascript">

	console.log('aaaaaaaaaaaaaa');
	console.info('getStart');
	
    $('#load-project-id').click(function(){
            debugger;
        var url="/project/listUI.do?t="+Math.random(1000);
        $("#container").load(url);
        debugger;
    })
    $('#load-team-id').click(function(){
        debugger;
        var url="team/listUI.do?t="+Math.random(1000);
        $("#container").load(url);
    })
    $('#load-type-id').click(function(){

        debugger;

        var url="productType/listUI.do?t="+Math.random(1000);
        $("#container").load(url);
    })
    $('#load-role-id').click(function(){
        debugger;
        var url="role/listUI.do?t="+Math.random(1000);
        $("#container").load(url);
    })
    $('#load-function-id').click(function(){
        debugger;
        var url="function/listUI.do?t="+Math.random(1000);
        $("#container").load(url);
    })
    $('#load-user-id').click(function(){
        debugger;
        var url="user/listUI.do?t="+Math.random(1000);
        $("#container").load(url);
    })
    $('#load-org-id').click(function(){
        debugger;

        var url="org/ListUI.do?t="+Math.random(1000);
        $("#container").load(url);
    })
	
	$('#load-attachement-id').click(function(){
        debugger;
        var url="attach/uploadUI.do?t="+Math.random(1000);
		$("#container").load(url);
	})

</script>

<%--
/*$('#loin').click(function(){
var url="toLogin.do?t="+Math.random(1000);
$("#modal-dialog .modal-body").load(url,
function(){//加载完成执行此
$(".modal-title").html("请登录");
$("#modal-dialog").modal("show");
})
})*/
/*$(function () {
if(currentUser.username){
$('#login').click(function () {
var url="personl/listUI.do?"+Math.random(1000);
$('#container').load(url);
})
}else{
$('#login').click(function () {
document.location.href='toLogin.do';
})
}
})*/--%>
