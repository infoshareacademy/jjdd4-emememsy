<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="908551710285-0p3j7v2j1okoor79871acul99t3u00gj.apps.googleusercontent.com">

    <title>myWords</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/main">Menu główne<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/progress">Mój postęp</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/management">Ustawienia</a>
            </li>


            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Tryby nauki
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/choose-category?mode=browse-mode">Przeglądanie</a>
                    <a class="dropdown-item" href="/choose-category?mode=learn-mode">Nauka</a>
                    <a class="dropdown-item" href="/choose-category?mode=repeat-mode">Powtórki</a>
                </div>
            </li>
            <li>
                <a class="nav-link" href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/logout">Wyloguj</a>
            </li>
        </ul>
    </div>
</nav>

<h2>myWords - logowanie</h2>
<br>
<div class="g-signin2" data-onsuccess="onSignIn"></div>

<script>
    //google callback. This function will redirect to our login servlet
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId());
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
        console.log('id_token: ' + googleUser.getAuthResponse().id_token);

        //do not post all above info to the server because that is not secure.
        //just send the id_token

        var redirectUrl = 'login';

        //using jquery to post data dynamically
        var form = $('<form action="' + redirectUrl + '" method="post">' +
            '<input type="text" name="id_token" value="' +
            googleUser.getAuthResponse().id_token + '" />' +
            '<input type="text" name="expires_in" value="' +
            googleUser.getAuthResponse().expires_in + '" />' +
            '<input type="text" name="access_token" value="' +
            googleUser.getAuthResponse().access_token + '" />' +
            '</form>');
        $('body').append(form);
        form.submit();
    }

</script>
</body>
</html>