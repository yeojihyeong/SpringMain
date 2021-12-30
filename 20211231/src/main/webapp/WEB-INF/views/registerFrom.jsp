<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Register</title>

<!-- Custom fonts for this template-->
<link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
   rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

   <div class="container">

      <div class="card o-hidden border-0 shadow-lg my-5">
         <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
               <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
               <div class="col-lg-7">
                  <div class="p-5">
                     <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                     </div>
                     <form class="user" action="register.do" onsubmit="return FormCheck()" method="post">
                        <div class="form-group row">
                           <div class="col-sm-6 mb-3 mb-sm-0">
                              <input type="email" class="form-control form-control-user"
                                 id="id" name="id" placeholder="Enter your Email...">
                           </div>
                           <div class="col-sm-6">
                              <button type="button" id="idCheck" class="btn btn-primary btn-user btn-block" onclick="isIdCheck()" value="NO">아이디중복체크</button>                  
                           </div>
                        </div>
                        <div class="form-group row">
                           <div class="col-sm-6 mb-3 mb-sm-0">
                              <input type="password" class="form-control form-control-user"
                                 id="password" name="password" placeholder="Password...">
                           </div>
                           <div class="col-sm-6">
                              <input type="password" class="form-control form-control-user"
                                 id="password1" name="password1" placeholder="Repeat Password">
                           </div>
                        </div>
                        <div class="form-group">
                           <input type="text" class="form-control form-control-user"
                              id="name" name="name" placeholder="Your Name...">
                        </div>
                        <div class="form-group">
                           <input type="text" class="form-control form-control-user"
                              id="tel" name="tel" placeholder="TelePhone....">
                        </div>
                        <div class="form-group">
                           <input type="text" class="form-control form-control-user"
                              id="address" name="address" placeholder="Address...">
                        </div>
                        <button type="submit" class="btn btn-primary btn-user btn-block">Register Account </button>
                        <hr>
                        <a href="main.do" class="btn btn-google btn-user btn-block">
                           <i class="fab fa-google fa-fw"></i> Register with Google
                        </a> <a href="index.html"
                           class="btn btn-facebook btn-user btn-block"> <i
                           class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                        </a>
                     </form>
                     <hr>
                     <div class="text-center">
                        <a class="small" href="forgot-password.html">Forgot
                           Password?</a>
                     </div>
                     <div class="text-center">
                        <a class="small" href="loginForm.do">Already have an account? Login!</a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>

   <!-- Bootstrap core JavaScript-->
   <script src="resources/vendor/jquery/jquery.min.js"></script>
   <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

   <!-- Core plugin JavaScript-->
   <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

   <!-- Custom scripts for all pages-->
   <script src="resources/js/sb-admin-2.min.js"></script>



   <script type="text/javascript">
      function isIdCheck() {
         var id = $("#id").val();
         if(id != ''){
            //ajax
            $.ajax({
               url : "ajaxIsIdCheck.do",
               type : "post",
               data : {"id" : id},
               success : function (result) {
                  console.log(result);
                  var b = (result === true); //넘어오는 값을 boolean타입으로 변경 0=false, 1=true
                  console.log(b);
                  if(b != false){
                     alert("사용가능한 아이디 입니다!!!!!");
                     $("#idCheck").val("YES");
                     $("#idCheck").prop("disabled",true);
                     /* $("#idCheck").hide(); */
                     $("#password").focus();   
         
                  }else{
                     alert("사용중인 아이디 입니다!!!!!");
                     $("#id").val('');
                     $("#id").focus();
                  }   
               }
                
            });
         }else{
            alert("ID를 입력하세요X_X_X_X");
            $("#id").focus();
         }
      }
   </script>
</body>
</html>