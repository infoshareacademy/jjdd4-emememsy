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
        <#include "macros/learn-banner.ftlh">
    </div>

    <div class="container">
        <h1>Poprawne tłumaczenie słowa ${word} to ${translation}.</h1>
        <br/><br/><br/>
        <div class="row">
            <div class="col-md-4">
                <p><a class="btn btn-outline-success btn-lg"
                      href="/counter?category=${category}&mode=${mode}&word=${word}&counter=good" role="button">Dobrze!
                    :-)</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-warning btn-lg"
                      href="/counter?category=${category}&mode=${mode}&word=${word}&counter=soso" role="button">Średnio
                    :-|</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-danger btn-lg"
                      href="/counter?category=${category}&mode=${mode}&word=${word}&counter=bad" role="button">Źle...
                    :-(</a></p>
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