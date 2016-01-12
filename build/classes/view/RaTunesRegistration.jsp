<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
    <meta charset="UTF-8" />
    <title>RaTunes Login</title>
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="/css/demoRegistration.css" />
    <link rel="stylesheet" type="text/css" href="/css/style2.css" />
    <link rel="stylesheet" type="text/css" href="/css/animate-custom.css" />
    <link rel="stylesheet" href="/scss/style.css">
    <link rel="icon" href="/images/RaTunesIcon.png" type="image/png" />
    <script type="text/javascript" src="/js/validatePassword.js"></script>
    <script type="text/javascript" src="/js/jquery-2.1.4.js"></script>

</head>
<title>RaTunes Login</title>
<body style="font-family: Arial;" class="registrationBackground">
<div class="container">
    <div class="center">
        <a class="logoContain" href="RaTunesRegistration.jsp"></a>
    </div>
    <header>

    </header>
    <section>
        <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form method="post" action="/LoginController" autocomplete="on">
                        <h1>Log in</h1>
                        <p>
                            <label for="username" class="uname"> Your username </label>
                            <input id="username" name="username" required="required" type="text" placeholder="myusername"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" />
                        </p>
                        <p class="login button">
                            <input type="submit" value="Login" />
                        </p>
                        <p class="change_link">
                             Unregistered?
                            <a href="#toregister" class="to_register">Join us</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form method="post" action="/RegistrationController" autocomplete="on"  onSubmit="return validatePassword()">
                        <h1> Sign up </h1>
                        <p>
                            <label for="usernamesignup" class="uname">Your username</label>
                            <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                        </p>
                        <p>
                            <label for="emailsignup" class="youmail"> Your email</label>
                            <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com"/>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd">Your password </label>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd">Please confirm your password </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                            <div id="passwordMessage" class="red"></div>
                        </p>
                        <p class="signin button">
                            <input type="submit" onclick="validatePassword()" value="Sign up">
                        </p>
                        <p class="change_link">
                            already registered?
                            <a href="#tologin" class="to_register"> Go and log in </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
</body>
</html>