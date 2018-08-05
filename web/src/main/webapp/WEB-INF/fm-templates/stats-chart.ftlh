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

    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

        google.charts.load('current', {packages: ['corechart', 'bar']});
        google.charts.setOnLoadCallback(drawMultSeries);

        function drawMultSeries() {
            var data = google.visualization.arrayToDataTable([
                    <#if title??>
                            <#list title?keys as key>['${key}', '${title[key]}',],</#list>
                    </#if>
                 <#if map??>
                         <#list map?keys as key>['${key}', ${map[key]}]<#sep>,</#sep></#list>
                </#if>
            ]);


            var options = {
                title: 'Ile razy zostało wyświetlone każde słowo',
                chartArea: {width: '70%'},
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>

    <script type="text/javascript">

        google.charts.load('current', {packages: ['corechart', 'bar']});
        google.charts.setOnLoadCallback(drawMultSeries);

        function drawMultSeries() {
            var data = google.visualization.arrayToDataTable([
                    <#if titleBad??>
                            <#list titleBad?keys as key>['${key}', '${titleBad[key]}', { role: "style" } ],</#list>
                    </#if>
                 <#if mapBad??>
                         <#list mapBad?keys as key>['${key}', ${mapBad[key]}, 'red']<#sep>,</#sep></#list>
                 </#if>
            ]);

            var options = {
                title: 'Ile razy podano złą odpowiedź',
                chartArea: {width: '70%'},
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart2_div'));
            chart.draw(data, options);
        }
    </script>

</head>
<body>

<!--   inject navbar here  -->
    <#include "macros/navbar.ftlh">

<div class="jumbotron banner">
        <#include "macros/welcome-banner.ftlh">
</div>

<#--Mail Report button---------------------------->
<div style="width: 80%; height: 100px; margin: auto">
<div class="row justify-content-center">
<span class="col-md-3 d-flex align-items-center">
    <b><h2>Wyślij raport: </h2></b>
</span>
<span class="col-md-3 d-flex align-items-center">
    <a class="btn btn-outline-primary btn-lg" href="/mail-report" role="button">Wyślij</a>
</span>
</div>
</div>
<br/>
<br/>
<#------------------------------------------------>


<div class="container">
    <strong>
    Łączna liczba wyświetlonych słów: ${numberAllDisplayed}.<br/>
    Liczba słów dostępnych w trybie przeglądania: ${numberBrowse}.<br/>
    Liczba słów dostępnych w trybie nauki: ${numberLearn}.<br/>
    Liczba słów dostępnych w trybie powtórek: ${numberRepeat}.<br/>
    Liczba słów oznaczonych jako nauczone: ${numberExcluded}.<br/>
    </strong>
</div>
<br/>



<br/>
<div class="container">
    <div id="chart_div"></div>
</div>
<br/>
<br/>
<div class="container">
    <div id="chart2_div"></div>
</div>






<footer class="container fixed-bottom footer">
    <hr>
    <#include "macros/copyright-footer.ftlh">
</footer>

</body>
</html>