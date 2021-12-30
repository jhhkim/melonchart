$(document).ready(function()
{
    $.getJSON("/api/v1/melon", function(result)
    {
        var html = "";
        var link = "https://www.youtube.com/results?search_query=";
        $.each(result, function(i, field)
        {
            html += "<tr>";
            html += "<td>"+field.rank + "<td>";
            html +="<td><a href= '"  + link +  field.title + "' target= '_blank'>"
            html += field.title + "</a><td>";
            html += "<td>"+field.artist + "<td>";
            html += "</tr>";

            

        });
        $("#musiclist").append(html);

        //여기넣으면 =undifined 검색한 결과가 나오고 16행에 붙이면 1위곡 검색결과만 나옴
        // $("#musiclist").click(function musicpop(field)
        //     {   
        //         link += field.title;
        //         window.open(link);
        //     }); 방법2로 해결!
        
        
    });
});

//방법2 window.open 사용
// $(document).ready(function()
// {
//     $.getJSON("/api/v1/melon", function(result)
//     {
//         var html = "";
//         var link = "https://www.youtube.com/results?search_query=";
//         $.each(result, function(i, field)
//         {
//             html += "<tr>";
//             html += "<td>"+field.rank + "<td>";
//             html +="<td><a href= '#' onclick=\"musicPop('"+ link +  field.title + "')\">"
//             html += field.title + "</a><td>";
//             html += "<td>"+field.artist + "<td>";
//             html += "</tr>";

//         });
//         $("#musiclist").append(html);
        
//     });
// });


// function musicPop(url)
// {
//     window.open(url);
// }
