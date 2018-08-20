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
                <#include "macros/repeat-banner.ftlh">
    </div>

    <div class="container">
    <#if singleWord?? >
        <h1>Czy znasz tłumaczenie słowa: ${singleWord.word} ?</h1>
        <br/><br/><br/>
        <div class="row">
            <div class="col-md-4">
                <p><a class="btn btn-outline-primary btn-lg"
                      href="/translation-repeat?mode=${mode}&category=${category}&word=${singleWord.word}&translation=${singleWord.translation}"
                      role="button">Sprawdź odpowiedź<br/>i oceń się!</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-success btn-lg" href="/choose-category?mode=${mode}"
                      role="button">Zmień kategorię</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-danger btn-lg" href="/main" role="button">Menu główne</a>
                </p>
            </div>
        </div>

    <#else>
        <h2>Nie ma więcej słów dostępnych w kategorii ${category} trybie powtórek. Zmień kategorię lub
            tryb.</h2>
        <br/><br/><br/>
        <div class="row">
            <div class="col-md-4">
                <p><a class="btn btn-outline-success btn-lg" href="/choose-category?mode=${mode}"
                      role="button">Zmień kategorię</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-danger btn-lg" href="/main" role="button">Menu główne</a></p>
            </div>
        </div>
    </#if>
    </div>
</main>

<footer class="container fixed-bottom footer">
    <hr>
    <#include "macros/copyright-footer.ftlh">
</footer>

</body>
</html>