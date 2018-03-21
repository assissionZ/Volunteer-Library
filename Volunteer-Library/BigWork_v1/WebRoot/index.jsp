 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>

        <!-- meta data & title -->
        <meta charset="utf-8">
        <title>Office</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

	    <!-- CSS -->
	    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300">
	    <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
	    <link href="http://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
	    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
	    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
	    <link rel="stylesheet" href="assets/css/animate.min.css">
	    <link rel="stylesheet" href="assets/css/style.css">
	    <link rel="stylesheet" href="assets/css/list.css">
	    <link href="login-register.css" rel="stylesheet" />
	    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    	
		<!-- JS -->
		<script src="jquery/jquery-1.10.2.js" type="text/javascript"></script>
		<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
		<script src="login-register.js" type="text/javascript"></script>
		<script src="js/register_check.js" type="text/javascript"></script>
		<script src="js/login_again.js" type="text/javascript"></script>
		<script src="js/outputCookie.js" type="text/javascript"></script>
		<script src="js/login_check.js" type="text/javascript"></script>
        
        
    </head>
  
	<body>
    <!-- Header -->
	<%
		session.setAttribute("account", null);
		String user_id = "";
		String password = "";
		Cookie c[] = request.getCookies();
		if(c!=null)
		{
		    for(int i=0;i<c.length;i++)
		   {
		       //从cookie中将account和password获取
		       if(c[i].getName().equals("user_id"))
		    	   user_id = c[i].getValue(); 
		       else if(c[i].getName().equals("password"))
		    	   password = c[i].getValue(); 
		    	  // request.setAttribute("password",c[i].getValue()); 
		   } 
		}
	%>
    <nav id="navbar-section" class="navbar navbar-default navbar-static-top navbar-sticky" role="navigation">
        <div class="container">
        
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand wow fadeInDownBig" href="index.html"><img class="office-logo" src="assets/img/slider/Office.png" alt="Office"></a>      
            </div>
        
            <div id="navbar-spy" class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav pull-right">
                    <li class="active">
                        <a href="index.jsp">主页</a>
                    </li>
                    <li>
                        <a href="about.html">关于</a>
                    </li>
                    <li>
                        <a data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">登录/注册</a>
                    </li>
                </ul>         
            </div>
        </div>
    </nav>
		
		 <div class="modal fade login" id="loginModal">
		      <div class="modal-dialog login animated">
    		      <div class="modal-content">
    		         <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Login with</h4>
                    </div>
                    <div class="modal-body">  
                        <div class="box">
                             <div class="content">
                                <div class="social">
                                    <a class="circle github" href="/auth/wechat">
                                        <i class="fa fa-wechat fa-fw"></i>
                                    </a>
                                    <a id="qq_login" class="circle facebook" href="/auth/qq">
                                        <i class="fa fa-qq fa-fw"></i>
                                    </a>
                                    <a id="weibo_login" class="circle google" href="/auth/weibo">
                                        <i class="fa fa-weibo fa-fw"></i>
                                    </a>
                                </div>
                                <div class="division">
                                    <div class="line l"></div>
                                      <span>or</span>
                                    <div class="line r"></div>
                                </div>
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form method="post" action="LoginServlet" accept-charset="UTF-8">
                                    <input id="user_id_login" class="form-control" type="text" placeholder="学号" name="user_id_login" value=<%=user_id %>>
                                    <input id="password_login" class="form-control" type="password" placeholder="密码" name="password_login" value=<%=password %>>
                                    <input type="checkbox" name="save"><span>记住密码</span>
                                    <input class="btn btn-default btn-login" type="submit" value="登录">
                                    <script type="text/javascript">outputLoginCookie();</script>
                                    </form>
                                </div>
                             </div>
                        </div>
                        
                        <div class="box" id="register_box">
                            <div class="content registerBox" style="display:none;">
                             <div class="form registerBox">
                                <form name="registerForm" method="post" html="{:multipart=>true}" data-remote="true" action="RegisterServlet" accept-charset="UTF-8">
                                <input id="user_id" class="form-control" type="text" placeholder="账号" name="user_id" onblur="check_id()">
                                <span id="check_id_result" name="check_id_result"></span>
                                <input id="user_name" class="form-control" type="text" placeholder="姓名/昵称" name="user_name">
                                <input id="password" class="form-control" type="password" placeholder="密码" name="password">
                                <input id="password_again" class="form-control" type="password" placeholder="请再次输入密码" name="password_again" onblur="check_password()">
								<span id="check_password_result" name="check_password_result"></span>
								<input id="phone" class="form-control" type="text" placeholder="手机号" name="phone" onblur="check_phone()">
                                <span id="check_phone_result" name="check_phone_result"></span>
                                <input id="address" class="form-control" type="text" placeholder="宿舍楼+宿舍号" name="address" onblur="check_address()">
                                <span id="check_address_result" name="check_address_result"></span>
                                <input class="btn btn-default btn-register" type="submit" value="注册" name="commit">
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="forgot login-footer">
                            <span>如果您没有账号请 
                                 <a href="javascript: showRegisterForm();">注册账号</a>
                            </span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                             <span>已经有账号了?</span>
                             <a href="javascript: showLoginForm();">登录</a>
                        </div>
                    </div>        
    		      </div>
		      </div>
		  </div>

    <!-- End Header -->


    <!-- Begin #carousel-section -->
    <section id="carousel-section" class="section-global-wrapper"> 
        <div class="container-fluid-kamn">
            <div class="row">
                <div id="carousel-1" class="carousel slide" data-ride="carousel">

                    <!-- Indicators -->
                    <ol class="carousel-indicators visible-lg">
                        <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-1" data-slide-to="1"></li>
                        <li data-target="#carousel-1" data-slide-to="2"></li>
                    </ol>
        
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <!-- Begin Slide 1 -->
                        <div class="item active">
                            <img src="assets/img/slider/slide2.jpg" height="400" alt="Image of first carousel">
                            <div class="carousel-caption">
                                <h1 class="carousel-title hidden-xs">义工书库</h1>
                                <p class="carousel-body">计软义工 \ ZZP</p>
                            </div>
                        </div>
                        <!-- End Slide 1 -->

                        <!-- Begin Slide 2 -->
                        <div class="item">
                            <img src="assets/img/slider/slide4.jpg" height="400" alt="Image of second carousel">
                            <div class="carousel-caption">
                                <h1 class="carousel-title hidden-xs">义工书库</h1>
                                <p class="carousel-body">计软义工 \ ZZP</p>
                            </div>
                        </div>
                        <!-- End Slide 2 -->

                        <!-- Begin Slide 3 -->
                        <div class="item">
                            <img src="assets/img/slider/slide3.jpg" height="400" alt="Image of third carousel">
                            <div class="carousel-caption">
                                <h1 class="carousel-title hidden-xs">义工书库</h1>
                                <p class="carousel-body">计软义工 \ ZZP</p>
                            </div>
                        </div>
                        <!-- End Slide 3 -->
                    </div>
        
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-1" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-1" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
        </div>
    </section>
    <!-- End #carousel-section --><div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>


    <!-- Begin #services-section -->
    <section id="services" class="services-section section-global-wrapper">
        <div class="container">
            <div class="row">
                <div class="services-header">
                    <h3 class="services-header-title">计软义工</h3>
                    <p class="services-header-body"><em> 用行动传递爱心与热情 </em>  </p><hr>
                </div>
            </div>
      
            <!-- Begin Services Row 1 -->
            <div class="row services-row services-row-head services-row-1">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated fadeInLeft" data-wow-offset="40">
                        <p class="services-icon"><span class="fa fa-hand-o-left fa-5x"></span></p>
                        <h4 class="services-title"><a href="BookListServlet?op=1">申请借书</a></h4>
                        <!--p class="services-body">Cras interdum placerat libero vel tempor. Curabitur gravida iaculis erat quis dignissim.</p-->
                        <!--p class="services-more"><a href="#">Find Out More</a></p-->
                    </div>
                </div>
        
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated zoomIn" data-wow-offset="40">
                        <p class="services-icon"><i class="fa fa-hand-o-right fa-5x"></i></p>
                        <h4 class="services-title"><a href="pre_donate.jsp">申请捐书</a></h4>
                        <!--p class="services-body">Cras interdum placerat libero vel tempor. Curabitur gravida iaculis erat quis dignissim.</p-->
                        <!--p class="services-more"><a href="#">Find Out More</a></p-->
                    </div>
                </div>
        
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated fadeInRight" data-wow-offset="40">
                        <p class="services-icon"><i class="fa  fa-list-ul fa-5x"></i></p>
                        <h4 class="services-title"><a href="BookListServlet?op=0">查看书单</a></h4>
                        <!--p class="services-body">Cras interdum placerat libero vel tempor. Curabitur gravida iaculis erat quis dignissim.</p-->
                        <!--p class="services-more"><a href="#">Find Out More</a></p-->
                    </div>        
                </div>
            </div>
            <!-- End Serivces Row 1 -->
      
            <!-- Begin Services Row 2 -->
            <div class="row services-row services-row-tail services-row-2">
                <div class="col-lg-12 col-md-4 col-sm-4 col-xs-12">
                    <div class="services-group wow animated zoomIn" data-wow-offset="40">
                        <p class="services-icon"><i class="fa fa-eye fa-5x"></i></p>
                        <h4 class="services-title">公告</h4>
                        <p class="services-body">春节节活动将要来袭.</p>
						<p class="services-body">1月U站正在进行中.</p>
                        <p class="services-more"><a href="#">了解更多</a></p>
                    </div>
                </div>
            </div>
            <!-- End Serivces Row 2 -->
    
        </div>      
    </section>
    <!-- End #services-section -->


    <!-- Footer -->
    <footer> 
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3><i class="fa fa-map-marker"></i> 联系我们:</h3>
                    <p class="footer-contact">
                        深圳大学石头坞二楼义工联合会办公室<br>
                        电话: 13811467407<br>
                        邮箱: jryg@163.com<br>
                    </p>
                </div>
                <div class="col-md-4">
                    <h3><i class="fa fa-external-link"></i> 链接</h3>
                    <p> <a href="#"> 关于我们 </a></p>
                    <p> <a href="#"> 留言箱</a></p>
                    <p> <a href="#"> 了解更多</a></p>
                </div>
              <div class="col-md-4">
                <h3><i class="fa fa-heart"></i> 社交</h3>
                <div id="social-icons">
                    <a href="#" class="btn-group google-plus">
                        <i class="fa fa-weixin"></i>
                    </a>
                      <a href="#" class="btn-group linkedin">
                        <i class="fa fa-qq"></i>
                    </a>
                      <a href="#" class="btn-group twitter">
                        <i class="fa fa-weibo"></i>
                    </a>
                      <a href="#" class="btn-group facebook">
                        <i class="fa fa-facebook"></i>
                    </a>
                </div>
              </div>    
        </div>
      </div>
    </footer>

    
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script>
      new WOW().init();
    </script>
  </body>
</html>
