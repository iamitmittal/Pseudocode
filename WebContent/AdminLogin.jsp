<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html  >
<head>
  <meta charset="ISO-8859-1">
  <title>Admin Login</title>
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">

</head>
<body>
  
  <section class="content4 cid-stMPFlBuHn" id="content4-e">
    
    
    <div class="container">
        <div class="row justify-content-center">
            <div class="title col-md-12 col-lg-10">
                <h3 class="mbr-section-title mbr-fonts-style align-center mb-4 display-2"><strong>Admin Panel</strong></h3>
                
                
            </div>
        </div>
    </div>
</section>

<section class="form4 cid-stMOVD0nUK">

    <div class="container">
        <div class="row content-wrapper justify-content-center">
            <div class="col-lg-3 offset-lg-1 mbr-form" data-form-type="formoid">
                <form action="AdminLoginServlet" method="post" class="mbr-form form-with-styler">
                    <div class="dragArea row">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                              <%
								String login_msg=(String)request.getAttribute("error");  
								if(login_msg!=null)
								out.println("<p align= center><font color=red size=4px>"+login_msg+"</font></p>");
								%>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <p class="mbr-text mbr-fonts-style mb-4 display-7">
                                Sign to Admin Panel</p>
                        </div>
                        <div class="col-lg-12 col-md col-12 form-group" data-for="name">
                            <input type="text" name="adminid" placeholder="User-id" class="form-control" >
                        </div>
                        <div class="col-lg-12 col-md col-12 form-group" data-for="email">
                            <input type="password" name="password" placeholder="Password" class="form-control" >
                        </div>
                        <div class="col-12 col-md-auto mbr-section-btn">
                            <button type="submit" class="btn btn-secondary display-4">Submit</button>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12">
                        	<p class="mbr-text mbr-fonts-style mb-4 display-7"><a href="login.jsp">Click here for User login</a></p>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-7 offset-lg-1 col-12">
                <div class="image-wrapper">
                    <img class="w-100" src="assets/images/mbr-5.jpg" alt="Pseudocode">
                </div>
            </div>
        </div>
    </div>
</section>
 
 <section class="footer4 cid-stN1BpmyPY" once="footers" id="footer4-l">

    
    <div class="mbr-overlay" style="opacity: 0.6; background-color: rgb(35, 35, 35);"></div>
    <div class="container">
        <div class="row mbr-white">
            <div class="col-6 col-lg-3">
                <div class="media-wrap col-md-8 col-12">
                    <a href="https://mobiri.se/">
                        <img src="assets/images/mbr-11.jpg" alt="Mobirise">
                    </a>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7">
                    <strong>About</strong>
                </h5>
                <p class="mbr-text mbr-fonts-style mb-4 display-4">A student management system, simply put, is a digital platform enables user to store and track 
<br>the use of online training resources in order to make learning experiences more efficient.&nbsp;</p>
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-3 display-7">
                    <strong>Follow Us</strong>
                </h5>
                <div class="social-row display-7">
                    <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="mbr-iconfont socicon socicon-facebook"></span>
                        </a>
                    </div>
                    <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="mbr-iconfont socicon socicon-twitter"></span>
                        </a>
                    </div>
                    <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="mbr-iconfont socicon socicon-instagram"></span>
                        </a>
                    </div>
                    
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7"><strong>StudentMate Help</strong>
                </h5>
                <ul class="list mbr-fonts-style display-4">
                    <li class="mbr-text item-wrap">Help Center</li>
                    <li class="mbr-text item-wrap">Forums</li>
                    <li class="mbr-text item-wrap">Blogs</li>
                    <li class="mbr-text item-wrap">Our site</li>
                </ul>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7">
                    <strong>Our Vision</strong></h5>
                <ul class="list mbr-fonts-style display-4">
                    <li class="mbr-text item-wrap"><span style="font-size: 1.1rem;">About us</span></li><li class="mbr-text item-wrap"><span style="font-size: 1.1rem;">Founders</span><br></li>
                    <li class="mbr-text item-wrap">Testimonials</li>
                    <li class="mbr-text item-wrap">Address</li>
                </ul>
            </div>
            
        </div>
    </div>
</section><section style="background-color: #fff; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;"><a href="https://mobirise.site/p" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a><p style="flex: 0 0 auto; margin:0; padding-right:1rem;">This <a href="https://mobirise.site/e" style="color:#aaa;">site</a> was built with Mobirise</p></section><script src="assets/web/assets/jquery/jquery.min.js"></script>  <script src="assets/popper/popper.min.js"></script>  <script src="assets/tether/tether.min.js"></script>  <script src="assets/bootstrap/js/bootstrap.min.js"></script>  <script src="assets/smoothscroll/smooth-scroll.js"></script>  <script src="assets/dropdown/js/nav-dropdown.js"></script>  <script src="assets/dropdown/js/navbar-dropdown.js"></script>  <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>  <script src="assets/theme/js/script.js"></script>  
 
</body>
</html>