<!ECOTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>WS Company Registration</title>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
    *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins',sans-serif;
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
    .container{
      max-width: 700px;
      max-height: 690px;
      width: 100%;
      height: 100%;
      background-color: #fff;
      padding: 25px 30px;
      border-radius: 5px;
      box-shadow: 0 5px 10px rgba(0,0,0,0.15);
    }
    .container .title{
      font-size: 25px;
      font-weight: 500;
      position: relative;
    }
    .container .title::before{
      content: "";
      position: absolute;
      left: 0;
      bottom: 0;
      height: 3px;
      width: 610px;
      border-radius: 5px;
      background: linear-gradient(45deg, #71b7e6, #9b59b6);
      background-size: 400% 400%;
      animation: gradient 15s ease infinite;
    }
    .content form .user-details{
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      margin: 20px 0 12px 0;
    }
    form .user-details .input-box{
      margin-bottom: 15px;
      width: calc(100% / 2 - 20px);
    }
    form .input-box span.details{
      display: block;
      font-weight: 500;
      margin-bottom: 5px;
    }
    .user-details .input-box input{
      height: 45px;
      width: 100%;
      outline: none;
      font-size: 16px;
      border-radius: 5px;
      padding-left: 15px;
      border: 1px solid #ccc;
      border-bottom-width: 2px;
      transition: all 0.3s ease;
    }
    .user-details .input-box input:focus,
    .user-details .input-box input:valid{
      border-color: #9b59b6;
    }
     form .gender-details .gender-title{
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

     form input[type="radio"]{
       display: none;
     }
     form .button{
       height: 45px;
       margin: 35px 0
     }
     form .button input{
       height: 100%;
       width: 100%;
       border-radius: 5px;
       border: none;
       color: #fff;
       font-size: 18px;
       font-weight: 500;
       letter-spacing: 1px;
       cursor: pointer;
       transition: all 0.3s ease;
       background: linear-gradient(135deg, #71b7e6, #9b59b6);
     }
     form .button input:hover{
      /* transform: scale(0.99); */
      background: linear-gradient(-135deg, #71b7e6, #9b59b6);
      }
     @media(max-width: 584px){
     .container{
      max-width: 100%;
    }
    form .user-details .input-box{
        margin-bottom: 15px;
        width: 100%;
      }
      form .category{
        width: 100%;
      }
      .content form .user-details{
        max-height: 300px;
        overflow-y: scroll;
      }
      .user-details::-webkit-scrollbar{
        width: 5px;
      }
      }
      @media(max-width: 459px){
      .container .content .category{
        flex-direction: column;
      }
    }

    </style>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
<div class="d-flex flex-column justify-content-center w-100 h-100">

	<div class="d-flex flex-column justify-content-center align-items-center">
	<div class="btn-group my-5">
  <div class="container">
    <div class="title">Complete steps to become a part of WorkSpace</div>
    <div class="content">
      <form action="#">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Company Name<font color="red">*</font></span>
            <input type="text" placeholder="WorkSpace" required>
          </div>
          <div class="input-box">
            <span class="details">Email<font color="red">*</font></span>
            <input type="text" placeholder="example@company.com" required>
          </div>
          <div class="input-box">
            <span class="details">Phone </span>
            <input type="text" placeholder="37410548607" required>
          </div>
          <div class="input-box">
            <span class="details">Office Address</span>
            <input type="text" placeholder="Komitas Avenue 50/9" required>
          </div>
          <div class="input-box">
            <span class="details">Specialized in<font color="red">*</font></span>
            <input list="brow" placeholder="Choose category..." required>
            <datalist id="brow">
              <option value="Agriculture/Food/Natural Resources">
              <option value="Architecture/Construction">
              <option value="Education/Training">
              <option value="Administration/Business Management">
              <option value="Arts/Audio/Video Technology">
              <option value="Communications">
              <option value="Finance/Banking">
              <option value="Government/Public Administration">
              <option value="Health/Medicine">
              <option value="Human Services">
              <option value="Software Development">
              <option value="IT other">
              <option value="Hospitality/Tourism">
              <option value="Law">
              <option value="Public Safety/Corrections/Security">
              <option value="Manufacturing">
              <option value="Marketing/Sales/Service">
              <option value="Science/Technology/Engineering">
              <option value="Transportation/Distribution/Logistics">
              <option value="Other">
            </datalist>
          </div>
          <div class="input-box">
                    <span class="details">Gender</span>
                       <input list="gender" placeholder="Male/Female" required>
                         <datalist id="gender">
                            <option value="Male" >
                            <option value="Female" >
                         </datalist>
                  </div>
          <div class="input-box">
            <span class="details">Username<font color="red">*</font></span>
            <input type="text" placeholder="username" required>
          </div>
          <div class="input-box">
            <span class="details">Password<font color="red">**</font></span>
            <input type="text" placeholder="Example08&" required>
          </div>
          <div class="input-box">
            <span class="details">Confirm Password<font color="red">**</font></span>
            <input type="text" placeholder="Confirm your password" required>
          </div>

        </div>

        <div class="button">
          <input type="submit" value="Register"><br><br>
          <p><font color="#A6A19F"><font color="red">*</font>Headings marked with an asterisk indicate that it is required to complete</font></p>
          <p><font color="#A6A19F"><font color="red">**</font>Password must contain at least one upper case, number and special symbol</font></p>
        </div>
      </form>
    </div>
  </div>

</body>
</html>