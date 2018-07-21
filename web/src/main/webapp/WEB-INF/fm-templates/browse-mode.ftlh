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
</head>
<body>

<!--   inject navbar here  -->
    <#include "macros/navbar.ftlh">
<main role="main">
    <div class="jumbotron">
        <!--   inject banner here  -->
        <#include "macros/browse-banner.ftlh">
    </div>
    <div class="container">
        <#if singleWord?? >
            <div class="row">
                <h2>
                    <div class="col-md-4"><h2>${singleWord.word}</div>
                </h2>
                <div class="col-md-3"></div>
                <h2>
                    <div class="col-md-4">${singleWord.translation}</div>
                </h2>
                <div class="col-md-3"></div>
            </div>
        <#else>
            <h2>Nie ma więcej słów dostępnych w kategorii ${category} trybie przeglądania. Zmień kategorię lub przejdź
                do innego trybu.</h2>
        </#if>
        <br/><br/><br/>
        <div class="row">
            <div class="col-md-4">
                <p><a class="btn btn-outline-primary btn-lg" href="/${mode}?category=${category}&mode=${mode}"
                      role="button">Następne słowo</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-success btn-lg" href="/choose-category?mode=${mode}" role="button">Zmień
                    kategorię</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-danger btn-lg" href="/main" role="button">Main menu</a></p>
            </div>
        </div>
    </div>
</main>

<footer class="container fixed-bottom">
    <hr>
    <#include "macros/copyright-footer.ftlh">
</footer>
</body>
</html>