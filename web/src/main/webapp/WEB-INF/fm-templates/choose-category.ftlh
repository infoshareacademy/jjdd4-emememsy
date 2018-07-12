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

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/main">Home <span class="sr-only">(current)</span></a>
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
        <h2>Jesteś w trybie ${mode}</h2>

        <p><a class="btn btn-secondary" href="/choose-category?category=wszystkie" role="button">Wszystkie</a></p>
        <#list categories>
            <#items as category>
                <p><a class="btn btn-secondary" href="#" role="button">${category}</a></p>
            </#items>
        </#list>
            // for each /nowy-servlet?category=XXXXXXXX&mode=XXXXX
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