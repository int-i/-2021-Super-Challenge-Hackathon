let cnt = 0;

$(function(){
    $('.circle1').on('click',function(){
        cnt = 1;
        $('#img_slide1').css('right','0');
        $('#img_slide2').css('right','-100%');
        $('#img_slide3').css('right','-200%');
        $('.circle1').css('color','white');
        $('.circle2').css('color','black');
        $('.circle3').css('color','black');
    });
});

$(function(){
    $('.circle2').on('click',function(){
        cnt = 2;
        $('#img_slide1').css('right','100%');
        $('#img_slide2').css('right','0');
        $('#img_slide3').css('right','-100%');
        $('.circle1').css('color','black');
        $('.circle2').css('color','white');
        $('.circle3').css('color','black');
    });
});

$(function(){
    $('.circle3').on('click',function(){
        cnt = 3;
        $('#img_slide1').css('right','200%');
        $('#img_slide2').css('right','100%');
        $('#img_slide3').css('right','0');
        $('.circle1').css('color','black');
        $('.circle2').css('color','black');
        $('.circle3').css('color','white');
    });
});

$(function(){
    $(".img_slide_left").on('click',function(){
        cnt -= 1;
        if(cnt < 1){
            cnt = 3;
        }

        switch(cnt){
            case(1):
            $('#img_slide1').css('right','0');
            $('#img_slide2').css('right','-100%');
            $('#img_slide3').css('right','-200%');
            $('.circle1').css('color','white');
            $('.circle2').css('color','black');
            $('.circle3').css('color','black');
            break;
            case(2):
            $('#img_slide2').css('right','0');
            $('#img_slide1').css('right','100%');
            $('#img_slide3').css('right','-100%');
            $('.circle1').css('color','black');
            $('.circle2').css('color','white');
            $('.circle3').css('color','black');
            break;
            case(3):
            $('#img_slide3').css('right','0');
            $('#img_slide2').css('right','100%');
            $('#img_slide1').css('right','200%');
            $('.circle1').css('color','black');
            $('.circle2').css('color','black');
            $('.circle3').css('color','white');
            break;
        }
    });
});

$(function(){
    $(".img_slide_right").on('click',function(){
        
        cnt += 1;

        if(cnt > 3){
            cnt = 1;
        }

        switch(cnt){
            case(1):
            $('#img_slide1').css('right','0');
            $('#img_slide2').css('right','-100%');
            $('#img_slide3').css('right','-200%');
            $('.circle1').css('color','white');
            $('.circle2').css('color','black');
            $('.circle3').css('color','black');
            break;
            case(2):
            $('#img_slide2').css('right','0');
            $('#img_slide1').css('right','100%');
            $('#img_slide3').css('right','-100%');
            $('.circle1').css('color','black');
            $('.circle2').css('color','white');
            $('.circle3').css('color','black');
            break;
            case(3):
            $('#img_slide3').css('right','0');
            $('#img_slide2').css('right','100%');
            $('#img_slide1').css('right','200%');
            $('.circle1').css('color','black');
            $('.circle2').css('color','black');
            $('.circle3').css('color','white');
            break;
        }
    });
});