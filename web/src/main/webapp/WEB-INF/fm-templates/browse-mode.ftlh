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
        <#if singleWord?? >
            <h1>Słowo: ${singleWord.word}</h1>
            <h1>Tłumaczenie: ${singleWord.translation}</h1>
        <#else>
            <h2>Nie ma więcej słów dostępnych w kategorii ${category} trybie przeglądania. Zmień kategorię lub przejdź do innego trybu.</h2>
        </#if>
        <br/><br/><br/>
        <div class="row">
            <div class="col-md-4">
                <p><a class="btn btn-primary" href="/${mode}?category=${category}&mode=${mode}" role="button">Następne słowo</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-success" href="/choose-category?mode=${mode}" role="button">Zmień kategorię</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-danger" href="/main" role="button">Main menu</a></p>
            </div>
        </div>

        <!-- // for each /nowy-servlet?category=XXXXXXXX&mode=XXXXX   -->
    </div>
    <hr>

    </div> <!-- /container -->

</main>

<footer class="container fixed-bottom">
    <hr/>
    <p>&copy; Inject footer</p>
</footer>

</body>
</html>