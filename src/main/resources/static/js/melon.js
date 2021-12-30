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
    });
});

// $(document).click(function()
// {   
//     var url = "https://www.youtube.com/results?search_query="
//     url += field.title;
//     window.open(url);
// });