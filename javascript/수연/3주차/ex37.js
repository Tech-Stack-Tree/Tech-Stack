function drawChart(width=200, height=400){
    console.log(`${width} X ${height} 차트를 그립니다.`);
}
drawChart(100);     //100 X 400 차트를 그립니다.
drawChart();        //200 X 400 차트를 그립니다.

function drawChart2(width=200, height=width/2){
    console.log(`${width} X ${height} 차트를 그립니다.`);
}
drawChart2(300);    //300 X 150 차트를 그립니다.
drawChart2();       //200 X 100 차트를 그립니다.