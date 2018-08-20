google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

    var entries = [
        ['City', '2010 Population'],
        ['New York City, NY', 0],
        ['Los Angeles, CA', 1],
        ['City', '2010 Population'],
        ['New York City, NY', 0],
        ['Los Angeles, CA', 1],
        ['City', '2010 Population'],
        ['New York City, NY', 0],
        ['Los Angeles, CA', 1],
        ['City', '2010 Population'],
        ['New York City, NY', 0],
        ['Los Angeles, CA', 1],
        ['City', '2010 Population'],
        ['New York City, NY', 0],
        ['Los Angeles, CA', 1],
        ['City', '2010 Population'],
        ['New York City, NY', 0],
        ['Los Angeles, CA', 1],

        ['Houston, TX', 2],
        ['Philadelphia, PA',2]
    ]

    var max = Math.max.apply(null, entries.slice(1).map(item => item[1]);

    var data = google.visualization.arrayToDataTable(
        entries
    );

    var options = {
        title: 'Population of Largest U.S. Cities',
        width: 600,
        height: entries.length * 20,
        chartArea: {width: '50%'},
        hAxis: {
            title: 'Total Population',
            minValue: 0,
            ticks: Array.from({ length: max + 1 }, (_, index) => index)
},
    vAxis: {
        title: 'City'
    },
    bar: { groupWidth: "30%" }
};

    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

    chart.draw(data, options);
}