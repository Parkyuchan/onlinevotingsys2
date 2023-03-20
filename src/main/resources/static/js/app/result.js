function drawChart() {

    var id = $('#candidate_id').val();

    $.ajax({
        type: 'GET',
        url: '/api/v1/voteresult/' + id
    }).done(function (receiveData) {
        //데이터 설정
        var data = new google.visualization.DataTable();
        //데이터 타입과 데이터 추가
        data.addColumn('string', '후보');
        data.addColumn('number', '결과');

        var voteData = ["찬성", receiveData[0]];  //'찬성'이라는 항목 추가
        data.addRow(voteData);
        voteData = ["반대", receiveData[1]];  //'반대'라는 항목 추가
        data.addRow(voteData);
        //receiveData 를 통해 값 전달, 차트의 데이터 추가

        var options = {
            title: '투표결과',
            isStacked: 'percent',
            focusTarget: 'category',
            height: 400,
            width: '100%',
            legend: {position: "top", textStyle: {fontSize: 13}},
            pointSize: 5,
            tooltip: {textStyle: {fontSize: 12}, showColorCode: true, trigger: 'both'},
            vAxis: {minValue: 100, viewWindow: {min: 0}, textStyle: {fontSize: 12}},
            animation: {startup: true, duration: 1000, easing: 'in'},
        }; //그래프 속성(옵션 설정)

        //차트 그리기
        var chart = new google.visualization.PieChart(document.getElementById('chart_div4'));
        chart.draw(data, options);

    }).fail(function (error){
        alert(JSON.stringify(error));
    })
}

google.charts.load('current', {packages: ['corechart']}); //google chart API 로드
google.charts.setOnLoadCallback(drawChart); //google chart API 가 로드되고 실제로 차트를 그리는 함수 호출