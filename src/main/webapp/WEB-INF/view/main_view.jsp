<!ECOTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>WorkSpace</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <style>
    @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
    *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }
    body{
      height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 10px;
            background: linear-gradient(135deg, #ee7752, #e73c7e, #6d23d5, #234ad5);
            background-size: 400% 400%;
            animation: gradient 15s ease infinite;
    }
    @keyframes gradient {
        	0% {
        		background-position: 0% 50%;
        	}
        	50% {
        		background-position: 100% 50%;
        	}
        	100% {
        		background-position: 0% 50%;
        	}
        }
    ::selection{
      background: #fa4299;
      color: #fff;
    }
    .wrapper{
      overflow: hidden;
      max-width: 390px;
      background: #fff;
      padding: 30px;
      border-radius: 5px;
      box-shadow: 0px 15px 20px rgba(0,0,0,0.1);
    }
    .wrapper .title-text{
      display: flex;
      width: 200%;
    }
    .wrapper .title{
      width: 50%;
      font-size: 35px;
      font-weight: 600;
      text-align: center;
      transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
    }
    .wrapper .slide-controls{
      position: relative;
      display: flex;
      height: 50px;
      width: 100%;
      overflow: hidden;
      margin: 30px 0 10px 0;
      justify-content: space-between;
      border: 1px solid lightgrey;
      border-radius: 5px;
    }
    .slide-controls .slide{
      height: 100%;
      width: 100%;
      color: #fff;
      font-size: 18px;
      font-weight: 500;
      text-align: center;
      line-height: 48px;
      cursor: pointer;
      z-index: 1;
      transition: all 0.6s ease;
    }
    .slide-controls label.signup{
      color: #000;
    }
    .slide-controls .slider-tab{
      position: absolute;
      height: 100%;
      width: 50%;
      left: 0;
      z-index: 0;
      border-radius: 5px;
      background: -webkit-linear-gradient(left, #a445b2, #fa4299);
      transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
    }
    input[type="radio"]{
      display: none;
    }
    #signup:checked ~ .slider-tab{
      left: 50%;
    }
    #signup:checked ~ label.signup{
      color: #fff;
      cursor: default;
      user-select: none;
    }
    #signup:checked ~ label.login{
      color: #000;
    }
    #login:checked ~ label.signup{
      color: #000;
    }
    #login:checked ~ label.login{
      cursor: default;
      user-select: none;
    }
    .wrapper .form-container{
      width: 100%;
      overflow: hidden;
    }
    .form-container .form-inner{
      display: flex;
      width: 200%;
    }
    .form-container .form-inner form{
      width: 50%;
      transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
    }
    .form-inner form .field{
      height: 50px;
      width: 100%;
      margin-top: 20px;
    }
    .form-inner form .field input{
      height: 100%;
      width: 100%;
      outline: none;
      padding-left: 15px;
      border-radius: 5px;
      border: 1px solid lightgrey;
      border-bottom-width: 2px;
      font-size: 17px;
      transition: all 0.3s ease;
    }
    .form-inner form .field input:focus{
      border-color: #fc83bb;
      /* box-shadow: inset 0 0 3px #fb6aae; */
    }
    .form-inner form .field input::placeholder{
      color: #999;
      transition: all 0.3s ease;
    }
    form .field input:focus::placeholder{
      color: #b3b3b3;
    }
    .form-inner form .pass-link{
      margin-top: 5px;
    }
    .form-inner form .signup-link{
      text-align: center;
      margin-top: 30px;
    }
    .form-inner form .pass-link a,
    .form-inner form .signup-link a{
      color: #fa4299;
      text-decoration: none;
    }
    .form-inner form .pass-link a:hover,
    .form-inner form .signup-link a:hover{
      text-decoration: underline;
    }
    form .btn{
      height: 50px;
      width: 100%;
      border-radius: 5px;
      position: relative;
      overflow: hidden;
    }
    form .btn .btn-layer{
      height: 100%;
      width: 300%;
      position: absolute;
      left: -100%;
      background: -webkit-linear-gradient(right, #a445b2, #fa4299, #a445b2, #fa4299);
      border-radius: 5px;
      transition: all 0.4s ease;;
    }
    form .btn:hover .btn-layer{
      left: 0;
    }
    form .btn input[type="submit"]{
      height: 100%;
      width: 100%;
      z-index: 1;
      position: relative;
      background: none;
      border: none;
      color: #fff;
      padding-left: 0;
      border-radius: 5px;
      font-size: 20px;
      font-weight: 500;
      cursor: pointer;
    }
    form .user-details .user-title{
          font-size: 20px;
          font-weight: 500;
         }
         form .category{
           display: flex;
           width: 80%;
           margin: 14px 0 ;
           justify-content: space-between;
         }
         form .category label{
           display: flex;
           align-items: center;
           cursor: pointer;
         }
         form .category label .dot{
          height: 18px;
          width: 18px;
          border-radius: 50%;
          margin-right: 10px;
          background: #d9d9d9;
          border: 5px solid transparent;
          transition: all 0.3s ease;
        }
         #dot-1:checked ~ .category label .one,
         #dot-2:checked ~ .category label .two{
           background: #9b59b6;
           border-color: #d9d9d9;
         }
         form input[type="radio"]{
           display: none;
         }
    </style>
   </head>
   <body>
      <div class="wrapper">
         <div class="title-text">
            <div class="title login">
               WorkSpace
            </div>
            <div class="title signup">
               Join Now
            </div>
         </div>
         <div class="form-container">
            <div class="slide-controls">
               <input type="radio" name="slide" id="login" checked>
               <input type="radio" name="slide" id="signup">
               <label for="login" class="slide login">Login</label>
               <label for="signup" class="slide signup">Register</label>
               <div class="slider-tab"></div>
            </div>
            <div class="form-inner">
               <form action="employee/home" class="login">
                  <div class="field btn" style="margin-top:25px;">
                      <div class="btn-layer">
                          <a href="/employee/login"><font color="white" size="+3"> &emsp;&emsp;&nbsp;As Employee</font></a>
                      </div>
                  </div>
                  <div class="field btn" style="margin-top:35px;">
                      <div class="btn-layer">
                          <a href="/company/login"><font color="white" size="+3"> &emsp;&emsp;&nbsp;As Company</font></a>
                      </div>
                  </div>
                  <div class="pass-link">
                      <a href="#">Forgot password?</a>
                  </div>
               </form>
               <form action="#" class="signup">
               <div class="user-details">
                  <span class="user-title"> I want to become a member of WorkSpace as </span><br></>
                  <div class="field btn" style="margin-top:20px;">
                      <div class="btn-layer">
                        <a href="/employee/registration"><font color="white" size="+3"> &emsp;&emsp;&nbsp; Employee</font></a>
                      </div>
                  </div>
                  <div class="field btn" style="margin-top:30px;">
                      <div class="btn-layer">
                        <a href="/company/registration"><font color="white" size="+3"> &emsp;&emsp;&nbsp; Company</font></a>
                      </div>
                  </div>
               </form>
            </div>
         </div>
      </div>
      <script>
         const loginText = document.querySelector(".title-text .login");
         const loginForm = document.querySelector("form.login");
         const loginBtn = document.querySelector("label.login");
         const signupBtn = document.querySelector("label.signup");
         const signupLink = document.querySelector("form .signup-link a");
         signupBtn.onclick = (()=>{
           loginForm.style.marginLeft = "-50%";
           loginText.style.marginLeft = "-50%";
         });
         loginBtn.onclick = (()=>{
           loginForm.style.marginLeft = "0%";
           loginText.style.marginLeft = "0%";
         });
         signupLink.onclick = (()=>{
           signupBtn.click();
           return false;
         });
      </script>
   </body>
</html>