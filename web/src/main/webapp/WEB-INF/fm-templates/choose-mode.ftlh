<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>MyWords</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Ustawienia</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Mój postęp</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tryby nauki</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Przeglądanie</a>
                    <a class="dropdown-item" href="#">Nauka</a>
                    <a class="dropdown-item" href="#">Powtórki</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Welcome to myWords!</h1>
            <p>Witaj w aplikacji do nauki słówek w języku obcym. Jeśli chcesz korzystać z naszej bazy danych możesz od razu rozpocząć naukę.
                Możesz wczytać własny plik ze słowami aby uczyć się własnych słów w dowolnym języku. Miłej zabawy! .</p>
        </div>
    </div>

    <div class="container">
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <h2>Przeglądanie</h2>
                <p>To pierwszy tryb nauki nowych słów. W tym trybie wyświetlimy Ci parę słowo - tłumaczenie. Nie spiesz się i postaraj się zapamiętać dane słowo. W tym trybie będzie ono dostępne tylko raz!</p>
                <p><a class="btn btn-secondary" href="#" role="button">Start &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Nauka</h2>
                <p>To drugi tryb nauki. </p>
                <p><a class="btn btn-secondary" href="#" role="button">Start &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Powtórka</h2>
                <p>To trzeci tryb nauki.</p>
                <p><a class="btn btn-secondary" href="#" role="button">Start &raquo;</a></p>
            </div>
        </div>

        <hr>

    </div> <!-- /container -->

</main>

<footer class="container">
    <p>&copy; Inject footer</p>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../../../assets/js/vendor/popper.min.js"></script>
<script src="../../../../dist/js/bootstrap.min.js"></script>
</body>
</html>