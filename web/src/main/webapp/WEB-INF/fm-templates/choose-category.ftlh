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
        <#include "macros/category-banner.ftlh">
    </div>

    <div class="container">
        <#list categories>
            <div class="row">
                <p style="margin-right: 10px;"><a class="btn btn-outline-primary btn-block"  href="/${mode}?category=wszystkie&mode=${mode}" role="button">WSZYSTKIE</a></p>
                <#items as category>
                    <p style="margin-right: 10px;"><a class="btn btn-outline-primary btn-block" href="/${mode}?category=${category}&mode=${mode}" role="button">${category}</a></p>
                </#items>
            </div>
        </#list>
    </div>
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