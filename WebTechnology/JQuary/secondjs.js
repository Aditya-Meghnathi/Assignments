$('document').ready(function(){
    var current = 0;
    var score = 0;
    var question = $('.question');
    question.hide();
    $('#click').hide();
    $('#Score').hide();
    $("button[name='start']").click(function () {
        $('#First').hide();
        $(question[current]).show();
        $('#click').show();
    });
    $('#submit').hide();
    $('#prev').attr('disabled',true);
    $("#next").click(function(){
        $(question[current]).hide();
        current++;
        $(question[current]).show();
        if(current==4){
            $('#next').attr('disabled',true);
            $('#submit').show();
        }
        $('#prev').attr('disabled',false);
    });
    $("#prev").click(function(){
        $(question[current]).hide();
        current--;
        $(question[current]).show();
        if(current==0){
            $('#prev').attr('disabled',true);
        }
        $('#next').attr('disabled',false);
        $('#submit').hide();
    });
    $("#submit").click(function(){
        question.hide();
        for(var i=0;i<5;i++){
            if(parseInt($(question[i]).find('input[name="options"]:checked').val())==1)
                score++;
        }
        $('#score').text(score);
        $("#Score").show();
        $('#click').hide();
    });
    $('#restart').click(function(){
        location.reload();
    });
});