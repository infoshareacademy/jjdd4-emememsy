<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <title>MyWords</title>
    <style type="text/css">
        .banner {
            text-align: center;
        }
        .footer{
            background: white;
        }
    </style>
</head>
<body>

<!--   inject navbar here  -->
    <#include "macros/navbar.ftlh">

<main role="main">

    <div class="jumbotron banner">
        <!--   inject banner here  -->
                <#include "macros/error-banner.ftlh">
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h2>Przeglądanie</h2>
                <p>To pierwszy tryb nauki nowych słów. W tym trybie wyświetlimy Ci parę słowo - tłumaczenie. Nie spiesz
                    się i postaraj się zapamiętać dane słowo. W tym trybie będzie ono dostępne tylko raz!</p>
            </div>
            <div class="col-md-4">
                <h2>Nauka</h2>
                <p>To drugi tryb nauki. W tym trybie wyświetlimy słowa, które poznałeś w trybie przeglądania. Dokonuj
                    uczciwie oceny :) </p>
            </div>
            <div class="col-md-4">
                <h2>Powtórka</h2>
                <p>To trzeci i ostatni tryb nauki. Tutaj pojawią się słowa, które już znasz. Możesz zadecydować, czy
                    chcesz je pozostawić aby móc do nich wrócić w przyszłości, czy chcesz je trwale usunąć z
                    programu.</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <p><a class="btn btn-outline-primary btn-lg" href="/choose-category?mode=browse-mode" role="button">Start
                    &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-primary btn-lg" href="/choose-category?mode=learn-mode" role="button">Start
                    &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-primary btn-lg" href="/choose-category?mode=repeat-mode" role="button">Start
                    &raquo;</a></p>
            </div>
        </div>
    </div>
</main>

<footer class="container fixed-bottom footer">
    <hr>
    <#include "macros/copyright-footer.ftlh">
</footer>

</body>
</html>