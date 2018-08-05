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
        <#include "macros/file-upload-banner.ftlh">
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <p><a class="btn btn-outline-danger btn-lg" href="/management?action=delete" role="button">Wyczyść bazę słów
                    &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <p><a class="btn btn-outline-primary btn-lg" href="/management?action=initialize" role="button">Przywróć bazę słów
                    &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <p></p>
            </div>
        </div>
    </div>
    <div class="container"></div>
    <form enctype="multipart/form-data"
          action="management"
          method="POST">
        <div class="container">
            <br/>
            Nowy plik: <input type="file" name="dataFile"/>
            <input type="submit" name="save" value="Zastosuj"/>
        </div>
    </form>
    </div>
    <div class="container">
        <br/><br/>
            <h5>Twoje słowa zostały wczytane do bazy danych. Przejdź do menu głównego aby zacząć korzystać z aplikacji</h5>

    </div>
</main>

<footer class="container fixed-bottom footer">
    <hr>
    <#include "macros/copyright-footer.ftlh">
</footer>

</body>
</html>