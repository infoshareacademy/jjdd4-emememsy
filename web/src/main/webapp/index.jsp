<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="908551710285-0p3j7v2j1okoor79871acul99t3u00gj.apps.googleusercontent.com">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <title>myWords</title>

    <style type="text/css">
        form.google {
            display: none;
        }
        .banner {
            text-align: center;
        }
        .google {
            width: 100px;
            margin: 0 auto;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/main">Menu główne<span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Statystyki
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/progress">Postęp</a>
                    <a class="dropdown-item" href="/mail-report">Wyslij raport</a>
                </div>
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
                <a class="nav-link" href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://emememsy.jjdd4.is-academy.pl/logout">Wyloguj</a>
            </li>
        </ul>
    </div>
</nav>


<div class="jumbotron">
<div class="container banner">
    <h3 class="display-3">Witaj w myWords!</h3>
    <h5>Zaloguj się aby rozpocząć naukę. Miłej zabawy!</h5>
</div>
</div>

<div class="google">
    <br/>
    <div class="g-signin2" data-onsuccess="onSignIn"></div>
<br>

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
        var form = $('<form class="google" action="' + redirectUrl + '" method="post">' +
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
</div>


</body>
</html>