<!doctype html>

<html lang="pl">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
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

<div class="jumbotron">
        <#include "macros/mail-banner.ftlh">
</div>


<div style="margin: 50px; padding: 10px">
    <h2>Wyslij raport na email</h2>
    <form method="POST" action="/mail-dispatcher">
        <table>
            <tr>
                <td>
                    <label for="emailAddress">Do:</label>
                    <input type="text" name="email" value=${userEmail} id="emailAddress" class="form-control" size="75">
                </td>
            </tr>

            <tr>
                <td>
                <label for="exampleTextarea">Wiadomość</label>
                <textarea name="message" readonly class="form-control" id="exampleTextarea" rows="6" cols="75">
Łączna liczba wyświetlonych słów: ${numberAllDisplayed}.
Liczba słów dostępnych w trybie przeglądania: ${numberBrowse}.
Liczba słów dostępnych w trybie nauki: ${numberLearn}.
Liczba słów dostępnych w trybie powtórek: ${numberRepeat}.
Liczba słów oznaczonych jako nauczone: ${numberExcluded}.
                </textarea>
                </td>
            </tr>

            <tr>
                <td>
                <button type="submit" class="btn btn-primary">Wyślij</button>
                </td>
            </tr>
        </table>
    </form>
</div>


<footer class="container fixed-bottom">
    <hr>
    <#include "macros/copyright-footer.ftlh">
</footer>

</body>

</html>