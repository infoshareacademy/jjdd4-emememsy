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

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

    <!--   inject navbar here  -->
</nav>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <!--   inject banner here  -->
    </div>

    <div class="container">
        <!-- Example row of columns -->
        <h1>Poprawne tłumaczenie słowa ${word} to ${translation}.</h1>

        <div class="row">
            <div class="col-md-6">
                <p><a class="btn btn-success btn-lg" href="/${mode}?category=${category}&mode=${mode}&word=${word}&counter=remain" role="button">Pozostaw słowo<br/>w trybie powtórek</a></p>
            </div>
            <div class="col-md-6">
                <p><a class="btn btn-warning btn-lg" href="/${mode}?category=${category}&mode=${mode}&word=${word}&counter=remove" role="button">Usuń słowo <br/>z trybu powtórek</a></p>
            </div>
        </div>




        <!-- // for each /nowy-servlet?category=XXXXXXXX&mode=XXXXX   -->
    </div>
    <hr>

    </div> <!-- /container -->

</main>

<footer class="container fixed-bottom">
    <hr>
    <#include "macros/copyright-footer.ftlh">
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>