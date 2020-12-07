// //google.charts.load("current", { packages: ["corechart", "bar"] });
// google.charts.load('current', {'packages':['bar']});
// // google.charts.setOnLoadCallback(drawStacked);

// //Bind click event to make an ajax call to post request of DataVisualization. This will return
// // a json object with top 3 review for each city;

// $("#btnGetChartData2").click(function () {
//   //$("#btnGetChartData").hide();
//   $.ajax({
//     url: "Trending",
//     type: "POST",
//     data: "{}",
//     success: function (msg) {
//       console.log("success");
      
//       //createDataTable2(msg);
//       drawStuff();
//     },
//     error: function () {
//       console.log("error occurred while making ajax call;");
//     },
//   });
// });

// function drawStuff() {
//   var data = new google.visualization.arrayToDataTable([
//     ['Opening Move', 'Percentage'],
//     ["King's pawn (e4)", 44],
//     ["Queen's pawn (d4)", 31],
//     ["Knight to King 3 (Nf3)", 12],
//     ["Queen's bishop pawn (c4)", 10],
//     ['Other', 3]
//   ]);

//   var options = {
//     title: 'Chess opening moves',
//     width: 900,
//     legend: { position: 'none' },
//     chart: { title: 'Chess opening moves',
//              subtitle: 'popularity by percentage' },
//     bars: 'horizontal', // Required for Material Bar Charts.
//     axes: {
//       x: {
//         0: { side: 'top', label: 'Percentage'} // Top x-axis.
//       }
//     },
//     bar: { groupWidth: "90%" }
//   };

//   var chart = new google.charts.Bar(document.getElementById('chart_div'));
//         chart.draw(data, options);
// };


// // const createDataTable2 = (jsonData) => {
// //   var parsedData = $.parseJSON(jsonData);
// //   var data = new Array();
// //   var productNameArr = new Array(); // productName
// //   var stockArr = new Array(); // quantity
// //   let axes = new Array();

// //   axes[0] = "Doctor";
// //   axes[1] = "Quantity";

// //   // Create an array of product name and an array of zipcodes
// //   console.log(parsedData);
// //   for (var i = 0; i < parsedData.length; i++) {
    
// //     var productName = parsedData[i]["quantity"];
// //     var stock = parsedData[i]["doctorName"];

// //     productNameArr.push(productName);
// //     stockArr.push(stock);
// //   }

// //   data[0] = axes;
// //   let counter = 0;

// //   for (let i = 1; i < productNameArr.length; i++) {
// //     let tempArr = new Array();
// //     tempArr[0] = productNameArr[counter];
// //     tempArr[1] = stockArr[counter];
// //     data[i] = tempArr;
// //     counter++;
// //   }

// //   drawChart2(data, productNameArr);
// // };

// // const drawChart2 = (data, productNameArr) => {
// //   var productNames = "";
// //   for (var i = 0; i < productNameArr.length; i++) {
// //     productNames += productNameArr[i] + ",";
// //   }

// //   //Invoke google's built in method to get data table object required by google.
// //   var chartData = google.visualization.arrayToDataTable(data);

// //   var options = {
// //     title: "Sales Chart",
// //     width: 750,
// //     height: 650,
// //     chart: {
// //       title: "Sales Chart",
// //       subtitle: productNames,
// //     },
// //     bars: "horizontal", // Required for Material Bar Charts.
// //   };

// //   var chart = new google.visualization.BarChart(
// //     document.getElementById("chart_div")
// //   );
// //   chart.draw(chartData, options);
// // };
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawProductChart1);

function drawProductChart1() {

var table1 = new google.visualization.DataTable();
  table1.addColumn('string','Product Name');
  table1.addColumn('number','Total Sales($)');
var result1 = $.ajax({
   url: "Trending",
         async: false,
   dataType: "json"
  }).responseText;

var resultJson1=JSON.parse(result1);

for(var i=0;i<resultJson1.length;i++){
     table1.addRow([resultJson1[i]["name"],resultJson1[i]["quantity"]*resultJson1[i]["price"]]);
   }

var options1 = {
width: 1400,
height: 800,
'is3D':true,
title: "Sales Chart",
bar: {groupWidth: "42%"},
legend: { position: "none" }
};

var an1 = new google.visualization.BarChart(document.getElementById('sales_barchart'));
  an1.draw(table1,options1);
}