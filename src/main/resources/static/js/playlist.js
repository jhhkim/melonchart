$(document).ready(function() {
    $("#saveBtn").click(function() {
        let song = $("#song").val();
        let artist = $("#artist").val();
        let songLink = $("#song_link").val();
        if (song.trim() == "") {
            alert("노래 제목을 입력하세요");
            return;
        }
        if (artist.trim() == "") {
            alert("가수를 입력하세요");
            return;
        }
        if (songLink.trim() == "") {
            alert("노래 링크를 입력하세요");
            return;
        }
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            song: song,
            artist: artist,
            songLink: songLink
        };
 
        $.ajax({
            type : 'POST',
            url : '/api/v1/playlistsave',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('노래가 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // saveBtn

    $("#updateBtn").click(function() {
        let song = $("#m_song").val();
        let artist = $("#m_artist").val();
        let songLink = $("#m_songlink").val();
        if (song.trim() == "") {
            alert("노래 제목을 입력하세요");
            return;
        }
        if (artist.trim() == "") {
            alert("가수를 입력하세요");
            return;
        }
        if (songLink.trim() == "") {
            alert("노래 링크를 입력하세요");
            return;
        }
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            song: song,
            artist: artist,
            songLink: songLink
        };

        // 업데이트를 하기위한 키값
        let id = $("#m_id").val();
        //alert(id + " " + song + " " + artist + " " + songLink + " 수정이 됩니다.");
 
        $.ajax({
            type : 'PUT',
            url : '/api/v1/playlist/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('플레이리스트가 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // updateBtn

    $("#delBtn").click(function() {
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        // 업데이트를 하기위한 키값
        let id = $("#m_id").val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/playlist/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
        }).done(function () {
            alert('노래가 플레이리스트에서 삭제되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // delBtn

    $("#rndBtn").click(function() {
        $.getJSON("/api/v1/rndplaylist", function(result){
            console.log(result.song);
            console.log(result.artist);
            console.log(result.songLink);
            var html = "오늘의 노래는 <b> " +result.artist+"</b>의 <b>"+"<a href= '"+ result.songLink +"' target= '_blank'>" + result.song +"</a></b>입니다. <br> 노래 제목을 클릭하면 음원 영상으로 이동합니다.<br>";
            var videoId=result.songLink.split('v=');
            html += '<embed width="560" height="315" src= "https://www.youtube.com/embed/'+ videoId[1] +' " title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>';
            //https://www.youtube.com/embed/해당동영상고유키값(v=뒤에 있는값) 꼴이어야하는데 result.songLink는 저런 형태 아니라서 youtube에서 연결 거부함
            //html += '<embed width="560" height="315" src= " '+ result.songLink +' " title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>';
            
            $("#div1").html(html);
        });
    });  // rndBtn
});

// 오늘은 <b> 메뉴 </b> (이)닭!!!<br> 맛있게 먹기~<br>
// <img src="이미지링크" class="rounded" alt="메뉴" width="320" height="240"> 

function modal_show(id, song, artist, songLink) {
    console.log(id);
    console.log(song);
    console.log(artist);
    console.log(songLink);
    // 클릭한 위치의 테이블의 데이터를 모달에 값을 셋팅
    $("#m_id").val(id);
    $("#m_song").val(song);
    $("#m_artist").val(artist);
    $("#m_songlink").val(songLink);

    $("#myModal").modal();
}