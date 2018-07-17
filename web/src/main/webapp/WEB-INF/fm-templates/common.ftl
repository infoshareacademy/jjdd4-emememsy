<#macro myWords>
    <!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>MyWords</title>
</head>
    <body>
    <!-- header section -->
    <div class="container">
        <h1 class="display-3">Welcome to myWords!</h1>
        <p>Witaj w aplikacji do nauki słówek w języku obcym. Jeśli chcesz korzystać z naszej bazy danych możesz od razu rozpocząć naukę.
            Możesz wczytać własny plik ze słowami aby uczyć się własnych słów w dowolnym języku. Miłej zabawy! .</p>
    </div>

    <#nested/>
    <!-- footer section -->
    </body></html>
</#macro>