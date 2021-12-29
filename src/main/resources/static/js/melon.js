$(document).ready(function()
{
    $.getJSON("/api/v1/melon", function(result)
    {
        var html = "";
        $.each(result, function(i, field)
        {
            html += "<tr>";
            html += "<td>"+field.rank + "<td>";
            html += "<td>"+field.title + "<td>";
            html += "<td>"+field.artist + "<td>";
            html += "</tr>";
        });
        $("#musiclist").append(html);
    });
});

$(document).click(function()
{   
    var url = "https://www.youtube.com/results?search_query=" + $("#musiclist").val();
    window.open(url);
});